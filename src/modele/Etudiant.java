package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import utils.Utils;

/**
 * Regroupe les informations d'un étudiant qui sont utilisées par l'application 
 * Un seul profil d'étudiant n'est disponible par application, ce profil est accésible avec la méthode getInstanceEtudiant.
 */

public class Etudiant implements Serializable {
	
	/**
	 * Permet la sérialisation et désérialisation des données pour les sauvegarder dans un fichier.
	 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
	 */
	private static final long serialVersionUID = -2882072551330105119L;

	private static Etudiant instanceEtudiant;

	private String nom;
	private String prenom;
	private String classe;
	private String login;
	
	private Etudiant() {
		super();
	}
	
	/**
	 * Retourne le profil étudiant actif de l'application.
	 * Si un profil avait été sauvegardé lors de la derniére utilisation il sera automatiquement chargé.
	 * @return Le profil étudiant actif.
	 * @throws LectureProfilException 
	 */
	public static Etudiant getInstanceEtudiant() throws LectureProfilException {
		
		// Si l'instance est nulle on essaye de chargé le profil etudiant qui aurait pé etre sauvegardé.
		if (instanceEtudiant == null) {
			instanceEtudiant = LireProfilEtudiantSauvegarde();
		}
		return instanceEtudiant;
	}

	/**
	 * Retourne le profil d'un étudiant qui aurait été sauvegardé, 
	 * si aucune sauvegarde n'est trouvé renvoie un nouvel étudiant.
	 * @return Le profil d'un étudiant sauvegardé ou d'un nouvel étudiant s'il n'y a pas de sauvegarde
	 * @throws LectureProfilException
	 */
	private static Etudiant LireProfilEtudiantSauvegarde() throws LectureProfilException {
		// Récuperation de l'adresse du dossier joodle
		String cheminDossierJoodle = Utils.addresseDossierDonneesApplication();

		// On vérifie que le dossier et le fichier des profils existent 
		File dossier = new File(cheminDossierJoodle);
		String cheminFichier = cheminDossierJoodle + File.separator + "profilEtudiant.ser";
		File fichier = new File(cheminFichier);
		if (dossier.exists() && fichier.exists()) {
			try {
				// Ouverture d'un flux de lecture sur le fichier profilEtudiant
				ObjectInputStream ois = new ObjectInputStream (new FileInputStream(fichier));
				
				 // désérialization de l'objet dans le flux sur profilEtudiant
				instanceEtudiant = (Etudiant)ois.readObject();
				ois.close();
			} catch (IOException | ClassNotFoundException e) {
				throw new LectureProfilException("Une erreur est survenue lors de la lecture du profil de étudiant", e);
			}
		}
		// Création d'un nouveau profil car aucune sauvegarde n'a été trouvée.
		else {
			instanceEtudiant = new Etudiant();
		}
		return instanceEtudiant;
	}
	
	/**
	 * Sauvegarde le profil étudiant dans un fichier de sérialisation stocké dans le dossier joodle dans les documents de l'utilisateur.
	 * @throws SauvegardeProfilException Exception generée lorsque une exception est generée lors de l'écriture dans le fichier de sauvegarde.
	 */
	public void sauvegarderProfilEtudiant() throws SauvegardeProfilException {
		
		// Récuperation de l'adresse du dossier joodle
		String cheminDossierJoodle = Utils.addresseDossierDonneesApplication();
		
		// Création du dossier joodle s'il n'existe pas
		File dossier = new File(cheminDossierJoodle);
		if (!dossier.exists()) {
			dossier.mkdir();
		}
		
		// Ouverture d'un flux d'écriture sur le fichier profilEtudiant
		String cheminFichier = cheminDossierJoodle + File.separator + "profilEtudiant.ser";
		File fichier = new File(cheminFichier);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
			
			 // sérialization de l'objet dans le flux sur profilEtudiant
			oos.writeObject(this);
			oos.close();
		} catch (IOException e) {
			throw new SauvegardeProfilException("Une erreur est survenue lors de la sauvegarde du profil etudiant", e);
		}
	
		
	}
	
	/**
	 * Nom de l'étudiant.
	 * @return Une chaine de caractére représentant le nom de l'étudiant.
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Permet de modifier le nom de l'étudiant.
	 * @param nom Le nouveau nom de l'étudiant.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Prénom de l'étudiant.
	 * @return Une chaine de caractére représentant le prénom de l'étudiant.
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Permet de modifier le prénom de l'étudiant.
	 * @param prenom Le nouveau prénom de l'étudiant.
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Classe de l'étudiant.
	 * @return Une chaine de caractére représentant la classe de l'étudiant.
	 */
	public String getClasse() {
		return classe;
	}
	
	public static int codeClasse() throws NomClasseIntrouvableException, LectureProfilException {
		return Classes.getCodeClasse(Etudiant.getInstanceEtudiant().getClasse());
	}
	
	/**
	 * Permet de modifier la classe de l'étudiant.
	 * @param classe La nouvelle classe de l'étudiant.
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	/**
	 * Login de l'étudiant.
	 * @return Une chaine de caractére représentant le login de l'étudiant.
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Permet de modifier le login de l'étudiant.
	 * @param login Le nouveau login de l'étudiant.
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Indique si l'étudiant est connecté
	 * @return
	 * @throws LectureProfilException
	 */
	public static boolean estConnecte() throws LectureProfilException {
		return (Etudiant.getInstanceEtudiant().nom != null && Etudiant.getInstanceEtudiant().prenom != null);
	}

	@Override
	public String toString() {
		return nom + " " + prenom;
	}

}
