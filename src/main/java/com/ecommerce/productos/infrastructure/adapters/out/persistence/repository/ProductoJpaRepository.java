package com.ecommerce.productos.infrastructure.adapters.out.persistence.repository;

import com.ecommerce.productos.infrastructure.adapters.out.persistence.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Le indica a Spring que esto es un componente de persistencia
public interface ProductoJpaRepository extends JpaRepository<ProductoEntity, Long> {
    // JpaRepository ya nos da métodos como save(), findById(), findAll(), deleteById(), etc.
    // No necesitamos añadir nada más por ahora.
}