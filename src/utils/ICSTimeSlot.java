package utils;

public class ICSTimeSlot {
	private String start;
	private String end;
	private String cours;
	private String salle;
	private String professeur;

	public ICSTimeSlot(){
		this.start = "";
		this.end = "";
		this.cours = "";
		this.salle = "";
		this.professeur = "";
	}
	
	public ICSTimeSlot(String start, String end, String cours, String salle, String professeur) {
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

	@Override
	public String toString() {
		return "start=" + start + "\nend=" + end + "\ncours=" + cours + "\nsalle=" + salle + "\nprofesseur="
				+ professeur + "\n";
	}
	
	public String getDay(){
		return UtilitaireICSTimeSlot.getDay(this);
	}

	public int getDayNumber() {
		return UtilitaireICSTimeSlot.getDayNumber(this);
	}
	
	public int getDayWeekNumber() {
		return UtilitaireICSTimeSlot.getDayWeekNumber(this);
	}

	public String getMonth() {
		return UtilitaireICSTimeSlot.getMonth(this);
	}
	
	public int getMonthNumber() {
		return UtilitaireICSTimeSlot.getMonthNumber(this);
	}

	public String getStartingHour() {
		return UtilitaireICSTimeSlot.getStartingHour(this);
	}

	public String getEndingHour() {
		return UtilitaireICSTimeSlot.getEndingHour(this);
	}
	
}
