package modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Classes {
	
	private static Map<Integer, String> classes = new HashMap<Integer, String>();
	
	private Classes() {
		
	}
	
	public static int getCodeClasse(String nomClasse) throws NomClasseIntrouvableException {
		for (Entry<Integer, String> entry : classes.entrySet()) {
			if(nomClasse.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		throw new NomClasseIntrouvableException("La classe " + nomClasse + "+n'a pas été trouvée");
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
