package modele;

/**
 * Exception gener�e lorsque une exception est gener�e par une sauvegarde du profil �tudiant.
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
