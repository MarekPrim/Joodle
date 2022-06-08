package modele;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import utils.ICSParser;
import utils.ListeCours;
import utils.RequestFormeur;

/**
 * Classe réprésentant une salle, avec son nom et son code ade.
 * Chaque salle ajoutée est stocké dans un ensemble de salle disponible dans getListeSalles pour y avoir accès dans toutes l'application.
 * @author Groupe 6
 *
 */
public class Salle implements Comparable<Salle>{
	
	private int codeSalle;
	
	private ListeCours listeCours;
	
	private static Set<Salle> listeSalles = new TreeSet<Salle>();
	
	private char batiment;
	
	private int numeroSalle;
	
	private char lettreSousSalle;
	
	private LocalDateTime derniereMiseAJourCours;
	
	/**
	 * Crée une salle, charge ses cours depuis son calendrier et l'ajoute à l'ensemble des salles.
	 * @param nomSalle Nom de la salle de la forme BNNNL avec B la lettre du batiment, NNN les 3 chiffres d'une salle et L optionnelle si la salle est en plusieurs parties.
	 * @param code Code de la salle sur l'emploi du temps ade pour télécharger le fichier ICS.
	 * @throws IOException Exception si une erreur se produit lors du chargement des cours.
	 */
	public Salle(String nomSalle, int code) throws IOException {
		setNomSalle(nomSalle);
		this.codeSalle = code;
		listeSalles.add(this);
		this.chargerCours();
	}

	/**
	 * Charge les cours d'une salle depuis son calendrier. Charge seulement si la dernière mise à jour date de plus de 12h pour éviter un trop grand nombre de chargement.
	 * @throws IOException Exception si une erreur se produit lors du téléchargement du calendrier et de son ouverture/lecture.
	 */
	public void chargerCours() throws IOException{
		LocalDateTime heureActuelle = LocalDateTime.now();
		LocalDateTime heure12HAvant = heureActuelle.minusHours(12);
		if (this.derniereMiseAJourCours == null || this.derniereMiseAJourCours.isBefore(heure12HAvant)) {
			System.out.println("Tentative de mise a jour de la salle " + this.getNomSalle());
			RequestFormeur request = new RequestFormeur(this.codeSalle);
			File fichierCalendrier = request.write();
			ICSParser ics = new ICSParser(fichierCalendrier);
			this.listeCours = ics.recoverData();
			if (this.listeCours.isEmpty()) {
				ics = new ICSParser();
				this.listeCours = ics.recoverData();
			}
			this.derniereMiseAJourCours = LocalDateTime.now();
		}	
	}
	
	/**
	 * Retourne le nom de la salle sous la forme, BNNNL avec B la lettre du batiment, NNN les 3 chiffres d'une salle et L optionnelle si la salle est en plusieurs parties.
	 * @return Nom de la salle.
	 */
	public String getNomSalle() {
		return batiment + "" + String.format("%03d", numeroSalle) + lettreSousSalle;
	}
	
	/**
	 * Permet de modifier le nom de la salle.
	 * @param nomSalle Nom de la salle de la forme BNNNL avec B la lettre du batiment, NNN les 3 chiffres d'une salle et L optionnelle si la salle est en plusieurs parties.
	 */
	public void setNomSalle(String nomSalle) {
		nomSalle = nomSalle.stripLeading();
		this.batiment = nomSalle.charAt(0);
		this.numeroSalle = Integer.parseInt(nomSalle.substring(1, 4));
		if(nomSalle.length() > 4) {
			this.lettreSousSalle = nomSalle.charAt(4);
		}
	}
	
	/**
	 * Retourne le code de la salle utilisé dans ade pour avoir le calendrier de la salle.
	 * @return Code de la salle.
	 */
	public int getCodeSalle() {
		return codeSalle;
	}

	/**
	 * Permet de changer le code de la salle utilisé dans ade pour avoir le calendrier de la salle.
	 * @param codeSalle Nouveau code de la salle.
	 */
	public void setCodeSalle(int codeSalle) {
		this.codeSalle = codeSalle;
	}
	
	/**
	 * Retourne la liste des cours ayant lieu dans la salle.
	 * @return Liste de cours de type ListeCours avec les cours utilisant la salle.
	 */
	public ListeCours getListeCours() {
		return listeCours;
	}

	/**
	 * Retourne l'ensemble des salles ajoutées dans l'application.
	 * @return Set<Salle>, ensemble des salles ajoutées dans l'application.
	 */
	public static Set<Salle> getListeSalles() {
		return listeSalles;
	}
	
	/**
	 * Retourne la lettre du batiment de la salle (A, B..).
	 * @return Un char réprésentant le batiment de la salle.
	 */
	public char getBatiment() {
		return batiment;
	}
	
	/**
	 * Retourne le numéro de la salle.
	 * @return Entier représentant le numéro de la salle.
	 */
	public int getNumeroSalle() {
		return numeroSalle;
	}
	
	/**
	 * Retourne une lettre réprésentant l'indicateur de sous salle (a ou b).
	 * @return Un char réprésentant la partie de la salle (a ou b).
	 */
	public char getLettreSousSalle() {
		return lettreSousSalle;
	}
	
	/**
	 * Retourne la salle ayant le nom donné en paramètres si elle existe null sinon.
	 * @param nomDonne Nom de la salle recherchée.
	 * @return La salle ayant nomDonne comme nom ou null si elle n'existe pas.
	 */
	public static Salle getSalleNomDonne(String nomDonne) {
		Salle[] listeSallesTab = (Salle[]) listeSalles.toArray();
		int i = 0;
		boolean trouve = false;
		while (i < listeSalles.size() && !trouve) {
			if (nomDonne.equals(listeSallesTab[i].getNomSalle())) {
				trouve = true;
			}
			else {
				i++;
			}
			
		}
		if (trouve) {
			return listeSallesTab[i];
		}
		else {
			return null;
		}
	}

	@Override
	public int compareTo(Salle salle2) {
		int compareBatiment = Character.compare(this.batiment, salle2.getBatiment());
		if(compareBatiment == 0) {
			int compareNumero = this.numeroSalle - salle2.getNumeroSalle();
			if(compareNumero == 0) {
				return Character.compare(this.lettreSousSalle, salle2.getLettreSousSalle());
			}
			else {
				return compareNumero;
			}
		}
		else {
			return compareBatiment;
		}
		
	}

}
