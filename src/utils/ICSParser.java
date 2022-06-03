package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modele.Cours;


//Parse each element from a .ics file
public class ICSParser {
	
	private static final String FILENAME = "ADECal.ics";

private ArrayList<String> icsContent;

	public ICSParser() throws IOException {
		//Read the file and store the content in a string
		this.icsContent = this.readFileToArrayListOfString(ICSParser.FILENAME);
	}
	
	public ICSParser(File fichier) throws IOException {
		this.icsContent = this.readFileToArrayListOfString(fichier.getPath());
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
	
	/**
	 * Return the list of all the events in the file
	 * @return
	 */
	public ListeCours recoverData(){
		ListeCours stack = new ListeCours();
		for(int i = 0;i<this.icsContent.size()-1;i++) {
			
			if(this.icsContent.get(i).equals("BEGIN:VEVENT")) {
				Cours cumul = new Cours();
				while(! this.icsContent.get(i).equals("END:VEVENT") && i<this.icsContent.size()-1) {

					try {
						this.parseICSSpecificString(this.icsContent.get(i),cumul);
					} catch (ParseException e) {
						System.out.println("Error while parsing the string: " + this.icsContent.get(i));
					}i++;
				}
				stack.add(cumul);
			}
		}
		return stack;
	}
	
	private void parseICSSpecificString(String icsString, Cours slot) throws ParseException {
		String value = icsString.split(":").length > 1 ? icsString.split(":")[1] : "";
	
		switch (icsString.split(":")[0]) {
		case "DTSTART":
			slot.setStart(value);
			break;
		case "DTEND":
			slot.setEnd(value);
			break;
		case "SUMMARY":
			slot.setCours(value);
			break;
		case "LOCATION":
			slot.setSalle(value);
			break;
		case "DESCRIPTION":
			int index = icsContent.indexOf(icsString);
			String deuxiemeValue = icsContent.get(index+1);
			value = value + deuxiemeValue;
			Pattern rgx = Pattern.compile("[^\\\\n]*\\(\\d+\\)\\s?\\\\n[a-zA-Z\\s]+");
			Matcher matcher = rgx.matcher(value);
			if(matcher.find()) {
				value = matcher.group(0);
				value.replace('\n', ':');
			} else {
				//Non trouvé
			}
			slot.setProfesseur(value.split("\\\\n")[1]);
		default:
			break;
		}
	}
}
