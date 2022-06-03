package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import modele.Cours;
import modele.Etudiant;
import modele.LectureProfilException;
import modele.NomClasseIntrouvableException;
import modele.Semaine;
import utils.ICSParser;
import utils.ListeCours;


public class ControllerEDT implements Initializable{

	
	private Semaine modeledSemaine = new Semaine();
	private ListeCours edt;
	
    
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
		mardi.setText("Mardi "+(modeledSemaine.getSelectedWeek().plusDays(1).getDayOfMonth()));
		mercredi.setText("Mercredi "+(modeledSemaine.getSelectedWeek().plusDays(2).getDayOfMonth()));
		jeudi.setText("Jeudi "+(modeledSemaine.getSelectedWeek().plusDays(3).getDayOfMonth()));
		vendredi.setText("Vendredi "+(modeledSemaine.getSelectedWeek().plusDays(4).getDayOfMonth()));
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
		modeledSemaine = new Semaine();
		try {
			int codeClasse;
			try{
				codeClasse = Etudiant.codeClasse();
			} catch(NullPointerException e) {
				codeClasse = 3579;
			}
			ICSParser parser = new ICSParser(codeClasse);
			edt = parser.recoverData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NomClasseIntrouvableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LectureProfilException e) {
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
		for(Cours creneau : edt) {
			int dayNumber = creneau.getDayNumber() - modeledSemaine.getSelectedWeek().getDayOfMonth();
			boolean isSameMonth = modeledSemaine.getSelectedWeek().getMonthValue() == creneau.getMonthNumber();
			if(dayNumber >= 0 && dayNumber <= 4 && isSameMonth) {
				Text texteToBeAdded = new Text(creneau.afficher());
				texteToBeAdded.setFill(creneau.color());
				switch(creneau.getDay()) {
				case "Lundi":
					liste_lundi.getItems().add(texteToBeAdded);
					break;
				case "Mardi":
					liste_mardi.getItems().add(texteToBeAdded);
					break;
				case "Mercredi":
					liste_mercredi.getItems().add(texteToBeAdded);
					break;
				case "Jeudi":
					liste_jeudi.getItems().add(texteToBeAdded);
					break;
				case "Vendredi":
					liste_vendredi.getItems().add(texteToBeAdded);
					break;
				default:
					break;
				}
			} else {
				System.out.println("Modele : "+modeledSemaine.getSelectedWeek().getMonthValue());
				System.out.println("EDT : "+creneau.getMonthNumber()+"/"+dayNumber);
				
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
		String monthString = t.replaceAll("[0-9]", "").strip();
		switch(monthString) {
			case "janvier":
				monthString = "01";
				break;
			case "février":
				monthString = "02";
				break;
			case "mars":
				monthString = "03";
				break;
			case "avril":
				monthString = "04";
				break;
			case "mai":
				monthString = "05";
				break;
			case "juin":
				monthString = "06";
				break;
			case "juillet":
				monthString = "07";
				break;
			case "août":
				monthString = "08";
				break;
			case "septembre":
				monthString = "09";
				break;
			case "octobre":
				monthString = "10";
				break;
			case "novembre":
				monthString = "11";
				break;
			case "décembre":
				monthString = "12";
				break;
			default:
				break;
		}
		return LocalDate.parse(year+"-"+monthString+"-"+day);
	}
	
}
