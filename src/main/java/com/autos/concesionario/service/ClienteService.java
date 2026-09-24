package com.autos.concesionario.service;

import org.springframework.stereotype.Service;

import com.autos.concesionario.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


}
