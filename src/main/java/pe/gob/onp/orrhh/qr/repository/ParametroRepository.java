package pe.gob.onp.orrhh.qr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.model.Parametro;

@Repository
public interface ParametroRepository extends CrudRepository<Parametro, Long> {

	@Query("SELECT p FROM Parametro p WHERE p.codPadre = :codPadre ")
	public List<Parametro> findParametroByCodPadre(@Param("codPadre") String codPadre);
	
}
