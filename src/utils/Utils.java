package utils;

import java.io.File;

public class Utils {
	
	private Utils() {
		
	}
	
	public static String addresseDossierDonneesApplication()
	{
		String nomOS = System.getProperty("os.name").toLowerCase();
	    if (nomOS.contains("win"))
	        return System.getenv("APPDATA");
	    else if (nomOS.contains("mac"))
	        return System.getProperty("user.home") + File.separator + "Library" 
	        		+ File.separator + "Preferences" + File.separator + "Joodle";
	    else if (nomOS.contains("nix")|| nomOS.contains("nux"))
	        return System.getProperty("user.home") + File.separator + ".config" +
	        	File.separator + "joodle";
	    return System.getProperty("user.dir");
	}

}
