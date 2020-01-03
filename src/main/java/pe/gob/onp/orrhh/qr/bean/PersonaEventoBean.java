package pe.gob.onp.orrhh.qr.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "V_PERSONA_EVENTO" )
public class PersonaEventoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "ID_PERSONA" )
	private Long idPersona;
	
	@Column( name = "DNI" )
	private String dni;
	
	@Column( name = "APELLIDO_PATERNO" )
	private String apellidoPaterno;
	
	@Column( name = "APELLIDO_MATERNO" )
	private String apellidoMaterno;
	
	@Column( name = "NOMBRES" )
	private String nombres;
	
	@Column( name = "SEXO" )
	private String sexo;
	
	@Column( name = "REGIMEN" )
	private String regimen;
	
	@Column( name = "PUESTO" )
	private String puesto;
	
	@Column( name = "AREA_OPERATIVA" )
	private String areaOperativa;
	
	@Column( name = "TELEFONO" )
	private String telefono;
	
	@Column( name = "FECHA_INGRESO" )
	private String fechaIngreso;
	
	@Column( name = "CORREO_CORPORATIVO" )
	private String correoCorporativo;
	
	@Column( name = "CORREO_PERSONAL" )
	private String correoPersonal;
	
	@Column( name = "COD_QR" )
	private byte[] codQR;
	
	@Column( name = "TIPO_EVENTO" )
	private String tipoEvento;
	
	@Column( name = "NOMBRE_EVENTO" )
	private String nombreEvento;
	
	@Column( name = "ID_EVENTO" )
	private Long idEvento;
	
	@Column( name = "FECHA_INICIO" )
	private Date fechaInicio;
	
	@Column( name = "FECHA_CIERRE" )
	private Date fechaCierre;
	
	@Column( name = "SEDE" )
	private String sede;
	
	@Transient
	private String strFechaInicio;
	
	@Transient
	private String strFechaFin;
	
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getRegimen() {
		return regimen;
	}
	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getAreaOperativa() {
		return areaOperativa;
	}
	public void setAreaOperativa(String areaOperativa) {
		this.areaOperativa = areaOperativa;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getCorreoCorporativo() {
		return correoCorporativo;
	}
	public void setCorreoCorporativo(String correoCorporativo) {
		this.correoCorporativo = correoCorporativo;
	}
	public String getCorreoPersonal() {
		return correoPersonal;
	}
	public void setCorreoPersonal(String correoPersonal) {
		this.correoPersonal = correoPersonal;
	}
	public byte[] getCodQR() {
		return codQR;
	}
	public void setCodQR(byte[] codQR) {
		this.codQR = codQR;
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
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getStrFechaInicio() {
		return strFechaInicio;
	}
	public void setStrFechaInicio(String strFechaInicio) {
		this.strFechaInicio = strFechaInicio;
	}
	public String getStrFechaFin() {
		return strFechaFin;
	}
	public void setStrFechaFin(String strFechaFin) {
		this.strFechaFin = strFechaFin;
	}
	
	
	
}
