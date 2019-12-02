package pe.gob.onp.orrhh.qr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.onp.orrhh.qr.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
