package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;

public class RolDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idRol;
	private String nombreRol;
	private String activo;
	private String descripcion;
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
