package pe.gob.onp.orrhh.qr.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "V_PERSONA_EVENTO_ASIST")
public class PersonaEventoAsistenteBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "ID" )
	private Long id;
	
	@Column( name = "ID_ASISTENCIA" )
	private Long idAsistencia;
	
	@Column( name = "ID_EVENTO" )
	private Long idEvento;
	
	@Column( name = "NOMBRE_CORTO" )
	private String nombreCorto;
	
	@Column( name = "TIPO_EVENTO" )
	private String tipoEvento;
	
	@Column( name = "NOMBRE_EVENTO" )
	private String nombreEvento;
	
	@Column( name = "SEDE" )
	private String sede;
	
	@Column( name = "DNI" )
	private String dni;
	
	@Column( name = "NOMBRES" )
	private String nombres;
	
	@Column( name = "APELLIDO_PATERNO" )
	private String apellidoPaterno;
	
	@Column( name = "APELLIDO_MATERNO" )
	private String apellidoMaterno;
	
	@Column( name = "SEXO" )
	private String sexo;

	@Column( name = "EDAD" )
	private String edad;
	
	@Column( name = "FECHA_INGRESO" )
	private String fechaIngreso;
	
	@Column( name = "PUESTO" )
	private String puesto;
	
	@Column( name = "REGIMEN" )
	private String regimen;
	
	@Column( name = "AREA_OPERATIVA" )
	private String areaOperativa;
	
	@Column( name = "FECHA_ASISTENCIA" )
	private String fechaAsistencia;
	
	@Column( name = "HORA_ASISTENCIA" )
	private String horaAsistencia;

	public Long getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
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

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public String getAreaOperativa() {
		return areaOperativa;
	}

	public void setAreaOperativa(String areaOperativa) {
		this.areaOperativa = areaOperativa;
	}

	public String getFechaAsistencia() {
		return fechaAsistencia;
	}

	public void setFechaAsistencia(String fechaAsistencia) {
		this.fechaAsistencia = fechaAsistencia;
	}

	public String getHoraAsistencia() {
		return horaAsistencia;
	}

	public void setHoraAsistencia(String horaAsistencia) {
		this.horaAsistencia = horaAsistencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
