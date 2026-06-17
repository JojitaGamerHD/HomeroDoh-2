# HomeroDoh API

![Titulo](Assets/TituloEmpresa.png)

API REST desarrollada con Spring Boot y MySQL para la gestión de cervezas y marcas.

El proyecto implementa arquitectura por capas, persistencia con JPA/Hibernate, autenticación JWT, documentación Swagger/OpenAPI, HATEOAS, variables de entorno, Docker Compose, pruebas unitarias y consumo de APIs externas mediante WebClient.

---

# Integrantes

* Johaquin Fernandez
* Joaquin Cardenas
* Danilo Navarro

---

# Descripción del Proyecto

HomeroDoh API es una aplicación backend desarrollada utilizando:

* Java 17
* Spring Boot 3
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* MySQL
* Docker
* Docker Compose
* Maven
* Lombok
* WebClient
* Swagger/OpenAPI

El sistema permite administrar:

* Cervezas
* Marcas

Además, incluye integración con una API externa para obtener frases aleatorias.

---

# Arquitectura del Proyecto

```txt
src/main/java/com/example/homerodoh
│
├── auth
├── controller
├── service
├── repository
├── model
├── dto
├── security
├── exception
└── config
```

---

# Tecnologías Utilizadas

| Tecnología      | Descripción                    |
| --------------- | ------------------------------ |
| Java 17         | Lenguaje principal             |
| Spring Boot     | Framework backend              |
| Spring Security | Seguridad de endpoints         |
| JWT             | Autenticación basada en tokens |
| Spring Data JPA | Persistencia                   |
| Hibernate       | ORM                            |
| MySQL           | Base de datos                  |
| Docker          | Contenedores                   |
| Docker Compose  | Orquestación                   |
| Swagger/OpenAPI | Documentación interactiva      |
| Lombok          | Reducción de código            |
| WebClient       | Consumo de APIs externas       |
| JUnit 5         | Pruebas unitarias              |
| Mockito         | Mocking para pruebas           |

---

# Seguridad JWT

La aplicación protege los endpoints mediante autenticación JWT.

## Login

```http
POST /auth/login
```

Ejemplo:

```json
{
  "username": "admin",
  "password": "admin123"
}
```

Respuesta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

Luego el token debe enviarse en:

```http
Authorization: Bearer TOKEN
```

---

# Swagger/OpenAPI

Documentación disponible en:

```txt
http://localhost:8080/swagger-ui/index.html
```

Permite:

* Generar JWT
* Autorizar peticiones
* Probar todos los endpoints

---

# HATEOAS

Se implementó HATEOAS para enriquecer las respuestas REST.

Ejemplo:

```json
{
  "id": 1,
  "nombre": "Duff",
  "_links": {
    "self": {
      "href": "/api/v1/cervezas/1"
    }
  }
}
```

---

# Variables de Entorno

Configuración mediante variables:

```env
DB_URL=jdbc:mysql://localhost:3306/homerodoh
DB_USER=root
DB_PASSWORD=
```

Configuradas desde:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

---

# Docker Compose

El proyecto incluye:

```txt
docker-compose.yml
Dockerfile
```

Servicios:

* MySQL 8
* API Spring Boot

Levantar proyecto:

```bash
docker compose up --build
```

---

# Endpoints Disponibles

## Autenticación

| Método | Endpoint    |
| ------ | ----------- |
| POST   | /auth/login |

---

## Cervezas

| Método | Endpoint              |
| ------ | --------------------- |
| GET    | /api/v1/cervezas      |
| GET    | /api/v1/cervezas/{id} |
| POST   | /api/v1/cervezas      |
| PUT    | /api/v1/cervezas/{id} |
| DELETE | /api/v1/cervezas/{id} |

---

## Marcas

| Método | Endpoint            |
| ------ | ------------------- |
| GET    | /api/v1/marcas      |
| GET    | /api/v1/marcas/{id} |
| POST   | /api/v1/marcas      |
| PUT    | /api/v1/marcas/{id} |
| DELETE | /api/v1/marcas/{id} |

---

# API Externa

Obtención de frases aleatorias:

```http
GET /api/v1/quotes/random
```

API utilizada:

```txt
https://dummyjson.com/quotes/random
```

---

# Pruebas Unitarias

Se implementaron pruebas utilizando:

* JUnit 5
* Mockito

Ejecutar:

```bash
mvn test
```

Resultado esperado:

```txt
Tests run: 5
Failures: 0
Errors: 0
BUILD SUCCESS
```

---

# Ejecución del Proyecto

## Clonar

```bash
git clone https://github.com/JojitaGamerHD/HomeroDoh2
```

## Compilar

```bash
mvn clean package
```

## Levantar Docker

```bash
docker compose up --build
```

## Abrir Swagger

```txt
http://localhost:8080/swagger-ui/index.html
```

---

# Características Implementadas

✅ CRUD completo

✅ Arquitectura por capas

✅ Spring Data JPA

✅ Hibernate

✅ Relaciones JPA

✅ DTO Pattern

✅ Validaciones JSR-380

✅ Manejo global de excepciones

✅ JWT Authentication

✅ Swagger/OpenAPI

✅ Docker Compose

✅ Variables de entorno

✅ HATEOAS

✅ Pruebas unitarias

✅ WebClient

✅ API externa

---

# Evaluación 3

Proyecto desarrollado para la Evaluación 3 de Desarrollo Fullstack.
