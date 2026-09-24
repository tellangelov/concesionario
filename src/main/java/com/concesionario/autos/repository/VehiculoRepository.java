package com.autos.concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autos.concesionario.model.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    // Ejemplos de consultas derivadas:
    // List<Vehiculo> findByCondicion(Vehiculo.Condicion condicion);
    // List<Vehiculo> findByMarca(String marca);
}
