package com.concesionario.autos.service;

import com.concesionario.autos.repository.AlquilerRepository;
import org.springframework.stereotype.Service;

@Service
public class AlquilerService {

    private final AlquilerRepository repository;
    private final ClienteService clienteService;
    private final VehiculoService vehiculoService;

    public AlquilerService(AlquilerRepository repository,
                           ClienteService clienteService,
                           VehiculoService vehiculoService) {
        this.repository = repository;
        this.clienteService = clienteService;
        this.vehiculoService = vehiculoService;
    }

    // TODO (RF5): iniciar alquiler: validar cliente existe, vehiculo existe y esta DISPONIBLE
    //             -> crear Alquiler con fechaInicio y precioDia, fechaFin = null
    // TODO (RF6): finalizar alquiler: setear fechaFin
    // TODO (RF7): total se calcula con Alquiler.calcularTotal() (exponerlo en el DTO de respuesta)
    // TODO (RF8): listar, editar, eliminar alquileres
    // TODO (RF9): al listar, incluir Alquiler.calcularEstado() en el DTO
}
