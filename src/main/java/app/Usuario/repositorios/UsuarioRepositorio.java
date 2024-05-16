package app.Usuario.repositorios;

import app.Usuario.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

        Usuario findUsuarioByPersona_Dni(String dni);

        //Usuario findByUsuario(String usuario);

}