package org.example.rutaexpress.application.Services.Envio;
import org.example.rutaexpress.Domain.Model.Envio;
import org.example.rutaexpress.application.Services.Envio.EnvioService;
import org.example.rutaexpress.infrastructure.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioServiceImpl implements EnvioService {
    private  EnvioRepository repository;


    @Override
    public Envio crear(Envio envio) {
        return repository.save(envio);
    }

    @Override
    public Envio actualizar(Long id, Envio envioActualizado) {
        Envio existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Envío no encontrado"));

        // Actualizamos los campos necesarios
        existente.setOrigen(envioActualizado.getOrigen());
        existente.setDestino(envioActualizado.getDestino());
        existente.setPeso(envioActualizado.getPeso());
        existente.setDescripcion(envioActualizado.getDescripcion());
        existente.setEstado(envioActualizado.getEstado());

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Envio> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Envio> obtenerTodos() {
        return repository.findAll();
    }
}