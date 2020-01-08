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

import pe.gob.onp.orrhh.qr.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer>, JpaSpecificationExecutor<Persona> {

	@Query("SELECT p FROM Persona p WHERE p.idPersona in (:ids)")
	public List<Persona> getPersonasByIdPersonas(List<Integer> ids);

	@Query("SELECT p FROM Persona p WHERE p.dni = :dni AND p.regimen = :regimen AND p.areaCorporativa = :areaOperativa ")
	public List<Persona> getPersonaByDNI(@Param("dni") String dni,
										 @Param("regimen") String regimen,
										 @Param("areaOperativa") String areaOperativa);
	
	@Modifying
	@Transactional
	@Query("Update Persona p SET p.activo = 'I' WHERE p.idPersona in (:ids) ")
	public void inactivarPersonas(@Param("ids") List<Integer> ids);
	
	@Modifying
	@Transactional
	@Query( value = "UPDATE PERSONA SET DNI = :dni, APELLIDO_PATERNO = :apellidoPaterno, APELLIDO_MATERNO = :apellidoMaterno, NOMBRES = :nombres, "
			+ "SEXO = :sexo, REGIMEN = :regimen, PUESTO = :puesto, AREA_OPERATIVA = :areaOperativa, TELEFONO = :telefono, FECHA_INGRESO = :fechaIngreso, "
			+ "CORREO_CORPORATIVO = :correoCorporativo, CORREO_PERSONAL = :correoPersonal " + 
			"  WHERE DNI = :dniOld AND REGIMEN = :regimenOld AND AREA_OPERATIVA = :areaOperativaOld", nativeQuery = true)
	public void actualizarDatosPersona(@Param("dni") String dni, 
				@Param("apellidoPaterno") String apellidoPaterno, 
				@Param("apellidoMaterno") String apellidoMaterno,
				@Param("nombres") String nombres, 
				@Param("sexo") String sexo, 
				@Param("regimen") String regimen, 
				@Param("puesto") String puesto, 
				@Param("areaOperativa") String areaOperativa, 
				@Param("telefono") String telefono,
				@Param("fechaIngreso") Date fechaIngreso, 
				@Param("correoCorporativo") String correoCorporativo,
				@Param("correoPersonal") String correoPersonal,
				@Param("dniOld") String dniOld,
				@Param("regimenOld") String regimenOld,
				@Param("areaOperativaOld") String areaOperativaOld);
	
}
