package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import modele.Etudiant;
import modele.LectureProfilException;
import views.App;

public class ControllerBarreSuperieure implements Initializable{

	private Etudiant etudiant;
	
    @FXML
    private Label profil_etudiant;

    @FXML
    void modifier_profil_etudiant(MouseEvent event) throws IOException, LectureProfilException {
    	etudiant = Etudiant.getInstanceEtudiant();
    	profil_etudiant.setText(etudiant.toString());
    	App.setRoot("view_Profil_Etudiant");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			etudiant = Etudiant.getInstanceEtudiant();
		} catch (LectureProfilException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	profil_etudiant.setText(etudiant.toString());
		
	}

}
