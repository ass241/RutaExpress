package org.example.rutaexpress.application.Services.Usuario;
import org.example.rutaexpress.Domain.Model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario crear(Usuario usuario);
    Usuario obtenerPorId(Long id);
    List<Usuario> listarTodos();
    Usuario actualizar(Long id, Usuario usuarioActualizado);
    void eliminar(Long id);
}