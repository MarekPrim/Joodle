package utils;

/**
 * Exception generée lorsque une exception est generée par une sauvegarde du profil étudiant.
 *
 */
public class SauvegardeProfilException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6244928258888705146L;
	
	public SauvegardeProfilException(String message) {
		super(message);
	}
	
	public SauvegardeProfilException(String message, Throwable exceptionParent) {
		super(message, exceptionParent);
	}

}
