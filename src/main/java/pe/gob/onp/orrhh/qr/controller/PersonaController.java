package pe.gob.onp.orrhh.qr.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pe.gob.onp.orrhh.qr.dto.PersonaAsistenciaDTO;
import pe.gob.onp.orrhh.qr.dto.PersonaDTO;
import pe.gob.onp.orrhh.qr.dto.ResponseDataDTO;
import pe.gob.onp.orrhh.qr.model.Persona;
import pe.gob.onp.orrhh.qr.model.Proceso;
import pe.gob.onp.orrhh.qr.service.MailService;
import pe.gob.onp.orrhh.qr.service.PersonaService;
import pe.gob.onp.orrhh.qr.service.ProcesoService;
import pe.gob.onp.orrhh.qr.utilitario.DateUtilitario;
import pe.gob.onp.orrhh.qr.utilitario.JavaPOI;
import pe.gob.onp.orrhh.qr.utilitario.MailTemplateUtil;
import pe.gob.onp.orrhh.qr.utilitario.ONPUtilitarios;
import pe.gob.onp.orrhh.qr.utilitario.exception.PersonaException;

@RestController
@RequestMapping(value = "/api/personal")
public class PersonaController {

	public static final Logger LOG = LoggerFactory.getLogger(PersonaController.class);

	@Autowired
	private PersonaService service;

	@Autowired
	private ProcesoService procesoService;
	
	
	@Value("${file.path.orhqr}")
	private String filePath;

	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/upload")
	public @ResponseBody ResponseDataDTO leerCargaArchivo(HttpServletRequest request,
			@RequestParam("file") MultipartFile uploadfile, @RequestParam("usuarioEjecucion") String usuarioEjecucion) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			if (uploadfile.isEmpty()) {
				throw new PersonaException("Por favor seleccione el archivo a cargar!");
			}
			List<PersonaDTO> personas = uploadedFiles(Arrays.asList(uploadfile), filePath);
			List<Persona> list = new ArrayList<Persona>();
			Proceso proceso = new Proceso();
			proceso.setFechaEjecucion(DateUtilitario.getCurrentDate());
			proceso.setUsuarioEjecucion(usuarioEjecucion);
			for (PersonaDTO p : personas) {
				Persona oPersona = new Persona();
				BeanUtils.copyProperties(oPersona, p);
				oPersona.setProceso(proceso);
				oPersona.setUsuarioCarga(usuarioEjecucion);
				list.add(oPersona);
			}
			proceso.setPersonas(list);
			proceso = procesoService.procesarCarga(proceso);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("" + proceso.getIdProceso());
			response.setData(personas);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}

	private List<PersonaDTO> uploadedFiles(List<MultipartFile> files, String filePath) throws IOException {
		List<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				continue; // next pls
			}
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);

			// Iniciar procesamiento de lectura de excel
			File fileProcess = ONPUtilitarios.convert(file);
			JavaPOI javaPoiUtils = new JavaPOI();
			// javaPoiUtils.readExcelFile(fileProcess);
			personas = javaPoiUtils.leerExcelFilePersona(fileProcess);
		}
		return personas;
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/asistencia")
	public @ResponseBody ResponseDataDTO registrarAsistencia(@RequestBody PersonaAsistenciaDTO personaAsistenciaDTO){
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			PersonaAsistenciaDTO resultado = service.marcarAsistencia(personaAsistenciaDTO);
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
}
