package pe.gob.onp.orrhh.qr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import pe.gob.onp.orrhh.qr.dto.ProfesorCriteriaSearchDTO;
import pe.gob.onp.orrhh.qr.dto.ProfesorDTO;
import pe.gob.onp.orrhh.qr.model.Profesor;
import pe.gob.onp.orrhh.qr.repository.ProfesorRepository;
import pe.gob.onp.orrhh.qr.utilitario.Constantes;
import pe.gob.onp.orrhh.qr.utilitario.DateUtilitario;
import pe.gob.onp.orrhh.qr.utilitario.exception.ProfesorException;

@Service
public class ProfesorService {

	private static final Logger LOG = LoggerFactory.getLogger(ProfesorService.class);
	
	@Autowired
	private ProfesorRepository repository;
	
	@Autowired
	private MessageSource messageSource; 
	
	public ProfesorDTO guardarProfesor(ProfesorDTO profesorDTO) throws ProfesorException {
		try {
			if(validaCamposProfesor(profesorDTO)) {
				if(profesorDTO.getIdProfesor() != null) {
					Optional<Profesor> tmp = repository.findById(profesorDTO.getIdProfesor());
					if(tmp == null) throw new ProfesorException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PROFESOR_NOT_FOUND, null, Locale.US));
					
					Profesor profesor = repository.findByDni(profesorDTO.getDni());
					if(profesor != null) throw new ProfesorException("Este DNI o CE ya fue registrado en el sistema ");
					
					profesorDTO.setUsuarioCreacion(tmp.get().getUsuarioCreacion());
					profesorDTO.setFechaCreacion(tmp.get().getFechaCreacion());
					profesorDTO.setFechaModifica(DateUtilitario.getCurrentDate());
				} else {
					profesorDTO.setFechaCreacion(DateUtilitario.getCurrentDate());
				}
				Profesor profesor = new Profesor();
				BeanUtils.copyProperties(profesor, profesorDTO);
				profesor.setPasswordSistema(Constantes.PASSWORD_TEMPORAL_APP);
				profesor = repository.save(profesor);
				profesorDTO.setIdProfesor(profesor.getIdProfesor());
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new ProfesorException(e.getLocalizedMessage());
		}
		return profesorDTO;
	}
	
	public boolean validaCamposProfesor(ProfesorDTO profesorDTO) throws ProfesorException {
		if(profesorDTO.getDni() == null) throw new ProfesorException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PROFESOR_DNI, null, Locale.US));
		if(profesorDTO.getTipoDocumento() == null) throw new ProfesorException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PROFESOR_TIPO_DOCUMENTO, null, Locale.US));
		if(profesorDTO.getNombre() == null) throw new ProfesorException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PROFESOR_NOMBRE, null, Locale.US));
		if(profesorDTO.getApellidoPaterno() == null) throw new ProfesorException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PROFESOR_PATERNO, null, Locale.US));
		if(profesorDTO.getApellidoMaterno() == null) throw new ProfesorException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PROFESOR_MATERNO, null, Locale.US));
		if(profesorDTO.getActivo() == null) throw new ProfesorException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PROFESOR_ACTIVO, null, Locale.US));
		return true;
	}
	
	public List<ProfesorDTO> listarProfesorAll() throws ProfesorException {
		List<ProfesorDTO> list = new ArrayList<ProfesorDTO>();
		try {
			// Iterable<Profesor> iterator = repository.findAll();
			List<Profesor> iterator = repository.findAllActive();
			iterator.forEach( item -> {
				try {
					ProfesorDTO profesorDTO = new ProfesorDTO();
					BeanUtils.copyProperties(profesorDTO, item);
					list.add(profesorDTO);
				} catch (Exception e) {
					LOG.error(e.getLocalizedMessage(), e);
				}
			});
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new ProfesorException(e.getLocalizedMessage());
		}
		return list;
	}
	
	public ProfesorDTO obtenerProfesorById(Long id) throws ProfesorException {
		ProfesorDTO profesorDTO = new ProfesorDTO();
		try {
			if(id == null) throw new ProfesorException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PROFESOR_ID, null, Locale.US));
			Optional<Profesor> optional = repository.findById(id);
			if(optional==null) throw new ProfesorException(messageSource.getMessage(Constantes.MESSAGE_EXCEPTION_PROFESOR_NOT_FOUND, null, Locale.US));
			Profesor profesor = optional.get();
			BeanUtils.copyProperties(profesorDTO, profesor);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new ProfesorException(e.getLocalizedMessage());
		}
		return profesorDTO;
	}
	
	public List<ProfesorDTO> findByCriteriaProfesorDTO(ProfesorCriteriaSearchDTO requestSearch) throws ProfesorException {
		List<Profesor> list = findByCriteria(requestSearch);
		List<ProfesorDTO> profesores = new ArrayList<ProfesorDTO>();
		list.forEach(item -> {
			ProfesorDTO profesorDTO = new ProfesorDTO();
			try {
				BeanUtils.copyProperties(profesorDTO, item);
				profesores.add(profesorDTO);
			} catch (Exception e) {
				LOG.error(e.getLocalizedMessage(), e);
			}
		});
		return profesores;
	}
	
	public List<Profesor> findByCriteria(ProfesorCriteriaSearchDTO requestSearch) throws ProfesorException {
		return repository.findAll(new Specification<Profesor>() {
			@Override
			public Predicate toPredicate(Root<Profesor> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				if(requestSearch.getDni() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("dni"), requestSearch.getDni())));
				}
				
				if(requestSearch.getNombre() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("nombre"), "%" + requestSearch.getNombre().toUpperCase() + "%")));
				}
				
				if(requestSearch.getApellidoPaterno() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("apellidoPaterno"), "%" + requestSearch.getApellidoPaterno().toUpperCase() + "%")));
				}
				
				if(requestSearch.getApellidoMaterno() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("apellidoMaterno"), "%" + requestSearch.getApellidoMaterno().toUpperCase() + "%")));
				}
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}
	
	public ProfesorDTO loginProfesor(ProfesorDTO profesorDTO) throws ProfesorException {
		try {
			Profesor u = repository.login(profesorDTO.getDni(), profesorDTO.getPasswordSistema());
			if(u == null) throw new ProfesorException("Usuario o Contraseña son incorrectas");
			BeanUtils.copyProperties(profesorDTO, u);
			profesorDTO.setPasswordSistema("");
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new ProfesorException(e.getLocalizedMessage());
		}
		return profesorDTO;
	}
	
	public boolean eliminarProfesor(List<Long> ids) throws ProfesorException {
		boolean result = false;
		try {
			repository.updateInactiveProfesor(ids);
			result = true;
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			throw new ProfesorException(e.getLocalizedMessage());
		}
		return result;
	}
	
}
