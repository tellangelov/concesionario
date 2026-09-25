package com.autos.concesionario.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.autos.concesionario.model.Vehiculo;
import com.autos.concesionario.service.VehiculoService;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    public Vehiculo registrar(Vehiculo vehiculo){
        return vehiculoService.registrarVehiculo(vehiculo);
    }

    public List<Vehiculo> listar(){
        return vehiculoService.listarVehiculos();
    }

    public Vehiculo actualizar(Integer id, Vehiculo vehiculo){
        return vehiculoService.actualizarVehiculo(id, vehiculo);
    }
    
    public void eliminar(Integer id){
        vehiculoService.eliminarVehiculo(id);
    }

}
