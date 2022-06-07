package modele.menu;

import java.util.List;

public class Repas {

	private String date;
	private List<String> plats;

	public Repas(String date, List<String> plats) {
		this.date = date;
		this.plats = plats;
	}

	public String getDate() {
		return date;
	}

	public List<String> getPlats() {
		return plats;
	}

}
