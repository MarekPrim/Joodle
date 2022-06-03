package utils;

import modele.Cours;

public class UtilitaireICSTimeSlot {
	
	/**
	 * Transforme un string au format "Mon" dans un jour complet en français
	 * @param timeSlot : le créneau de cours
	 * @return la traduction du jour au format français
	 */
	public static String getDay(Cours timeSlot) {
		switch (timeSlot.getStart().getDayOfWeek()) {
		case MONDAY:
			return "Lundi";
		case TUESDAY:
			return "Mardi";
		case WEDNESDAY:
			return "Mercredi";
		case THURSDAY:
			return "Jeudi";
		case FRIDAY:
			return "Vendredi";
		default:
			return "";
		}
	}
	
	/**
	 * Retourne le numéro du jour dans la semaine
	 * @param timeSlot
	 * @return int
	 */
	static int getDayWeekNumber(Cours timeSlot) {
		return timeSlot.getStart().getDayOfWeek().getValue();
	}

	/**
	 * Retourne le numéro du jour dans le mois
	 * @param timeSlot
	 * @return int
	 */
	public static int getDayNumber(Cours timeSlot){
		return timeSlot.getStart().getDayOfMonth();
	}
	
	/**
	 * Retourne la traduction du mois au format français
	 * @param timeSlot
	 * @return String
	 */
	public static String getMonth(Cours timeSlot) {
		switch (timeSlot.getStart().getMonth()) {
		case JANUARY:
			return "Janvier";
		case FEBRUARY:
			return "Février";
		case MARCH:
			return "Mars";
		case APRIL:
			return "Avril";
		case MAY:
			return "Mai";
		case JUNE:
			return "Juin";
		case JULY:
			return "Juillet";
		case AUGUST:
			return "Août";
		case SEPTEMBER:
			return "Septembre";
		case OCTOBER:
			return "Octobre";
		case NOVEMBER:
			return "Novembre";
		case DECEMBER:
			return "Décembre";
		default:
			return "";
		}
	}
	
	/**
	 * Retourne le numéro du mois dans l'année
	 * @param timeSlot
	 * @return int
	 */
	public static int getMonthNumber(Cours timeSlot) {
		return timeSlot.getStart().getMonthValue();
	}
	
	/**
	 * Retourne l'heure de début
	 * @param timeSlot
	 * @return String
	 */
	public static int getStartingHour(Cours timeSlot) {
		return timeSlot.getStart().getHour();
	}
	
	/**
	 * Retourne l'heure de fin
	 * @param timeSlot
	 * @return String
	 */
	public static int getEndingHour(Cours timeSlot) {
		return timeSlot.getEnd().getHour();
	}

}
