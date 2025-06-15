package com.ecommerce.productos.infrastructure.adapters.in.web;

import com.ecommerce.productos.domain.model.Producto;
import com.ecommerce.productos.domain.port.in.ProductoServicePort;
import com.ecommerce.productos.infrastructure.adapters.in.web.dto.ProductoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Anotación clave que combina @Controller y @ResponseBody
@RequestMapping("/api/productos") // Ruta base para todos los endpoints de este controlador
public class ProductoController {

    private final ProductoServicePort productoServicePort;

    // Inyectamos el puerto de entrada, no la implementación directamente
    public ProductoController(ProductoServicePort productoServicePort) {
        this.productoServicePort = productoServicePort;
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoRequest productoRequest) {
        // Mapeamos del DTO de solicitud a nuestro modelo de dominio
        Producto producto = new Producto();
        producto.setNombre(productoRequest.nombre());
        producto.setDescripcion(productoRequest.descripcion());
        producto.setPrecio(productoRequest.precio());
        producto.setStock(productoRequest.stock());

        Producto nuevoProducto = productoServicePort.crearProducto(producto);
        // Devolvemos el producto creado y un estado HTTP 201 (Created)
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        return productoServicePort.obtenerProductoPorId(id)
                // Si se encuentra, devolvemos el producto con estado 200 (OK)
                .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                // Si no, devolvemos un estado 404 (Not Found)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        List<Producto> productos = productoServicePort.obtenerTodosLosProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
}