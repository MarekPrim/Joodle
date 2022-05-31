package modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classes {
	
	private static Map<Integer, String> classes = new HashMap<Integer, String>();
	
	private Classes() {
		
	}
	
	public static List<String> getListeNomClasse() {
		return new ArrayList<String>(classes.values());
	}
	
	public static String getNomClasse(int code) {
		return classes.get(code);
	}
	
	public static void ajouterClasse(int code, String nomClasse) {
		classes.put(code, nomClasse);
	}
}
