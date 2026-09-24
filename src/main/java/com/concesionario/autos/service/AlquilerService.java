package com.autos.concesionario.service;

import org.springframework.stereotype.Service;

import com.autos.concesionario.repository.AlquilerRepository;
import com.autos.concesionario.repository.ClienteRepository;
import com.autos.concesionario.repository.VehiculoRepository;

@Service
public class AlquilerService {

    private final AlquilerRepository alquilerRepository;
    private final ClienteRepository clienteRepository;
    private final VehiculoRepository vehiculoRepository;

    public AlquilerService(AlquilerRepository alquilerRepository,
                           ClienteRepository clienteRepository,
                           VehiculoRepository vehiculoRepository) {
        this.alquilerRepository = alquilerRepository;
        this.clienteRepository = clienteRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    // RF5: iniciar alquiler (validar que cliente y vehículo existen, fechaFin = null)
    // public Alquiler alquilar(...) { ... }

    // RF6: finalizar alquiler registrando la fecha de finalización
    // public Alquiler finalizarAlquiler(Integer id, LocalDate fechaFin) { ... }

    // RF7: el cálculo del monto vive en Alquiler.calcularTotal()

    // RF8: listar alquileres
    // public List<Alquiler> listarAlquileres() { ... }

    // RF8: actualizar alquiler
    // public Alquiler actualizarAlquiler(Integer id, ...) { ... }

    // RF8: eliminar alquiler
    // public void eliminarAlquiler(Integer id) { ... }
}
