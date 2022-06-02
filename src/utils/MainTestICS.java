package utils;

import java.io.IOException;
import java.text.ParseException;

import modele.Cours;


public class MainTestICS {

	public static void main(String[] args) throws IOException, ParseException {
		ICSParser p = new ICSParser();		
		for(Cours t : p.recoverData()) {
			System.out.println(t.getStart());
			System.out.println(t.getDay());
			System.out.println(t.getDayNumber());
			System.out.println(t.getMonth());
			System.out.println(t.getStartingHour());
			System.out.println(t.getSalle());
			System.out.println(t.getProfesseur());
		}
	}

}
