package pe.gob.onp.orrhh.qr.bean;

import java.io.Serializable;
import java.util.List;

public class ReporteDetalladoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ReporteResumenBean> data;
	private List<String> columnas;
	
	public List<ReporteResumenBean> getData() {
		return data;
	}
	public void setData(List<ReporteResumenBean> data) {
		this.data = data;
	}
	public List<String> getColumnas() {
		return columnas;
	}
	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}
}
