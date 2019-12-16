package pe.gob.onp.orrhh.qr.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table( name = "PROCESO" , schema = "ORHQRSYS")
public class Proceso {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ID_PROCESO")
	@SequenceGenerator(sequenceName = "SQ_ID_PROCESO", allocationSize = 1, name = "SQ_ID_PROCESO")
	@Column( name = "ID_PROCESO" )
	private Long idProceso;
	
	@Column( name = "FECHA_EJECUCION" )
	private Date fechaEjecucion;
	
	@Column( name = "USUARIO_EJECUCION" )
	private String usuarioEjecucion;
	
	@OneToMany( mappedBy = "proceso", cascade = CascadeType.ALL)
	private List<Persona> personas;

	public Long getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(Long idProceso) {
		this.idProceso = idProceso;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public String getUsuarioEjecucion() {
		return usuarioEjecucion;
	}

	public void setUsuarioEjecucion(String usuarioEjecucion) {
		this.usuarioEjecucion = usuarioEjecucion;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
}
