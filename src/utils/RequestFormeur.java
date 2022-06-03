package utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;


public class RequestFormeur {
	
	public static final String url = "https://edt.inp-toulouse.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=CODE&projectId=35&calType=ical&firstDate=2021-08-01&lastDate=2022-07-15";
	
	private URL urlRequest;
	
	public RequestFormeur(int code) throws IOException {
		String urlFinal = url.replace("CODE", Integer.toString(code));
		this.urlRequest = new URL(urlFinal);
	}
	
	public File write() throws IOException {
		String addresseDossierJoodle = Utils.addresseDossierDonneesApplication();
		File fichier = new File(addresseDossierJoodle + File.separator + "calendrierTemp.ics");
		
		if (!fichier.exists()) {
			fichier.createNewFile();
		}
        BufferedInputStream inputStream = new BufferedInputStream(this.urlRequest.openStream());
        OutputStream outStream = new FileOutputStream(fichier);
        while (inputStream.available() > 0) {
        	outStream.write(inputStream.read());
       }
        outStream.close();
        return fichier;
	}
	

	
	

}
