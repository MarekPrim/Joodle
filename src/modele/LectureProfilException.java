package modele;

/**
 * Exception gener�e lorsque une exception est gener�e par une lecture du fichier contenant le profil �tudiant.
 *
 */
public class LectureProfilException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6244928258888705146L;
	
	public LectureProfilException(String message) {
		super(message);
	}
	
	public LectureProfilException(String message, Throwable exceptionParent) {
		super(message, exceptionParent);
	}

}
