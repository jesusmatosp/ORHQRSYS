package pe.gob.onp.orrhh.qr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.model.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {

}
