package com.autos.concesionario.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public Cliente registrar(Cliente cliente){
        return clienteService.registrarCliente(cliente);
    }

    public List<Cliente> listarClientes(){
        return clienteService.listarCliente();
    }

    public Cliente buscarPorId(Integer id){
        return clienteService.buscarPorId(id);
    }

    public Cliente actualizarCliente(Integer id, Cliente data){
        return clienteService.actualizarCliente(id, data);
    }

    public void eliminarCliente(Integer id){
        clienteService.eliminarCliente(id);
    }

}
