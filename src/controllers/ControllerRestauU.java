package controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import modele.menu.Repa;

public class ControllerRestauU implements Initializable {

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
	private TextField jour1Menu;
	@FXML
	private TextField jour1Date;

	@FXML
	private TextField jour2Menu;
	@FXML
	private TextField jour2Date;

	@FXML
	private TextField jour3Menu;
	@FXML
	private TextField jour3Date;

	@FXML
	private TextField jour4Menu;
	@FXML
	private TextField jour4Date;

	@FXML
	private TextField jour5Menu;
	@FXML
	private TextField jour5Date;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<Repa> menu = loadMenu();
		if (menu.size() != 0) {
			remplirAffichage(menu);
		}
	}

	private List<Repa> loadMenu() {
		List<Repa> menus = new ArrayList<>();
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
					content.indexOf("<resto id=\"r665\">"),
					content.length() - 1);
			String ru = debutRu.substring(0, debutRu.indexOf("</resto>"));

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
				while (menu.contains("li")) {
					int finMenu = menu.indexOf(LI_FIN);
					System.out.println(
							menu.substring(menu.indexOf(LI_DEBUT)+ LI_DEBUT.length(), finMenu));
					plats.add(menu.substring(
							menu.indexOf(LI_DEBUT) + LI_DEBUT.length(),
							finMenu));
					menu = menu.substring(finMenu + LI_FIN.length(),
							menu.length());
				}

				System.out.println(date);
			}
		} catch (Exception e) {
			// TODO enlever
			e.printStackTrace();
			System.out.println(ERREUR_URL);
		}

		return menus;
	}

	private void remplirAffichage(List<Repa> menu) {
		for (int i = 0; i < 5; i++) {
			Repa repa = menu.get(i);
			switch (i) {
			case 0:
				jour1Menu.setText(repa.getPlats().get(0)); // FIXME pourchaque
															// plat
				jour1Date.setText(repa.getDate());
				break;
			case 1:
				jour2Menu.setText(repa.getPlats().get(0)); // FIXME pourchaque
															// plat
				jour2Date.setText(repa.getDate());
				break;
			case 2:
				jour3Menu.setText(repa.getPlats().get(0)); // FIXME pourchaque
															// plat
				jour3Date.setText(repa.getDate());
				break;
			case 3:
				jour4Menu.setText(repa.getPlats().get(0)); // FIXME pourchaque
															// plat
				jour4Date.setText(repa.getDate());
				break;
			case 4:
				jour5Menu.setText(repa.getPlats().get(0)); // FIXME pourchaque
															// plat
				jour5Date.setText(repa.getDate());
				break;

			default:
				break;
			}
		}
	}
}
