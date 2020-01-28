package pe.gob.onp.orrhh.qr.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import pe.gob.onp.orrhh.qr.bean.AsistenteSedeBen;
import pe.gob.onp.orrhh.qr.bean.PersonaEventoAsistenteBean;
import pe.gob.onp.orrhh.qr.bean.ReporteDetalladoBean;
import pe.gob.onp.orrhh.qr.dto.FilterReporteDTO;
import pe.gob.onp.orrhh.qr.dto.ResponseDataDTO;
import pe.gob.onp.orrhh.qr.service.EventoService;

@Controller
@RequestMapping("/api/reportes")
public class ReporteController {
	public static final Logger LOG = LoggerFactory.getLogger(ReporteController.class);
	
	@Autowired
	private EventoService service;
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@RequestMapping(value = "/asistencia/{id}", method = RequestMethod.GET)
	 public void export(ModelAndView model, HttpServletResponse response,
			 @PathVariable("id") Long idEvento) throws IOException, JRException {
	  JasperPrint jasperPrint = null;
	  response.setContentType("application/x-download");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"ONP_REPORTE_DE_ASISTENCIA_POR_CURSO.pdf\""));
	  OutputStream out = response.getOutputStream();
	  jasperPrint = service.generarReporteAsistencia(idEvento); 
	  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	 }
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@RequestMapping(value = "/persona/evento/asistencia/export", method = RequestMethod.POST)
	 public void exportReporteAsistenciaxSede(ModelAndView model, HttpServletResponse response,
			 @RequestBody FilterReporteDTO filter) throws IOException, JRException, Exception {
	  JasperPrint jasperPrint = null;
	  response.setContentType("application/x-download");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"ONP_REPORTE_DE_ASISTENCIA_FECHA.pdf\""));
	  OutputStream out = response.getOutputStream();
	  jasperPrint = service.generarReporteAsistenciaFecha(filter); 
	  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	  out.flush();
      out.close();
	 }
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@RequestMapping(value = "/persona/evento/asistencia/export/excel", method = RequestMethod.POST)
	 public void exportReporteAsistenciaxSedeExcel(ModelAndView model, HttpServletResponse response,
			 @RequestBody FilterReporteDTO filter) throws IOException, JRException, Exception {
	  JasperPrint jasperPrint = null;
	  response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"ONP_REPORTE_DE_ASISTENCIA_FECHA.xslx\""));
	  OutputStream out = response.getOutputStream();
	  jasperPrint = service.generarReporteAsistenciaFecha(filter); 
	  JRXlsxExporter exporter = new JRXlsxExporter();
	  exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
	  exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
      exporter.exportReport();
      out.flush();
      out.close();
	 }
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@RequestMapping(value = "/asistencia/sede/export", method = RequestMethod.POST)
	 public void exportReportePersonaAsistenciaEvento(ModelAndView model, HttpServletResponse response,
			 @RequestBody FilterReporteDTO filter) throws IOException, JRException, Exception {
	  JasperPrint jasperPrint = null;
	  response.setContentType("application/x-download");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"ONP_REPORTE_DE_ASISTENCIA_POR_SEDE.pdf\""));
	  OutputStream out = response.getOutputStream();
	  jasperPrint = service.generarReporteAsistenciaSede(filter); 
	  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	 }
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@RequestMapping(value = "/asistencia/sede/export/excel", method = RequestMethod.POST)
	 public void exportReportePersonaAsistenciaEventoExcel(ModelAndView model, HttpServletResponse response,
			 @RequestBody FilterReporteDTO filter) throws IOException, JRException, Exception {
	  JasperPrint jasperPrint = null;
	  response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"ONP_REPORTE_DE_ASISTENCIA_POR_SEDE.xlsx\""));
	  OutputStream out = response.getOutputStream();
	  jasperPrint = service.generarReporteAsistenciaSede(filter); 
	  JRXlsxExporter exporter = new JRXlsxExporter();
	  exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
	  exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
      exporter.exportReport();
      out.flush();
      out.close();
	 }
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/asistencia/sede")
	public @ResponseBody ResponseDataDTO getReporteAsistenciaxSede(@RequestBody FilterReporteDTO filter) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			List<AsistenteSedeBen> lista = service.getListaAsistentexSede(filter);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("Datos encontrados correctamente");
			response.setData(lista);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/persona/evento/asistencia")
	public @ResponseBody ResponseDataDTO getReportePersonaAsistenciaEvento(@RequestBody FilterReporteDTO filter) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			List<PersonaEventoAsistenteBean> lista = service.getListaPersonaEventoAsistencia(filter);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("Datos encontrados correctamente");
			response.setData(lista);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200", "http://104.41.14.101:8083"})
	@PostMapping("/persona/asistencia/detallada")
	public @ResponseBody ResponseDataDTO getReportePersonaDetallado(@RequestBody FilterReporteDTO filter) {
		ResponseDataDTO response = new ResponseDataDTO();
		try {
			ReporteDetalladoBean reporte = service.getListaAsistenciaDetallada(filter);
			response.setCodigo("100");
			response.setCodigoHTTP(HttpStatus.OK.name());
			response.setMessage("Datos encontrados correctamente");
			/// response.setData(lista);
			response.setData(reporte);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			response.setCodigo("005");
			response.setCodigoHTTP(HttpStatus.INTERNAL_SERVER_ERROR.name());
			response.setMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	
}
