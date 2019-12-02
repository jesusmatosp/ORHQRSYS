package pe.gob.onp.orrhh.qr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.model.Parametro;

@Repository
public interface ParametroRepository extends CrudRepository<Parametro, Long> {

}
