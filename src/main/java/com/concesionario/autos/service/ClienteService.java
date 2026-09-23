package com.concesionario.autos.service;

import com.concesionario.autos.entity.Cliente;
import com.concesionario.autos.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    // TODO (RF1): registrar cliente
    // TODO (RF2): listar, editar, eliminar cliente
}
