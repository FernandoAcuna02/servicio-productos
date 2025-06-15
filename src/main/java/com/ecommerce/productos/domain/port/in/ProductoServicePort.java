package com.ecommerce.productos.domain.port.in;

import com.ecommerce.productos.domain.model.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoServicePort {
    Producto crearProducto(Producto producto);
    List<Producto> obtenerTodosLosProductos();
    Optional<Producto> obtenerProductoPorId(Long id);
}