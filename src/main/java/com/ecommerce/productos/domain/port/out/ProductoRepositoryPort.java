package com.ecommerce.productos.domain.port.out;

import com.ecommerce.productos.domain.model.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {
    Producto save(Producto producto);
    Optional<Producto> findById(Long id);
    List<Producto> findAll();
    // ... otros métodos como update y delete se pueden añadir en futuros Sprints
}