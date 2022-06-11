package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import modele.Classes;
import modele.Salle;

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
	
	public static String addresseDossierDocumentJoodle()
	{
		String cheminDossierJoodle = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() + File.separator + "Joodle";
		// Création du dossier joodle s'il n'existe pas
		File dossier = new File(cheminDossierJoodle);
		if (!dossier.exists()) {
			dossier.mkdir();
		}
		return cheminDossierJoodle;
	}
	
	public static void chargerClasse() throws FileNotFoundException {
		Scanner sc = new Scanner(Utils.class.getClassLoader().getResourceAsStream("groupeEtudiant.csv"));
		sc.useDelimiter(";");
		while(sc.hasNext()) {
			String[] ligneClasse = sc.next().split(",");
			Classes.ajouterClasse(Integer.parseInt(ligneClasse[0].strip()), ligneClasse[1]);
		}
		sc.close();
	}
	
	public static void chargerSalles() throws NumberFormatException, IOException{
		Scanner sc = new Scanner(Utils.class.getClassLoader().getResourceAsStream("salles.csv"));
        sc.useDelimiter(";");
        while(sc.hasNext()) {
            String data = sc.next();
            new Salle(data.split(",")[0].replace("\n", ""), Integer.parseInt(data.split(",")[1]));
        }
        sc.close();
	}

}
