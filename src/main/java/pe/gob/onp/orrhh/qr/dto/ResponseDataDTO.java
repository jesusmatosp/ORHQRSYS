package pe.gob.onp.orrhh.qr.dto;

import java.io.Serializable;

public class ResponseDataDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String codigoHTTP;
	private String message;
	private Object data;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigoHTTP() {
		return codigoHTTP;
	}
	public void setCodigoHTTP(String codigoHTTP) {
		this.codigoHTTP = codigoHTTP;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
