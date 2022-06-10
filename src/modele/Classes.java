package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Permet d'obtenir la correspondance entre une classe (Ex : 1A APP MF2E) et son code
 * dans l'API d'ADE pour obtenir le fichier .ics qui correspond
 * @author Yoan
 */
public class Classes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1237971888485644835L;

	// Map qui contient la correspondance entre une classe et son code dans l'API d'ADE
	// Attribut de classe
	private static Map<Integer, String> classes = new HashMap<Integer, String>();
	
	/*
	 * On ne souhaite pas pouvoir instancier la classe
	 */
	private Classes() {
		
	}
	/*
	 * Recherche dans la map des classes les classes dont le code correspond à celui passé en paramètre
	 * @param String nomClasse : le nom de la classe
	 * @return integer : le code de la classe
	 * @throws NomClasseIntrouableException : si la classe n'est pas trouvée
	 */
	public static int getCodeClasse(String nomClasse) throws NomClasseIntrouvableException {
		for (Entry<Integer, String> entry : classes.entrySet()) {
			if(nomClasse.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		throw new NomClasseIntrouvableException("La classe " + nomClasse + "n'a pas été trouvée");
	}
	
	public static List<String> getListeNomClasse() {
		return new ArrayList<String>(classes.values());
	}
	
	public static Set<Integer> getListeCodeClasse(){
		return classes.keySet();
	}
	
	public static String getNomClasse(int code) {
		return classes.get(code);
	}
	
	public static void ajouterClasse(int code, String nomClasse) {
		classes.put(code, nomClasse);
	}
}
