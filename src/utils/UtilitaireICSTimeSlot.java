package utils;

public class UtilitaireICSTimeSlot {
	
	static String getDay(ICSTimeSlot timeSlot) {
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

	static String getDayNumber(ICSTimeSlot timeSlot){
		return timeSlot.getStart().substring(8, 10);
	}
	
	static String getMonth(ICSTimeSlot timeSlot) {
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
	
	static String getStartingHour(ICSTimeSlot timeSlot) {
		return timeSlot.getStart().substring(12, 16);
	}
	
	static String getEndingHour(ICSTimeSlot timeSlot) {
		return timeSlot.getEnd().substring(12, 16);
	}

}
