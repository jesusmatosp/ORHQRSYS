package pe.gob.onp.orrhh.qr.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.lowagie.text.pdf.AcroFields.Item;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import pe.gob.onp.orrhh.qr.bean.AsistenteSedeBen;
import pe.gob.onp.orrhh.qr.bean.DetailReporteResumenBean;
import pe.gob.onp.orrhh.qr.bean.PersonaEventoAsistenteBean;
import pe.gob.onp.orrhh.qr.bean.ReporteDetalladoBean;
import pe.gob.onp.orrhh.qr.bean.ReporteResumenBean;
import pe.gob.onp.orrhh.qr.core.unit.mail.EmailHtmlSender;
import pe.gob.onp.orrhh.qr.core.unit.mail.EmailStatus;
import pe.gob.onp.orrhh.qr.dto.AsistenciaDTO;
import pe.gob.onp.orrhh.qr.dto.EventoDTO;
import pe.gob.onp.orrhh.qr.dto.EventoHorarioDTO;
import pe.gob.onp.orrhh.qr.dto.FilterReporteDTO;
import pe.gob.onp.orrhh.qr.dto.HorarioEventoDTO;
import pe.gob.onp.orrhh.qr.dto.PersonaDTO;
import pe.gob.onp.orrhh.qr.dto.PersonaEventoDTO;
import pe.gob.onp.orrhh.qr.dto.ProfesorDTO;
import pe.gob.onp.orrhh.qr.model.Evento;
import pe.gob.onp.orrhh.qr.model.EventoAsistencia;
import pe.gob.onp.orrhh.qr.model.EventoHorario;
import pe.gob.onp.orrhh.qr.model.Parametro;
import pe.gob.onp.orrhh.qr.model.PersonAsistencia;
import pe.gob.onp.orrhh.qr.model.Persona;
import pe.gob.onp.orrhh.qr.model.PersonaEvento;
import pe.gob.onp.orrhh.qr.model.PersonaEventoPK;
import pe.gob.onp.orrhh.qr.model.Proceso;
import pe.gob.onp.orrhh.qr.model.Profesor;
import pe.gob.onp.orrhh.qr.repository.AsistenteSedeRepository;
import pe.gob.onp.orrhh.qr.repository.EventoAsistenciaRepository;
import pe.gob.onp.orrhh.qr.repository.EventoHorarioRepository;
import pe.gob.onp.orrhh.qr.repository.EventoRepository;
import pe.gob.onp.orrhh.qr.repository.ParametroRepository;
import pe.gob.onp.orrhh.qr.repository.PersonaAsistenciaRepository;
import pe.gob.onp.orrhh.qr.repository.PersonaEventoAsistenciaRepository;
import pe.gob.onp.orrhh.qr.repository.PersonaEventoRepository;
import pe.gob.onp.orrhh.qr.repository.PersonaRepository;
import pe.gob.onp.orrhh.qr.repository.ProcesoRepository;
import pe.gob.onp.orrhh.qr.repository.ProfesorRepository;
import pe.gob.onp.orrhh.qr.utilitario.Constantes;
import pe.gob.onp.orrhh.qr.utilitario.DateUtilitario;
import pe.gob.onp.orrhh.qr.utilitario.JasperDataSource;
import pe.gob.onp.orrhh.qr.utilitario.MailTemplateUtil;
import pe.gob.onp.orrhh.qr.utilitario.QRCodeGenerator;
import pe.gob.onp.orrhh.qr.utilitario.exception.EventoException;

@Service
public class EventoService {

	@Autowired
	private PersonaEventoRepository personaEvtRepository;
	
	@Autowired
	private EventoRepository repository;
	
	@Autowired
	private EventoHorarioRepository eventoHorarioRepository;
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private ProcesoRepository procesoRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private ParametroRepository parametroRepository;
	
	@Autowired
	private MessageSource messageSource; 
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private PersonaAsistenciaRepository asistenciaRepository;
	
	@Autowired
	private EventoAsistenciaRepository eventoAsistenciaRepository;
	
	@Autowired
	private AsistenteSedeRepository asistenciaSedeRepository;
	
	@Autowired
	private PersonaEventoAsistenciaRepository personaEventoAsistenciaRepository;
	
	@Autowired
	private EmailHtmlSender emailHtmlSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(EventoService.class); 
	
