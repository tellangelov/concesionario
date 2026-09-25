package com.autos.concesionario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.autos.concesionario.service.ClienteService;

import com.autos.concesionario.model.Cliente;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente registrar(@RequestBody Cliente cliente){
        return clienteService.registrarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listar(){
        return clienteService.listarCliente();
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Integer id, @RequestBody Cliente data){
        return clienteService.actualizarCliente(id, data);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        clienteService.eliminarCliente(id);
    }

}
