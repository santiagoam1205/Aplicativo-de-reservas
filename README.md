
# Sistema de Reservas API

## Descripción

Sistema de reservas desarrollado con Java y Spring Boot. Permite gestionar usuarios, espacios y reservas mediante una API REST.

El proyecto implementa operaciones CRUD y validaciones para evitar conflictos de horarios en las reservas.

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Maven
- API REST
- Insomnia
- HashMap para almacenamiento temporal en memoria

## Funcionalidades

### Usuarios
- Registrar usuarios.
- Consultar usuarios.
- Buscar usuarios por ID y nombre.
- Actualizar usuarios.
- Eliminar usuarios.

### Espacios
- Registrar espacios.
- Consultar espacios.
- Buscar espacios por nombre.
- Consultar espacios disponibles.
- Actualizar y eliminar espacios.

### Reservas
- Registrar reservas.
- Consultar reservas.
- Buscar reservas por usuario o espacio.
- Actualizar reservas.
- Cancelar y eliminar reservas.
- Validar conflictos de horarios.

## Ejecución del proyecto

1. Clonar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Configurar Java 17.
4. Recargar las dependencias de Maven.
5. Ejecutar `DemoApplication.java`.

La API estará disponible en:

`http://localhost:8080`

## Pruebas

La colección de Insomnia se encuentra en:

`docs/Sistema-Reservas-Insomnia.json`

Importar el archivo desde Insomnia para probar los endpoints.

## Almacenamiento

El proyecto utiliza HashMap en memoria. Por esta razón, los datos registrados se pierden cuando se reinicia la aplicación.

## Autor

Santiago Alvarado Mejía     
