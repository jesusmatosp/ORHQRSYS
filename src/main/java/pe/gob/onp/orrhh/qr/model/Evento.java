package pe.gob.onp.orrhh.qr.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "EVENTO", schema = "ORHQRSYS" )
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ID_EVENTO")
	@SequenceGenerator(sequenceName = "SQ_ID_EVENTO", allocationSize = 1, name = "SQ_ID_EVENTO")
	@Column( name =  "ID_EVENTO")
	private Long idEvento;
	
	@Column( name = "NOMBRE_EVENTO" )
	private String nombreEvento;
	
	@Column( name = "NOMBRE_CORTO" )
	private String nombreCorto;
	
	@Column( name = "SEDE" )
	private String sede;
	
	@Column( name = "TIPO_EVENTO" )
	private String tipoEvento;
	
	@Column( name = "CANTIDAD_PARTICIPANTES" )
	private Integer cantidadParticipantes;
	
	@Column( name = "FECHA_INICIO" )
	private Date fechaInicio;
	
	@Column( name = "FECHA_CIERRE" )
	private Date fechaCierre;
	
	@Column( name = "DURACION_HORAS" )
	private Integer duracionHoras;
	
	@Column( name = "USUARIO_CREA" )
	private String usuarioCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column( name = "FECHA_CREA" )
	private Date fechaCreacion;
	
	@Column( name = "USUARIO_MODIFICA" )
	private String usuarioModifica;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column( name = "FECHA_MODIFICA" )
	private Date fechaModifica;
	
	@OneToMany( mappedBy = "evento", cascade = CascadeType.ALL)
	private List<EventoHorario> horario;
	
	//@OneToOne
	//@JoinColumn( name = "idProfesor", referencedColumnName = "ID_PROFESOR")
//	@OneToMany( mappedBy = "evento", cascade = CascadeType.ALL)
//	private List<Profesor> profesores;
	@Column( name = "ID_PROFESOR" )
	private Long idProfesor;
	
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public Integer getCantidadParticipantes() {
		return cantidadParticipantes;
	}
	public void setCantidadParticipantes(Integer cantidadParticipantes) {
		this.cantidadParticipantes = cantidadParticipantes;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public Integer getDuracionHoras() {
		return duracionHoras;
	}
	public void setDuracionHoras(Integer duracionHoras) {
		this.duracionHoras = duracionHoras;
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
	public List<EventoHorario> getHorario() {
		return horario;
	}
	public void setHorario(List<EventoHorario> horario) {
		this.horario = horario;
	}
//	public Profesor getProfesor() {
//		return profesor;
//	}
//	public void setProfesor(Profesor profesor) {
//		this.profesor = profesor;
//	}
	public Long getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}

}
