package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    
    @FXML
    private Button next_edt;

    @FXML
    private Button previous_edt;
    
    @FXML
    private Button S1;

    @FXML
    private Button S2;

    @FXML
    private Button S3;

    @FXML
    private Button S4;

    @FXML
    private Button S5;
	
	public Controller() throws LectureProfilException {
		etudiant = Etudiant.getInstanceEtudiant();
	}
	
	@FXML
    void changeWeek(MouseEvent event) {
		String idSource = event.getPickResult().getIntersectedNode().getId();
		if(idSource.equals("previous_edt")) {
			S1.setText((Integer.parseInt(S1.getText())-1)+"");
			S2.setText((Integer.parseInt(S2.getText())-1)+"");
			S3.setText((Integer.parseInt(S3.getText())-1)+"");
			S4.setText((Integer.parseInt(S4.getText())-1)+"");
			S5.setText((Integer.parseInt(S5.getText())-1)+"");
		} else {
			S1.setText((Integer.parseInt(S1.getText())+1)+"");
			S2.setText((Integer.parseInt(S2.getText())+1)+"");
			S3.setText((Integer.parseInt(S3.getText())+1)+"");
			S4.setText((Integer.parseInt(S4.getText())+1)+"");
			S5.setText((Integer.parseInt(S5.getText())+1)+"");
		}
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
