package pe.gob.onp.orrhh.qr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "ROL", schema = "ORHQRSYS")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ID_ROL")
	@SequenceGenerator(sequenceName = "SQ_ID_ROL", allocationSize = 1, name = "SQ_ID_ROL")
	@Column( name = "ID_ROL" )
	private Long idRol;
	
	@Column( name = "NOMBRE_ROL" )
	private String nombreRol;
	
	@Column( name = "ACTIVO" )
	private String activo;
	
	@Column( name = "DESCRIPCION_ROL" )
	private String descripcion;
	
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
