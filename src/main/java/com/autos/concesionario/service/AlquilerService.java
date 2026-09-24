package com.autos.concesionario.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import com.autos.concesionario.model.Alquiler;
import com.autos.concesionario.repository.*;

@Service
public class AlquilerService {

    private final AlquilerRepository alquilerRepository;
    private final ClienteRepository clienteRepository;
    private final VehiculoRepository vehiculoRepository;
    private final ClienteService clienteService;
    private final VehiculoService vehiculoService;

    public AlquilerService(AlquilerRepository alquilerRepository,
                           ClienteRepository clienteRepository,
                           VehiculoRepository vehiculoRepository, ClienteService clienteService, VehiculoService vehiculoService) {
        this.alquilerRepository = alquilerRepository;
        this.clienteRepository = clienteRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.clienteService = clienteService;
        this.vehiculoService = vehiculoService;
    }

    public Alquiler alquilar(Alquiler datos){
        Alquiler alquiler = new Alquiler();
        alquiler.setCliente(clienteService.buscarPorId(datos.getCliente().getId()));
        alquiler.setVehiculo(vehiculoService.buscarPorId(datos.getVehiculo().getId()));
        alquiler.setFechaInicio(datos.getFechaInicio());
        alquiler.setPrecioDia(datos.getPrecioDia());
        return alquilerRepository.save(alquiler);
    }

    public List<Alquiler> listarAlquileres(){
        return alquilerRepository.findAll();
    }

    public Alquiler buscarPorId(Integer id){
        return alquilerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alquiler no encontrado") {
                });

    }

    public Alquiler actualizarAlquiler(Integer id, Alquiler data){
        Alquiler alquiler = buscarPorId(id);
        alquiler.setCliente(clienteService.buscarPorId(data.getCliente().getId()));
        alquiler.setFechaFin(data.getFechaFin());
        alquiler.setFechaInicio(data.getFechaInicio());
        alquiler.setPrecioDia(data.getPrecioDia());
        alquiler.setVehiculo(vehiculoService.buscarPorId(data.getVehiculo().getId()));
        return alquilerRepository.save(alquiler);
    }

    public Alquiler finalizarAlquiler(Integer id, LocalDate fechaFin){
        
    }

}
