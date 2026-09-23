package com.concesionario.autos.controller;

import com.concesionario.autos.service.AlquilerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alquileres")
public class AlquilerController {

    private final AlquilerService service;

    public AlquilerController(AlquilerService service) {
        this.service = service;
    }

    // TODO: GET    /api/alquileres              -> listar, incluyendo estado y total en cada DTO (RF8, RF9, RF7)
    // TODO: POST   /api/alquileres              -> iniciar alquiler: body { clienteId, vehiculoId, fechaInicio, precioDia } (RF5)
    // TODO: PUT    /api/alquileres/{id}/fin     -> finalizar alquiler: body { fechaFin } (RF6)
    // TODO: PUT    /api/alquileres/{id}         -> editar (RF8)
    // TODO: DELETE /api/alquileres/{id}         -> eliminar (RF8)
}
