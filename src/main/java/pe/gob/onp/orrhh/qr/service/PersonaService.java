package pe.gob.onp.orrhh.qr.service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import pe.gob.onp.orrhh.qr.dto.PersonaAsistenciaDTO;
import pe.gob.onp.orrhh.qr.dto.PersonaDTO;
import pe.gob.onp.orrhh.qr.model.Evento;
import pe.gob.onp.orrhh.qr.model.PersonAsistencia;
import pe.gob.onp.orrhh.qr.model.Persona;
import pe.gob.onp.orrhh.qr.model.PersonaEvento;
import pe.gob.onp.orrhh.qr.model.PersonaEventoPK;
import pe.gob.onp.orrhh.qr.repository.EventoRepository;
import pe.gob.onp.orrhh.qr.repository.PersonaAsistenciaRepository;
import pe.gob.onp.orrhh.qr.repository.PersonaEventoRepository;
import pe.gob.onp.orrhh.qr.repository.PersonaRepository;
import pe.gob.onp.orrhh.qr.utilitario.Constantes;
import pe.gob.onp.orrhh.qr.utilitario.DateUtilitario;
import pe.gob.onp.orrhh.qr.utilitario.exception.PersonaException;

@Service
public class PersonaService {

	private static final Logger LOG = LoggerFactory.getLogger(PersonaService.class);
	
	@Autowired
	private PersonaRepository repository;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PersonaAsistenciaRepository asistRepository;
	
	@Autowired
	private PersonaEventoRepository personaEventoRepository;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public PersonaDTO guardarDatosPersona(PersonaDTO personaDTO) throws PersonaException {
		try {
			Persona persona = new Persona();
			BeanUtils.copyProperties(persona, personaDTO);
			persona.setFechaCarga(DateUtilitario.getCurrentDate());
			persona = repository.save(persona);
			personaDTO.setIdPersona(persona.getIdPersona());
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			throw new PersonaException(e.getLocalizedMessage());
		}
		return personaDTO;
	}
	
	public PersonaAsistenciaDTO marcarAsistencia(PersonaAsistenciaDTO asistencia) throws PersonaException {
		PersonaAsistenciaDTO pAsistencia = new PersonaAsistenciaDTO();
		try {
			// Validar Evento existe:
			List<Evento> evento = eventoRepository.findEventoByIdFechas(asistencia.getIdEvento(), DateUtilitario.getCurrentDate());
			if(evento.isEmpty()) throw new PersonaException("Código Inválido, el evento o curso no existe o no está activo");
			// Validar Persona pertenece al evento:
			PersonaEventoPK idPersonaEvento = new PersonaEventoPK();
			idPersonaEvento.setIdEvento(asistencia.getIdEvento());
			idPersonaEvento.setIdPersona(asistencia.getIdPersona());
			Optional<PersonaEvento> personaEvento = personaEventoRepository.findById(idPersonaEvento);
			if(!personaEvento.isPresent()) throw new PersonaException("Esta persona no se encuentra matriculada en este evento o curso");
			List<PersonAsistencia> personaAsistencia = asistRepository.getAsistenciaByIdPersonaFecha(asistencia.getIdPersona(), asistencia.getIdEvento());
			List<PersonAsistencia> pAst = personaAsistencia;
			if(!pAst.isEmpty()) throw new PersonaException("La persona ya marcó su asistencia.");
			asistencia.setEstado("A");
			asistencia.setFechaAsistencia(DateUtilitario.getCurrentDate());
			PersonAsistencia pa = new PersonAsistencia();
			BeanUtils.copyProperties(pa, asistencia);
			asistRepository.save(pa);
			pAsistencia.setResult(true);
			pAsistencia.setEstado("OK");
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			throw new PersonaException(e.getLocalizedMessage());
		}
		return pAsistencia;
	}
	
	public boolean validarPersona(PersonaDTO personaDTO) throws PersonaException {
		if(personaDTO.getDni()==null) throw new PersonaException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PERSONA_DNI, null, Locale.US));
		if(personaDTO.getApellidoPaterno() == null) throw new PersonaException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PERSONA_APELLIDO_PATERNO, null, Locale.US));
		if(personaDTO.getApellidoMaterno() == null) throw new PersonaException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PERSONA_APELLIDO_MATERNO, null, Locale.US));
		if(personaDTO.getNombres() == null )throw new PersonaException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PERSONA_NOMBRE, null, Locale.US));
		if(personaDTO.getCorreoCorporativo()  == null ) throw new PersonaException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PERSONA_CORREO_CORPORATIVO, null, Locale.US));
		return true;
	}
	
}
