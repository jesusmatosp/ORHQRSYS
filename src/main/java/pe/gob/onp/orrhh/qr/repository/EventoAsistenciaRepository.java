package pe.gob.onp.orrhh.qr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.model.EventoAsistencia;

@Repository
public interface EventoAsistenciaRepository extends CrudRepository<EventoAsistencia, Integer>, JpaSpecificationExecutor<EventoAsistencia> {

	List<EventoAsistencia> getEventoAsistenciaByIdEvento(Long idEvento);
	
}
