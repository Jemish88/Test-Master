# TestMaster - Spring Boot Testing Demo

## Overview

This project demonstrates the use of various testing techniques in a Spring Boot application. It focuses on unit testing, integration testing, and in-memory testing using JUnit and Mockito.

## Technologies and Components

### 1. JUnit

- **Overview**: JUnit is a popular testing framework for Java that allows you to write and run tests.
- **Usage**: It provides annotations like `@Test`, `@BeforeEach`, and `@AfterEach` to define test methods and lifecycle hooks.
- **Example**:
  ```java
  @Test
  void testMethod() {
      // Test logic here
  }

### 2. Mockito

- **Overview**: Mockito is a mocking framework that allows you to create mock objects for your tests. It is commonly used to isolate the component being tested.
- **Usage**: You can use annotations like `@Mock` to create mock instances and `@InjectMocks` to inject them into the class under test.
- **Key Methods**:
  - `when(...)`: Specifies the behavior of a mock object.
  - `verify(...)`: Checks if a method was called on a mock.
- **Example**:
  ```java
  @Mock
  private TaskService taskService;

  @Test
  void testServiceMethod() {
      when(taskService.getTaskById(1L)).thenReturn(new Task());
      // Assertions here
  }

### 3. In-Memory Testing with H2

- **Overview**: In-memory testing uses an in-memory database (like H2) to run integration tests without needing a real database. It is useful for testing data access layers.
- **Usage**: Configure H2 in the application properties for testing. Spring Boot will automatically use this configuration during tests.
- **Example Configuration**:
  ```properties
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=password
  spring.jpa.hibernate.ddl-auto=create-drop

### Testing Strategies

- **Unit Testing**: Focus on testing individual methods or components, typically using Mockito to mock dependencies.
- **Integration Testing**: Tests multiple components together, using a real or in-memory database to validate interactions.
- **End-to-End Testing**: Tests the complete flow of the application, including controllers and services.


### Conclusion

This project serves as a practical guide to understanding how to implement and utilize JUnit, Mockito, and in-memory testing with Spring Boot. These tools help ensure code quality and reliability through effective testing strategies.

