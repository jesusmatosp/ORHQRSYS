package pe.gob.onp.orrhh.qr.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.gob.onp.orrhh.qr.model.Profesor;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Long>, JpaSpecificationExecutor<Profesor> {

	@Modifying
	@Transactional
	@Query("Update Profesor p SET p.activo = 'I'  WHERE p.idProfesor in :ids")
	public void updateInactiveProfesor(@Param("ids") List<Long> ids);
	
	@Query("SELECT p FROM Profesor p WHERE p.activo = 'A'")
	public List<Profesor> findAllActive(); 
	
	@Query("SELECT p FROM Profesor p WHERE p.dni = :dni AND p.passwordSistema = :password ")
	public Profesor login(@Param("dni") String dni, @Param("password") String password);
	
	@Query("SELECT p FROM Profesor p WHERE p.dni = :dni ")
	public Profesor findByDni(@Param("dni") String dni);
	
}
