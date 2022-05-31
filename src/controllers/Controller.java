package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import modele.Etudiant;
import modele.LectureProfilException;
import utils.ICSParser;
import utils.ICSTimeSlot;
import utils.ICSTimeSlotStack;
import views.App;

public class Controller implements Initializable{
	
	private Etudiant etudiant;
	private ICSTimeSlotStack icsData = new ICSTimeSlotStack();
	
	@FXML private Label profil_etudiant;
	
    @FXML private ListView<Text> liste_vendredi;
	
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
    private void switchToRestauU(ActionEvent e) throws IOException {
        App.setRoot("view_RestauU");
    }
    
    @FXML
    private void modifier_profil_etudiant(MouseEvent e) throws IOException {
    	App.setRoot("view_Profil_Etudiant");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ICSParser parser = null;
		try {
			parser = new ICSParser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(ICSTimeSlot timeslot : parser.recoverData()) {
			if(timeslot.getDay().equals("Vendredi")) {
				this.icsData.add(timeslot);
				liste_vendredi.getItems().add(new Text(timeslot.getCours()));
			}
		}
		
		profil_etudiant.setText(etudiant.toString());
	}
}
