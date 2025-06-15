# Microservicio: Servicio de Productos

Este repositorio contiene el código fuente del `servicio-productos`, que forma parte de un sistema de E-Commerce basado en una arquitectura de microservicios.

## Descripción

Este microservicio es responsable de gestionar toda la lógica de negocio relacionada con el catálogo de productos. Sus responsabilidades incluyen la creación, consulta, actualización y eliminación de productos, así como la gestión de su stock y precios. Funciona de manera autónoma y expone sus funcionalidades a través de una API REST.

## Arquitectura y Diseño

El desarrollo de este microservicio se adhiere a principios de diseño de software modernos para garantizar su mantenibilidad, escalabilidad y testabilidad.

-   **Arquitectura de Microservicios:** El servicio está diseñado para ser una unidad de despliegue independiente, gestionando su propio dominio y su propia base de datos.
-   **Arquitectura Hexagonal (Puertos y Adaptadores):** Se ha implementado esta arquitectura para aislar completamente el núcleo de la lógica de negocio (dominio) de las tecnologías externas (infraestructura). Esto se logra mediante el uso de puertos (interfaces) y adaptadores (implementaciones concretas), lo que permite cambiar la base de datos o el tipo de API sin afectar el dominio.
-   **Principios SOLID:** El código sigue los principios SOLID para crear un software robusto y fácil de mantener.

## Tecnologías Utilizadas

-   **Lenguaje:** Java 17
-   **Framework:** Spring Boot 3.x
-   **Persistencia:** Spring Data JPA / Hibernate
-   **Base de Datos:** PostgreSQL
-   **Gestión de Dependencias:** Maven

## Endpoints de la API

La API se expone en la ruta base `/api/productos`.

---

### Crear un nuevo producto

-   **Método:** `POST`
-   **URL:** `/api/productos`
-   **Descripción:** Permite registrar un nuevo producto en el catálogo.
-   **Request Body (Ejemplo):**
    ```json
    {
        "nombre": "Monitor Curvo 27 pulgadas",
        "descripcion": "Monitor para gaming y productividad",
        "precio": 950000.00,
        "stock": 30
    }
    ```
-   **Respuesta Exitosa (201 Created):**
    ```json
    {
        "id": 1,
        "nombre": "Monitor Curvo 27 pulgadas",
        "descripcion": "Monitor para gaming y productividad",
        "precio": 950000.00,
        "stock": 30
    }
    ```

---

### Obtener un producto por su ID

-   **Método:** `GET`
-   **URL:** `/api/productos/{id}`
-   **Descripción:** Devuelve los detalles de un producto específico.
-   **Respuesta Exitosa (200 OK):**
    ```json
    {
        "id": 1,
        "nombre": "Monitor Curvo 27 pulgadas",
        "descripcion": "Monitor para gaming y productividad",
        "precio": 950000.00,
        "stock": 30
    }
    ```

---

## Cómo Ejecutar el Proyecto

Siga los siguientes pasos para ejecutar el microservicio en un entorno local.

1.  **Pre-requisitos:**
    * Tener instalado Java 17 o superior.
    * Tener instalado Maven.
    * Tener una instancia de PostgreSQL corriendo.

2.  **Base de Datos:**
    * Cree una nueva base de datos en PostgreSQL llamada `productos_db`.
    * Configure las credenciales de acceso (usuario y contraseña) en el archivo `src/main/resources/application.properties`.

3.  **Ejecución:**
    * Clone este repositorio.
    * Abra una terminal en la raíz del proyecto.
    * Ejecute el siguiente comando Maven:
        ```bash
        mvn spring-boot:run
        ```
    * La aplicación se iniciará y estará escuchando en el puerto `8081` por defecto.

## Autor

-   [CIPALOSINGENIEROS]
