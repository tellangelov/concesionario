package com.concesionario.autos.repository;

import com.concesionario.autos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    // RF4: listar inventario (solo vehiculos no vendidos)
    List<Vehiculo> findByEstado(Vehiculo.EstadoVehiculo estado);
}
