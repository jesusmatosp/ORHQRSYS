package pe.gob.onp.orrhh.qr.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
