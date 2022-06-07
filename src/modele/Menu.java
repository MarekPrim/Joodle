package modele;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Menu {
	private static final String LI = "li";
	private static final String RESTO_FIN = "</resto>";
	private static final String LI_DEBUT = "<li>";
	private static final String LI_FIN = "</li>";
	private static final String MENU_FIN = "</menu>";
	private static final String MENU_DEBUT = "<menu";
	private static final String XML_DATE = "<menu date=\"";
	private static final int DATE_SIZE = 10;
	private static final String ERREUR_URL = "Erreur lors de la récupération des menu du RU. Veuillez cotacter un administrateur";
	private static final String NUM_RU = "r665";
	
	List<Repas> repas;
	
	public Menu(String url) {
		repas = new ArrayList<Repas>();
		loadMenu(url);
	}

	public List<Repas> getRepas(){
		return repas;
	}
	
	private void loadMenu(String urlString) {
		try {
			URL url = new URL(urlString);
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
				repas.add(new Repas(date, plats));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(ERREUR_URL);
		}

	}
}
