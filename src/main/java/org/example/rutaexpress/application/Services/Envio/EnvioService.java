package org.example.rutaexpress.application.Services.Envio;
import org.example.rutaexpress.Domain.Model.Envio;

import java.util.List;
import java.util.Optional;

public interface EnvioService {
    Envio crear(Envio envio);
    Envio actualizar(Long id, Envio envioActualizado);
    void eliminar(Long id);
    Optional<Envio> obtenerPorId(Long id);
    List<Envio> obtenerTodos();
}