package modele;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Classe réprésentant la semaine observé et la semaine selectionné dans la vue
 * @author Kilyan
 */
public class Semaine {
	
	/**
	 * Abstrait l'incrémentation des semaines dans le calendrier
	 */
	private final int REGULAR_STEP = 5;

	private LocalDate week;
	private LocalDate selectedDate;

	public Semaine() {
		this.week = LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(1,DayOfWeek.MONDAY));
		this.selectedDate = LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(1,DayOfWeek.MONDAY));
	}

  /**
   * Permet de récupérer le groupe de semaines suivante
   */
  public void increase() {
	  System.out.println("Increase");
	  week = week.plusWeeks(REGULAR_STEP);
  }

  /**
   * Permet de récupérer le groupe de semaines précédente
   */
  public void decrease() {
	  System.out.println("Decrease");
	 week = week.minusWeeks(REGULAR_STEP);
  }
  
  /**
   * Permet d'obtenir la semaine + n par rapport à la semaine courante
   * @return
   */
  public LocalDate getFollowingWeek(int step) {
	  if(step<=0 || step>=REGULAR_STEP) {
		  throw new IllegalArgumentException();
	  }
	  LocalDate copy = week;
	  copy = copy.plusWeeks(step);
	  return copy;
  }
  
  /**
   * Permet d'obtenir le dernier lundi de la semaine
   * au sens de la date du lundi passé
   */
  public LocalDate getLastLundi() {
	  return week.with(TemporalAdjusters.previous( DayOfWeek.MONDAY ));
  }
  
  @Override
  public String toString() {
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
	  String formattedString = week.format(formatter);
	  return formattedString;
  }
  
  public void setSelectedWeek(LocalDate date) {
	  this.selectedDate = date;
	  System.out.println(date);
  }
  
  public LocalDate getSelectedWeek() {
	  return selectedDate;
  }
  
}
