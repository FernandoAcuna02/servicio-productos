package com.ecommerce.productos.infrastructure.persistence.adapter;

import com.ecommerce.productos.domain.model.Producto;
import com.ecommerce.productos.domain.port.out.ProductoRepositoryPort;
import com.ecommerce.productos.infrastructure.adapters.out.persistence.entity.ProductoEntity;
import com.ecommerce.productos.infrastructure.adapters.out.persistence.repository.ProductoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component // Le dice a Spring que esta clase es un componente gestionado
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {

    private final ProductoJpaRepository productoJpaRepository;

    public ProductoRepositoryAdapter(ProductoJpaRepository productoJpaRepository) {
        this.productoJpaRepository = productoJpaRepository;
    }
    
    // Mapeadores para convertir entre Dominio y Entidad
    private ProductoEntity toEntity(Producto producto) {
        ProductoEntity entity = new ProductoEntity();
        entity.setId(producto.getId());
        entity.setNombre(producto.getNombre());
        entity.setDescripcion(producto.getDescripcion());
        entity.setPrecio(producto.getPrecio());
        entity.setStock(producto.getStock());
        return entity;
    }

    private Producto toDomainModel(ProductoEntity productoEntity) {
        Producto producto = new Producto();
        producto.setId(productoEntity.getId());
        producto.setNombre(productoEntity.getNombre());
        producto.setDescripcion(productoEntity.getDescripcion());
        producto.setPrecio(productoEntity.getPrecio());
        producto.setStock(productoEntity.getStock());
        return producto;
    }

    @Override
    public Producto save(Producto producto) {
        ProductoEntity productoEntity = toEntity(producto);
        ProductoEntity savedEntity = productoJpaRepository.save(productoEntity);
        return toDomainModel(savedEntity);
    }

    @Override
    public Optional<Producto> findById(Long id) {
        // Usamos .map() para convertir el Optional<ProductoEntity> a Optional<Producto>
        return productoJpaRepository.findById(id).map(this::toDomainModel);
    }

    @Override
    public List<Producto> findAll() {
        return productoJpaRepository.findAll().stream()
                .map(this::toDomainModel)
                .collect(Collectors.toList());
    }
}