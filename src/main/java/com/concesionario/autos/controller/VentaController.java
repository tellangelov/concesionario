package com.concesionario.autos.controller;

import com.concesionario.autos.service.VentaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService service;

    public VentaController(VentaService service) {
        this.service = service;
    }

    // TODO: GET    /api/ventas       -> listar incluyendo utilidad de cada venta (RF12, RF13)
    // TODO: POST   /api/ventas       -> registrar venta: body { clienteId, vehiculoId, precioVenta } (RF10, RF11)
    // TODO: PUT    /api/ventas/{id}  -> editar (RF12)
    // TODO: DELETE /api/ventas/{id}  -> eliminar (RF12)
}
