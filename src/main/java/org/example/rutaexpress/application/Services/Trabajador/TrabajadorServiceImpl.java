package org.example.rutaexpress.application.Services.Trabajador;
import org.example.rutaexpress.Domain.Model.Trabajador;
import org.example.rutaexpress.infrastructure.repository.TrabajadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

    private final TrabajadorRepository repository;

    public TrabajadorServiceImpl(TrabajadorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Trabajador crear(Trabajador trabajador) {
        return repository.save(trabajador);
    }

    @Override
    public Trabajador actualizar(Long id, Trabajador trabajadorActualizado) {
        Trabajador existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));

        existente.setNombre(trabajadorActualizado.getNombre());
        existente.setSucursal(trabajadorActualizado.getSucursal());

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Trabajador> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Trabajador> obtenerTodos() {
        return repository.findAll();
    }
}