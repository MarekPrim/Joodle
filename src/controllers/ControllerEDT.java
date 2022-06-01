package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import modele.Semaine;
import utils.ICSParser;

public class ControllerEDT implements Initializable{
	
	private Semaine modeledSemaine = new Semaine();
	private ICSParser parser;
	
    
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
    
    @FXML
    private Label jeudi;

    @FXML
    private ListView<Text> liste_jeudi;

    @FXML
    private ListView<Text> liste_lundi;

    @FXML
    private ListView<Text> liste_mardi;

    @FXML
    private ListView<Text> liste_mercredi;

    @FXML
    private ListView<Text> liste_vendredi;

    @FXML
    private Label lundi;

    @FXML
    private Label mardi;

    @FXML
    private Label mercredi;

    @FXML
    private Button test;

    @FXML
    private Label vendredi;

    
    

	
	@FXML
    void changeWeek(MouseEvent event) {
		
		String idSource = event.getPickResult().getIntersectedNode().getId();
		
		if(idSource == null) {
			return;
		}
		if(idSource.equals("previous_edt")) {
			modeledSemaine.decrease();
		} else {
			modeledSemaine.increase();
		}
		//Maj weeks graphique
		majButtonSemaine();
    }
	
	void majButtonSemaine() {
		S1.setText(modeledSemaine.toString());
		S2.setText(modeledSemaine.getFollowingWeek(1).toString());
		S3.setText(modeledSemaine.getFollowingWeek(2).toString());
		S4.setText(modeledSemaine.getFollowingWeek(3).toString());
		S5.setText(modeledSemaine.getFollowingWeek(4).toString());
		
		lundi.setText("Lundi "+modeledSemaine.getSelectedWeek().getDayOfMonth());
		mardi.setText("Mardi "+modeledSemaine.getSelectedWeek().getDayOfMonth()+1);
		mercredi.setText("Mercredi "+modeledSemaine.getSelectedWeek().getDayOfMonth()+2);
		jeudi.setText("Jeudi "+modeledSemaine.getSelectedWeek().getDayOfMonth()+3);
		vendredi.setText("Vendredi "+modeledSemaine.getSelectedWeek().getDayOfMonth()+4);
	}
	
    @FXML
    void select_week(MouseEvent event) {
    	String date = ((Text)event.getTarget()).getText();
    	System.out.println(date);
    	modeledSemaine.setSelectedWeek(LocalDate.parse(date));
    	majButtonSemaine();
    }
    
 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			parser = new ICSParser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		majButtonSemaine();
		System.out.println("Démarrage controlleur EDT");
	}

}
