package modele;

public class NomClasseIntrouvableException extends Exception{
	
private static final long serialVersionUID = 6244928258888705146L;
	
	public NomClasseIntrouvableException(String message) {
		super(message);
	}
	
	public NomClasseIntrouvableException(String message, Throwable exceptionParent) {
		super(message, exceptionParent);
	}

}
