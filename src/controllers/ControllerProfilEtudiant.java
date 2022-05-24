package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import modele.Etudiant;
import modele.LectureProfilException;
import modele.SauvegardeProfilException;
import views.App;

public class ControllerProfilEtudiant implements Initializable{

		@FXML private TextField nom;
		@FXML private TextField prenom;
		@FXML private TextField login;
		private Etudiant etudiant;
		
		public ControllerProfilEtudiant() throws LectureProfilException {
			etudiant = Etudiant.getInstanceEtudiant();
		}
	    
	    @FXML
	    private void enregistrer_profil_etudiant(ActionEvent e) throws IOException, SauvegardeProfilException {
	    	etudiant.setLogin(login.getText());
	    	etudiant.setPrenom(prenom.getText());
	    	etudiant.setNom(nom.getText());
	    	etudiant.sauvegarderProfilEtudiant();
	    	App.setRoot("view_EDT");
	    }
	    
	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
	    	prenom.setText(etudiant.getPrenom());
	        nom.setText(etudiant.getNom());
	        login.setText(etudiant.getLogin());
	    }

}
