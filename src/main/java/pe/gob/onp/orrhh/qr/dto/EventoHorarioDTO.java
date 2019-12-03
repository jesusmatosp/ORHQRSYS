package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;

public class EventoHorarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idEventoHorario;
	private String dia;
	private String horaInicio;
	private String horaFin;
//	private EventoDTO evento;
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
//	public EventoDTO getEvento() {
//		return evento;
//	}
//	public void setEvento(EventoDTO evento) {
//		this.evento = evento;
//	}
	
	
}
