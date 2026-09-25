package com.autos.concesionario.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autos.concesionario.model.Alquiler;
import com.autos.concesionario.service.AlquilerService;

@RestController
@RequestMapping("/api/alquileres")
public class AlquilerController {

    private final AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alquiler alquilar(@RequestBody Alquiler alquiler){
        return alquilerService.alquilar(alquiler);
    }

    @GetMapping
    public List<Alquiler> listar(){
        return alquilerService.listarAlquileres();
    }

    @PutMapping("/{id}")
    public Alquiler actualizar(@PathVariable Integer id, @RequestBody Alquiler alquiler){
        return alquilerService.actualizarAlquiler(id, alquiler);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        alquilerService.eliminarAlquiler(id);
    }

    @PatchMapping("/{id}/finalizar")
    public Alquiler finalizar(@PathVariable Integer id, @RequestParam LocalDate fechaFin){
        return alquilerService.finalizarAlquiler(id, fechaFin);
    }

}
