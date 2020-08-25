# customer_backend
kotlin + springboot exercise project


### Scenario

We are working on a web application and it's time to create a backend service for processing customer related information.

### Requirements

1. It interacts with other services via REST service endpoints (not done)
2. It can add a new customer (fields: account number, name, address, username, password) (done)
3. It can delete an existing customer (done)
4. It can update info of an existing customer (done)
5. It can retrieve an existing customer (done)
6. It can do search on customer records to provide autocompletion facility to the UI (not done)

### Other requirements
* Application should be functional together with any unit tests (not done)
* Implement some form of application security (not done)




# Read Me First
The following was discovered as part of building this project:

* The JVM level was changed from '14' to '11', review the [JDK Version Range](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions#jdk-version-range) on the wiki for more details.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)


# Problem

* @AfterThrowing advice not executing when ConstraintViolationException is caught while updating customer record in PUT request.
