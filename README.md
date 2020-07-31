# Customer Management Application

This repository is for Customer Management Application. This application exposes REST services to access customer resource.

## Built With

* 	[Maven 3.3.3](https://maven.apache.org/) - Dependency Management
* 	[JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit
* 	[Spring Boot 2.3.1](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[H2](https://www.h2database.com/html/main.html) - The Java SQL in-memory database
* 	[Lombok](https://projectlombok.org/) - Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.
* 	[JUnit5](https://junit.org/junit5/) - A simple framework to write repeatable tests.
* 	[Swagger 2](https://swagger.io/) - Interactive API documentation

## Running The Application Locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.business.customermanagement.CustomerManagementApplication` class from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Note: Please make sure you have JDK 11 installed on your system as default runtime environment is set to Java 11. 
If you have any other version installed(should be higher than JDK 1.8), please make sure you change `java.version` property in pom.xml.

## Unit Testing

To verify every small change in the application, unit test cases have been written using JUnit5 and Mockito. You can run following command to run all test cases,

```shell
mvn test
```

## Swagger

Once application is running on port 8080, below swagger url can be used to access APIs,

[http://localhost:8080/api/v1/swagger-ui.html](http://localhost:8080/api/v1/swagger-ui.html)


