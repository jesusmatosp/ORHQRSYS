package pe.gob.onp.orrhh.qr.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.bean.PersonaBean;

@Repository
public interface PersonaViewRepository extends CrudRepository<PersonaBean, String>, JpaSpecificationExecutor<PersonaBean>{

}
