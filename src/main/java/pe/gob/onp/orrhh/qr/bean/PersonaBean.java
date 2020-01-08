package pe.gob.onp.orrhh.qr.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_PERSONA")
public class PersonaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
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
	private Date fechaIngreso;
	
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
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	
}
