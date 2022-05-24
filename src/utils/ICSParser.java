package utils;

import java.io.BufferedReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


//Parse each element from a .ics file
public class ICSParser {
	
	//Unused ics parameters enumeration
	private final ArrayList<String> UnusedParameter = new ArrayList<String>() {{
		add("SEQUENCE");
		add("LAST-MODIFIED");
		add("METHOD");
		add("PRODID");
		add("VERSION");
		add("CALSCALE");
		
	   }};
	
	private static final String FILENAME = "/home/greenteam/N7/S6/CPO/projet-long/ADECal.ics";

	private ArrayList<String> icsContent;

	public ICSParser() throws IOException {
		//Read the file and store the content in a string
		this.icsContent = this.readFileToArrayListOfString(ICSParser.FILENAME);
	}
	
	public ICSParser(Path adresse) throws IOException {
		//Read the file and store the content in a string
		this.icsContent = this.readFileToArrayListOfString(adresse.toString());
	}

	private ArrayList<String> readFileToArrayListOfString(String pathFile)
  throws IOException {
    Path path = Paths.get(pathFile);
    ArrayList<String> stack = new ArrayList<String>();
    BufferedReader reader = Files.newBufferedReader(path);
    String line = reader.readLine();
    while (line != null) {
    	stack.add(line);
    	line = reader.readLine();
    }
    return stack;
}
	
	public boolean isValidICSFile() {
		if(this.icsContent.get(0).equals("BEGIN:VCALENDAR")) {
			return true;
		} else {
			return false;
		}
	}
	
	public ICSTimeSlotStack recoverData() throws ParseException, ICSFormatException{
		if(!this.isValidICSFile()) {
			throw new ICSFormatException();
		}
		ICSTimeSlotStack stack = new ICSTimeSlotStack();
		for(int i = 0;i<this.icsContent.size()-1;i++) {
			
			if(this.icsContent.get(i).equals("BEGIN:VEVENT")) {
				ICSTimeSlot cumul = new ICSTimeSlot();
				while(! this.icsContent.get(i).equals("END:VEVENT") && i<this.icsContent.size()-1) {
					this.parseICSSpecificString(this.icsContent.get(i),cumul);i++;
				}
				stack.add(cumul);
			}
		}
		return stack;
	}
	
	private void parseICSSpecificString(String icsString, ICSTimeSlot slot) throws ParseException {
		String goodValue = "";
		String value = icsString.split(":").length > 1 ? icsString.split(":")[1] : "";
		//Standard ICS date format, see RFC 5545 for further information
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
		
		switch (icsString.split(":")[0]) {
		case "DTSTART":
			goodValue = dateFormat.parse(value).toString();
			slot.setStart(goodValue);
			break;
		case "DTEND":
			goodValue = dateFormat.parse(value).toString();
			slot.setEnd(goodValue);
			break;
		case "SUMMARY":
			slot.setCours(value);
			break;
		case "LOCATION":
			slot.setSalle(value);
			break;
		case "DESCRIPTION":
			slot.setProfesseur(value);
			break;
		default:
			//do nothing
			break;
		}
	}
	
	@Override
	public String toString() {
		String c="";
		for(String s : this.icsContent) {
			c+=s+"\n";
		}
		return c;
	}

}
