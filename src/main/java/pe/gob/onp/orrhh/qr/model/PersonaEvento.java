package pe.gob.onp.orrhh.qr.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "PERSONA_EVENTO", schema = "ORHQRSYS")
public class PersonaEvento {

	@EmbeddedId
	private PersonaEventoPK id;
	
	@Column( name = "ACTIVO" )
	private String activo;
	
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}

}
