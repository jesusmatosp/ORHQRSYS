package pe.gob.onp.orrhh.qr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "USUARIO", schema = "ORHQRSYS")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ID_USUARIO")
	@SequenceGenerator(sequenceName = "SQ_ID_USUARIO", allocationSize = 1, name = "SQ_ID_USUARIO")
	@Column( name = "ID_USUARIO" )
	private Long idUsuario;
	
	@Column( name = "ID_ROL" )
	private Long idRol;
	
	@Column( name = "ID_PROFESOR" )
	private Long idProfesor;
	
	@Column( name = "LOGIN" )
	private String login;
	
	@Column( name = "PASSWORD" )
	private String password;
	
	@Column( name = "NOMBRE_COMPLETO" )
	private String nombreCompleto;
	
	@Column( name = "CORREO_ELECTRONICO" )
	private String correoElectronico;
	
	@Column( name = "ACTIVO" )
	private String activo;
	
	@Column( name = "FEC_ULTM_ACCESO" )
	private Date fecUltimoAcceso;
	
	@Column( name = "TIPO_USUARIO" )
	private String tipoUsuario;
	
	@Column( name = "USUARIO_CREACION" )
	private String usuarioCreacion;
	
	@Column( name = "FECHA_CREACION" )
	private Date fechaCreacion;
	
	@Column( name = "USUARIO_MODIFICA" )
	private String usuarioModifica;
	
	@Column( name = "FECHA_MODIFICA" )
	private Date fechaModifica;
	
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public Date getFecUltimoAcceso() {
		return fecUltimoAcceso;
	}
	public void setFecUltimoAcceso(Date fecUltimoAcceso) {
		this.fecUltimoAcceso = fecUltimoAcceso;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public Long getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}
	
}
