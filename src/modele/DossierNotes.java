package modele;

import java.util.ArrayList;
import java.util.List;

public class DossierNotes {
	

	
	private List<FichierNotes> listeFichier = new ArrayList<FichierNotes>();
	
	private String cheminDossier;

	private String nomDossier;

	public DossierNotes(String cheminDossier, String nomDossier) {
		this.setCheminDossier(cheminDossier);
		this.setNomDossier(nomDossier);
	}

	public List<FichierNotes> getListeFichier() {
		return listeFichier;
	}

	public void ajouterFichier(FichierNotes fichier) {
		this.listeFichier.add(fichier);
	}

	public String getNomDossier() {
		return nomDossier;
	}

	public void setNomDossier(String nomDossier) {
		this.nomDossier = nomDossier;
	}

	public String getCheminDossier() {
		return cheminDossier;
	}
	
	public void setCheminDossier(String cheminDossier) {
		this.cheminDossier = cheminDossier;
	}

	@Override
	public String toString() {
		return nomDossier;
	}

}
