package pe.gob.onp.orrhh.qr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonaEventoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column( name = "ID_EVENTO" )
	private Long idEvento;
	
	@Column( name = "ID_PERSONA" )
	private Long idPersona;
	
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	
}
