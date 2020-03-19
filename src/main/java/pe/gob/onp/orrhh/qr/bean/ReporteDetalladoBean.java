package pe.gob.onp.orrhh.qr.bean;

import java.io.Serializable;
import java.util.List;

public class ReporteDetalladoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ReporteResumenBean> data;
	private List<String> columnas;
	private String tipoEvento;
	private String nombreEvento;
	private String nombrePersona;
	private String fechaInicio;
	private String fechaFin;
	
	public List<ReporteResumenBean> getData() {
		return data;
	}
	public void setData(List<ReporteResumenBean> data) {
		this.data = data;
	}
	public List<String> getColumnas() {
		return columnas;
	}
	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
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
}
