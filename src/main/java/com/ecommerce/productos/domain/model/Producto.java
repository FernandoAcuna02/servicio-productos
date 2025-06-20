package com.ecommerce.productos.domain.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;
}