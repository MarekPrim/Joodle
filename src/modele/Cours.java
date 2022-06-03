package modele;

import javafx.scene.paint.Color;
import utils.UtilitaireICSTimeSlot;

/*
 * Permet de représenter un créneau de cours avec sa salle, sa matière, son type, son professeur
 * et ses horaires
 * @author Kilyan
 */
public class Cours {
	private String start;
	private String end;
	private String cours;
	private String salle;
	private String professeur;
	private String type;

	public Cours(){
		this.start = "";
		this.end = "";
		this.cours = "";
		this.type = "";
		this.salle = "";
		this.professeur = "";
	}
	
	public Cours(String start, String end, String cours, String salle, String professeur) {
		this.start = start;
		this.end = end;
		this.cours = cours;
		this.salle = salle;
		this.professeur = professeur;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
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
		return this.getStartingHour()+" - " +this.getEndingHour() + "\n" + this.type + " - " + this.cours+"\n"+this.professeur+"\n";
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
	 * Se référer à la javadoc de UtilitaireICSTimeSlot.getDayNumber()
	 * @return String
	 */
	public int getDayNumber() {
		return UtilitaireICSTimeSlot.getDayNumber(this);
	}

	/**
	 * Se référer à la javadoc de UtilitaireICSTimeSlot.getMonth()
	 * @return String
	 */
	public String getMonth() {
		return UtilitaireICSTimeSlot.getMonth(this);
	}

	/**
	 * Se référer à la javadoc de UtilitaireICSTimeSlot.getStartingHour()
	 * @return String
	 */
	public String getStartingHour() {
		return UtilitaireICSTimeSlot.getStartingHour(this);
	}

	/**
	 * Se référer à la javadoc de UtilitaireICSTimeSlot.getEndingHour()
	 * @return String
	 */
	public String getEndingHour() {
		return UtilitaireICSTimeSlot.getEndingHour(this);
	}

	/**
	 * Se référer à la javadoc de UtilitaireICSTimeSlot.getMonthNumber()
	 * @return int
	 */
	public int getMonthNumber() {
		return UtilitaireICSTimeSlot.getMonthNumber(this);
	}
	
}
