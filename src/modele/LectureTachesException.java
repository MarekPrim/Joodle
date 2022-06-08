package modele;

public class LectureTachesException extends Exception {

	
	public LectureTachesException(String message) {
		super(message);
	}
	
	public LectureTachesException(String message, Throwable exceptionParent) {
		super(message, exceptionParent);
	}
}
