package pe.gob.onp.orrhh.qr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonaEventoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column( name = "ID_EVENTO" )
	private Integer idEvento;
	
	@Column( name = "ID_PERSONA" )
	private Integer idPersona;
	
	public Integer getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	
}
