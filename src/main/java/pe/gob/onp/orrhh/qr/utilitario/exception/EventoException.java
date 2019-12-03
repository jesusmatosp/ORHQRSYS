package pe.gob.onp.orrhh.qr.utilitario.exception;

public class EventoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EventoException(String message) {
		super(message);
	}

	public EventoException(String message, Throwable cause) {
		super(message, cause);
		
	}
	
}
