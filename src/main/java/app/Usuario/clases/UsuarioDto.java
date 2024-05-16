package app.Usuario.clases;

import app.Usuario.entidades.Persona;
import app.Usuario.entidades.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private Persona persona;
    private Usuario usuario;
}
