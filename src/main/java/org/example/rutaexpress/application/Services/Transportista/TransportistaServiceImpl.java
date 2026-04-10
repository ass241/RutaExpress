package org.example.rutaexpress.application.Services.Transportista;

import org.example.rutaexpress.Domain.Model.Transportista;
import org.example.rutaexpress.infrastructure.repository.TransportistarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportistaServiceImpl implements TransportistaService {

    private final TransportistarRepository repository;

    public TransportistaServiceImpl(TransportistarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transportista crear(Transportista transportista) {
        return repository.save(transportista);
    }

    @Override
    public Transportista actualizar(Long id, Transportista transportistaActualizado) {
        Transportista existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transportista no encontrado"));

        existente.setNombre(transportistaActualizado.getNombre());
        existente.setRutaAsignada(transportistaActualizado.getRutaAsignada());

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Transportista> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Transportista> obtenerTodos() {
        return repository.findAll();
    }
}