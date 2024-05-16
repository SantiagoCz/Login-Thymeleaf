package app.Usuario.entidades;

import app.Usuario.entidades.Persona;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rol")
    private Rol rol;

    @Column(name = "contrasenia")
    private String contrasenia;

    //RELACION 1-1 CON PERSONA
    @OneToOne
    @JoinColumn(name = "persona_id", unique = true)
    private Persona persona;

}

