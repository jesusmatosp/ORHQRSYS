package pe.gob.onp.orrhh.qr.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.model.Evento;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long> {

	@Query("SELECT e FROM Evento e WHERE e.profesor.idProfesor = :id ")
	public List<Evento> findEventoByIdProfesor(Long id);
	
}
