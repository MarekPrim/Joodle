package utils;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;


public class MainTestICS {

		
	public static void main(String[] args) throws IOException, ParseException {
		LocalDate t = LocalDate.parse("2022-06-30");
		t = t.plusDays(1);
		System.out.println(t);
	}

}
