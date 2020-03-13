package pe.gob.onp.orrhh.qr.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "V_ASISTENTES_SEDE" )
public class AsistenteSedeBen implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_EVENTO")
	private Long idEvento;
	
	@Column(name = "NOMBRE_EVENTO")
	private String nombreEvento;
	
	@Column(name = "NOMBRE_CORTO")
	private String nombreCorto;
	
	@Column(name = "SEDE")
	private String sede;
	
	@Column(name = "NOMBRE_SEDE")
	private String nombreSede;
	
	@Column(name = "FECHA_INICIO")
	private String fechaInicio;
	
	@Column(name = "FECHA_CIERRE")
	private String fechaCierre;
	
	@Column(name = "CANTIDAD_ASISTENTE")
	private Integer cantidadAsistente;
	
	@Column( name = "TIPO_EVENTO" )
	private String tipoEvento;
	
	@Column(name = "DT_FECHA_INICIO")
	private Date dtFechaInicio; 
	
	
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getNombreSede() {
		return nombreSede;
	}
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public Integer getCantidadAsistente() {
		return cantidadAsistente;
	}
	public void setCantidadAsistente(Integer cantidadAsistente) {
		this.cantidadAsistente = cantidadAsistente;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public Date getDtFechaInicio() {
		return dtFechaInicio;
	}
	public void setDtFechaInicio(Date dtFechaInicio) {
		this.dtFechaInicio = dtFechaInicio;
	}
	
	
}
