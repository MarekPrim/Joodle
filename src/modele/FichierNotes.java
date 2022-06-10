package modele;

import javafx.scene.text.Text;

public class FichierNotes {

	private String cheminFichier;

	private String nomFichier;

	public FichierNotes(String cheminFichier, String nomFichier) {
		this.setCheminFichier(cheminFichier);
		this.setNomFichier(nomFichier);
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}

	public String getCheminFichier() {
		return cheminFichier;
	}

	public void setCheminFichier(String cheminFichier) {
		this.cheminFichier = cheminFichier;
	}
	
	@Override
	public String toString() {
		return nomFichier;
	}

}
