package pe.gob.onp.orrhh.qr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import pe.gob.onp.orrhh.qr.dto.EventoDTO;
import pe.gob.onp.orrhh.qr.dto.EventoHorarioDTO;
import pe.gob.onp.orrhh.qr.dto.ProfesorDTO;
import pe.gob.onp.orrhh.qr.model.Evento;
import pe.gob.onp.orrhh.qr.model.EventoHorario;
import pe.gob.onp.orrhh.qr.model.Profesor;
import pe.gob.onp.orrhh.qr.repository.EventoRepository;
import pe.gob.onp.orrhh.qr.repository.ProfesorRepository;
import pe.gob.onp.orrhh.qr.utilitario.Constantes;
import pe.gob.onp.orrhh.qr.utilitario.DateUtilitario;
import pe.gob.onp.orrhh.qr.utilitario.exception.EventoException;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repository;
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private MessageSource messageSource; 
	
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
				} else {
					eventoDTO.setFechaCreacion(DateUtilitario.getCurrentDate());
				}
				Evento evento = new Evento();
				BeanUtils.copyProperties(evento, eventoDTO);
				
				// Obtener Datos docente:
				Profesor profesor = new Profesor();
				BeanUtils.copyProperties(profesor, eventoDTO.getProfesorDTO());
				// Obtener Datos del horario:
				List<EventoHorario> horarios = new ArrayList<EventoHorario>();
				List<EventoHorarioDTO> lstHorarioDTO = eventoDTO.getHorarioDTO();
				for(EventoHorarioDTO horarioDTO : lstHorarioDTO) {
					EventoHorario eventoHorario = new EventoHorario();
					BeanUtils.copyProperties(eventoHorario, horarioDTO);
					eventoHorario.setEvento(evento);
					horarios.add(eventoHorario);
				}
				evento.setProfesor(profesor);
				evento.setHorario(horarios);
				evento = repository.save(evento);
				eventoDTO = obtenerEventoById(evento.getIdEvento());
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new EventoException(e.getLocalizedMessage());
		}
		return eventoDTO;
	}
	
	public List<EventoDTO> listarEventoAll() throws EventoException {
		List<EventoDTO> list = new ArrayList<EventoDTO>();
		try {
			Iterable<Evento> iterator = repository.findAll();
			iterator.forEach(item -> {
				try {
					EventoDTO eventoDTO = new EventoDTO();
					// Profesor:
					Profesor profesor = item.getProfesor();
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
	
	public EventoDTO obtenerEventoById(Long id) throws EventoException {
		EventoDTO eventoDTO = new EventoDTO();
		try {
			Optional<Evento> optional = repository.findById(id);
			if(optional == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_NOT_FOUND, null, Locale.US));
			Evento evento = optional.get();
			Profesor profesor = evento.getProfesor();
			ProfesorDTO profesorDTO = new ProfesorDTO();
			BeanUtils.copyProperties(profesorDTO, profesor);
			
			List<EventoHorario> horario = evento.getHorario();
			List<EventoHorarioDTO> horarioDTO = new ArrayList<EventoHorarioDTO>();
			for(EventoHorario eventoHorario: horario) {
				EventoHorarioDTO eventoHorarioDTO = new EventoHorarioDTO();
				BeanUtils.copyProperties(eventoHorarioDTO, eventoHorario);
				horarioDTO.add(eventoHorarioDTO);
			}
			
			//  Setter:
			BeanUtils.copyProperties(eventoDTO, evento);
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
			List<Evento> eventos = repository.findEventoByIdProfesor(idProfesor);
			for(Evento e: eventos) {
				EventoDTO eventoDTO = new EventoDTO();
				BeanUtils.copyProperties(eventoDTO, e);
				Profesor profesor = e.getProfesor();
				List<EventoHorario> horario = e.getHorario();
				List<EventoHorarioDTO> lstHorario = new ArrayList<EventoHorarioDTO>();
				ProfesorDTO profesorDTO = new ProfesorDTO();
				BeanUtils.copyProperties(profesorDTO, profesor);
				for(EventoHorario h: horario) {
					EventoHorarioDTO eventoHorarioDTO = new EventoHorarioDTO();
					BeanUtils.copyProperties(eventoHorarioDTO, h);
					lstHorario.add(eventoHorarioDTO);
				}
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
	
	public boolean validaEvento(EventoDTO eventoDTO) throws EventoException {
		if(eventoDTO.getNombreEvento() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_NOMBRE, null, Locale.US));
		if(eventoDTO.getSede() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_SEDE, null, Locale.US));
		if(eventoDTO.getTipoEvento() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_TIPO_EVENTO, null, Locale.US));
		if(eventoDTO.getCantidadParticipantes() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_CANTIDAD, null, Locale.US));
		if(eventoDTO.getFechaInicio() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_FECHA_INICIO, null, Locale.US));
		if(eventoDTO.getFechaCierre() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_FECHA_FIN, null, Locale.US));
		if(eventoDTO.getDuracionHoras() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_FECHA_FIN, null, Locale.US));
		if(eventoDTO.getUsuarioCreacion() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_USUARIO_CREACION, null, Locale.US));
//		if(eventoDTO.getUsuarioModifica() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_USUARIO_MODIFICACION, null, Locale.US));
		if(eventoDTO.getProfesorDTO() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_PROFESOR_NO_ASIGNADO, null, Locale.US));
		if(eventoDTO.getHorarioDTO() == null) throw new EventoException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_EVENTO_HORARIO_NO_ASIGNADO,  null, Locale.US));
		return true;
	}
	
	
}