	public EventoDTO guardarEvento(EventoDTO eventoDTO) throws EventoException {
		try {
			if(validaEvento(eventoDTO)) {
				if(eventoDTO.getIdEvento() != null) {
					// Modificacion:
					Optional<Evento> optional = repository.findById(eventoDTO.getIdEvento());
					if(optional.get() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_NOT_FOUND, null, Locale.US));
					eventoDTO.setUsuarioCreacion(optional.get().getUsuarioCreacion());
					eventoDTO.setFechaCreacion(optional.get().getFechaCreacion());
					eventoDTO.setFechaModifica(DateUtilitario.getCurrentDate());
					eventoHorarioRepository.eliminarHorariosByIdEvento(eventoDTO.getIdEvento());
				} else {
					eventoDTO.setFechaCreacion(DateUtilitario.getCurrentDate());
				}
				Evento evento = new Evento();
				BeanUtils.copyProperties(evento, eventoDTO);
				// Convert....
				evento.setFechaInicio(DateUtilitario.convertStringToDate(eventoDTO.getStrFechaInicio(), "yyyy-MM-dd"));
				evento.setFechaCierre(DateUtilitario.convertStringToDate(eventoDTO.getStrFechaCierre(), "yyyy-MM-dd"));
				// Obtener Datos docente:
				Profesor profesor = new Profesor();
				BeanUtils.copyProperties(profesor, eventoDTO.getProfesorDTO());
				// Obtener Datos del horario:
				List<EventoHorario> horarios = new ArrayList<EventoHorario>();
				List<EventoHorarioDTO> lstHorarioDTO = eventoDTO.getHorarioDTO();
				for(EventoHorarioDTO horarioDTO : lstHorarioDTO) {
					List<String> dias = horarioDTO.getDias();
					for(String dia: dias) {
						EventoHorario eventoHorario = new EventoHorario();
						BeanUtils.copyProperties(eventoHorario, horarioDTO);
						eventoHorario.setDia(dia);
						eventoHorario.setEvento(evento);
						horarios.add(eventoHorario);
					}
				}
				evento.setIdProfesor(profesor.getIdProfesor());
				evento.setHorario(horarios);
				LOG.info(evento.toString());
				evento = repository.save(evento);
				eventoDTO = obtenerEventoById(evento.getIdEvento());
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new EventoException(e.getLocalizedMessage());
		}
		return eventoDTO;
	}
	
	public List<EventoDTO> listarEventoByCriteriaFilter(FilterReporteDTO filter) throws EventoException {
		List<EventoDTO> listEvento = new ArrayList<EventoDTO>();
		try {
			List<Evento> eventos = listarEventoByCriteria(filter);
			List<Evento> iteratorSorted = eventos.stream().sorted(Comparator.comparingLong(Evento::getIdEvento).reversed())
					.collect(Collectors.toList());
			iteratorSorted.forEach( item -> {
				try {
					EventoDTO eventoDTO = new EventoDTO();
					// Profesor:
					Optional<Profesor> oProfesor = profesorRepository.findById(item.getIdProfesor());
					Profesor profesor = oProfesor.get();
					ProfesorDTO profesorDTO = new ProfesorDTO();
					BeanUtils.copyProperties(profesorDTO, profesor);
					// Horarios:
					List<EventoHorario> horarios = item.getHorario();
					List<EventoHorarioDTO> horariosDTO = new ArrayList<EventoHorarioDTO>();
					for(EventoHorario evt: horarios) {
						EventoHorarioDTO eventoHorarioDTO = new EventoHorarioDTO();
						BeanUtils.copyProperties(eventoHorarioDTO, evt);
						horariosDTO.add(eventoHorarioDTO);
					}
					
					// Agrupar:
				 	List<HorarioEventoDTO> lstHorario = new ArrayList<HorarioEventoDTO>(); 
				 	lstHorario = repository.findHorarioByEventoId(item.getIdEvento());
					eventoDTO.setHorarioGroup(lstHorario);
				 	 
					BeanUtils.copyProperties(eventoDTO, item);
					eventoDTO.setProfesorDTO(profesorDTO);
					eventoDTO.setHorarioDTO(horariosDTO);
					listEvento.add(eventoDTO);
				} catch (Exception e) {
					LOG.error(e.getLocalizedMessage(), e);
				}
			});
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new EventoException(e.getLocalizedMessage());
		}
		return listEvento;
	}
	
