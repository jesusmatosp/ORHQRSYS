package pe.gob.onp.orrhh.qr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.onp.orrhh.qr.dto.ParametroDTO;
import pe.gob.onp.orrhh.qr.dto.ResponseDataDTO;
import pe.gob.onp.orrhh.qr.service.ParametroService;

@RestController
@RequestMapping( value = "/api/parametro" )
public class ParametroController {

	private static Logger LOG = LoggerFactory.getLogger(ParametroController.class);
	
	@Autowired
	private ParametroService service;
	
	@GetMapping("/all")
	public @ResponseBody ResponseDataDTO all() {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			List<ParametroDTO> list = service.listarParametros();
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
	
	@PostMapping("/create")
	public @ResponseBody ResponseDataDTO create(@RequestBody ParametroDTO parametroDTO) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			parametroDTO = service.guardarParametro(parametroDTO);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("OK");
			response.setData(parametroDTO);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
}
