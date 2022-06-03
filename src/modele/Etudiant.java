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
 * Regroupe les informations d'un �tudiant qui sont utilis�es par l'application 
 * Un seul profil d'�tudiant n'est disponible par application, ce profil est acc�sible avec la m�thode getInstanceEtudiant.
 */

public class Etudiant implements Serializable {
	
	/**
	 * Permet la s�rialisation et d�s�rialisation des donn�es pour les sauvegarder dans un fichier.
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
	 * Retourne le profil �tudiant actif de l'application.
	 * Si un profil avait �t� sauvegard� lors de la derni�re utilisation il sera automatiquement charg�.
	 * @return Le profil �tudiant actif.
	 * @throws LectureProfilException 
	 */
	public static Etudiant getInstanceEtudiant() throws LectureProfilException {
		
		// Si l'instance est nulle on essaye de charg� le profil etudiant qui aurait p� etre sauvegard�.
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
		// R�cuperation de l'adresse du dossier joodle
		String cheminDossierJoodle = Utils.addresseDossierDonneesApplication();

		// On v�rifie que le dossier et le fichier des profils existent 
		File dossier = new File(cheminDossierJoodle);
		String cheminFichier = cheminDossierJoodle + File.separator + "profilEtudiant.ser";
		File fichier = new File(cheminFichier);
		if (dossier.exists() && fichier.exists()) {
			try {
				// Ouverture d'un flux de lecture sur le fichier profilEtudiant
				ObjectInputStream ois = new ObjectInputStream (new FileInputStream(fichier));
				
				 // d�s�rialization de l'objet dans le flux sur profilEtudiant
				instanceEtudiant = (Etudiant)ois.readObject();
				ois.close();
			} catch (IOException | ClassNotFoundException e) {
				throw new LectureProfilException("Une erreur est survenue lors de la lecture du profil de �tudiant", e);
			}
		}
		// Cr�ation d'un nouveau profil car aucune sauvegarde n'a �t� trouv�e.
		else {
			instanceEtudiant = new Etudiant();
		}
		return instanceEtudiant;
	}
	
	/**
	 * Sauvegarde le profil �tudiant dans un fichier de s�rialisation stock� dans le dossier joodle dans les documents de l'utilisateur.
	 * @throws SauvegardeProfilException Exception gener�e lorsque une exception est gener�e lors de l'�criture dans le fichier de sauvegarde.
	 */
	public void sauvegarderProfilEtudiant() throws SauvegardeProfilException {
		
		// R�cuperation de l'adresse du dossier joodle
		String cheminDossierJoodle = Utils.addresseDossierDonneesApplication();
		
		// Cr�ation du dossier joodle s'il n'existe pas
		File dossier = new File(cheminDossierJoodle);
		if (!dossier.exists()) {
			dossier.mkdir();
		}
		
		// Ouverture d'un flux d'�criture sur le fichier profilEtudiant
		String cheminFichier = cheminDossierJoodle + File.separator + "profilEtudiant.ser";
		File fichier = new File(cheminFichier);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
			
			 // s�rialization de l'objet dans le flux sur profilEtudiant
			oos.writeObject(this);
			oos.close();
		} catch (IOException e) {
			throw new SauvegardeProfilException("Une erreur est survenue lors de la sauvegarde du profil etudiant", e);
		}
	
		
	}
	
	/**
	 * Nom de l'�tudiant.
	 * @return Une chaine de caract�re repr�sentant le nom de l'�tudiant.
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Permet de modifier le nom de l'�tudiant.
	 * @param nom Le nouveau nom de l'�tudiant.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Pr�nom de l'�tudiant.
	 * @return Une chaine de caract�re repr�sentant le pr�nom de l'�tudiant.
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Permet de modifier le pr�nom de l'�tudiant.
	 * @param prenom Le nouveau pr�nom de l'�tudiant.
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Classe de l'�tudiant.
	 * @return Une chaine de caract�re repr�sentant la classe de l'�tudiant.
	 */
	public String getClasse() {
		return classe;
	}
	
	public static int codeClasse() throws NomClasseIntrouvableException, LectureProfilException {
		return Classes.getCodeClasse(Etudiant.getInstanceEtudiant().getClasse());
	}
	
	/**
	 * Permet de modifier la classe de l'�tudiant.
	 * @param classe La nouvelle classe de l'�tudiant.
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	/**
	 * Login de l'�tudiant.
	 * @return Une chaine de caract�re repr�sentant le login de l'�tudiant.
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Permet de modifier le login de l'�tudiant.
	 * @param login Le nouveau login de l'�tudiant.
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	public static boolean estConnecte() throws LectureProfilException {
		return (Etudiant.getInstanceEtudiant().nom != null && Etudiant.getInstanceEtudiant().prenom != null);
	}

	@Override
	public String toString() {
		return nom + " " + prenom;
	}

}
