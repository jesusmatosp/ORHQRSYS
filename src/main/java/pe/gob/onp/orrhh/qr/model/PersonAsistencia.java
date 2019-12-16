package pe.gob.onp.orrhh.qr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "PERSONA_ASISTENCIA", schema = "ORHQRSYS")
public class PersonAsistencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ID_ASISTENCIA")
	@SequenceGenerator(sequenceName = "SQ_ID_ASISTENCIA", allocationSize = 1, name = "SQ_ID_ASISTENCIA")
	@Column( name = "ID_ASISTENCIA" )
	private Long idAsistencia;
	
	@Temporal(TemporalType.DATE)
	@Column( name = "FECHA_ASISTENCIA" )
	private Date fechaAsistencia;
	
	@Column( name = "ID_PERSONA" )
	private Long idPersona;
	
	@Column( name = "ID_EVENTO" )
	private Long idEvento;
	
	@Column( name = "ESTADO" )
	private String estado;
	
	public Long getIdAsistencia() {
		return idAsistencia;
	}
	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
	}
	public Date getFechaAsistencia() {
		return fechaAsistencia;
	}
	public void setFechaAsistencia(Date fechaAsistencia) {
		this.fechaAsistencia = fechaAsistencia;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	} 
	
}
