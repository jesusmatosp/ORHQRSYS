package pe.gob.onp.orrhh.qr.utilitario.exception;

@SuppressWarnings("serial")
public class PersonaException extends Exception {

	public PersonaException(String message) {
		super(message);
	}
	
	public PersonaException(String message, Throwable e) {
		super(message, e);
	}
}
