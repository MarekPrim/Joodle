package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;

public class MainTestICS {

	public static void main(String[] args) throws IOException, ParseException {
//		RequestFormeur rq = new RequestFormeur();
//		Path adresse = rq.write();
		ICSParser p = new ICSParser();
		System.out.println(p.toString());
//		for(ICSTimeSlot slot : p.recoverData()) {
//			System.out.println(slot);
//		}
	}

}
