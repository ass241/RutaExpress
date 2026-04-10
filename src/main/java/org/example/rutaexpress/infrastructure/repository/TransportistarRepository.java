package org.example.rutaexpress.infrastructure.repository;

import org.example.rutaexpress.Domain.Model.Transportista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportistarRepository extends JpaRepository<Transportista, Long> {
    List<Transportista> findByRutaAsignada(String rutaAsignada);
}