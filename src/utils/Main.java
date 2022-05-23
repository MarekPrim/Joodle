package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;

public class Main {

	public static void main(String[] args) throws IOException, ParserException {
		FileInputStream fin = new FileInputStream("/home/greenteam/N7/S6/CPO/projet-long/Joodle/src/utils/ADECal.ics");
		CalendarBuilder builder = new CalendarBuilder();
		Calendar calendar = builder.build(fin);

	}

}
