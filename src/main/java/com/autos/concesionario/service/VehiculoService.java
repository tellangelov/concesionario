package com.autos.concesionario.service;

import org.springframework.stereotype.Service;

import com.autos.concesionario.repository.VehiculoRepository;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }


}
