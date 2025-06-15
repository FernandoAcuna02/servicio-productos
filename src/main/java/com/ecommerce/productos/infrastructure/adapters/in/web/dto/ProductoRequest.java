package com.ecommerce.productos.infrastructure.adapters.in.web.dto;

import java.math.BigDecimal;

// Usamos un 'record' de Java para un DTO conciso e inmutable.
public record ProductoRequest(
    String nombre,
    String descripcion,
    BigDecimal precio,
    int stock
) {}