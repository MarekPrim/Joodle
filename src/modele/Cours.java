package modele;

import javafx.scene.paint.Color;
import utils.UtilitaireICSTimeSlot;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;


public class Cours {
	private LocalDateTime start;
	private LocalDateTime end;
	private String cours;
	private String salle;
	private String professeur;
	private String type;
	
	private static final DateTimeFormatter formatterDateHeure = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'");

	public Cours(){
		this.start = null;
		this.end = null;
		this.cours = "";
		this.type = "";
		this.salle = "";
		this.professeur = "";
	}
	
	public Cours(String startString, String endString, String cours, String salle, String professeur) {
		this.start = convertirDateHeureStringVersLocalDateTime(startString);
		this.end = convertirDateHeureStringVersLocalDateTime(endString);
		this.cours = cours;
		this.salle = salle;
		this.professeur = professeur;
	}

	public LocalDateTime getStart() {
		return start;
	}
	
	private LocalDateTime convertirDateHeureStringVersLocalDateTime(String dateHeure) {
		return LocalDateTime.parse(dateHeure, formatterDateHeure);
	}
	
	public boolean estCoursDansCreneau(LocalDateTime debutCreneau, LocalDateTime finCreneau) {
		return this.start.isEqual(debutCreneau) || this.end.isEqual(finCreneau) || 
				(this.start.isAfter(debutCreneau) && this.start.isBefore(finCreneau)) ||
				(this.start.isBefore(debutCreneau) && this.end.isAfter(debutCreneau));
	}

	public void setStart(String start) {
		this.start = convertirDateHeureStringVersLocalDateTime(start);
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = convertirDateHeureStringVersLocalDateTime(end);
	}

	public String getCours() {
		return cours;
	}

	public void setCours(String cours) {
		this.cours = cours;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	public String getProfesseur() {
		return professeur;
	}

	public void setProfesseur(String professeur) {
		this.professeur = professeur;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "start=" + start + "\nend=" + end + "\ncours=" + cours + "\nsalle=" + salle + "\nprofesseur="
				+ professeur + "\n";
	}
	
	public String afficher() {
		return this.getStartingHour()+" - " +this.getEndingHour() + "\n" + this.type + " - " + this.cours+"\n"+this.professeur+"\n";
	}
	
	public String getDay(){
		return start.getDayOfWeek().toString();
	}
	
	public Color color() {
		if(this.type.contains("TP")) {
			return Color.GREEN;
		} else if(this.type.contains("TD") || this.type.contains("CTD")){
			return Color.BLUE;
		} else if(this.type.contains("EXAM")) {
			return Color.RED;
		} else {
			return Color.GREY;
		}
	}

	public int getDayNumber() {
		return start.getDayOfMonth();
	}

	public String getMonth() {
		return start.getMonth().toString();
	}

	public String getStartingHour() {
		return start.getHour() + ":" + start.getMinute();
	}

	public String getEndingHour() {
		return end.getHour() + ":" + end.getMinute();
	}

	public int getMonthNumber() {
		return start.getMonthValue();
	}
	
}
