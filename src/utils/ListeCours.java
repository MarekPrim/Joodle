package utils;

import java.time.LocalDateTime;
import java.util.ArrayList;

import modele.Cours;

public class ListeCours extends ArrayList<Cours> {
	
	private static final long serialVersionUID = 3606713725038303452L;

	public ListeCours() {
		super();
	}
	
	public Cours searchCoursBetweenStartAndEnd(LocalDateTime lookedStart, LocalDateTime lookedEnd) {
		for(Cours slot : this) {
			if(slot.estCoursDansCreneau(lookedStart, lookedEnd)) {
				return slot;
			}
		}
		return null;
	}



}
