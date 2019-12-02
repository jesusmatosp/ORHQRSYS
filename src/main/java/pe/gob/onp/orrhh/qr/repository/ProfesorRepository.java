package pe.gob.onp.orrhh.qr.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.onp.orrhh.qr.model.Profesor;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Long>, JpaSpecificationExecutor<Profesor> {

}
