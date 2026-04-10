package org.example.rutaexpress.Domain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del trabajador es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo debe contener letras")
    private String nombre;

    @NotBlank(message = "La sucursal es obligatoria")
    @Size(min = 4, max = 50, message = "El nombre de la sucursal debe tener entre 4 y 50 caracteres")
    private String sucursal;
}