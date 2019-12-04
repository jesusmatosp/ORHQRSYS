package pe.gob.onp.orrhh.qr.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "PERSONA", schema = "ORHQRSYS")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ID_PERSONA")
	@SequenceGenerator(sequenceName = "SQ_ID_PERSONA", allocationSize = 1, name = "SQ_ID_PERSONA")
	@Column( name = "ID_PERSONA" )
	private Integer idPersona;
	
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
	private String areaCorporativa;
	
	@Column( name = "TELEFONO" )
	private String telefono;
	
	@Column( name = "FECHA_INGRESO" )
	private Date fechaIngreso;
	
	@Column( name = "CORREO_CORPORATIVO" )
	private String correoCorporativo;
	
	@Column( name = "CORREO_PERSONAL" )
	private String correoPersonal;
	
	@Column( name = "COD_QR" )
	private String codQR;
	
	@Column( name = "FECHA_CARGA" )
	private Date fechaCarga;
	
	@Column( name = "USUARIO_CARGA" )
	private String usuarioCarga;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "ID_PROCESO" , nullable = false)
	private Proceso proceso;
	
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
	public String getCodQR() {
		return codQR;
	}
	public void setCodQR(String codQR) {
		this.codQR = codQR;
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
	public Proceso getProceso() {
		return proceso;
	}
	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}
}
