package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Salles {
    
    private static Map<Integer, String> salles = new HashMap<Integer, String>();
    
    private Salles() {
    	
    }

    public static void ajouterSalles(int code, String nomClasse) {
        salles.put(code, nomClasse);
    }
    
    public static String getNomSalle(int code) {
        return salles.get(code);
    }
    

    public static void afficher() {
    	String s = "";
    	for(int key : Salles.salles.keySet()) {
    		s+=key+":"+Salles.salles.get(key)+"\n";
    	}
    	System.out.println(s);
    }

}