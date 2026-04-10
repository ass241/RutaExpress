package org.example.rutaexpress.application.Services.Transportista;
import org.example.rutaexpress.Domain.Model.Transportista;

import java.util.List;
import java.util.Optional;

public interface TransportistaService {
    Transportista crear(Transportista transportista);
    Transportista actualizar(Long id, Transportista transportista);
    void eliminar(Long id);
    Optional<Transportista> obtenerPorId(Long id);
    List<Transportista> obtenerTodos();
}