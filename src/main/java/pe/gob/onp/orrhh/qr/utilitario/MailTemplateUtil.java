package pe.gob.onp.orrhh.qr.utilitario;

import pe.gob.onp.orrhh.qr.dto.EventoDTO;
import pe.gob.onp.orrhh.qr.dto.PersonaDTO;
import pe.gob.onp.orrhh.qr.model.Evento;
import pe.gob.onp.orrhh.qr.model.Persona;


public class MailTemplateUtil {
	
	public static String templateQRCode(Persona personaDTO, Evento evento) {
		StringBuffer sb = new StringBuffer();
		sb.append("<p>Estimado Colaborador: " + personaDTO.getNombres() + " " + personaDTO.getApellidoPaterno() + " " + personaDTO.getApellidoMaterno() + " <br />");
		sb.append("Usted ha sido matriculado en el curso/capacitación de " + evento.getNombreEvento() + "<br />");
		sb.append("por ello, por medio de la presente adjuntamos su código QR, el cual le servirá para registrar su asistencia a clase, es de vital importancia no extrabiarlo</p>");
		sb.append("Atte. <br/>");
		sb.append("<h4>Oficina de Recursos Humanos</h4>");
		sb.append("<br /> ONP");
		return sb.toString();
	}
	
}
