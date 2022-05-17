package utils;

/**
 * Exception generée lorsque une exception est generée par une lecture du fichier contenant le profil étudiant.
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
