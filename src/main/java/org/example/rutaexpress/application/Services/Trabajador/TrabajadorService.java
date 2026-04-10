package org.example.rutaexpress.application.Services.Trabajador;
import org.example.rutaexpress.Domain.Model.Trabajador;

import java.util.List;
import java.util.Optional;

public interface TrabajadorService {
    Trabajador crear(Trabajador trabajador);
    Trabajador actualizar(Long id, Trabajador trabajador);
    void eliminar(Long id);
    Optional<Trabajador> obtenerPorId(Long id);
    List<Trabajador> obtenerTodos();
}
