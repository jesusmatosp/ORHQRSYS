package pe.gob.onp.orrhh.qr.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.onp.orrhh.qr.model.Proceso;
import pe.gob.onp.orrhh.qr.repository.ProcesoRepository;

@Service
public class ProcesoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProcesoService.class);
	@Autowired
	private ProcesoRepository repository;
	
	public Proceso procesarCarga(Proceso proceso) throws Exception{
		try {
			proceso = repository.save(proceso);
			
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new Exception(e.getLocalizedMessage());
		}
		return proceso;
	}
	
}
