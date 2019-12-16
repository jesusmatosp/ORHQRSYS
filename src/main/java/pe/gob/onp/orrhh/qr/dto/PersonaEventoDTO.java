package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;

public class PersonaEventoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idEvento;
	private Long idPersona;
	private String activo;
	private Long idProceso;
	
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
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public Long getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(Long idProceso) {
		this.idProceso = idProceso;
	}

}
