# Tienda Backend (E-commerce API)

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Jakarta EE](https://img.shields.io/badge/Jakarta%20EE-11-blue.svg)
![WildFly](https://img.shields.io/badge/WildFly-Server-red.svg)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-yellow.svg)

Backend for an E-commerce (Tienda) application built with **Java 21** and **Jakarta EE 11**, designed to be deployed on a **WildFly** application server. It provides a robust and secure RESTful API for managing e-commerce operations, utilizing modern enterprise Java standards.

## 🚀 Key Features

* **RESTful API**: Standardized endpoints for application operations.
* **JWT Authentication**: Secure endpoints using JSON Web Tokens (JJWT).
* **Robust Data Access**: Utilizes Jakarta Data and Hibernate ORM for efficient database interactions.
* **DTO Mapping**: Clean separation of data layers using MapStruct to map between Entities and DTOs.
* **Enterprise Architecture**: Scalable, maintainable multi-layered N-Tier architecture.

## 🛠️ Technology Stack & Frameworks

* **Language**: Java 21
* **Core Framework**: Jakarta EE 11 (JAX-RS, CDI, EJB)
* **Application Server**: WildFly (JBoss)
* **ORM & Persistence**: Hibernate ORM 6.6, Jakarta Data API 1.0.1
* **Mapping**: MapStruct (Entity to DTO conversion)
* **Boilerplate Reduction**: Lombok
* **Security**: JJWT (Java JWT)
* **Build Tool**: Maven

## 🏗️ Architecture & Project Structure

The project follows a **Multi-layered (N-Tier) Architecture** to ensure separation of concerns, maintainability, and scalability. It is divided primarily into two main modules: `ejb` (Enterprise JavaBeans for business logic and data access) and `apirest` (for the presentation/web layer).

```
src/main/java/org/utp/web/back
├── apirest/                   # API / Presentation Layer
│   ├── config/                # REST application configuration (JAX-RS Application)
│   ├── controllers/           # REST endpoints / Controllers
│   ├── exceptions/            # Global exception handling and mappers
│   ├── models/                # Request/Response models
│   │   ├── dto/               # Data Transfer Objects (DTOs)
│   │   └── mappers/           # MapStruct interfaces for Entity <-> DTO
│   ├── security/              # JWT Authentication and Authorization filters
│   ├── services/              # REST-specific service orchestrators
│   └── util/                  # API Utilities
└── ejb/                       # Business Logic & Data Access Layer
    ├── config/                # EJB/JPA configurations
    ├── entities/              # JPA Domain Entities
    │   └── enums/             # Enums used in Entities
    ├── repositories/          # Data Access Layer (Jakarta Data Repositories)
    └── services/              # Business Logic Services (Enterprise Beans)
```

## 📐 Design Patterns Implemented

* **Repository Pattern**: Centralizes data access logic and abstracts the database interactions using the `jakarta.data` API.
* **Data Transfer Object (DTO)**: Used to pass data with multiple attributes in one shot from client to server, avoiding exposing domain entities directly.
* **Mapper Pattern (MapStruct)**: Automates the translation between Domain Entities and DTOs.
* **Dependency Injection (CDI)**: Manages object lifecycles and dependencies (Inversion of Control) throughout the application layers.
* **Facade / Controller Pattern**: REST endpoints act as a facade, receiving HTTP requests and delegating business logic to the underlying EJB services.
* **Singleton / Stateless Services**: EJB services are designed to be stateless (`@Stateless`), providing thread-safe and scalable business logic execution.

## ⚙️ How to Run

1. **Prerequisites**:
   * Java 21 JDK installed
   * Maven installed
   * WildFly Application Server configured and running
   * Database configured (refer to `base_datos.sql` for the schema)

2. **Build and Deploy**:
   Use the WildFly Maven plugin to easily deploy the application:
   ```bash
   mvn clean package wildfly:deploy
   ```

## 🗄️ Database

The project includes initialization scripts and mock data:
* `base_datos.sql`: Contains the database schema.
* `pedido.csv`, `pedido_det.csv`: Sample data.