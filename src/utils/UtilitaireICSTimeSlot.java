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
	
	static int getDayWeekNumber(ICSTimeSlot timeSlot) {
		switch (timeSlot.getStart().substring(0, 3)) {
		case "Mon":
			return 1;
		case "Tue":
			return 2;
		case "Wed":
			return 3;
		case "Thu":
			return 4;
		case "Fri":
			return 5;
		default:
			return -1;
		}
	}

	static int getDayNumber(ICSTimeSlot timeSlot){
		return Integer.parseInt(timeSlot.getStart().substring(8, 10));
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
	
	static int getMonthNumber(ICSTimeSlot timeSlot) {
		switch (timeSlot.getStart().substring(4, 7)) {
		case "Jan":
			return 1;
		case "Feb":
			return 2;
		case "Mar":
			return 3;
		case "Apr":
			return 4;
		case "May":
			return 5;
		case "Jun":
			return 6;
		case "Jul":
			return 7;
		case "Aug":
			return 8;
		case "Sep":
			return 9;
		case "Oct":
			return 10;
		case "Nov":
			return 11;
		case "Dec":
			return 12;
		default:
			return -1;
		}
	}
	
	static String getStartingHour(ICSTimeSlot timeSlot) {
		return timeSlot.getStart().substring(12, 16);
	}
	
	public static String getEndingHour(Cours timeSlot) {
		return timeSlot.getEnd().substring(12, 16);
	}

}
