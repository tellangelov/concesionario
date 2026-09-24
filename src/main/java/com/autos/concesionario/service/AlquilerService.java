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

}
