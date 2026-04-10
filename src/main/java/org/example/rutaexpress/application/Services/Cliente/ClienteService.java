package org.example.rutaexpress.application.Services.Cliente;

import org.example.rutaexpress.Domain.Model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente crear(Cliente cliente);
    Cliente actualizar(Long id, Cliente clienteActualizado);
    void eliminar(Long id);
    Optional<Cliente> obtenerPorId(Long id);
    List<Cliente> obtenerTodos();
}