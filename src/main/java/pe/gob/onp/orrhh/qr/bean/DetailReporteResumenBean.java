package pe.gob.onp.orrhh.qr.bean;

import java.io.Serializable;

public class DetailReporteResumenBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fechaAsistencia;
	private String asistencia;
	public String getFechaAsistencia() {
		return fechaAsistencia;
	}
	public void setFechaAsistencia(String fechaAsistencia) {
		this.fechaAsistencia = fechaAsistencia;
	}
	public String getAsistencia() {
		return asistencia;
	}
	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}
	
}