	public List<Evento> listarEventoByCriteria(FilterReporteDTO filter) throws EventoException {
		LOG.info("Filtro: "+filter.toString());
		return repository.findAll(new Specification<Evento>() {
			@Override
			public Predicate toPredicate(Root<Evento> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				try {
					if(filter.getTipoEvento() != null && !filter.getTipoEvento().isEmpty()) {
						predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("tipoEvento"), "%" + filter.getTipoEvento() + "%")));
					}
					if(filter.getIdCurso() != null && !filter.getIdCurso().equals(0L)) {
						predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("idEvento"), filter.getIdCurso())));
					}
					if( filter.getSede() != null && !filter.getSede().isEmpty()) {
						predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("sede"), filter.getSede())));
					}
					if(filter.getFechaInicio() != null && !filter.getFechaInicio().isEmpty()) {
						predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("fechaInicio"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(filter.getFechaInicio() + " 00:00:00")));
					}
					if(filter.getFechaFin() != null && !filter.getFechaFin().isEmpty()) {
						predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("fechaCierre"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(filter.getFechaFin() + " 23:59:59")));
					}
				} catch (Exception e) {
					LOG.error(e.getLocalizedMessage(), e);
				}
				predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("activo"), Constantes.ESTADO_ACTIVO_VALUE)));
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}
	
	public List<EventoDTO> listarEventoAll() throws EventoException {
		List<EventoDTO> list = new ArrayList<EventoDTO>();
		try {
			// Iterable<Evento> iterator = repository.findAll();
			List<Evento> iterator = repository.findAllActive();
			List<Evento> iteratorSorted = iterator.stream().sorted(Comparator.comparingLong(Evento::getIdEvento).reversed())
					.collect(Collectors.toList());
			iteratorSorted.forEach(item -> {
				try {
					EventoDTO eventoDTO = new EventoDTO();
					// Profesor:
					Optional<Profesor> oProfesor = profesorRepository.findById(item.getIdProfesor());
					Profesor profesor = oProfesor.get();
					ProfesorDTO profesorDTO = new ProfesorDTO();
					BeanUtils.copyProperties(profesorDTO, profesor);
					// Horarios:
					List<EventoHorario> horarios = item.getHorario();
					List<EventoHorarioDTO> horariosDTO = new ArrayList<EventoHorarioDTO>();
					for(EventoHorario evt: horarios) {
						EventoHorarioDTO eventoHorarioDTO = new EventoHorarioDTO();
						BeanUtils.copyProperties(eventoHorarioDTO, evt);
						horariosDTO.add(eventoHorarioDTO);
					}
					
					// Agrupar:
				 	List<HorarioEventoDTO> lstHorario = new ArrayList<HorarioEventoDTO>(); 
				 	lstHorario = repository.findHorarioByEventoId(item.getIdEvento());
					eventoDTO.setHorarioGroup(lstHorario);
				 	 
					BeanUtils.copyProperties(eventoDTO, item);
					eventoDTO.setProfesorDTO(profesorDTO);
					eventoDTO.setHorarioDTO(horariosDTO);
					list.add(eventoDTO);
				} catch (Exception e) {
					LOG.error(e.getLocalizedMessage(), e);
				}
			});
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new EventoException(e.getLocalizedMessage());
		}
		return list;
	}
	
	public List<EventoDTO> clonarEvento(List<Long> idEventos) throws EventoException {
		EventoDTO eventoCloneDTO = new EventoDTO();
		List<EventoDTO> list = new ArrayList<EventoDTO>();
		
		try {
			for(Long id:idEventos) {
				Optional<Evento> optional = repository.findById(id);
				if(optional == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_NOT_FOUND, null, Locale.US));
				Evento evento = optional.get();
				Evento oEvento = new Evento();
				BeanUtils.copyProperties(oEvento, evento);
				oEvento.setIdEvento(null);
				List<EventoHorario> lstEvtHorario = new ArrayList<EventoHorario>();
				for(EventoHorario eh: oEvento.getHorario()) {
					EventoHorario oEvtHorario = new EventoHorario();
					BeanUtils.copyProperties(oEvtHorario, eh);
					oEvtHorario.setIdEventoHorario(null);
					oEvtHorario.setEvento(oEvento);
					lstEvtHorario.add(oEvtHorario);
				}
				oEvento.setHorario(lstEvtHorario);
				Evento eventoClone = repository.save(oEvento);
				eventoCloneDTO = obtenerEventoById(eventoClone.getIdEvento());
				list.add(eventoCloneDTO);
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new EventoException(e.getLocalizedMessage());
		}
		return list;
	}
	
	public EventoDTO obtenerEventoById(Long id) throws EventoException {
		EventoDTO eventoDTO = new EventoDTO();
		try {
			Optional<Evento> optional = repository.findById(id);
			if(optional == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_NOT_FOUND, null, Locale.US));
			Evento evento = optional.get();
			
			Optional<Profesor> oProfesor = profesorRepository.findById(evento.getIdProfesor());
			ProfesorDTO profesorDTO = new ProfesorDTO();
			if(oProfesor != null) {
				Profesor profesor = oProfesor.get();
				BeanUtils.copyProperties(profesorDTO, profesor);
			};
			List<EventoHorario> horario = evento.getHorario();
			List<EventoHorarioDTO> horarioDTO = new ArrayList<EventoHorarioDTO>();
			for(EventoHorario eventoHorario: horario) {
				EventoHorarioDTO eventoHorarioDTO = new EventoHorarioDTO();
				BeanUtils.copyProperties(eventoHorarioDTO, eventoHorario);
				horarioDTO.add(eventoHorarioDTO);
			}
			//  Setter:
			BeanUtils.copyProperties(eventoDTO, evento);
			// Agrupar:
		 	 List<HorarioEventoDTO> lstHorario = repository.findHorarioByEventoId(eventoDTO.getIdEvento());
			eventoDTO.setHorarioGroup(lstHorario);
			
			eventoDTO.setProfesorDTO(profesorDTO);
			eventoDTO.setHorarioDTO(horarioDTO);
			
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new EventoException(e.getLocalizedMessage());
		}
		return eventoDTO;
	}
	
	public List<EventoDTO> obtenerEventoByIdProfesor(Long idProfesor) throws EventoException {
		if(idProfesor == null ) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PROFESOR_ID, null, Locale.US));
		Optional<Profesor> optional = profesorRepository.findById(idProfesor);
		if(!optional.isPresent()) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PROFESOR_NOT_FOUND, null, Locale.US));
		List<EventoDTO> list = new ArrayList<EventoDTO>();
		try {
			List<Evento> eventos = repository.findEventoByIdProfesor(idProfesor, DateUtilitario.getCurrentDate());
			for(Evento e: eventos) {
				EventoDTO eventoDTO = new EventoDTO();
				BeanUtils.copyProperties(eventoDTO, e);
				
				
				Optional<Profesor> oProfesor = profesorRepository.findById(e.getIdProfesor());
				Profesor profesor = oProfesor.get();
				ProfesorDTO profesorDTO = new ProfesorDTO();
				BeanUtils.copyProperties(profesorDTO, profesor);
				
				List<EventoHorario> horario = e.getHorario();
				List<EventoHorarioDTO> lstHorario = new ArrayList<EventoHorarioDTO>();
				
				for(EventoHorario h: horario) {
					EventoHorarioDTO eventoHorarioDTO = new EventoHorarioDTO();
					BeanUtils.copyProperties(eventoHorarioDTO, h);
					lstHorario.add(eventoHorarioDTO);
				}
				
				// Agrupar:
			 	 List<HorarioEventoDTO> lstHorarioGroup = repository.findHorarioByEventoId(eventoDTO.getIdEvento());
				eventoDTO.setHorarioGroup(lstHorarioGroup);
				
				eventoDTO.setProfesorDTO(profesorDTO);
				eventoDTO.setHorarioDTO(lstHorario);
				list.add(eventoDTO);
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new EventoException(e.getLocalizedMessage());
		}
		return list;
	}
	
	@Transactional
	public void asociarEvento(Long idEvento, Long idProceso) throws EventoException, Exception {
		Optional<Evento> optEvento = repository.findById(idEvento);
		if(optEvento == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_NOT_FOUND, null, Locale.US));
		Evento evt = optEvento.get();
		
		Optional<Proceso> optProceso = procesoRepository.findById(idProceso);
		if(optProceso == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PROCESO_NOT_FOUND, null, Locale.US));
		Proceso prc = optProceso.get();
		
		Parametro parametro = parametroRepository.findParametroByCodParametro(evt.getSede());
		String template = "";
		if(evt.getTipoEvento().equalsIgnoreCase("0202")) { // Bienestar
			template = "template-1";
		} else { // capacitacion
			template = "template-2";
		}
		List<Persona> lstPersonas = prc.getPersonas();
		for(Persona persona: lstPersonas) {
			PersonaEventoDTO evtPer = new PersonaEventoDTO();
			evtPer.setIdPersona(Long.parseLong(String.valueOf(persona.getIdPersona())));
			evtPer.setIdEvento(evt.getIdEvento());
			guardarPersonaEvento(evtPer);
			
			QRCodeGenerator qrGenerator = new QRCodeGenerator();
			byte[] qrCode = qrGenerator.getQRCodeImage(persona.getIdPersona() + "-" + evt.getIdEvento(), 250, 250);
			persona.setCodQR(qrCode);
			personaRepository.save(persona);

			// Notificar:
			Context context = new Context();
			context.setVariable("nombreColaborador", persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
			context.setVariable("nombreActividad", evt.getNombreEvento());
			context.setVariable("fechaInicio", DateUtilitario.convertDatetostring(evt.getFechaInicio()));
			context.setVariable("fechaFin", DateUtilitario.convertDatetostring(evt.getFechaCierre()));
			context.setVariable("sede", parametro.getNombreParametro());
			
			List<EventoHorario> horarios = evt.getHorario();
			String strHorario = "";
			for(EventoHorario item: horarios) {
				strHorario += item.getDia() + " De " + item.getHoraInicio() + " a " + item.getHoraFin() + "  <br />";
			}
			context.setVariable("horarios", strHorario);
			context.setVariable("logo", "logo");
			context.setVariable("ic_background", "ic_background");
			context.setVariable("ic_calendario", "ic_calendario");
			context.setVariable("ic_reloj", "ic_reloj");
			context.setVariable("ic_lugar", "ic_lugar");
			context.setVariable("qr", Base64.getEncoder().encodeToString(qrCode));
			System.out.println("code: " + Base64.getEncoder().encodeToString(qrCode));
			EmailStatus emailStatus = emailHtmlSender.send(persona.getCorreoCorporativo(),
						"ORRHH - ONP / Constancia de Matricula " + evt.getNombreEvento(),
						"email/" + template, context, qrCode, evt.getTipoEvento());	
			LOG.info("ONP - Envio de QR: [" + emailStatus.getTo() + " " + emailStatus.getStatus() + "]");
//			 ExecutorService emailExecutor = Executors.newCachedThreadPool();
//		        // from you getSalesUserData() method
//		        emailExecutor.execute(new Runnable() {
//		            @Override
//		            public void run() {
//		                try {
//		                	         
//		                } catch (Exception e) {
//		                    LOG.error("failed", e);
//		                }
//		            }
//		        });
		}
	}
	
	public boolean reenviarCodQR(List<PersonaEvento> list) throws EventoException, Exception {
		boolean result = true;
		for(PersonaEvento personaEvento: list) {
			Optional<Evento> optEvento = repository.findById(personaEvento.getId().getIdEvento());
			if(optEvento == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_NOT_FOUND, null, Locale.US));
			Evento evt = optEvento.get();
			Optional<Persona> oPersona = personaRepository.findById(Integer.parseInt(String.valueOf(personaEvento.getId().getIdPersona())));
			Persona persona = oPersona.get();
			
			Parametro parametro = parametroRepository.findParametroByCodParametro(evt.getSede());
			String template = "";
			if(evt.getTipoEvento().equalsIgnoreCase("0202")) { // Bienestar
				template = "template-1";
			} else { // capacitacion
				template = "template-2";
			}

			// Notificar:
			Context context = new Context();
			context.setVariable("nombreColaborador", persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
			context.setVariable("nombreActividad", evt.getNombreEvento());
			context.setVariable("fechaInicio", DateUtilitario.convertDatetostring(evt.getFechaInicio()));
			context.setVariable("fechaFin", DateUtilitario.convertDatetostring(evt.getFechaCierre()));
			context.setVariable("sede", parametro.getNombreParametro());
			
			List<EventoHorario> horarios = evt.getHorario();
			String strHorario = "";
			for(EventoHorario item: horarios) {
				strHorario += item.getDia() + " De " + item.getHoraInicio() + " a " + item.getHoraFin() + "  <br />";
			}
			context.setVariable("horarios", strHorario);
			context.setVariable("logo", "logo");
			context.setVariable("ic_background", "ic_background");
			context.setVariable("ic_calendario", "ic_calendario");
			context.setVariable("ic_reloj", "ic_reloj");
			context.setVariable("ic_lugar", "ic_lugar");
			context.setVariable("qr", Base64.getEncoder().encodeToString(persona.getCodQR()));
			EmailStatus emailStatus = emailHtmlSender.send(persona.getCorreoCorporativo(),
						"ORRHH - ONP / Constancia de Matricula " + evt.getNombreEvento(),
						"email/" + template, context, persona.getCodQR(), evt.getTipoEvento());	
			LOG.info("ONP - Envio de QR: [" + emailStatus.getTo() + " " + emailStatus.getStatus() + "]");
		}
		return result;
	}
	
	public void guardarPersonaEvento(PersonaEventoDTO personaEventoDTO) throws EventoException {
		PersonaEvento personaEvento = new PersonaEvento();
		PersonaEventoPK id = new PersonaEventoPK();
		id.setIdEvento(personaEventoDTO.getIdEvento());
		id.setIdPersona(personaEventoDTO.getIdPersona());
		personaEvento.setId(id);
		personaEvento.setActivo(Constantes.ESTADO_ACTIVO_VALUE);
		personaEvtRepository.save(personaEvento);
	}
	
	public List<PersonaDTO> listarPersonasMatriculadas(Long idEvento) throws EventoException {
		Optional<Evento> optEvento = repository.findById(idEvento);
		if(optEvento == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_NOT_FOUND, null, Locale.US));
		
		List<PersonaDTO> lstPersonasDTO = new ArrayList<PersonaDTO>();
		List<PersonaEvento> listaPersonas = personaEvtRepository.getPersonaEventoByIdEvento(idEvento);
		List<Integer> ids = new ArrayList<Integer>();
		listaPersonas.forEach( item -> {
			ids.add(Integer.parseInt(String.valueOf(item.getId().getIdPersona())));
		});
		List<Persona> personas = personaRepository.getPersonasByIdPersonas(ids);
		for(Persona p: personas) {
			PersonaDTO personaDTO = new PersonaDTO();
			try {
				BeanUtils.copyProperties(personaDTO, p);
				lstPersonasDTO.add(personaDTO);
			} catch (Exception e) {
				LOG.error(e.getLocalizedMessage(), e);
				e.printStackTrace();
			} 
		}
		return lstPersonasDTO;
	}
	
	public boolean validaEvento(EventoDTO eventoDTO) throws EventoException {
		if(eventoDTO.getNombreEvento() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_NOMBRE, null, Locale.US));
		if(eventoDTO.getSede() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_SEDE, null, Locale.US));
		if(eventoDTO.getTipoEvento() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_TIPO_EVENTO, null, Locale.US));
		if(eventoDTO.getCantidadParticipantes() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_CANTIDAD, null, Locale.US));
		if(eventoDTO.getStrFechaInicio() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_FECHA_INICIO, null, Locale.US));
		if(eventoDTO.getStrFechaCierre() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_FECHA_FIN, null, Locale.US));
		if(eventoDTO.getDuracionHoras() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_FECHA_FIN, null, Locale.US));
		if(eventoDTO.getUsuarioCreacion() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_USUARIO_CREACION, null, Locale.US));
