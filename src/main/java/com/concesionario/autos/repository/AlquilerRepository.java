package com.autos.concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autos.concesionario.model.Alquiler;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {

    // Ejemplos de consultas derivadas:
    // List<Alquiler> findByClienteId(Integer clienteId);
    // List<Alquiler> findByVehiculoId(Integer vehiculoId);
    // List<Alquiler> findByFechaFinIsNull(); // alquileres activos
}
