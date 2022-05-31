package modele;

import java.util.HashMap;
import java.util.Map;

public class Classes {
	
	private Map<Integer, String> classes = new HashMap<Integer, String>();
	
	public boolean estClassePresente(int code) {
		return classes.containsKey(code);
	}
	
	public void ajouterClasse(int code, String nomClasse) {
		classes.put(code, nomClasse);
	}
}
