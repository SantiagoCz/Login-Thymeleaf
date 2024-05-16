package app.Usuario.servicios;

import app.Usuario.entidades.Persona;
import app.Usuario.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicio {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    public Persona crearPersona(Persona persona) {
        return personaRepositorio.save(persona);
    }

    public Persona modificarPersona(Persona persona) {
        return personaRepositorio.save(persona);
    }

    public List<Persona> traerPersona() {
        return personaRepositorio.findAll();
    }


}
