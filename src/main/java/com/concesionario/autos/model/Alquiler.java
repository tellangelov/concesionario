package com.concesionario.autos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    private LocalDate fechaInicio;

    // null = alquiler ACTIVO (RF9)
    private LocalDate fechaFin;

    private BigDecimal precioDia;

    /** RF7: monto segun dias transcurridos entre inicio y fin */
    public BigDecimal calcularTotal() {
        if (fechaFin == null) return null;
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        return precioDia.multiply(BigDecimal.valueOf(Math.max(dias, 1)));
    }

    /** RF9: estado segun presencia/ausencia de fechaFin */
    public String calcularEstado() {
        return fechaFin == null ? "ACTIVO" : "FINALIZADO";
    }

    // TODO: getters y setters
}
