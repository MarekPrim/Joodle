package utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class RequestFormeur {
	
	public static final String url = "https://edt.inp-toulouse.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=3730&projectId=35&calType=ical&";
	//https://edt.inp-toulouse.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=3579&projectId=35&calType=ical&firstDate=2021-08-01&lastDate=2022-07-15
	
	private URL urlRequest;
	
	public RequestFormeur(String start,String end) throws IOException {
		this.urlRequest = new URL("https://edt.inp-toulouse.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=3730&projectId=35&calType=ical&firstDate=2022-07-02&lastDate=2022-07-15");
	}
	
	public void write() throws IOException {
		Path addresseFile = Files.createTempFile("fffffff", ".ics");
        BufferedInputStream inputStream = new BufferedInputStream(this.urlRequest.openStream());
        
        while (inputStream.available() > 0) {
              
                // Read the byte and
                // convert the integer to character
                char c = (char)inputStream.read();
      
                // Print the characters
                System.out.print(c);
                
       }
        Files.copy(inputStream, addresseFile, StandardCopyOption.REPLACE_EXISTING);
	}
	

	
	

}
