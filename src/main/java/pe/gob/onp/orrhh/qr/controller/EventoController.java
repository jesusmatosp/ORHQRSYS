package pe.gob.onp.orrhh.qr.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.onp.orrhh.qr.dto.EventoDTO;
import pe.gob.onp.orrhh.qr.dto.FilterReporteDTO;
import pe.gob.onp.orrhh.qr.dto.PersonaEventoDTO;
import pe.gob.onp.orrhh.qr.dto.ResponseDataDTO;
import pe.gob.onp.orrhh.qr.model.PersonaEvento;
import pe.gob.onp.orrhh.qr.service.EventoService;

@RestController
@RequestMapping( value = "/api/evento" )
public class EventoController {

	private static final Logger LOG = LoggerFactory.getLogger(EventoController.class);
	@Autowired
	private EventoService service;
	
	@Autowired
	private MessageSource messageSource;
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/create")
	public @ResponseBody ResponseDataDTO guardarEvento(@RequestBody EventoDTO eventoDTO) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			eventoDTO = service.guardarEvento(eventoDTO);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("OK");
			response.setData(eventoDTO);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/create/clone")
	public @ResponseBody ResponseDataDTO clonarEvento(@RequestBody List<Long> idEventos) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			List<EventoDTO> eventoDTO = service.clonarEvento(idEventos);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("El registro del Evento se clonó correctamente.");
			response.setData(eventoDTO);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	} 
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@GetMapping("/all")
	public @ResponseBody ResponseDataDTO all() {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			List<EventoDTO> list =  service.listarEventoAll();
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("OK");
			response.setData(list);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@GetMapping("/{id}")
	public @ResponseBody ResponseDataDTO eventoById(@PathVariable("id") Long idEvento) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			EventoDTO evento = service.obtenerEventoById(idEvento);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("OK");
			response.setData(evento);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@GetMapping("/profesor/{id}")
	public @ResponseBody ResponseDataDTO eventoByIdProfesor(@PathVariable("id") Long idProfesor) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			List<EventoDTO> evento = service.obtenerEventoByIdProfesor(idProfesor);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("OK");
			response.setData(evento);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/delete")
	public @ResponseBody ResponseDataDTO eliminarEvento(@RequestBody List<Long> idEventos) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			boolean result = service.inactiveEvento(idEventos);
			if(result) {
				response.setCodigo("100");
				response.setCodigoHTTP(HttpStatus.OK.name());
				response.setMessage("El evento se eliminó correctamente");
				response.setData(result);
			} else {
				response.setCodigo("300");
				response.setCodigoHTTP(HttpStatus.OK.name());
				response.setMessage("Ocurrió un error durante la eliminación.");
				response.setData(result);
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/find/criteria")
	public @ResponseBody ResponseDataDTO findByCriteria(@RequestBody FilterReporteDTO filter) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			List<EventoDTO> list = service.listarEventoByCriteriaFilter(filter);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("Lista recuperada correctamente.");
			response.setData(list);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/persona")
	public @ResponseBody ResponseDataDTO asociarEvento(@RequestBody PersonaEventoDTO personaEventoDTO) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			service.asociarEvento(personaEventoDTO.getIdEvento(), personaEventoDTO.getIdProceso());
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("OK");
			response.setData(true);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/reenviar/qr")
	public @ResponseBody ResponseDataDTO reenviarCodQR(@RequestBody List<PersonaEvento> list) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			boolean result = service.reenviarCodQR(list);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("OK");
			response.setData(result);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	

}
