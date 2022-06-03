package modele;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import utils.ICSParser;
import utils.ListeCours;
import utils.RequestFormeur;

public class Salle {
	
	private String nomSalle;
	
	private int codeSalle;
	
	private ListeCours listeCours;
	
	private static Set<Salle> listeSalles = new HashSet<Salle>();
	
	private LocalDateTime derniereMiseAJourCours;
	
	public Salle(String nomSalle, int code) throws IOException {
		this.nomSalle = nomSalle;
		this.codeSalle = code;
		listeSalles.add(this);
		this.chargerCours();
	}

	private void chargerCours() throws IOException {
		LocalDateTime heureActuelle = LocalDateTime.now();
		LocalDateTime heure12HAvant = heureActuelle.minusHours(12);
		if (this.derniereMiseAJourCours == null || this.derniereMiseAJourCours.isBefore(heure12HAvant)) {
			System.out.println("Tentative de mise a jour");
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
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
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

}
