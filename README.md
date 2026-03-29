Here’s a simple `README.md` you can use for your Spring Boot clinic management project:

````markdown
# Gestions des Consultations Cliniques

Simple Spring Boot application for managing patients and consultations in a clinic.

## Features

- CRUD operations for **Patients**:
  - Add, edit, delete, view details
- CRUD operations for **Consultations**:
  - Add, edit, delete, list
- Simple and clean **Thymeleaf UI**
- Form validation for patient and consultation data
- Uses **MySQL** as database

## Technologies

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- Thymeleaf
- MySQL
- Maven
- Lombok

## Setup

1. Clone the repository:

```bash
git clone git@github.com:tarikharda-enset/gestions_des_consultations_cliniques.git
````

2. Configure `application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/consultation_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. Run the application:

```bash
mvn spring-boot:run
```

4. Open in your browser:

```
http://localhost:8080/patients
http://localhost:8080/consultations
```

## Author

Tarik Harda – [tarikharda@etu.enset-media.ac.ma](mailto:tarikharda@etu.enset-media.ac.ma)
