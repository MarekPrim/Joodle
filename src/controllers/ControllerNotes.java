package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utils.Utils;

public class ControllerNotes {
	
	@FXML
	private TextArea editeur_text;
	
	@FXML
	private Button bouton_ajouter_fichier;
	
	@FXML
	private Button bouton_ajouter_dossier;
	
	@FXML
	private TextField texte_ajouter_fichier;
	
	@FXML
	private TextField texte_ajouter_dossier;
	
	private String nomFichierModifie = "test";
	
	private String nomCoursModifie = "UE_Test";

	
	@FXML
	private void enregistrerFichier(ActionEvent e) throws IOException {
		String addresseDossierDocument = Utils.addresseDossierDocumentJoodle();
		File fichier = new File(addresseDossierDocument + File.separator + nomCoursModifie + File.separator
				+ nomFichierModifie + ".txt");
		
		
        FileOutputStream fos = new FileOutputStream(fichier);
        fos.write(editeur_text.getText().getBytes());
        fos.close();
	}
	
	@FXML
	private void ajouterDossier(ActionEvent e) {
		this.bouton_ajouter_dossier.setVisible(false);
		this.texte_ajouter_dossier.setVisible(true);
	}
	
	@FXML
	private void ajouterFichier(ActionEvent e) {
		this.bouton_ajouter_fichier.setVisible(false);
		this.texte_ajouter_fichier.setVisible(true);
	}
	

}