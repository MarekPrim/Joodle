package modele;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Repas {

	private static final DateTimeFormatter formatterDateHeure = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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
	
	private Date convertirDateHeureStringVersLocalDateTime(String dateHeure) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	}
	
	public String afficher() {
		try {
			return ""+convertirDateHeureStringVersLocalDateTime(this.date).toLocaleString().split("à")[0];
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
