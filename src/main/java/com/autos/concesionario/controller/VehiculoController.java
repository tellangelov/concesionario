package com.autos.concesionario.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.autos.concesionario.model.Vehiculo;
import com.autos.concesionario.service.VehiculoService;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehiculo registrar(@RequestBody Vehiculo vehiculo){
        return vehiculoService.registrarVehiculo(vehiculo);
    }

    @GetMapping
    public List<Vehiculo> listar(){
        return vehiculoService.listarVehiculos();
    }

    @PutMapping("/{id}")
    public Vehiculo actualizar(@PathVariable Integer id, @RequestBody Vehiculo vehiculo){
        return vehiculoService.actualizarVehiculo(id, vehiculo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        vehiculoService.eliminarVehiculo(id);
    }

}