//		if(eventoDTO.getUsuarioModifica() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_USUARIO_MODIFICACION, null, Locale.US));
		if(eventoDTO.getProfesorDTO() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_PROFESOR_NO_ASIGNADO, null, Locale.US));
		if(eventoDTO.getHorarioDTO() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_HORARIO_NO_ASIGNADO,  null, Locale.US));
		return true;
	}
	
	
	public ReporteDetalladoBean getListaAsistenciaDetallada(FilterReporteDTO filter) throws EventoException, Exception {
		ReporteDetalladoBean reporteDetallado = new ReporteDetalladoBean();
		List<ReporteResumenBean> lstReporteResponse = new ArrayList<ReporteResumenBean>();
		List<PersonAsistencia> _list2 = asistenciaRepository.getAsistenciaByIdEvento(filter.getIdCurso());
		List<String> lstColumnas = new ArrayList<String>();
		Map<Date, List<PersonAsistencia>> columnas = _list2.stream().collect(Collectors.groupingBy(PersonAsistencia::getFechaAsistencia));
		columnas.forEach((k, v) -> {
			try {
				lstColumnas.add(DateUtilitario.convertDatetostring(k));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
		java.util.Collections.sort(lstColumnas);
		Map<Long, Map<Date, List<PersonAsistencia>> > map = _list2.stream().collect(Collectors.groupingBy(PersonAsistencia::getIdPersona, 
				Collectors.groupingBy(PersonAsistencia::getFechaAsistencia)));
		
		map.forEach((k,v) -> {
			ReporteResumenBean oReporteResumen = new ReporteResumenBean();
			// Buscar datos persona:
			Optional<Persona> oPersona = personaRepository.findById(Integer.parseInt(String.valueOf(k)));
			if(oPersona != null) {
				Persona persona = oPersona.get();
				oReporteResumen.setNombrePersona(persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
				PersonaDTO personaDTO = new PersonaDTO();
				try {
					BeanUtils.copyProperties(personaDTO, persona);
					oReporteResumen.setPersona(personaDTO);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			
			oReporteResumen.setIdPersona(k);
			List<DetailReporteResumenBean> lstDetail = new ArrayList<DetailReporteResumenBean>();
			for(String columna: lstColumnas) {
				DetailReporteResumenBean oDetalle = new DetailReporteResumenBean();
				oDetalle.setFechaAsistencia(columna);
				oDetalle.setAsistencia("F");
				lstDetail.add(oDetalle);
			}
			Integer contador = 0;
			v.forEach((a,b) -> {
				for(DetailReporteResumenBean detalle: lstDetail){
					try {
						if (detalle.getFechaAsistencia().equals(DateUtilitario.convertDatetostring(a))){
							detalle.setAsistencia("A");
							break;
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			});
			
			// Calculando asistencia.
			for(DetailReporteResumenBean d: lstDetail) {
				if(d.getAsistencia().equalsIgnoreCase("A")) {
					contador++;
				}
			}
			
			oReporteResumen.setDetalle(lstDetail);
			oReporteResumen.setTotalAsistido(contador);
			oReporteResumen.setPorcentajeAsistido( Double.parseDouble( "" + (contador * 100)/lstColumnas.size()) );
			lstReporteResponse.add(oReporteResumen);
		});
		
		reporteDetallado.setData(lstReporteResponse);
		reporteDetallado.setColumnas(lstColumnas);
		
		return reporteDetallado;
	}
	
	// Vistas Soporte:
	public List<AsistenteSedeBen> getListaAsistentexSede(FilterReporteDTO filter) throws EventoException {
		return asistenciaSedeRepository.findAll(new Specification<AsistenteSedeBen>() {
			@Override
			public Predicate toPredicate(Root<AsistenteSedeBen> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				if(filter.getTipoEvento() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("tipoEvento"), filter.getTipoEvento() )));
				}
				if(filter.getSede() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("sede"), filter.getSede() )));
				}
				if(filter.getFechaInicio() != null && filter.getFechaFin() != null){
					try {
						Date dtBegin = DateUtilitario.convertStringToDate(filter.getFechaInicio());
						Date dtEnd = DateUtilitario.convertStringToDate(filter.getFechaFin());
						Path<Date> dateEntryPath = root.get("fechaInicio");
						predicates.add(criteriaBuilder.and(criteriaBuilder.between(dateEntryPath, dtBegin, dtEnd)));
					} catch (Exception e) {
						LOG.error(e.getLocalizedMessage());
					}
				}
				query.orderBy(criteriaBuilder.desc(root.get("idEvento")));
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}
	
	public List<PersonaEventoAsistenteBean> getListaPersonaEventoAsistencia(FilterReporteDTO filter) throws EventoException {
		return personaEventoAsistenciaRepository.findAll(new Specification<PersonaEventoAsistenteBean>() {
			
			@Override
			public Predicate toPredicate(Root<PersonaEventoAsistenteBean> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				if(filter.getTipoEvento() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("tipoEvento"), filter.getTipoEvento() )));
				}
				if(filter.getIdCurso() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("idEvento"), filter.getIdCurso() )));
				}
				if(filter.getSede() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("sede"), filter.getSede() )));
				}
				if(filter.getFecha() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("fechaIngreso"), filter.getFecha() )));
				}
				if(filter.getDni() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("dni"), filter.getDni() )));
				}
				
				query.orderBy(criteriaBuilder.desc(root.get("idAsistencia")));
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}
	
	public boolean inactiveEvento(List<Long> ids) throws EventoException {
		boolean result = false;
		try {
			repository.inactiveEvento(ids);
			result = true;
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new EventoException(e.getLocalizedMessage());
		}
		return result;
	}
	
	// Reportes:
	public JasperPrint generarReporteAsistencia(Long idEvento) throws JRException, IOException {
		 // String path = resourceLoader.getResource("classpath:rpte_asistencia_curso.jrxml").getURI().getPath();
		 String path = getClass().getResource("classpath:rpte_asistencia_curso.jrxml").getPath();
		 JasperReport jasperReport = JasperCompileManager.compileReport(new File("").getAbsolutePath()+"/src/pe/gob/onp/orrhh/qr/reportes/rpte_asistencia_curso.jrxml");
		 // Parameters for report
		 List<PersonAsistencia> list = asistenciaRepository.getAsistenciaByIdEvento(idEvento);
		 Optional<Evento> opt = repository.findById(idEvento);
		 Evento evento = opt.get();
		 
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 
		 Optional<Profesor> oProfesor = profesorRepository.findById(evento.getIdProfesor());
		 Profesor profesor = oProfesor.get();
		 
		 parameters.put("P_PROFESOR", profesor.getNombre() + " " + profesor.getApellidoPaterno() + " " + profesor.getApellidoMaterno());
		 parameters.put("P_CURSO", evento.getNombreEvento());

		 List<Object> data = new ArrayList<>();
		 int i = 1;
		 
		 for(PersonAsistencia pe: list) {
			 AsistenciaDTO bean = new AsistenciaDTO();
			 bean.setNumero(new Integer(i));
			 Optional<Persona> optionPersona = personaRepository.findById(Integer.parseInt(String.valueOf(pe.getIdPersona())));
			 Persona personal = optionPersona.get();
			 bean.setNombres(personal.getNombres());
			 bean.setPaterno(personal.getApellidoPaterno());
			 bean.setMaterno(personal.getApellidoMaterno());
			 bean.setFecha(personal.getFechaCarga()); 
			 i++;
			 data.add(bean);
		 }
		 // Conexion
		 JasperDataSource dataSource = null;
		 dataSource = new JasperDataSource(AsistenciaDTO.class);
		 dataSource.addListData(data);
		 // JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
		 JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		 return print;
	}
	
	public JasperPrint generarReporteAsistenciaFecha(FilterReporteDTO filter) throws JRException, IOException, EventoException, Exception {
		InputStream imagen = Thread.currentThread().getContextClassLoader().getResourceAsStream("ic_logo_onp.png");
		JasperReport jasperReport = JasperCompileManager.compileReport(Thread.currentThread().getContextClassLoader().getResourceAsStream("reporteAsistenciaPersona.jrxml"));
		System.out.println("jasper " + imagen);
		 // Parameters for report
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("LOGO_ONP", imagen);
		 Optional<Evento> oEvento = repository.findById(filter.getIdCurso());
		 Evento e = oEvento.get();
		 parameters.put("CODIGO_EVENTO", e.getNombreCorto());
		
		 if(filter.getFecha() != null) {
			 Date fechaMarcacion = DateUtilitario.convertStringToDate(filter.getFecha());
			 if(fechaMarcacion != null) {
				 String mes = DateUtilitario.theMonth(DateUtilitario.getMonth(fechaMarcacion));
				 parameters.put("MES", mes);
				 parameters.put("FECHA_MARCACION", filter.getFecha());
			 }
		 }
		 
		 Integer asistidos = 0;
		 Integer inasistencia = 0;
		 
		 List<PersonaEventoAsistenteBean> lista = getListaPersonaEventoAsistencia(filter);
		 List<Object> data = new ArrayList<>();
		 for(PersonaEventoAsistenteBean bean: lista) {
			 if(bean.getFechaAsistencia() != null) {
				 asistidos++;
			 } else {
				 inasistencia ++;
			 }
			 data.add(bean);
		 }
		 parameters.put("TOTAL_AUSENCIA", "" + inasistencia);
		 parameters.put("TOTAL_MARCACION", "" + asistidos);
		// Conexion
		JasperDataSource dataSource = null;
		dataSource = new JasperDataSource(PersonaEventoAsistenteBean.class);
		dataSource.addListData(data);
		JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		return print;
	}
	
	public JasperPrint generarReporteAsistenciaSede(FilterReporteDTO filter) throws JRException, IOException, EventoException {
		// String path = resourceLoader.getResource("classpath:reporteAsistenciaSede.jrxml").getURI().getPath();
		JasperReport jasperReport = JasperCompileManager.compileReport(Thread.currentThread().getContextClassLoader().getResourceAsStream("reporteAsistenciaSede.jrxml"));
		 // Parameters for report
		InputStream imagen = Thread.currentThread().getContextClassLoader().getResourceAsStream("ic_logo_onp.png");
		 // Get Sede y Tipo Evento:
		 Parametro p1 = parametroRepository.findParametroByCodParametro(filter.getTipoEvento());
		 Parametro p2 = parametroRepository.findParametroByCodParametro(filter.getSede());
		 
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("LOGO_ONP", imagen);
		 parameters.put("TIPO_EVENTO", p1.getDescripcion()); 
		 parameters.put("SEDE", p2.getDescripcion());
		 parameters.put("DESDE", filter.getFechaInicio());
		 parameters.put("HASTA", filter.getFechaFin());
		 List<AsistenteSedeBen> lista = getListaAsistentexSede(filter);
		 List<Object> data = new ArrayList<>();
		 for(AsistenteSedeBen bean: lista) {
			 data.add(bean);
		 }
		// Conexion
		JasperDataSource dataSource = null;
		dataSource = new JasperDataSource(AsistenteSedeBen.class);
		dataSource.addListData(data);
		JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		return print;
	}
	
}
