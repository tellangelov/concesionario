package com.autos.concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autos.concesionario.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Spring Data genera las consultas a partir del nombre del método.
    // Ejemplos:
    // Optional<Cliente> findByDni(String dni);
    // boolean existsByDni(String dni);
}
