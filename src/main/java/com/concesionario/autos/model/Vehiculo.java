package com.concesionario.autos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String modelo;

    // Resultado de la correccion al diagrama: en lugar de eliminar el registro
    // al vender (RF11), se marca el estado y se excluye del inventario.
    @Enumerated(EnumType.STRING)
    private EstadoVehiculo estado; // DISPONIBLE, VENDIDO

    private String condicion;

    private LocalDate fechaCompra;

    private BigDecimal precioCompra;

    public enum EstadoVehiculo { DISPONIBLE, VENDIDO }

    // TODO: getters y setters


    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }
}
