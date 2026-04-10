package org.example.rutaexpress.Domain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El código de seguimiento es obligatorio")
    @Pattern(regexp = "^RTX-[0-9]{6}$", message = "El formato debe ser RTX seguido de 6 números (Ej: RTX-123456)")
    private String trackingCode;

    @NotBlank(message = "El origen no puede estar vacío")
    private String origen;

    @NotBlank(message = "El destino no puede estar vacío")
    private String destino;

    @NotNull(message = "El peso es obligatorio")
    @Positive(message = "El peso debe ser un número mayor a cero")
    private Double peso;

    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    private String descripcion;

    @NotBlank(message = "El estado es obligatorio")
    @Pattern(regexp = "^(Recogido|En Tránsito|Entregado|Incidencia)$",
            message = "El estado debe ser: Recogido, En Tránsito, Entregado o Incidencia")
    private String estado;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Transportista transportista;
}