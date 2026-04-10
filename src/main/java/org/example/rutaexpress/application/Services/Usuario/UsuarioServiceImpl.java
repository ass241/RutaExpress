package org.example.rutaexpress.application.Services.Usuario;

import org.example.rutaexpress.Domain.Model.Usuario;
import org.example.rutaexpress.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario crear(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuarioActualizado) {
        Usuario existente = obtenerPorId(id);
        existente.setNombre(usuarioActualizado.getNombre());
        existente.setEmail(usuarioActualizado.getEmail());
        existente.setRol(usuarioActualizado.getRol());
        // En un caso real, la contraseña se encriptaría aquí
        existente.setPassword(usuarioActualizado.getPassword());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repository.delete(id);
    }
}