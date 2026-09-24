package com.autos.concesionario.service;

import org.springframework.stereotype.Service;

import com.autos.concesionario.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // RF1: registrar cliente
    // public Cliente registrarCliente(Cliente cliente) { ... }

    // RF2: listar clientes
    // public List<Cliente> listarClientes() { ... }

    // RF2: actualizar cliente
    // public Cliente actualizarCliente(Integer id, Cliente datos) { ... }

    // RF2: eliminar cliente
    // public void eliminarCliente(Integer id) { ... }
}
