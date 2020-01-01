package pe.gob.onp.orrhh.qr.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.model.EventoHorario;

@Repository
public interface EventoHorarioRepository extends CrudRepository<EventoHorario, Long> {

	
	@Modifying
	@Transactional
	@Query("DELETE FROM EventoHorario e WHERE e.evento.idEvento =:idEvento ")
	public void eliminarHorariosByIdEvento(@Param("idEvento") Long idEvento);
	
	@Query(value = "SELECT * FROM EVENTO_HORARIO WHERE ID_EVENTO = :idEvento "
			+ " AND DIA = :dia AND TO_DATE(:horaMarcacion, 'HH24:MI') BETWEEN TO_DATE(HORA_INICIO, 'HH24:MI') "
			+ "AND TO_DATE(HORA_FIN, 'HH24:MI')", nativeQuery = true)
	public List<EventoHorario> getEventoByDiaHora(@Param("idEvento") Long idEvento, 
												  @Param("dia") String dia, 
												  @Param("horaMarcacion") String horaMarcacion);
	
	
}
