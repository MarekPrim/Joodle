package utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class RequestFormeur {
	
	public static final String url = "https://edt.inp-toulouse.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=3579&projectId=35&calType=ical&";
	//https://edt.inp-toulouse.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=3579&projectId=35&calType=ical&firstDate=2021-08-01&lastDate=2022-07-15
	
	private URL urlRequest;
	
	public RequestFormeur(String start,String end) throws IOException {
		this.urlRequest = new URL(RequestFormeur.url+"firstDate="+start+"&lastDate"+end);
	}
	
	public void write() throws IOException {
		InputStream in = this.urlRequest.openStream();
		File targetFile = new File("/home/greenteam/ici.ics");

	    Files.copy(
	      in, 
	      targetFile.toPath(), 
	      StandardCopyOption.REPLACE_EXISTING);
	    in.close();
	}
	
	

}
