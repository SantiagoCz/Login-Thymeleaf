package app.Usuario.clases;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {

    private Integer id;

    private String dni;

    private String nombre;

    private String apellido;

    private String telefono;

    private LocalDate fechaNacimiento;
}
