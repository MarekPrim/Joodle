package modele;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;


public class Cours {
	private LocalDateTime start;
	private LocalDateTime end;
	private String cours;
	private String salle;
	private String professeur;
	
	private static final DateTimeFormatter formatterDateHeure= DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'");

	public Cours(){
		this.start = null;
		this.end = null;
		this.cours = "";
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

	@Override
	public String toString() {
		return "start=" + start + "\nend=" + end + "\ncours=" + cours + "\nsalle=" + salle + "\nprofesseur="
				+ professeur + "\n";
	}
	
	public String afficher() {
		return this.getStartingHour()+" - "+this.cours + ", "+this.salle+";\n"+this.professeur;
	}
	
	public String getDay(){
		return start.getDayOfWeek().toString();
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
