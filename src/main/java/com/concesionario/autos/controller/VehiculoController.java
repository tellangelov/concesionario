package com.concesionario.autos.controller;

import com.concesionario.autos.service.VehiculoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    // TODO: GET    /api/vehiculos       -> listar inventario, solo DISPONIBLES (RF4)
    // TODO: GET    /api/vehiculos/{id}  -> obtener uno (RF4)
    // TODO: POST   /api/vehiculos       -> registrar (RF3)
    // TODO: PUT    /api/vehiculos/{id}  -> editar (RF4)
    // TODO: DELETE /api/vehiculos/{id}  -> eliminar (RF4)
}
