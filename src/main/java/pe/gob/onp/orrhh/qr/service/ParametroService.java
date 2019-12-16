package pe.gob.onp.orrhh.qr.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.onp.orrhh.qr.dto.ParametroDTO;
import pe.gob.onp.orrhh.qr.model.Parametro;
import pe.gob.onp.orrhh.qr.repository.ParametroRepository;

@Service
public class ParametroService {

	private static Logger LOG = LoggerFactory.getLogger(ParametroService.class);
	
	@Autowired
	private ParametroRepository repository;
	
	public ParametroDTO guardarParametro(ParametroDTO parametroDTO) throws Exception {
		try {
			Parametro parametro = new Parametro();
			BeanUtils.copyProperties(parametro, parametroDTO);
			parametro = repository.save(parametro);
			parametroDTO.setIdParametro(parametro.getIdParametro());
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			throw new Exception(e.getLocalizedMessage());
		}
		return parametroDTO;
	}
	
	public List<ParametroDTO> listarParametros() throws Exception {
		List<ParametroDTO> list = new ArrayList<ParametroDTO>();
		try {
			Iterable<Parametro> iterator = repository.findAll();
			iterator.forEach(item -> {
				ParametroDTO parametroDTO = new ParametroDTO();
				try {
					BeanUtils.copyProperties(parametroDTO, item);
					list.add(parametroDTO);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			throw new Exception(e.getLocalizedMessage());
		}
		return list;
	}
	
	public List<ParametroDTO> listarParametrosByCodPadre(String codPadre) throws Exception {
		List<ParametroDTO> list = new ArrayList<ParametroDTO>();
		try {
			List<Parametro> parametros = repository.findParametroByCodPadre(codPadre);
			parametros.forEach(item -> {
				ParametroDTO parametroDTO = new ParametroDTO();
				try {
					BeanUtils.copyProperties(parametroDTO, item);
					list.add(parametroDTO);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			throw new Exception(e.getLocalizedMessage());
		}
		return list;
	}
}
