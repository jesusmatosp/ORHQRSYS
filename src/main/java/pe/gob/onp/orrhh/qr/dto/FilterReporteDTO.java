package pe.gob.onp.orrhh.qr.dto;

import java.util.Date;

public class FilterReporteDTO {

	private String tipoEvento;
	private Long idCurso;
	private String sede;
	private String fecha;
	private String dni;
	private String fechaInicio;
	private String fechaFin;
	
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public Long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	@Override
	public String toString() {
		return "FilterReporteDTO [tipoEvento=" + tipoEvento + ", idCurso=" + idCurso + ", sede=" + sede + ", fecha="
				+ fecha + ", dni=" + dni + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	
	
}
	
