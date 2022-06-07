package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import modele.Erreurs;
import modele.Salle;
import utils.Utils;

public class ControllerSalleLibre implements Initializable{
	
	@FXML private ChoiceBox<Integer> heureDebut;
	
	@FXML private ChoiceBox<Integer> heureFin;
	
	@FXML private DatePicker date;
	
	@FXML private ListView<String> listeSalleLibre;
	
	private final Integer[] tableauHeure = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
	
	
	@FXML private void chercherSalleLibre(ActionEvent e) {
		listeSalleLibre.getItems().clear();
		LocalDate dateChoisit = date.getValue();
		LocalDateTime timestampDebut = dateChoisit.atTime(heureDebut.getValue(), 0);
		LocalDateTime timestampFin = dateChoisit.atTime(heureFin.getValue(), 0);
		if (timestampDebut.isAfter(timestampFin)) {
			// Ici mettre pop up
		}
		Set<Salle> listeSalle = Salle.getListeSalles();
		for(Salle salle : listeSalle) {
			if(salle.getListeCours().searchCoursBetweenStartAndEnd(timestampDebut, timestampFin) == null) {
				listeSalleLibre.getItems().add(salle.getNomSalle());
			}
		}
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		heureDebut.getItems().addAll(tableauHeure);
		heureFin.getItems().addAll(tableauHeure);
	}

}
