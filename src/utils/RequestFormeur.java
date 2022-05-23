package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class RequestFormeur {
	
	public static final String url = "https://edt.inp-toulouse.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=3579&projectId=35&calType=ical&";
	//https://edt.inp-toulouse.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=3579&projectId=35&calType=ical&firstDate=2021-08-01&lastDate=2022-07-15
	
	private URL urlRequest;
	
	public RequestFormeur(String start,String end) throws IOException {
		try {
			this.urlRequest = new URL(RequestFormeur.url+"firstDate="+start+"&lastDate"+end);
		} catch (MalformedURLException e) {
			System.out.print("Il y a eu une erreur à la formation de l'url");
			throw new MalformedURLException();
		}
		HttpURLConnection conn = (HttpURLConnection) this.urlRequest.openConnection();
		
		BufferedReader in = new BufferedReader(
			new InputStreamReader(conn.getInputStream())
		);
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();

		System.out.println(content.toString());
	}
	
	

}
