# API de Tareas con Spring Boot 🧠

Este es un proyecto básico que implementa una **API RESTful** usando **Spring Boot**, **Java 21**, **Spring Data JPA** y base de datos en memoria **H2**.

## 🎯 Funcionalidades

- ✅ Listar todas las tareas (`GET /tasks`)
- ✅ Crear nuevas tareas (`POST /tasks`)
- ✅ Actualizar tareas existentes (`PUT /tasks/{id}`)
- ✅ Eliminar tareas (`DELETE /tasks/{id}`)
- ❗ Manejo de errores estructurado y personalizado

## 🛠 Tecnologías usadas

- Java 21
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database (en memoria)
- Maven

## 🚀 Cómo ejecutar el proyecto

1. Clona este repositorio:
   ```bash
   git clone https://github.com/jmanuelvs/task-api.git
2. Ejecuta la aplicacion:
   ```bash
   ./mvnw spring-boot:run
3. Accede a la API en:
    ```bash
    http://localhost:8080/tasks
4. Puedes acceder a la consola H2 en:
    ```bash
    http://localhost:8080/h2-console
    JDBC URL: jdbc:h2:mem:taskdb

## Endpionts disponibles

| METODO  | ENDPOINT  | Descripcion |
|--------------|--------------|--------------|
| GET | /tasks | Lista todas las tareas |
| POST | /tasks | Crea una nueva tarea |
| GET | /tasks/{id} | Obtener una tarea por ID |
| PUT | /tasks/{id} | Actualiza una tarea |

✍️ Autor
Juan Manuel Vázquez Santiago
