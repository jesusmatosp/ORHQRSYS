package pe.gob.onp.orrhh.qr.service;

import java.util.Locale;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import pe.gob.onp.orrhh.qr.dto.PersonaDTO;
import pe.gob.onp.orrhh.qr.model.Persona;
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
	
	public boolean validarPersona(PersonaDTO personaDTO) throws PersonaException {
		if(personaDTO.getDni()==null) throw new PersonaException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PERSONA_DNI, null, Locale.US));
		if(personaDTO.getApellidoPaterno() == null) throw new PersonaException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PERSONA_APELLIDO_PATERNO, null, Locale.US));
		if(personaDTO.getApellidoMaterno() == null) throw new PersonaException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PERSONA_APELLIDO_MATERNO, null, Locale.US));
		if(personaDTO.getNombres() == null )throw new PersonaException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PERSONA_NOMBRE, null, Locale.US));
		if(personaDTO.getCorreoCorporativo()  == null ) throw new PersonaException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PERSONA_CORREO_CORPORATIVO, null, Locale.US));
		return true;
	}
	
}
