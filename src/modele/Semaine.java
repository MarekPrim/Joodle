package modele;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Semaine {
	
	private final int REGULAR_STEP = 5;

	private LocalDate week;
	private LocalDate selectedDate;

	public Semaine() {
		this.week = LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(1,DayOfWeek.MONDAY));
		this.selectedDate = LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(1,DayOfWeek.MONDAY));
	}

  public void increase() {
	  System.out.println("Increase");
	  week = week.plusWeeks(REGULAR_STEP);
  }

  public void decrease() {
	  System.out.println("Decrease");
	 week = week.minusWeeks(REGULAR_STEP);
  }
  
  public LocalDate getFollowingWeek(int step) {
	  if(step<=0 || step>=REGULAR_STEP) {
		  throw new IllegalArgumentException();
	  }
	  LocalDate copy = week;
	  copy = copy.plusWeeks(step);
	  return copy;
  }
  
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
