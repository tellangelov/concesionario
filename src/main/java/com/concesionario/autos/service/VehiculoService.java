package com.autos.concesionario.service;

import org.springframework.stereotype.Service;

import com.autos.concesionario.repository.VehiculoRepository;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    // RF3: registrar vehículo
    // public Vehiculo registrarVehiculo(Vehiculo vehiculo) { ... }

    // RF4: listar vehículos
    // public List<Vehiculo> listarVehiculos() { ... }

    // RF4: actualizar vehículo
    // public Vehiculo actualizarVehiculo(Integer id, Vehiculo datos) { ... }

    // RF4: eliminar vehículo
    // public void eliminarVehiculo(Integer id) { ... }
}
