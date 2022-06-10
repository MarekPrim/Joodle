package modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Erreurs extends Observable{

	private static Erreurs instanceErreurs;

	private ArrayList<Throwable> errors;
	
	private Erreurs() {
		this.errors = new ArrayList<Throwable>();
	}
	
	/**
	 * Retourne une instance de Erreurs
	 */
	public static Erreurs getInstanceErreur() {
		if (instanceErreurs == null) {
			instanceErreurs = new Erreurs();
		}
		return instanceErreurs;
	}
	
	/**
	 * Ajoute une erreur dans la liste statique des erreurs
	 * @param Throwable s
	 */
	public static void ajouterErreur(Throwable s) {
		Erreurs erreurs = Erreurs.getInstanceErreur();
		erreurs.errors.add(s);
		Erreurs.getInstanceErreur().setChanged();
		Erreurs.getInstanceErreur().notifyObservers(s.getLocalizedMessage());
	}
	
	/**
	 * Permet d'ajouter un observer
	 * @param Observer o Observeur
	 */
	public static void ajouterObserver(Observer o) {
		Erreurs.getInstanceErreur().addObserver(o);
	}
	


}