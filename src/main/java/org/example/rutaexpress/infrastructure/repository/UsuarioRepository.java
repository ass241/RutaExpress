package org.example.rutaexpress.infrastructure.repository;

import org.example.rutaexpress.Domain.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<UsuarioRepository> findByEmail(String email);
}