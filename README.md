# Employee REST API - SpringBoot and MySQL

This is a project to manage employees, it uses SpringBoot, Hibernate and MySQL.
It consist of a collection of routes that can perform the basics CRUD operations. 

HTTP Methods:
* GET
* POST
* PUT
* DELETE

The response is automatically converted to JSON using Jackson's Project.
It also follows the [REST API Naming Conventions](https://restfulapi.net/resource-naming/)

<br />
This project is for purely academic purposes.

### Routes

*  **GET**         /api/employee                   <br>
*  **GET**         /api/employee/{employeeId}      <br>
*  **POST**        /api/employee                   <br>
*  **DELETE**      /api/employee/{employeeId}      <br>
*  **PUT**         /api/employee/{employeeId}      <br>


### MySQL Database

This project uses MySQL Database, the connection driver is already included in the pom.xml.
Also the script used to generate the Database Schema and the Table can be found in "./sql-script"

### Business Requirement
![Business Requirement](./requirements/api_requirements.png?raw=true "App Diagram")
### Built With

* [MySQL DB](https://www.mysql.com/products/community/) - 8.0.17
* [Java](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) - 11
* [Hibernate ORM](http://hibernate.org/orm/) - 5.3.10.Final
* [SpringBoot](https://spring.io/) - 2.1.7.RELEASE
* [Jackson's Project](https://github.com/FasterXML/jackson) - 2.9.9