package com.ecommerce.productos.infrastructure.config;

import com.ecommerce.productos.application.usecase.ProductoServiceImpl;
import com.ecommerce.productos.domain.port.in.ProductoServicePort;
import com.ecommerce.productos.domain.port.out.ProductoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProductoServicePort productoServicePort(ProductoRepositoryPort productoRepositoryPort) {
        // Aquí le decimos a Spring:
        // 1. Crea una instancia de ProductoServiceImpl.
        // 2. Para su constructor, necesita un ProductoRepositoryPort.
        // 3. Spring buscará un componente que implemente esa interfaz (nuestro ProductoRepositoryAdapter)
        //    y lo inyectará automáticamente.
        return new ProductoServiceImpl(productoRepositoryPort);
    }
}