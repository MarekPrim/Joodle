package modele;

import javafx.scene.paint.Color;
import utils.UtilitaireICSTimeSlot;

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
	
	public String afficher() {
		return this.getStartingHour()+" - " +this.getEndingHour() + "\n" + this.type + " - " + this.cours+"\n"+this.professeur+"\n";
	}
	
	public String getDay(){
		return UtilitaireICSTimeSlot.getDay(this);
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
		return UtilitaireICSTimeSlot.getDayNumber(this);
	}

	public String getMonth() {
		return UtilitaireICSTimeSlot.getMonth(this);
	}

	public String getStartingHour() {
		return UtilitaireICSTimeSlot.getStartingHour(this);
	}

	public String getEndingHour() {
		return UtilitaireICSTimeSlot.getEndingHour(this);
	}

	public int getMonthNumber() {
		return UtilitaireICSTimeSlot.getMonthNumber(this);
	}
	
}
