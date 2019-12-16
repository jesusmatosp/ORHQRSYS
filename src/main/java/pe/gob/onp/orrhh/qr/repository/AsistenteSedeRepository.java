package pe.gob.onp.orrhh.qr.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.onp.orrhh.qr.bean.AsistenteSedeBen;

@Repository
public interface AsistenteSedeRepository extends CrudRepository<AsistenteSedeBen, Long>, JpaSpecificationExecutor<AsistenteSedeBen>{

	@Query(value =  "SELECT * FROM V_ASISTENTES_SEDE WHERE ", nativeQuery = true)
	public List<AsistenteSedeBen> getReporteListaAsistenteSede();
}
