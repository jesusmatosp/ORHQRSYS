package pe.gob.onp.orrhh.qr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.model.PersonaEvento;
import pe.gob.onp.orrhh.qr.model.PersonaEventoPK;

@Repository
public interface PersonaEventoRepository extends CrudRepository<PersonaEvento, PersonaEventoPK> {

	
	@Query("SELECT pe FROM PersonaEvento pe WHERE pe.id.idEvento = :idEvento  ")
	public List<PersonaEvento> getPersonaEventoByIdEvento(Long idEvento);
	
}
