package pe.gob.onp.orrhh.qr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

	@Query("SELECT p FROM Persona p WHERE p.idPersona in (:ids)")
	public List<Persona> getPersonasByIdPersonas(List<Integer> ids);
	
	@Modifying
	@Query("Update Persona p SET p.activo = 'I' WHERE p.idPersona in (:ids) ")
	public void inactivarPersonas(@Param("ids") List<Integer> ids);
	
}
