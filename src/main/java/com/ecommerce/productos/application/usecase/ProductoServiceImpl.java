package com.ecommerce.productos.application.usecase;

import com.ecommerce.productos.domain.model.Producto;
import com.ecommerce.productos.domain.port.in.ProductoServicePort;
import com.ecommerce.productos.domain.port.out.ProductoRepositoryPort;

import java.util.List;
import java.util.Optional;

// Esta clase NO tiene anotaciones de Spring.
// La configuraremos como un Bean más adelante.
public class ProductoServiceImpl implements ProductoServicePort {

    private final ProductoRepositoryPort productoRepositoryPort;

    // Inyectamos el puerto de salida (la interfaz)
    public ProductoServiceImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        // Aquí podría ir lógica de negocio, como validaciones.
        // Por ejemplo, asegurar que el precio no es negativo.
        return productoRepositoryPort.save(producto);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepositoryPort.findAll();
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepositoryPort.findById(id);
    }
}