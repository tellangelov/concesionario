package com.autos.concesionario.service;

import java.time.LocalDate;
import java.util.List;

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

    public AlquilerService(AlquilerRepository alquilerRepository,
                           ClienteRepository clienteRepository,
                           VehiculoRepository vehiculoRepository) {
        this.alquilerRepository = alquilerRepository;
        this.clienteRepository = clienteRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    public Alquiler alquilar(Alquiler alquiler){
        return alquilerRepository.save(alquiler);
    }

    public List<Alquiler> listarAlquileres(){
        return alquilerRepository.findAll();
    }

    public Alquiler buscarPorId(Integer id){
        return alquilerRepository.findById(id)
                .orElseThrow(() -> new HttpStatusCodeException(HttpStatus.NOT_FOUND, "Alquiler no encontrado") {
                });

    }

    public Alquiler actualizarAlquiler(Integer id, Alquiler data){
        Alquiler alquiler = buscarPorId(id);
        alquiler.setCliente(data.getCliente());
        alquiler.setFechaFin(data.getFechaFin());
        alquiler.setFechaInicio(data.getFechaInicio());
        alquiler.setPrecioDia(data.getPrecioDia());
        alquiler.setVehiculo(data.getVehiculo());
        return alquilerRepository.save(alquiler);
    }

    public Alquiler finalizarAlquiler(Integer id, Date)

}
