package pe.gob.onp.orrhh.qr.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import pe.gob.onp.orrhh.qr.core.unit.mail.EmailHtmlSender;
import pe.gob.onp.orrhh.qr.core.unit.mail.EmailStatus;
import pe.gob.onp.orrhh.qr.dto.ProfesorCriteriaSearchDTO;
import pe.gob.onp.orrhh.qr.dto.ProfesorDTO;
import pe.gob.onp.orrhh.qr.dto.ResponseDataDTO;
import pe.gob.onp.orrhh.qr.service.ProfesorService;

@RestController
@RequestMapping( value = "/api/profesor" )
public class ProfesorController {

	private static final Logger LOG = LoggerFactory.getLogger(ProfesorController.class);
	
	@Autowired
	private ProfesorService service;

	@Autowired
	private EmailHtmlSender emailHtmlSender;
	
	@GetMapping("/sendmail")
	public String enviarCorreoPrueba() {
		Context context = new Context();
		context.setVariable("nombreColaborador", "JESUS MATOS PORTOCARRERO");
		context.setVariable("nombreActividad", "PROGRAMACIÓN BASICA EN JAVA");
		context.setVariable("logo", "logo");
		context.setVariable("ic_background", "ic_background");
		context.setVariable("ic_calendario", "ic_calendario");
		context.setVariable("ic_reloj", "ic_reloj");
		context.setVariable("ic_lugar", "ic_lugar");
//		EmailStatus emailStatus = emailHtmlSender.send("jesus.matosp@gmail.com", "Title of email 2", "email/template-1", context, null);
		return "Correo Enviado: ";
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/create")
	public @ResponseBody ResponseDataDTO create(@RequestBody ProfesorDTO profesorDTO) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			profesorDTO = service.guardarProfesor(profesorDTO);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("OK");
			response.setData(profesorDTO);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/login")
	public @ResponseBody ResponseDataDTO login(@RequestBody ProfesorDTO profesorDTO) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			profesorDTO = service.loginProfesor(profesorDTO);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("Validado correctamente");
			response.setData(profesorDTO);
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
			List<ProfesorDTO> list = service.listarProfesorAll();
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
	public @ResponseBody ResponseDataDTO all(@PathVariable("id") Long id) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			ProfesorDTO profesorDTO = service.obtenerProfesorById(id);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("OK");
			response.setData(profesorDTO);
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
	public @ResponseBody ResponseDataDTO deleteProfesor(@RequestBody List<Long> ids) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			service.eliminarProfesor(ids);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("Eliminación del registro exitosa!");
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage("No se pudo eliminar el registro de profesor");
		}
		return response;
	}

	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/find/criteria")
	public @ResponseBody ResponseDataDTO findByCriteria(@RequestBody ProfesorCriteriaSearchDTO criteriaSearch) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			List<ProfesorDTO> list = service.findByCriteriaProfesorDTO(criteriaSearch);
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
	
}
