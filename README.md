
This project demonstrates how to use Spring Boot with Spring Data JPA and a PostgreSQL database.

# Project Flow Explanation

# `Student` Entity
* Marked with `@Entity` → makes it a JPA entity so it maps to a database table (`student`).
* Fields: `rollno` (Primary Key), `name`, and `marks`.
* Annotated with `@Component` and `@Scope("prototype")`, so each time we call `context.getBean(Student.class)`, a new Student object is created.
*  `toString()` method for printing details.

# `StudentRepo` (Repository Layer)

* Extends `JpaRepository<Student, Integer>` → gives us built-in CRUD methods like `save()`, `findById()`, `delete()`, etc.
* Custom Query defined using `@Query`:

  ```java
  List<Student> findByName(String name);
  ```
  This fetches all students with a given name.

# `SpringDataJpaDemoApplication` (Main Class)

* Starts the Spring Boot application and gets beans from the ApplicationContext.
* Creates three Student objects (`s1`, `s2`, `s3`).
* Sets rollno, name, and marks for each student.
* Saves `s2` and `s3` into the database using `repo.save()`.
* Tries to fetch `s1` from the database using `repo.findById(25)`.

  * If not found, it prints a new empty Student object.
* Uses `repo.findByName("Rup")` to fetch students with the name `"Rup"`.
* Updates `s1` with new details (`Zaheer`) and calls `repo.save(s1)` → this updates or inserts the student with rollno `25`.
* Finally, deletes `s1` using `repo.delete(s1)`.

# `application.properties` (Database Configuration)
* Connects the application to PostgreSQL:

  * Database URL → `jdbc:postgresql://localhost:5432/ecommerce`
  * Username & Password → your PostgreSQL credentials
  * Driver class → `org.postgresql.Driver`
* Hibernate properties:

  * `spring.jpa.hibernate.ddl-auto=update` → automatically creates/updates tables based on entity.
  * `spring.jpa.show-sql=true` → shows SQL queries in the console.

# outputs:-

# Actual Data
<img width="521" height="367" alt="image" src="https://github.com/user-attachments/assets/d16bdcfd-f34c-41d2-a970-defb26ed4dcf" />
# Data after updating
<img width="509" height="356" alt="image" src="https://github.com/user-attachments/assets/e866f0b7-640b-4e9c-9ee4-46dfffb7a665" />
# Data after deleting
<img width="507" height="280" alt="image" src="https://github.com/user-attachments/assets/935c4c45-96f9-43ae-9ed1-c59f42aa86e7" />

