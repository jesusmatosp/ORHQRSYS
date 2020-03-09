package pe.gob.onp.orrhh.qr.bean;

import java.io.Serializable;
import java.util.List;

import pe.gob.onp.orrhh.qr.dto.PersonaDTO;

public class ReporteResumenBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombrePersona;
	private PersonaDTO persona;
	private Long idPersona;
	private Integer totalAsistido;
	private Double porcentajeAsistido;
	private Long idEvento;
	
	private List<DetailReporteResumenBean> detalle;
	
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public List<DetailReporteResumenBean> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<DetailReporteResumenBean> detalle) {
		this.detalle = detalle;
	}
	public Integer getTotalAsistido() {
		return totalAsistido;
	}
	public void setTotalAsistido(Integer totalAsistido) {
		this.totalAsistido = totalAsistido;
	}
	public Double getPorcentajeAsistido() {
		return porcentajeAsistido;
	}
	public void setPorcentajeAsistido(Double porcentajeAsistido) {
		this.porcentajeAsistido = porcentajeAsistido;
	}
	public PersonaDTO getPersona() {
		return persona;
	}
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	
	
}
