/**
 * Paquete para DTOs:
 *
 * - Separa los request bodies de las entidades JPA (ej. AlquilerRequest
 *   con clienteId/vehiculoId/fechaInicio/precioDia).
 * - Los response DTOs agregan campos calculados:
 *     AlquilerResponse  -> estado (RF9), total (RF7)
 *     VentaResponse     -> utilidad (RF13)
 *
 * Puedes usar Java records para mantenerlos cortos, por ejemplo:
 *
 *   public record VentaResponse(
 *       Integer id,
 *       String clienteNombre,
 *       String vehiculoModelo,
 *       BigDecimal precioVenta,
 *       BigDecimal utilidad,
 *       LocalDate fechaVenta
 *   ) {}
 */
package com.concesionario.autos.dto;
