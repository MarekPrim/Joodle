package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import modele.DossierNotes;

public class ControllerManageurFichierNotes implements Initializable{
	
	
	private DossierNotes dossier;
	
	@FXML
	private Button bouton_ajouter_fichier;
	
	@FXML
	private TitledPane panneauDossier;
	
	@FXML
	private void ajouterFichier(ActionEvent e) {
		this.bouton_ajouter_fichier.setVisible(false);
	}
	
	public ControllerManageurFichierNotes(DossierNotes dossier) {
		this.dossier = dossier;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		panneauDossier.setText(dossier.getNomDossier());
		
	}

}
