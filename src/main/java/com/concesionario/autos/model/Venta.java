package com.concesionario.autos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    private BigDecimal precioVenta;

    private LocalDate fechaVenta;

    /** RF13: utilidad = precioVenta - precioCompra del vehiculo */
    public BigDecimal calcularUtilidad() {
        return precioVenta.subtract(vehiculo.getPrecioCompra());
    }

    // TODO: getters y setters
}
