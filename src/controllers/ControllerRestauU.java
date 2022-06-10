package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import modele.Menu;
import modele.Repas;

public class ControllerRestauU implements Initializable {

	private static final String COLOR_AND_RADIUS_PANE = "-fx-background-radius: 7 ; -fx-background-color: #AFA7A7";
	private static final String URL = "http://webservices-v2.crous-mobile.fr:8080/feed/toulouse/externe/menu.xml";

	@FXML
	private ListView<Text> jour1list;
	@FXML
	private Text jour1Date;
	@FXML
	private Pane jour1Pane;

	@FXML
	private ListView<Text> jour2list;
	@FXML
	private Text jour2Date;
	@FXML
	private Pane jour2Pane;

	@FXML
	private ListView<Text> jour3list;
	@FXML
	private Text jour3Date;
	@FXML
	private Pane jour3Pane;

	@FXML
	private ListView<Text> jour4list;
	@FXML
	private Text jour4Date;
	@FXML
	private Pane jour4Pane;

	@FXML
	private ListView<Text> jour5list;
	@FXML
	private Text jour5Date;
	@FXML
	private Pane jour5Pane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Menu menu = new Menu(URL);
		if (menu.getRepas().size() != 0) {
			remplirAffichage(menu.getRepas());
		}
	}

	private void remplirAffichage(List<Repas> menu) {
		for (int i = 0; i < (menu.size() >= 5 ? 5 : menu.size()); i++) {
			Repas repas = menu.get(i);
			System.out.println(repas.getDate());
			switch (i) {
			case 0:
				setMenu(jour1list, repas.getPlats());
				jour1Date.setText(repas.afficherDate());
				setRadiusPane(repas.getDate(), jour1Pane);
				break;
			case 1:
				setMenu(jour2list, repas.getPlats());
				jour2Date.setText(repas.afficherDate());
				setRadiusPane(repas.getDate(), jour2Pane);
				break;
			case 2:
				setMenu(jour3list, repas.getPlats());
				jour3Date.setText(repas.afficherDate());
				setRadiusPane(repas.getDate(), jour3Pane);
				break;
			case 3:
				setMenu(jour4list, repas.getPlats());
				jour4Date.setText(repas.afficherDate());
				setRadiusPane(repas.getDate(), jour4Pane);
				break;
			case 4:
				setMenu(jour5list, repas.getPlats());
				jour5Date.setText(repas.afficherDate());
				setRadiusPane(repas.getDate(), jour5Pane);
				break;

			default:
				break;
			}
		}
	}

	private void setRadiusPane(LocalDate date, Pane pane) {
		if (date.equals(LocalDate.now())) {
			pane.setStyle(COLOR_AND_RADIUS_PANE);
		}
	}

	/**
	 * Set all the plats of a menu in a ListView
	 * @param menu  the ListView
	 * @param plats menus
	 */
	private void setMenu(ListView<Text> menu, List<String> plats) {
		for (String plat : plats) {
			Text platText = new Text(plat);
			menu.getItems().add(platText);
		}
	}
}
