package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;

public class MainTestICS {

	public static void main(String[] args) throws IOException, ParseException, ICSFormatException {
		ICSParser p = new ICSParser();		
		p.recoverData();
	}

}
