package pe.gob.onp.orrhh.qr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "EVENTO_ASISTENCIA", schema = "ORHQRSYS" )
public class EventoAsistencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ID_EVENTO")
	@SequenceGenerator(sequenceName = "SQ_ID_EVENTO_ASISTENCIA", allocationSize = 1, name = "SQ_ID_EVENTO")
	@Column( name =  "ID")
	private Long id;
	
	@Column( name = "FECHA_REG_ASIS" )
	private Date fechaRegistroAsistencia;
	
	@Column( name = "HORA_REG_ASIS" )
	private String horaRegistroAsistencia;
	
	@Column( name = "ID_EVENTO" )
	private Long idEvento;
	
	@Column( name = "ID_EVENTO_HORARIO" )
	private Long idEventoHorario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaRegistroAsistencia() {
		return fechaRegistroAsistencia;
	}

	public void setFechaRegistroAsistencia(Date fechaRegistroAsistencia) {
		this.fechaRegistroAsistencia = fechaRegistroAsistencia;
	}

	public String getHoraRegistroAsistencia() {
		return horaRegistroAsistencia;
	}

	public void setHoraRegistroAsistencia(String horaRegistroAsistencia) {
		this.horaRegistroAsistencia = horaRegistroAsistencia;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public Long getIdEventoHorario() {
		return idEventoHorario;
	}

	public void setIdEventoHorario(Long idEventoHorario) {
		this.idEventoHorario = idEventoHorario;
	}
	
	
}
