package pe.gob.onp.orrhh.qr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.model.PersonaEvento;
import pe.gob.onp.orrhh.qr.model.PersonaEventoPK;

@Repository
public interface PersonaEventoRepository extends CrudRepository<PersonaEvento, PersonaEventoPK> {

}
