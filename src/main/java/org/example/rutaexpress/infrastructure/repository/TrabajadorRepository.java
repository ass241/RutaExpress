package org.example.rutaexpress.infrastructure.repository;

import org.example.rutaexpress.Domain.Model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    List<Trabajador> findBySucursal(String sucursal);
}