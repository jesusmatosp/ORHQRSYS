package pe.gob.onp.orrhh.qr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "PARAMETRO", schema = "ORHQRSYS")
public class Parametro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ID_PARAMETRO")
	@SequenceGenerator(sequenceName = "SQ_ID_PARAMETRO", allocationSize = 1, name = "SQ_ID_PARAMETRO")
	@Column( name = "ID_PARAMETRO" )
	private Long idParametro;
	
	@Column( name = "COD_PARAMETRO" )
	private String codParametro;
	
	@Column( name = "NOMBRE_PARAMETRO" )
	private String nombreParametro;
	
	@Column( name = "VALOR_PARAMETRO" )
	private String valorParametro;
	
	@Column( name = "COD_PARAM_PADRE" )
	private String codPadre;
	
	@Column( name = "DESCRIPCION" )
	private String descripcion;
	
	@Column( name = "ACTIVO" )
	private String activo;
	
	public Long getIdParametro() {
		return idParametro;
	}
	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}
	public String getCodParametro() {
		return codParametro;
	}
	public void setCodParametro(String codParametro) {
		this.codParametro = codParametro;
	}
	public String getNombreParametro() {
		return nombreParametro;
	}
	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}
	public String getValorParametro() {
		return valorParametro;
	}
	public void setValorParametro(String valorParametro) {
		this.valorParametro = valorParametro;
	}
	public String getCodPadre() {
		return codPadre;
	}
	public void setCodPadre(String codPadre) {
		this.codPadre = codPadre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}

}
