package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;

public class MainTestICS {

	public static void main(String[] args) throws IOException, ParseException {
		ICSParser p = new ICSParser();		
		for(ICSTimeSlot slot : p.recoverData()) {
			System.out.println(slot);
		}
	}

}
