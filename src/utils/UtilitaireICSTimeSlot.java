package utils;

import modele.Cours;

public class UtilitaireICSTimeSlot {
	
	public static String getDay(Cours timeSlot) {
		switch (timeSlot.getStart().substring(0, 3)) {
		case "Mon":
			return "Lundi";
		case "Tue":
			return "Mardi";
		case "Wed":
			return "Mercredi";
		case "Thu":
			return "Jeudi";
		case "Fri":
			return "Vendredi";
		default:
			return "";
		}
	}

	public static String getDayNumber(Cours timeSlot){
		return timeSlot.getStart().substring(8, 10);
	}
	
	public static String getMonth(Cours timeSlot) {
		switch (timeSlot.getStart().substring(4, 7)) {
		case "Jan":
			return "Janvier";
		case "Feb":
			return "Février";
		case "Mar":
			return "Mars";
		case "Apr":
			return "Avril";
		case "May":
			return "Mai";
		case "Jun":
			return "Juin";
		case "Jul":
			return "Juillet";
		case "Aug":
			return "Août";
		case "Sep":
			return "Septembre";
		case "Oct":
			return "Octobre";
		case "Nov":
			return "Novembre";
		case "Dec":
			return "Décembre";
		default:
			return "";
		}
	}
	
	public static String getStartingHour(Cours timeSlot) {
		return timeSlot.getStart().substring(12, 16);
	}
	
	public static String getEndingHour(Cours timeSlot) {
		return timeSlot.getEnd().substring(12, 16);
	}

}
