package com.concesionario.autos.controller;

import com.concesionario.autos.entity.Cliente;
import com.concesionario.autos.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    // TODO: GET    /api/clientes       -> listar (RF2)
    // TODO: GET    /api/clientes/{id}  -> obtener uno (RF2)
    // TODO: POST   /api/clientes       -> registrar (RF1)
    // TODO: PUT    /api/clientes/{id}  -> editar (RF2)
    // TODO: DELETE /api/clientes/{id}  -> eliminar (RF2)
}
