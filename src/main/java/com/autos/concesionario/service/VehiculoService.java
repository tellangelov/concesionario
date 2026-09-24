package com.autos.concesionario.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.autos.concesionario.model.Vehiculo;
import com.autos.concesionario.repository.VehiculoRepository;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public Vehiculo registrarVehiculo(Vehiculo vehiculo){
        return vehiculoRepository.save(vehiculo);
    }

    public List<Vehiculo> listarVehiculos(){
        return vehiculoRepository.findAll();
    }

    public Vehiculo buscarPorId(Integer id){
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehiculo no encontrado"));
    }

    public Vehiculo actualizarVehiculo(Integer id, Vehiculo datos) {
        Vehiculo vehiculo = buscarPorId(id);
        vehiculo.setMarca(datos.getMarca());
        vehiculo.setModelo(datos.getModelo());
        vehiculo.setCondicion(datos.getCondicion());
        vehiculo.setFechaCompra(datos.getFechaCompra());
        vehiculo.setPrecioCompra(datos.getPrecioCompra());
        return vehiculoRepository.save(vehiculo);
    }

    public void eliminarVehiculo(Integer id){
        Vehiculo vehiculo = buscarPorId(id);
        vehiculoRepository.delete(vehiculo);
    }

}
