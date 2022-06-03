package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import modele.Salle;
import utils.Utils;

public class ControllerSalleLibre implements Initializable{
	
	@FXML private ChoiceBox<Integer> heureDebut;
	
	@FXML private ChoiceBox<Integer> heureFin;
	
	@FXML private DatePicker date;
	
	private final Integer[] tableauHeure = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
	
	
	@FXML private void chercherSalleLibre(ActionEvent e) {
		LocalDate dateChoisit = date.getValue();
		String timestampDebut = dateChoisit.atTime(heureDebut.getValue(), 0).format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'"));
		String timestampFin = dateChoisit.atTime(heureFin.getValue(), 0).format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'"));
		List<Salle> listeSalle = Salle.getListeSalles();
		for(Salle salle : listeSalle) {
			System.out.println(salle.getListeCours().searchByStartAndEnd(timestampDebut.toString(), timestampFin.toString()));
		}
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		heureDebut.getItems().addAll(tableauHeure);
		heureFin.getItems().addAll(tableauHeure);
		if (Salle.getListeSalles().isEmpty()) {
			try {
				Utils.chargerSalles();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
