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

import pe.gob.onp.orrhh.qr.bean.PersonaBean;
import pe.gob.onp.orrhh.qr.bean.PersonaEventoBean;
import pe.gob.onp.orrhh.qr.dto.PersonaAsistenciaDTO;
import pe.gob.onp.orrhh.qr.dto.PersonaDTO;
import pe.gob.onp.orrhh.qr.dto.ResponseDataDTO;
import pe.gob.onp.orrhh.qr.model.Persona;
import pe.gob.onp.orrhh.qr.model.Proceso;
import pe.gob.onp.orrhh.qr.service.PersonaService;
import pe.gob.onp.orrhh.qr.service.ProcesoService;
import pe.gob.onp.orrhh.qr.utilitario.Constantes;
import pe.gob.onp.orrhh.qr.utilitario.DateUtilitario;
import pe.gob.onp.orrhh.qr.utilitario.JavaPOI;
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
				oPersona.setActivo(Constantes.ESTADO_ACTIVO_VALUE);
				list.add(oPersona);
			}
			System.out.println("Personas: " + list.size());
			LOG.info("Personas: " + list.size());
			
			if(list.size() == 0) throw new PersonaException("El archivo no puede estar vacío.");
			proceso.setPersonas(list);
			proceso = procesoService.procesarCarga(proceso);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("" + proceso.getIdProceso());
			response.setData(personas);
		} catch (PersonaException personaException) {
			LOG.error(personaException.getLocalizedMessage(), personaException.getCause());
			response.setCodigo("004");
			response.setCodigoHTTP(HttpStatus.NOT_FOUND.name());
			response.setMessage(personaException.getLocalizedMessage());
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}

	private List<PersonaDTO> uploadedFiles(List<MultipartFile> files, String filePath) throws IOException, PersonaException {
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
			response.setData(resultado);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/evento")
	public @ResponseBody ResponseDataDTO getListaPersonaEvento(@RequestBody PersonaEventoBean bean) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			List<PersonaEventoBean> list = service.getPersonaEventoByCriteria(bean);
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
	@PostMapping("/baja")
	public @ResponseBody ResponseDataDTO bajaPersonal(@RequestBody List<Integer> idPersonas) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			boolean result = service.bajaPersona(idPersonas);
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
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/get")
	public @ResponseBody ResponseDataDTO getPersonaByDni(@RequestBody PersonaDTO personaDTO) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			PersonaDTO oPersonaDTO = service.getPersonaByDNI(personaDTO.getDni(), personaDTO.getRegimen(), personaDTO.getAreaCorporativa());
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("OK");
			response.setData(oPersonaDTO);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/update")
	public @ResponseBody ResponseDataDTO actualizarPersonas(@RequestBody PersonaDTO personaDTO) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			service.modificarDatosPersona(personaDTO);
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
	@PostMapping("/find")
	public @ResponseBody ResponseDataDTO findPersonalByCriteria(@RequestBody PersonaDTO personaDTO) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			List<PersonaBean> list = service.findPersona(personaDTO);
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
