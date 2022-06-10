package modele;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.paint.Color;
import utils.UtilitaireICSTimeSlot;


/*
 * Permet de représenter un créneau de cours avec sa salle, sa matière, son type, son professeur
 * et ses horaires
 * @author Kilyan
 */
public class Cours implements Comparable<Cours>{

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
		this.start = convertirDateHeureStringVersLocalDateTime(startString).plusHours(2);
		this.end = convertirDateHeureStringVersLocalDateTime(endString).plusHours(2);
		this.cours = cours;
		this.salle = salle;
		this.professeur = professeur;
	}

	public LocalDateTime getStart() {
		return start;
	}
	
	/**
	 * Convertit une date/heure de string vers un LocalDateTime
	 * @param dateHeure String représentant la date à convertir
	 * @return
	 */
	private LocalDateTime convertirDateHeureStringVersLocalDateTime(String dateHeure) {
		return LocalDateTime.parse(dateHeure, formatterDateHeure);
	}
	
	/**
	 * Indique si un un cours est présent dans le créneau
	 * @param debutCreneau Début du créneau
	 * @param finCreneau Fin du créneau
	 * @return Créneau libre de cours ?
	 */
	public boolean estCoursDansCreneau(LocalDateTime debutCreneau, LocalDateTime finCreneau) {
		return this.start.isEqual(debutCreneau) || this.end.isEqual(finCreneau) || 
				(this.start.isAfter(debutCreneau) && this.start.isBefore(finCreneau)) ||
				(this.start.isBefore(debutCreneau) && this.end.isAfter(debutCreneau));
	}

	public void setStart(String start) {
		this.start = convertirDateHeureStringVersLocalDateTime(start).plusHours(2);
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = convertirDateHeureStringVersLocalDateTime(end).plusHours(2);
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
	
	/**
	 * Permet d'afficher le cours dans le calendrier
	 * @return String : le cours sous forme d'une chaine de caractères
	 */
	public String afficher() {
		return this.getStartingHour()+" - " +this.getEndingHour() + " - " + this.type + "\n" + this.cours + "\n" + this.professeur + "\n";
	}
	
	/**
	 * Permet de fournir la couleur du cours selon son type
	 * @return Color : la couleur du cours
	 */
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

	/**
	 * Se référer à la javadoc de UtilitaireICSTimeSlot.getDay()
	 * @return String
	 */
	public String getDay(){
		return UtilitaireICSTimeSlot.getDay(this);
	}
	
	/**
	 * Retourne le numéro du jour dans le mois
	 * @return String
	 */
	public int getDayNumber() {
		return start.getDayOfMonth();
	}

	/**
	 * Retourne le mois en francais en String
	 * @return String
	 */
	public String getMonth() {
		return start.getMonth().toString();
	}

	/**
	 * Retourne l'heure de début du cours
	 * @return String
	 */
	public String getStartingHour() {
		return start.getHour() + ":" + start.getMinute();
	}

	/**
	 * Retourne l'heure de fin du cours
	 * @return String
	 */
	public String getEndingHour() {
		return end.getHour() + ":" + end.getMinute();
	}

	/**
	 * Retourne le numéro du mois dans l'année
	 * @return int
	 */
	public int getMonthNumber() {
		return start.getMonthValue();
	}

	@Override
	public int compareTo(Cours o) {
		return this.getStart().compareTo(o.getStart());
	}

}
