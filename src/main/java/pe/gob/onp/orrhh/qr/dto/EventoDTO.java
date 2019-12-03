package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EventoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long idEvento;
	private String nombreEvento;
	private String nombreCorto;
	private String sede;
	private String tipoEvento;
	private Integer cantidadParticipantes;
	private Date fechaInicio;
	private Date fechaCierre;
	private Integer duracionHoras;
	private String usuarioCreacion;
	private Date fechaCreacion;
	private String usuarioModifica;
	private Date fechaModifica;
	private List<EventoHorarioDTO> horarioDTO;
	private ProfesorDTO profesorDTO;
	
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
	public ProfesorDTO getProfesorDTO() {
		return profesorDTO;
	}
	public void setProfesorDTO(ProfesorDTO profesorDTO) {
		this.profesorDTO = profesorDTO;
	}
	public List<EventoHorarioDTO> getHorarioDTO() {
		return horarioDTO;
	}
	public void setHorarioDTO(List<EventoHorarioDTO> horarioDTO) {
		this.horarioDTO = horarioDTO;
	}


}
