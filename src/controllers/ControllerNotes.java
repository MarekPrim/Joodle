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
import utils.Utils;

public class ControllerNotes {
	
	@FXML
	private TextArea editeur_text;
	
	@FXML
	private Button bouton_valider;
	
	private String nomFichierModifie = "test";
	
	private String nomCoursModifie = "UE_test";

	
	@FXML
	private void enregistrerFichier(ActionEvent e) throws IOException {
		String addresseDossierJoodle = Utils.addresseDossierDonneesApplication();
		File fichier = new File(addresseDossierJoodle + File.separator + nomCoursModifie + File.separator
				+ nomFichierModifie + ".txt");
		
		
        FileOutputStream fos = new FileOutputStream(fichier);
        fos.write(editeur_text.getText().getBytes());
        fos.close();
	}
	

}