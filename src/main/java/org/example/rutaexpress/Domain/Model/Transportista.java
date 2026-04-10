package org.example.rutaexpress.Domain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Transportista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del transportista es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo debe contener letras")
    private String nombre;

    @NotBlank(message = "La ruta asignada no puede estar vacía")
    @Size(min = 5, max = 50, message = "La descripción de la ruta debe tener entre 5 y 50 caracteres")
    private String rutaAsignada;
}