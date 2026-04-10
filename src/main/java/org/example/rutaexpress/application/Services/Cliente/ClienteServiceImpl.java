package org.example.rutaexpress.application.Services.Cliente;
import org.example.rutaexpress.Domain.Model.Cliente;
import org.example.rutaexpress.infrastructure.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente actualizar(Long id, Cliente clienteActualizado) {
        Cliente existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        existente.setNombre(clienteActualizado.getNombre());
        existente.setEmail(clienteActualizado.getEmail());
        existente.setTelefono(clienteActualizado.getTelefono());

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Cliente> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return repository.findAll();
    }
}