package pe.gob.onp.orrhh.qr.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import pe.gob.onp.orrhh.qr.bean.PersonaBean;
import pe.gob.onp.orrhh.qr.bean.PersonaEventoBean;
import pe.gob.onp.orrhh.qr.dto.PersonaAsistenciaDTO;
import pe.gob.onp.orrhh.qr.dto.PersonaDTO;
import pe.gob.onp.orrhh.qr.model.Evento;
import pe.gob.onp.orrhh.qr.model.EventoHorario;
import pe.gob.onp.orrhh.qr.model.PersonAsistencia;
import pe.gob.onp.orrhh.qr.model.Persona;
import pe.gob.onp.orrhh.qr.model.PersonaEvento;
import pe.gob.onp.orrhh.qr.model.PersonaEventoPK;
import pe.gob.onp.orrhh.qr.repository.EventoHorarioRepository;
import pe.gob.onp.orrhh.qr.repository.EventoRepository;
import pe.gob.onp.orrhh.qr.repository.PersonaAsistenciaRepository;
import pe.gob.onp.orrhh.qr.repository.PersonaEventoBeanRepository;
import pe.gob.onp.orrhh.qr.repository.PersonaEventoRepository;
import pe.gob.onp.orrhh.qr.repository.PersonaRepository;
import pe.gob.onp.orrhh.qr.repository.PersonaViewRepository;
import pe.gob.onp.orrhh.qr.type.DiaType;
import pe.gob.onp.orrhh.qr.utilitario.Constantes;
import pe.gob.onp.orrhh.qr.utilitario.DateUtilitario;
import pe.gob.onp.orrhh.qr.utilitario.exception.PersonaException;

@Service
public class PersonaService {

	private static final Logger LOG = LoggerFactory.getLogger(PersonaService.class);
	
	@Autowired
	private PersonaRepository repository;
	
	@Autowired
	private PersonaViewRepository viewRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PersonaAsistenciaRepository asistRepository;
	
	@Autowired
	private PersonaEventoRepository personaEventoRepository;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private EventoHorarioRepository eventoHorarioRepository;
	
	@Autowired
	private PersonaEventoBeanRepository personaEventoViewRepository;
	
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
			
			// Validar dia:
			// Obtener dia:
			Integer iDia = DateUtilitario.getDiaSemana(DateUtilitario.getCurrentDate());
			String sDia = DiaType.get(iDia).getValue();
			String sHora = DateUtilitario.getHoraActual(DateUtilitario.getCurrentDate());
			List<EventoHorario> eventoHorario = eventoHorarioRepository.getEventoByDiaHora(asistencia.getIdEvento(), sDia, sHora);
			if(eventoHorario.isEmpty()) throw new PersonaException("El Evento o Curso no se encuentra disponible en estos momentos para el registro de asistencia.");
			
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
			EventoHorario evtHora = eventoHorario.get(0);
			pa.setIdEventoHorario(evtHora.getIdEventoHorario());
			pa.setHoraAsistencia(sHora);
			asistRepository.save(pa);
			pAsistencia.setResult(true);
			pAsistencia.setEstado("OK");
			
			// Get Cantidad:
			
			
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
	
	
	public boolean bajaPersona(List<Integer> ids) throws PersonaException {
		boolean result = true;
		try {
			repository.inactivarPersonas(ids);
		} catch (Exception e) {
			result = false;
			LOG.error(e.getLocalizedMessage(), e.getCause());
			throw new PersonaException(e.getLocalizedMessage());
		}
		return result;
	}
	
	public List<PersonaBean> findPersona(PersonaDTO personaDTO) throws PersonaException {
		List<PersonaBean> list = new ArrayList<PersonaBean>();
		try {
			list = findPersonaByCriteria(personaDTO);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			throw new PersonaException(e.getLocalizedMessage());
		}
		return list;
	}
	
	public List<PersonaBean> findPersonaByCriteria(PersonaDTO personaDTO) throws PersonaException {
		return viewRepository.findAll(new Specification<PersonaBean>() {
			@Override
			public Predicate toPredicate(Root<PersonaBean> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				if(personaDTO.getDni() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("dni"), personaDTO.getDni())));
				}
				if(personaDTO.getNombres() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("nombres"), "%" + personaDTO.getNombres().toUpperCase()
							+ "%")));
				}
				if(personaDTO.getApellidoPaterno() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("apellidoPaterno"), "%" + personaDTO.getApellidoPaterno().toUpperCase() + "%")));
				}
				if(personaDTO.getApellidoMaterno() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("apellidoMaterno"), "%" + personaDTO.getApellidoMaterno().toUpperCase() + "%")));
				}
				query.multiselect(root.get("dni"), root.get("regimen"));
				query.distinct(true);
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}
	// 
	public List<PersonaEventoBean> getPersonaEventoByCriteria(PersonaEventoBean requestSearch) throws PersonaException {
		return personaEventoViewRepository.findAll(new Specification<PersonaEventoBean>() {
			@Override
			public Predicate toPredicate(Root<PersonaEventoBean> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				// Obligatorios:
				predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("tipoEvento"), requestSearch.getTipoEvento()))); // tipo de evento
				predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("idEvento"), requestSearch.getIdEvento()))); // id evento
				Date fechaInicio = null;
				Date fechaFin = null;
				if(requestSearch.getStrFechaInicio() != null && requestSearch.getFechaCierre() != null) {
					try {
						fechaInicio = DateUtilitario.convertStringToDate(requestSearch.getStrFechaInicio());
						fechaFin = DateUtilitario.convertStringToDate(requestSearch.getStrFechaFin());
					} catch (ParseException e) {
						e.printStackTrace();
						LOG.error(e.getLocalizedMessage());
					}
					predicates.add(criteriaBuilder.and(criteriaBuilder.between(root.get("fechaInicio"), fechaInicio, fechaFin))); // id evento
				}
				if(requestSearch.getSede() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("sede"), requestSearch.getSede())));
				}
				if(requestSearch.getDni() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("dni"), requestSearch.getDni())));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}
	
	public void modificarDatosPersona(PersonaDTO personaDTO) throws PersonaException {
		try {
			repository.actualizarDatosPersona(personaDTO.getDni(), 
											personaDTO.getApellidoPaterno(), 
											personaDTO.getApellidoMaterno(), 
											personaDTO.getNombres(), 
											personaDTO.getSexo(), 
											personaDTO.getRegimen(), 
											personaDTO.getSexo(), 
											personaDTO.getAreaCorporativa(), 
											personaDTO.getTelefono(), 
											personaDTO.getFechaIngreso(), 
											personaDTO.getCorreoCorporativo(), 
											personaDTO.getCorreoPersonal(),
											personaDTO.getDniOld(),
											personaDTO.getRegimenOld(),
											personaDTO.getAreaOperativaOld());
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			throw new PersonaException(e.getLocalizedMessage());
		}
	}
	
	public PersonaDTO getPersonaByDNI(String dni, String regimen, String areaOperativa) throws PersonaException {
		PersonaDTO personaDTO = new PersonaDTO();
		try {
			List<Persona> personas = repository.getPersonaByDNI(dni, regimen, areaOperativa);
			if(personas != null) {
				Persona persona = personas.get(0);
				BeanUtils.copyProperties(personaDTO, persona);
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			throw new PersonaException(e.getLocalizedMessage());
		}
		return personaDTO;
	}
	
	
	
}
