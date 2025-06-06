# API de Tareas con Spring Boot 🧠

Este es un proyecto básico que implementa una **API RESTful** usando **Spring Boot**, **Java 21**, **Spring Data JPA** y base de datos en memoria **H2**.

## 🎯 Funcionalidades

- ✅ Listar todas las tareas (`GET /tasks`)
- ✅ Crear nuevas tareas (`POST /tasks`)
- ✅ Obtener tarea por ID (`GET /tasks/{id}`)
- ✅ Actualizar tareas existentes (`PUT /tasks/{id}`)
- ✅ Eliminar tareas (`DELETE /tasks/{id}`)
- ✅ Filtros por estado (`GET /tasks?status=PENDIENTE`)
- ✅ Validación automática con `@Valid`
- ✅ Documentación con Swagger UI
- ✅ Manejo de errores estructurado

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
5. Documentacion interactiva:
   ```bash
   http://localhost:8080/swagger-ui/index.html

## Endpionts disponibles

| METODO  | ENDPOINT  | Descripcion |
|--------------|--------------|--------------|
| GET | /tasks | Lista todas las tareas |
| GET | /tasks/{id} | Obtiene una tarea por ID |
| POST | /tasks | Crea una nueva tarea |
| PUT | /tasks/{id} | Actualiza una tarea |
| DELETE | /tasks/{id} | Eliminar una tarea |
| GET | /tasks/completes | Tareas completadas |
| GET | /tasks/incomplete | Tareas incompletas |

🙌 Créditos
Proyecto desarrollado por Juan Manuel Vazquez Santiago como parte de mi aprendizaje en desarrollo backend en Java.
