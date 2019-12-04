package pe.gob.onp.orrhh.qr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.model.Proceso;

@Repository
public interface ProcesoRepository extends CrudRepository<Proceso, Long> {

}
