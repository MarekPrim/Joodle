package modele;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import utils.UtilitaireICSTimeSlot;

public class Repas {

	private static final DateTimeFormatter formatterDateHeure = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private LocalDate date;
	private List<String> plats;

	public Repas(String dateString, List<String> plats) {
		this.date = this.convertirDateHeureStringVersLocalDateTime(dateString);
		this.plats = plats;
	}

	public LocalDate getDate() {
		return date;
	}

	public List<String> getPlats() {
		return plats;
	}
	
	private LocalDate convertirDateHeureStringVersLocalDateTime(String dateHeure) {
		return LocalDate.parse(dateHeure, formatterDateHeure);
	}
	
	public String afficherDate() {
		return UtilitaireICSTimeSlot.getDay(date) + " "
				+ date.getDayOfMonth() + " " + UtilitaireICSTimeSlot.getMonth(date);
	}

}
