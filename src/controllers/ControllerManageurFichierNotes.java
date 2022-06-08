package controllers;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;

import javafx.scene.text.Text;
import javafx.scene.control.TextField;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.DossierNotes;
import modele.FichierNotes;

public class ControllerManageurFichierNotes implements Initializable{
	

    @FXML
    private ListView<Text> liste_fichiers;
    
	private DossierNotes dossier;
	
	@FXML
	private Button bouton_ajouter_fichier;
	
	@FXML
	private TitledPane panneauDossier;
	
	@FXML
	private TextField texte_ajouter_fichier;
	
	@FXML
	private void ajouterFichier(ActionEvent e) {
		if (this.texte_ajouter_fichier.isVisible()) {
			if (!this.texte_ajouter_fichier.getText().isBlank()) {
				enregistrementNouveauFichier();
			}
			else {
				texte_ajouter_fichier.setVisible(false);
			}
		}
		else {
			this.texte_ajouter_fichier.setVisible(true);
		}
	}
	

	private void enregistrementNouveauFichier() {
		File fichier = new File(dossier.getCheminDossier() + File.separator + "Notes_" + texte_ajouter_fichier.getText() + ".txt");
		if(!fichier.exists()) {
			try {
				fichier.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dossier.ajouterFichier(new FichierNotes(fichier.getPath(), texte_ajouter_fichier.getText()));
		}
		texte_ajouter_fichier.setText("");
		texte_ajouter_fichier.setVisible(false);
		
	}
	
	public ControllerManageurFichierNotes(DossierNotes dossier) {
		this.dossier = dossier;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		panneauDossier.setText(dossier.getNomDossier());
		liste_fichiers.getItems().add(new Text("eee"));
		texte_ajouter_fichier.setOnKeyPressed(new EventHandlerEnregistrementFichier());
	}
	
	private class EventHandlerEnregistrementFichier implements EventHandler<KeyEvent> {

		@Override
		public void handle(KeyEvent e) {
			if (e.getCode().equals(KeyCode.ENTER)) {
				if (!texte_ajouter_fichier.getText().isBlank()) {
					enregistrementNouveauFichier();
				}
				else {
					texte_ajouter_fichier.setVisible(false);
				}
			}
		}
		
	}
	
    @FXML
    void select_notes(MouseEvent event) {
    	System.out.println(event.getSource());
    }

}
