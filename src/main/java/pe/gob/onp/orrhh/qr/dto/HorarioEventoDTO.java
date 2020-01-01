package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "V_HORARIOS_POR_EVENTO" )
public class HorarioEventoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private HorarioPkDTO horario;
	
	@Column(name = "ID_EVENTO")
	private Long idEvento;
	
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public HorarioPkDTO getHorario() {
		return horario;
	}
	public void setHorario(HorarioPkDTO horario) {
		this.horario = horario;
	}
	
	
	
}
