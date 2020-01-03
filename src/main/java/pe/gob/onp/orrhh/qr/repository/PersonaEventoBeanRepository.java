package pe.gob.onp.orrhh.qr.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import pe.gob.onp.orrhh.qr.bean.PersonaEventoBean;

public interface PersonaEventoBeanRepository extends CrudRepository<PersonaEventoBean, Long>, JpaSpecificationExecutor<PersonaEventoBean>{

	
}
