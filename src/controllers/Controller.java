package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import modele.Etudiant;
import modele.LectureProfilException;
import views.App;

public class Controller implements Initializable{
	
	private Etudiant etudiant;
	
	@FXML private Label profil_etudiant;
	
	public Controller() throws LectureProfilException {
		etudiant = Etudiant.getInstanceEtudiant();
	}

    @FXML
    private void switchToEDT(ActionEvent e) throws IOException {
        App.setRoot("view_EDT");
    }

    @FXML
    private void switchToCours(ActionEvent e) throws IOException {
        App.setRoot("view_Cours");
    }

    @FXML
    private void switchToNotes(ActionEvent e) throws IOException {
        App.setRoot("view_Notes");
    }

    @FXML
    private void switchToTaches(ActionEvent e) throws IOException {
        App.setRoot("view_Taches");
    }
    
    @FXML
    private void modifier_profil_etudiant(MouseEvent e) throws IOException {
    	App.setRoot("view_Profil_Etudiant");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		profil_etudiant.setText(etudiant.toString());
	}
}
