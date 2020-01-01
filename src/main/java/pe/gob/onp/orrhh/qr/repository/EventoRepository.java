package pe.gob.onp.orrhh.qr.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.dto.HorarioEventoDTO;
import pe.gob.onp.orrhh.qr.model.Evento;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long>, JpaSpecificationExecutor<Evento> {

	@Query("SELECT e FROM Evento e WHERE e.idProfesor = :id AND :toDate BETWEEN e.fechaInicio AND e.fechaCierre")
	public List<Evento> findEventoByIdProfesor(Long id, @Param("toDate") Date toDate);
	
	@Query("SELECT e FROM Evento e WHERE e.activo = 'A'")
	public List<Evento> findAllActive();
	
	@Modifying
	@Transactional
	@Query("UPDATE Evento e SET e.activo = 'I' WHERE e.idEvento in :ids")
	public void inactiveEvento(@Param("ids") List<Long> ids);
	
	@Query("SELECT e FROM Evento e WHERE e.idEvento =:idEvento AND :toDate BETWEEN e.fechaInicio AND e.fechaCierre ")
	public List<Evento> findEventoByIdFechas( @Param("idEvento") Long idEvento, @Param("toDate") Date toDate );
	
	@Query("SELECT h FROM HorarioEventoDTO h WHERE h.idEvento = :idEvento ")
	public List<HorarioEventoDTO> findHorarioByEventoId(@Param("idEvento") Long idEvento);
	
}
