package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;

public class PersonaEventoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEvento;
	private Integer idPersona;
	private String activo;
	
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
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}

}
