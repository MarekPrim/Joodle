package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modele.DossierNotes;
import modele.FichierNotes;
import utils.Utils;
import views.App;

public class ControllerNotes implements Initializable{
	
	@FXML
	private TextArea editeur_text;
	
	@FXML
	private Button bouton_ajouter_dossier;
	
	@FXML
	private TextField texte_ajouter_fichier;
	
	@FXML
	private TextField texte_ajouter_dossier;
	
	@FXML
	private VBox VboxManageurNotes;
	
	private String nomFichierModifie = "test";
	
	private String nomCoursModifie = "UE_Test";
	
	private List<DossierNotes> listeDossier;

	
	@FXML
	private void enregistrerFichier(ActionEvent e) throws IOException {
		String addresseDossierDocument = Utils.addresseDossierDocumentJoodle();
		File fichier = new File(addresseDossierDocument + File.separator + nomCoursModifie + File.separator
				+ nomFichierModifie + ".txt");
		System.out.println(addresseDossierDocument + File.separator + nomCoursModifie + File.separator
				+ nomFichierModifie + ".txt");
		if(!fichier.exists()) {
			fichier.createNewFile();
		}
        FileOutputStream fos = new FileOutputStream(fichier);
        fos.write(editeur_text.getText().getBytes());
        fos.close();
	}
	
	@FXML
	private void ajouterDossier(ActionEvent e) {
		this.bouton_ajouter_dossier.setVisible(false);
		this.texte_ajouter_dossier.setVisible(true);
	}
	
	private void chargerNotesExistantes() {
		this.listeDossier = new ArrayList<DossierNotes>();
		String addresseDossierDocument = Utils.addresseDossierDocumentJoodle();
		File dossierDocumentJoodle = new File(addresseDossierDocument);
		for(File fichierDocumentJoodle : dossierDocumentJoodle.listFiles()) {
			if(fichierDocumentJoodle.isDirectory() && fichierDocumentJoodle.getName().contains("Notes_")) {
				DossierNotes dossier = new DossierNotes(fichierDocumentJoodle.getPath(), fichierDocumentJoodle.getName().replace("Notes_", ""));
				for(File fichier : fichierDocumentJoodle.listFiles()) {
					
					if(!fichier.isDirectory() && fichier.getName().contains("Notes_")) {
						dossier.ajouterFichier(new FichierNotes(fichier.getPath(), fichier.getName().replace("Notes_", "")));
					}
				}
				this.listeDossier.add(dossier);
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (this.texte_ajouter_dossier != null) {
			this.texte_ajouter_dossier.setOnKeyPressed(new EventHandlerEnregistrementDossier());
		}
		chargerNotesExistantes();
		System.out.println(this.listeDossier);
		for(DossierNotes dossier : this.listeDossier) {
//			dossier.afficherFichiers();
			try {
				FXMLLoader loader = App.getFXMLLoader("squeletteManageurFichierNotes");
				ControllerManageurFichierNotes controller = new ControllerManageurFichierNotes(dossier);
				loader.setController(controller);
				VboxManageurNotes.getChildren().add(loader.load());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private class EventHandlerEnregistrementDossier implements EventHandler<KeyEvent> {

		@Override
		public void handle(KeyEvent e) {
			if (e.getCode().equals(KeyCode.ENTER))  {
				String addresseDossierDocument = Utils.addresseDossierDocumentJoodle();
				File fichier = new File(addresseDossierDocument + File.separator + texte_ajouter_dossier.getText());
				if(!fichier.exists()) {
					fichier.mkdir();
				}
				bouton_ajouter_dossier.setVisible(true);
				texte_ajouter_dossier.setVisible(false);
	       }
		}
		
	}

	private class EventHandlerEnregistrementFichier implements EventHandler<KeyEvent> {

		@Override
		public void handle(KeyEvent e) {
			if (e.getCode().equals(KeyCode.ENTER))  {
				bouton_ajouter_dossier.setVisible(true);
				texte_ajouter_dossier.setVisible(false);
	       }
		}
		
	}
	

}