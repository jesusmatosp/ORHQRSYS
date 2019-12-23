package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;
import java.util.Date;

public class ProfesorDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idProfesor;
	private String dni;
	private String tipoDocumento;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String telefono;
	private String sexo;
	private String activo;
	private String usuarioCreacion;
	private Date fechaCreacion;
	private String usuarioModifica;
	private Date fechaModifica;
	private String passwordSistema;
	
	
	public Long getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getUsuarioModifica() {
		return usuarioModifica;
	}
	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	public Date getFechaModifica() {
		return fechaModifica;
	}
	public void setFechaModifica(Date fechaModifica) {
		this.fechaModifica = fechaModifica;
	}
	public String getPasswordSistema() {
		return passwordSistema;
	}
	public void setPasswordSistema(String passwordSistema) {
		this.passwordSistema = passwordSistema;
	}
	
	
}
