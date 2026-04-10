package org.example.rutaexpress.infrastructure.repository;

import org.example.rutaexpress.Domain.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

