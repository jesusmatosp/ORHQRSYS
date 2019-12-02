package pe.gob.onp.orrhh.qr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "EVENTO_HORARIO", schema = "ORHQRSYS")
public class EventoHorario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ID_EVENTO_HORARIO")
	@SequenceGenerator(sequenceName = "SQ_ID_EVENTO_HORARIO", allocationSize = 1, name = "SQ_ID_EVENTO_HORARIO")
	@Column( name = "ID_EVENTO_HORARIO" )
	private Long idEventoHorario;
	
	@Column( name = "DIA" )
	private String dia;
	
	@Column( name = "HORA_INICIO" )
	private String horaInicio;
	
	@Column( name = "HORA_FIN" )
	private String horaFin;
	
	@ManyToOne
	@JoinColumn( name = "ID_EVENTO" , nullable = false)
	private Evento evento;
	
	
	public Long getIdEventoHorario() {
		return idEventoHorario;
	}
	public void setIdEventoHorario(Long idEventoHorario) {
		this.idEventoHorario = idEventoHorario;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	
}
