package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import modele.Classes;
import modele.Salles;

public class Utils {
	
	private Utils() {
		
	}
	
	public static String addresseDossierDonneesApplication()
	{
		String nomOS = System.getProperty("os.name").toLowerCase();
	    if (nomOS.contains("win"))
	        return System.getenv("APPDATA") + File.separator + "Joodle";
	    else if (nomOS.contains("mac"))
	        return System.getProperty("user.home") + File.separator + "Library" 
	        		+ File.separator + "Preferences" + File.separator + "Joodle";
	    else if (nomOS.contains("nix")|| nomOS.contains("nux"))
	        return System.getProperty("user.home") + File.separator + ".config" +
	        	File.separator + "joodle";
	    return System.getProperty("user.dir");
	}
	
	public static void chargerClasse() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("groupeEtudiant.csv"));
		sc.useDelimiter(";");
		while(sc.hasNext()) {
			String[] ligneClasse = sc.next().split(",");
			Classes.ajouterClasse(Integer.parseInt(ligneClasse[0].strip()), ligneClasse[1]);
		}
		sc.close();
	}
	
	public static void chargerSalles() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("salles.csv"));
        sc.useDelimiter(",");
        while(sc.hasNext()) {
            String data = sc.next();
            Salles.ajouterSalles(Integer.parseInt(data.split(";")[1]), data.split(";")[0].replace("\n", ""));
        }
        sc.close();
	}

}
