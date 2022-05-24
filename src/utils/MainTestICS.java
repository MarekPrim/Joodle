package utils;

import java.io.IOException;
import java.text.ParseException;

public class MainTestICS {

	public static void main(String[] args) throws IOException, ParseException {
		ICSParser p = new ICSParser();		
		for(ICSTimeSlot slot : p.recoverData()) {
			System.out.println(slot);
		}
	}

}
