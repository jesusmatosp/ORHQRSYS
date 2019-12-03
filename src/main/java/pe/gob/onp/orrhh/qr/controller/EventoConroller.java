package pe.gob.onp.orrhh.qr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.onp.orrhh.qr.dto.EventoDTO;
import pe.gob.onp.orrhh.qr.dto.ResponseDataDTO;
import pe.gob.onp.orrhh.qr.service.EventoService;

@RestController
@RequestMapping( value = "/api/evento" )
public class EventoConroller {

	private static final Logger LOG = LoggerFactory.getLogger(EventoConroller.class);
	@Autowired
	private EventoService service;
	
	@Autowired
	private MessageSource messageSource;
	
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
}
