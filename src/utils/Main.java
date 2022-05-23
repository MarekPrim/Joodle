package utils;

import java.io.FileInputStream;
import java.io.IOException;


import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;

public class Main {

	public static void main(String[] args) throws IOException {
		//RequestFormeur rq = new RequestFormeur("2022-07-02","2022-07-15");
		//rq.write();
		
		FileInputStream fin = new FileInputStream("ADECal.ics");
		CalendarBuilder builder = new CalendarBuilder();
		try {
			Calendar calendar = builder.build(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
