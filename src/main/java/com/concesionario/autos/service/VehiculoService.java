package com.concesionario.autos.service;

import com.concesionario.autos.entity.Vehiculo;
import com.concesionario.autos.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    private final VehiculoRepository repository;

    public VehiculoService(VehiculoRepository repository) {
        this.repository = repository;
    }

    // TODO (RF3): registrar vehiculo (estado inicial DISPONIBLE)
    // TODO (RF4): listar (findByEstado(DISPONIBLE)), editar, eliminar vehiculo
    // TODO (RF11): marcarVendido(vehiculo) -> cambia estado a VENDIDO (llamado desde VentaService)
}
