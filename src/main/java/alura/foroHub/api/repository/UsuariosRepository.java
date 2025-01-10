package alura.foroHub.api.repository;

import alura.foroHub.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>
{
    UserDetails findByLogin(String username);
}
