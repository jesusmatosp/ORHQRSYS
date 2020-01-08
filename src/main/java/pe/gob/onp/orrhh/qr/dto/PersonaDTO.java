package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;
import java.util.Date;

public class PersonaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPersona;
	private String dni;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private String sexo;
	private String regimen;
	private String puesto;
	private String areaCorporativa;
	private String telefono;
	private Date fechaIngreso;
	private String correoCorporativo;
	private String correoPersonal;
	private byte[] codQR;
	private Date fechaCarga;
	private String usuarioCarga;
	// 
	private String dniOld;
	private String areaOperativaOld;
	private String regimenOld;
	
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
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
	public String getAreaCorporativa() {
		return areaCorporativa;
	}
	public void setAreaCorporativa(String areaCorporativa) {
		this.areaCorporativa = areaCorporativa;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
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
	public Date getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	public String getUsuarioCarga() {
		return usuarioCarga;
	}
	public void setUsuarioCarga(String usuarioCarga) {
		this.usuarioCarga = usuarioCarga;
	}
	public byte[] getCodQR() {
		return codQR;
	}
	public void setCodQR(byte[] codQR) {
		this.codQR = codQR;
	}
	public String getDniOld() {
		return dniOld;
	}
	public void setDniOld(String dniOld) {
		this.dniOld = dniOld;
	}
	public String getAreaOperativaOld() {
		return areaOperativaOld;
	}
	public void setAreaOperativaOld(String areaOperativaOld) {
		this.areaOperativaOld = areaOperativaOld;
	}
	public String getRegimenOld() {
		return regimenOld;
	}
	public void setRegimenOld(String regimenOld) {
		this.regimenOld = regimenOld;
	}
	
}
