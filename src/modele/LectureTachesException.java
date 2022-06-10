package modele;

public class LectureTachesException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5020116272487286203L;

	public LectureTachesException(String message) {
		super(message);
	}
	
	public LectureTachesException(String message, Throwable exceptionParent) {
		super(message, exceptionParent);
	}
}
