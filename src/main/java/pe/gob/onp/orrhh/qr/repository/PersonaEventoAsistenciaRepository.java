package pe.gob.onp.orrhh.qr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.bean.PersonaEventoAsistenteBean;

@Repository
public interface PersonaEventoAsistenciaRepository extends CrudRepository<PersonaEventoAsistenteBean, Long> , JpaSpecificationExecutor<PersonaEventoAsistenteBean> {

	@Query(value = "SELECT * FROM V_PERSONA_EVENTO_ASIST", nativeQuery = true)
	public List<PersonaEventoAsistenteBean> getListaPersonaEventoAsistencia();
	
}
