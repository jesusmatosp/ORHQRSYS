package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;

public class ParametroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idParametro;
	private String codParametro;
	private String nombreParametro;
	private String valorParametro;
	private String codPadre;
	private String descripcion;
	private String activo;
	
	public Long getIdParametro() {
		return idParametro;
	}
	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}
	public String getCodParametro() {
		return codParametro;
	}
	public void setCodParametro(String codParametro) {
		this.codParametro = codParametro;
	}
	public String getNombreParametro() {
		return nombreParametro;
	}
	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}
	public String getValorParametro() {
		return valorParametro;
	}
	public void setValorParametro(String valorParametro) {
		this.valorParametro = valorParametro;
	}
	public String getCodPadre() {
		return codPadre;
	}
	public void setCodPadre(String codPadre) {
		this.codPadre = codPadre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}

}
