package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import utils.Utils;

@SuppressWarnings("deprecation")
public class Erreurs extends Observable{
	
	/**
	 * Permet la sérialisation et désérialisation des données pour les sauvegarder dans un fichier.
	 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
	 */


	private static Erreurs instanceErreurs;
	private Observer control;

	private ArrayList<Throwable> errors;
	
	private Erreurs() {
		this.errors = new ArrayList<Throwable>();
	}
	
	/**
	 * Retourne le profil étudiant actif de l'application.
	 * Si un profil avait été sauvegardé lors de la derniére utilisation il sera automatiquement chargé.
	 * @return Le profil étudiant actif.
	 * @throws LectureProfilException 
	 */
	public static Erreurs getInstanceErreur() {
		
		// Si l'instance est nulle on essaye de chargé le profil etudiant qui aurait pé etre sauvegardé.
		if (instanceErreurs == null) {
			instanceErreurs = new Erreurs();
		}
		return instanceErreurs;
	}
	
	public static void ajouterErreur(Throwable s) {
		Erreurs erreurs = Erreurs.getInstanceErreur();
		erreurs.errors.add(s);
		Erreurs.getInstanceErreur().setChanged();
		Erreurs.getInstanceErreur().notifyObservers(s.getLocalizedMessage());
	}
	
	public static void ajouterObserver(Observer o) {
		Erreurs.getInstanceErreur().addObserver(o);
	}
	


}