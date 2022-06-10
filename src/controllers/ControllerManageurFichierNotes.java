package controllers;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;

import javafx.scene.text.Text;
import javafx.scene.control.TextField;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import modele.DossierNotes;
import modele.FichierNotes;

public class ControllerManageurFichierNotes implements Initializable{
	

    @FXML
    private ListView<FichierNotes> liste_fichiers;
    
	private DossierNotes dossier;
	private ControllerNotes ctnotes;
	
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
			FichierNotes fichierNote = new FichierNotes(fichier.getPath(), texte_ajouter_fichier.getText());
			dossier.ajouterFichier(fichierNote);
			liste_fichiers.getItems().add(fichierNote);
		}
		texte_ajouter_fichier.setText("");
		texte_ajouter_fichier.setVisible(false);
		
	}
	
	public ControllerManageurFichierNotes(DossierNotes dossier, ControllerNotes ctnotes) {
		this.ctnotes = ctnotes;
		this.dossier = dossier;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		panneauDossier.setText(dossier.getNomDossier());
		for (FichierNotes fichier : dossier.getListeFichier()) {
			liste_fichiers.getItems().add(fichier);
		}
		texte_ajouter_fichier.setOnKeyPressed(new EventHandlerEnregistrementFichier());
		liste_fichiers.setOnMouseClicked(new EventHandlerSelectionFichier());
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
	
	private class EventHandlerSelectionFichier implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			ListView<FichierNotes> l = (ListView<FichierNotes>)event.getSource();
			System.out.println(l.getSelectionModel().getSelectedItem());
			FichierNotes f = (FichierNotes)l.getSelectionModel().getSelectedItem();
			System.out.println(f);
			try {
				ctnotes.chargerFichier(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
