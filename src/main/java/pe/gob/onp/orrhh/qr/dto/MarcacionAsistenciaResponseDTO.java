package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;

public class MarcacionAsistenciaResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String menesaje;
	private Integer total;
	private Integer totalPresentes;
	private String titulo;
	
	public String getMenesaje() {
		return menesaje;
	}
	
	public void setMenesaje(String menesaje) {
		this.menesaje = menesaje;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public Integer getTotalPresentes() {
		return totalPresentes;
	}
	
	public void setTotalPresentes(Integer totalPresentes) {
		this.totalPresentes = totalPresentes;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
