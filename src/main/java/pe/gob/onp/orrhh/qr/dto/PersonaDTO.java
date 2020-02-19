package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.poi.ss.formula.functions.EDate;

import pe.gob.onp.orrhh.qr.utilitario.exception.PersonaException;

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
	private String edad;
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
	
	public void validarDatosPersona(int position) throws PersonaException {
		if(dni == null || dni.equals("BLANK") || dni.isEmpty()) throw new PersonaException("El campo dni es obligatorio, registro: " + position);
		if(apellidoPaterno == null || apellidoPaterno.equals("BLANK") || apellidoPaterno.isEmpty()) throw new PersonaException("El campo Apellido Paterno es obligatorio, registro: " + position);
		if(apellidoMaterno == null || apellidoMaterno.equals("BLANK") || apellidoMaterno.isEmpty()) throw new PersonaException("El campo Apellido Materno es obligatorio, registro: " + position);
		if(nombres == null || nombres.equals("BLANK") || nombres.isEmpty()) throw new PersonaException("El campo nombres es obligatorio, registro: " + position );
		if(sexo == null || sexo.equals("BLANK") || sexo.isEmpty()) throw new PersonaException("El campo sexo es obligatorio, registro: " + position);
		if(edad == null || edad.equals("BLANK") || edad.isEmpty()) throw new PersonaException("El campo edad es obligatorio, registro: " + position);
		if(puesto == null || puesto.equals("BLANK") || puesto.isEmpty()) throw new PersonaException("El campo puesto es obligatorio, registro: " + position);
		if(regimen == null || regimen.equals("BLANK") || regimen.isEmpty()) throw new PersonaException("El campo regimen es obligatorio, registro: " + position);
		if(areaCorporativa == null || areaCorporativa.equals("BLANK") || areaCorporativa.isEmpty()) throw new PersonaException("El campo area operativa es obligatorio, registro: " + position);
		if(correoCorporativo == null || correoCorporativo.equals("BLANK") || correoCorporativo.isEmpty()) throw new PersonaException("El campo correo corporativo obligatorio, registro: " + position);
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
}
