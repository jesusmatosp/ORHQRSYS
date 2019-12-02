package pe.gob.onp.orrhh.qr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.model.EventoHorario;

@Repository
public interface EventoHorarioRepository extends CrudRepository<EventoHorario, Long> {

}
