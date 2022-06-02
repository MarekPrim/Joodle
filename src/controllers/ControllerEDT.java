package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import utils.ICSTimeSlot;
import utils.ICSTimeSlotStack;

public class ControllerEDT implements Initializable{
	
	private Semaine modeledSemaine = new Semaine();
	private ICSTimeSlotStack edt;
	
    
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		S2.setText(modeledSemaine.getFollowingWeek(1).format(formatter));
		S3.setText(modeledSemaine.getFollowingWeek(2).format(formatter));
		S4.setText(modeledSemaine.getFollowingWeek(3).format(formatter));
		S5.setText(modeledSemaine.getFollowingWeek(4).format(formatter));
		
		lundi.setText("Lundi "+modeledSemaine.getSelectedWeek().getDayOfMonth());
		mardi.setText("Mardi "+(modeledSemaine.getSelectedWeek().getDayOfMonth()+1));
		mercredi.setText("Mercredi "+(modeledSemaine.getSelectedWeek().getDayOfMonth()+2));
		jeudi.setText("Jeudi "+(modeledSemaine.getSelectedWeek().getDayOfMonth()+3));
		vendredi.setText("Vendredi "+(modeledSemaine.getSelectedWeek().getDayOfMonth()+4));
	}
	
    @FXML
    void select_week(MouseEvent event) {
    	String date = ((Text)event.getTarget()).getText();
    	System.out.println(date);
    	
    	modeledSemaine.setSelectedWeek(stringToLocalDate(date));
    	majButtonSemaine();
    	fillEDT();
    }
    
 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			ICSParser parser = new ICSParser();
			edt = parser.recoverData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(edt == null) {
			throw new NullPointerException();
		}
		majButtonSemaine();
		fillEDT();
		System.out.println("Démarrage controlleur EDT");
	}
	
	void fillEDT() {
		clearListes();
		for(ICSTimeSlot creneau : edt) {
			int dayNumber = creneau.getDayNumber() - modeledSemaine.getSelectedWeek().getDayOfMonth();
			boolean isSameMonth = modeledSemaine.getSelectedWeek().getMonthValue() == creneau.getMonthNumber();
			if(dayNumber >= 0 && dayNumber <= 4 && isSameMonth) {
				switch(creneau.getDay()) {
				case "Lundi":
					liste_lundi.getItems().add(new Text(creneau.toString()));
					break;
				case "Mardi":
					liste_mardi.getItems().add(new Text(creneau.toString()));
					break;
				case "Mercredi":
					liste_mercredi.getItems().add(new Text(creneau.toString()));
					break;
				case "Jeudi":
					liste_jeudi.getItems().add(new Text(creneau.toString()));
					break;
				case "Vendredi":
					liste_vendredi.getItems().add(new Text(creneau.toString()));
					break;
				default:
					break;
				}
			}
		}
	}

	private void clearListes() {
		liste_lundi.getItems().clear();
		liste_mardi.getItems().clear();
		liste_mercredi.getItems().clear();
		liste_jeudi.getItems().clear();
		liste_vendredi.getItems().clear();
	}

	public LocalDate stringToLocalDate(String t) {
		System.out.println(t);
		String day = t.substring(0,2);
		String year = t.substring(t.length()-4, t.length());
		String month = "06";
		return LocalDate.parse(year+"-"+month+"-"+day);
	}
	
}
