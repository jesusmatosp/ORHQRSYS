package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;
import java.util.Date;


public class PersonaAsistenciaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long idAsistencia;
	private Date fechaAsistencia;
	private Long idPersona;
	private Long idEvento;
	private String estado;
	private boolean result;
	private String mensaje;
	private String nombrePersona;
	
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
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	
	
}
