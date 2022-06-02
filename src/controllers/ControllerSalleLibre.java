package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

public class ControllerSalleLibre implements Initializable{
	
	@FXML private ChoiceBox<Integer> heureDebut;
	
	@FXML private ChoiceBox<Integer> heureFin;
	
	@FXML private DatePicker date;
	
	private final Integer[] tableauHeure = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		heureDebut.getItems().addAll(tableauHeure);
		heureFin.getItems().addAll(tableauHeure);
		
	}

}
