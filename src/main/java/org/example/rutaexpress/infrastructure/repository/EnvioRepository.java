package org.example.rutaexpress.infrastructure.repository;
import org.example.rutaexpress.Domain.Model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EnvioRepository extends JpaRepository<Envio, Long> {
    Optional<Envio> findByTrackingCode(String trackingCode);
    List<Envio> findByTransportistaId(Long transportistaId);
}