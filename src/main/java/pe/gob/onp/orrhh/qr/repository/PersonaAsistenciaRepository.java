package pe.gob.onp.orrhh.qr.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.gob.onp.orrhh.qr.bean.AsistenteSedeBen;
import pe.gob.onp.orrhh.qr.model.PersonAsistencia;

public interface PersonaAsistenciaRepository extends CrudRepository<PersonAsistencia, Long> {

	// @Query("SELECT p FROM PersonAsistencia p WHERE p.idPersona = :idPersona AND p.idEvento=:idEvento AND p.fechaAsistencia BETWEEN :dtAsistencia AND :dtAsistencia")
	@Query("SELECT p FROM PersonAsistencia p WHERE p.idPersona = :idPersona AND p.idEvento=:idEvento")
	public List<PersonAsistencia> getAsistenciaByIdPersonaFecha(
			@Param("idPersona") Long idPersona,
			@Param("idEvento") Long idEvento);
	
	@Query("SELECT a FROM PersonAsistencia a WHERE a.idEvento =:idEvento ")
	public List<PersonAsistencia> getAsistenciaByIdEvento(@Param("idEvento") Long idEvento);
	
	@Query("SELECT count(*) FROM PersonAsistencia a WHERE a.idEventoHorario = :idEventoHorario ")
	public Long getCountEvento(@Param("idEventoHorario") Long idEventoHorario);
	
	
}
