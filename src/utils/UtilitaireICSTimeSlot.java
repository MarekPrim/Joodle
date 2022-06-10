package utils;

import java.time.LocalDate;

import modele.Cours;

public class UtilitaireICSTimeSlot {
	
	/**
	 * Transforme un string au format "Mon" dans un jour complet en français
	 * @param timeSlot : le créneau de cours
	 * @return la traduction du jour au format français
	 */
	public static String getDay(Cours timeSlot) {
		return getDay(timeSlot.getStart().toLocalDate());
	}
	
	/**
	 * Transforme un string au format "Mon" dans un jour complet en français
	 * @param timeSlot : date au format localdatetime
	 * @return la traduction du jour au format français
	 */
	public static String getDay(LocalDate timeSlot) {
		switch (timeSlot.getDayOfWeek()) {
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
	 * Retourne la traduction du mois au format français
	 * @param timeSlot : Créneau de cours
	 * @return String
	 */
	public static String getMonth(Cours timeSlot) {
		return getMonth(timeSlot.getStart().toLocalDate());
	}

	/**
	 * Retourne la traduction du mois au format français
	 * @param timeSlot : date au format localdatetime
	 * @return String
	 */
	public static String getMonth(LocalDate timeSlot) {
		switch (timeSlot.getMonth()) {
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
	
	

}
