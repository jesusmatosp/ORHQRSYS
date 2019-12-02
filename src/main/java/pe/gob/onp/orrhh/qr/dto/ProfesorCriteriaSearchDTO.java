package pe.gob.onp.orrhh.qr.dto;

public class ProfesorCriteriaSearchDTO {

	private String dni;
	private String tipoDocumento;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	
	public ProfesorCriteriaSearchDTO() {
		
	}
	
	public ProfesorCriteriaSearchDTO(String dni, String tipoDocumento, String nombre, String apellidoPaterno,
			String apellidoMaterno) {
		super();
		this.dni = dni;
		this.tipoDocumento = tipoDocumento;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
}
