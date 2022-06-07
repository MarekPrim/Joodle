package controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import modele.menu.Repas;


public class ControllerRestauU implements Initializable {

	private static final String COLOR_AND_RADIUS_PANE = "-fx-background-radius: 7 ; -fx-background-color: #AFA7A7";
	private static final String LI = "li";
	private static final String RESTO_FIN = "</resto>";
	private static final String LI_DEBUT = "<li>";
	private static final String LI_FIN = "</li>";
	private static final String MENU_FIN = "</menu>";
	private static final String MENU_DEBUT = "<menu";
	private static final String XML_DATE = "<menu date=\"";
	private static final int DATE_SIZE = 10;
	private static final String URL = "http://webservices-v2.crous-mobile.fr:8080/feed/toulouse/externe/menu.xml";
	private static final String ERREUR_URL = "Erreur lors de la récupération des menu du RU. Veuillez cotacter un administrateur";
	private static final String NUM_RU = "r665";

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

		List<Repas> menu = loadMenu();
		if (menu.size() != 0) {
			remplirAffichage(menu);
		}
	}

	private List<Repas> loadMenu() {
		List<Repas> menus = new ArrayList<>();
		URL url = null;
		try {
			url = new URL(URL);
			HttpURLConnection connexion = (HttpURLConnection) url
					.openConnection();
			connexion.setRequestMethod("GET");
			// int status = connexion.getResponseCode();

			BufferedReader in = new BufferedReader(
					new InputStreamReader(connexion.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

			connexion.disconnect();

			// Récupérer seulement le menu du ru qui nous interesse
			String debutRu = content.substring(
					content.indexOf("<resto id=\"" + NUM_RU + "\">"),
					content.length() - 1);
			String ru = debutRu.substring(0, debutRu.indexOf(RESTO_FIN));

			List<String> menusString = new ArrayList<String>();
			while (ru.contains("menu")) {
				int finMenu = ru.indexOf(MENU_FIN);
				menusString.add(ru.substring(ru.indexOf(MENU_DEBUT), finMenu));
				ru = ru.substring(finMenu + MENU_FIN.length(), ru.length());
			}

			for (String menu : menusString) {
				// récupérer la date du menu
				String date = menu.substring(menu.indexOf(XML_DATE)).substring(
						XML_DATE.length(), DATE_SIZE + XML_DATE.length());
				// Récupérer les plats
				List<String> plats = new ArrayList<String>();
				while (menu.contains(LI)) {
					int finMenu = menu.indexOf(LI_FIN);
					plats.add(menu.substring(
							menu.indexOf(LI_DEBUT) + LI_DEBUT.length(),
							finMenu));
					menu = menu.substring(finMenu + LI_FIN.length(),
							menu.length());
				}
				menus.add(new Repas(date, plats));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(ERREUR_URL);
		}

		return menus;
	}

	private void remplirAffichage(List<Repas> menu) {
		for (int i = 0; i < 4; i++) {
			Repas Repas = menu.get(i);
			switch (i) {
			case 0:
				setMenu(jour1list, Repas.getPlats());
				jour1Date.setText(Repas.getDate());
				setRadiusPane(Repas.getDate(), jour1Pane);
				break;
			case 1:
				setMenu(jour2list, Repas.getPlats());
				jour2Date.setText(Repas.getDate());
				setRadiusPane(Repas.getDate(), jour2Pane);
				break;
			case 2:
				setMenu(jour3list, Repas.getPlats());
				jour3Date.setText(Repas.getDate());
				setRadiusPane(Repas.getDate(), jour3Pane);
				break;
			case 3:
				setMenu(jour4list, Repas.getPlats());
				jour4Date.setText(Repas.getDate());
				setRadiusPane(Repas.getDate(), jour4Pane);
				break;
			case 4:
				setMenu(jour5list, Repas.getPlats());
				jour5Date.setText(Repas.getDate());
				setRadiusPane(Repas.getDate(), jour5Pane);
				break;

			default:
				break;
			}
		}
	}

	private void setRadiusPane(String date, Pane pane) {
		if (date.equals(getActualDate())) {
			pane.setStyle(COLOR_AND_RADIUS_PANE);
		}
	}

	private String getActualDate() {
		LocalDate dateObj = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = dateObj.format(formatter);
		return date;

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
