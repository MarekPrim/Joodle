package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class RequestFormeur {
	
	public static final String url = "https://edt.inp-toulouse.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=CODE&projectId=35&calType=ical&firstDate=2021-08-01&lastDate=2022-07-15";
	
	private URL urlRequest;
	
	public RequestFormeur(int code) throws MalformedURLException {
		String urlFinal = url.replace("CODE", Integer.toString(code));
		this.urlRequest = new URL(urlFinal);
	}
	
	public File write() throws IOException{
		String addresseDossierJoodle = Utils.addresseDossierDonneesApplication();
		File fichier = new File(addresseDossierJoodle + File.separator + "calendrierTemp.ics");
		
		if (!fichier.exists()) {
			fichier.createNewFile();
		}

        ReadableByteChannel rbc = Channels.newChannel(this.urlRequest.openStream());
        FileOutputStream fos = new FileOutputStream(fichier);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();

        return fichier;
	}
	

	
	

}
