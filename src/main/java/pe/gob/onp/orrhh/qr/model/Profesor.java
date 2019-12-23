package pe.gob.onp.orrhh.qr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Entity
@Table( name = "PROFESOR", schema = "ORHQRSYS" )
public class Profesor {
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SQ_ID_PROFESOR")
	@SequenceGenerator(sequenceName = "SQ_ID_PROFESOR", allocationSize = 1, name = "SQ_ID_PROFESOR" )
	@Column(name = "ID_PROFESOR")
	private Long idProfesor;
	
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "TIPO_DOCUMENTO")
	private String tipoDocumento;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDO_PATERNO")
	private String apellidoPaterno;
	
	@Column(name = "APELLIDO_MATERNO")
	private String apellidoMaterno;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "SEXO")
	private String sexo;
	
	@Column(name = "ACTIVO")
	private String activo;
	
	@Column(name = "USUARIO_CREA")
	private String usuarioCreacion;
	
	@Column(name = "FECHA_CREA")
	private Date fechaCreacion;
	
	@Column(name = "USUARIO_MODIFICA")
	private String usuarioModifica;
	
	@Column(name = "FECHA_MODIFICA")
	private Date fechaModifica;
	
	@Column( name = "PASSWORD_SISTEMA" )
	private String passwordSistema;
	
	// @OneToOne(mappedBy = "profesor" )
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn( name = "ID_PROFESOR", nullable = false)
//	private Evento evento;
	
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
		if(tipoDocumento != null)
			tipoDocumento = tipoDocumento.trim();
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
//	public Evento getEvento() {
//		return evento;
//	}
//	public void setEvento(Evento evento) {
//		this.evento = evento;
//	}
	public String getPasswordSistema() {
		return passwordSistema;
	}
	public void setPasswordSistema(String passwordSistema) {
		this.passwordSistema = passwordSistema;
	}
	
}
