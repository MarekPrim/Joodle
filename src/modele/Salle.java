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

public class Salle implements Comparable<Salle>{
	
	private int codeSalle;
	
	private ListeCours listeCours;
	
	private static Set<Salle> listeSalles = new TreeSet<Salle>();
	
	private char batiment;
	
	private int numeroSalle;
	
	private char lettreSousSalle;
	
	private LocalDateTime derniereMiseAJourCours;
	
	public Salle(String nomSalle, int code) throws IOException{
		setNomSalle(nomSalle);
		this.codeSalle = code;
		listeSalles.add(this);
		this.chargerCours();
	}

	private void chargerCours() throws IOException{
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

	public String getNomSalle() {
		return batiment + "" + String.format("%03d", numeroSalle) + lettreSousSalle;
	}

	public void setNomSalle(String nomSalle) {
		nomSalle = nomSalle.stripLeading();
		this.batiment = nomSalle.charAt(0);
		this.numeroSalle = Integer.parseInt(nomSalle.substring(1, 4));
		if(nomSalle.length() > 4) {
			this.lettreSousSalle = nomSalle.charAt(4);
		}
	}

	public int getCodeSalle() {
		return codeSalle;
	}

	public void setCodeSalle(int codeSalle) {
		this.codeSalle = codeSalle;
	}

	public ListeCours getListeCours() {
		return listeCours;
	}


	public static Set<Salle> getListeSalles() {
		return listeSalles;
	}
	
	public char getBatiment() {
		return batiment;
	}
	
	public int getNumeroSalle() {
		return numeroSalle;
	}
	
	public char getLettreSousSalle() {
		return lettreSousSalle;
	}
	
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
