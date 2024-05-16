package app.Usuario.repositorios;

import app.Usuario.entidades.Persona;
import app.Usuario.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

}