package com.concesionario.autos.service;

import com.concesionario.autos.repository.VentaRepository;
import org.springframework.stereotype.Service;

@Service
public class VentaService {

    private final VentaRepository repository;
    private final ClienteService clienteService;
    private final VehiculoService vehiculoService;

    public VentaService(VentaRepository repository,
                        ClienteService clienteService,
                        VehiculoService vehiculoService) {
        this.repository = repository;
        this.clienteService = clienteService;
        this.vehiculoService = vehiculoService;
    }

    // TODO (RF10+RF11): registrar venta (@Transactional):
    //   1. validar cliente y vehiculo (debe estar DISPONIBLE)
    //   2. guardar Venta (cliente, vehiculo, precioVenta, fechaVenta)
    //   3. vehiculoService.marcarVendido(vehiculo) -> sale del inventario
    // TODO (RF12): listar, editar, eliminar ventas
    // TODO (RF13): exponer Venta.calcularUtilidad() en el DTO de respuesta
}
