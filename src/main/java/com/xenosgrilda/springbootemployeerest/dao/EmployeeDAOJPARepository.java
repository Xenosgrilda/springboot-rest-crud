package com.xenosgrilda.springbootemployeerest.dao;

import com.xenosgrilda.springbootemployeerest.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// We can configure the endpoint exposed by that
@RepositoryRestResource(path = "members")
public interface EmployeeDAOJPARepository extends JpaRepository<Employee, Integer> {
}

/**
 * Just a recap, in first version we made use of Hibernate's implementation of JPA, after we made use of JPA standard
 * implementation, but you may have noticed that it was all very similar, just some methods change and how we're using
 * the EntityManager or Session. SpringBoot automatically creates the "EntityManagerFactory" for us, and whenever we
 * inject a "EntityManager" class in our application, it automatically injects it by"createEntityManager();"
 *
 * Ok, but even though, either for JPA Standard or Hibernate, we would basically do the same. We would specify our
 * "entity" type and our "id"
 *
 *     @Override
 *     public Employee find(int id) {
 *         return this.entityManager.find(Employee.class, id);
 *     }
 *
 * It would be great if we could have those basic methods for free right?
 * That's possible with the Spring Data JPA solution!
 * Our @Repository class just needs to implements the JpaRepository<Entity.class , primary key type>
 * Check the methods we can get:
 * https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
 *
 * For defining custom queries
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
 */

/**
 * ======== SPRING DATA REST ==========
 * Have you noticed that we don't have a EmployeeController anymore?
 *
 * Alright! We have our CRUD API going, we have used Spring Data so we could get the CRUD methods for free
 * in our DAO, using the "JpaRepository" interface!
 *
 * But wow, we had lots of work to implement this REST Controller:
 * - We needed to create our REST Controller and inject the Service
 * - We needed to create our Service Interface and Service Implementation
 * - We created our architecture Controller -> Service -> Repository(DAO) -> DB
 *
 * What if we could tell Spring to create our REST API using our JpaRepository giving us all those basic CRUD methods?
 * We can get that by using the  Spring Data REST! (https://spring.io/projects/spring-data-rest)
 *
 * Spring Data REST builds on top of Spring Data repositories, analyzes your application’s domain model and exposes
 * hypermedia-driven HTTP resources for aggregates contained in the model.
 *
 * Spring Data REST will expose these endpoints for free:
 * GET         /api/employee
 * GET         /api/employee/{employeeId}
 * POST        /api/employee
 * DELETE      /api/employee/{employeeId}
 * PUT         /api/employee/{employeeId}
 *
 * Spring Data REST will scan our project for JpaRepository and expose REST APIs for each entity of JpaRepository
 * The mapping work like this:
 * - It create endpoints based on entity type
 * - Simple pluralized form:
 * - - First character of Entity type is lowercase
 * - - Then just adds an "s" to the entity (e.g. Employee => /employees)
 *
 * To actually get all this we just need to:
 * - Add it to the pom.xml...
 *
 * Before we used to have:
 * - Controller -> Service -> Repository(DAO) -> DB
 *
 * After implementing Spring Data REST we will have:
 * Spring Data REST /employees -> Employee Repository -> DB
 *
 * One note, Spring Data REST endpoits are HATEOAS (Hypermedia as the Engine of Application State) compliant.
 * It's basically metadata for accessing our REST interface attached to our response.
 *
 * It also provide some cool features like:
 * - Pagination, sorting and searching
 * - Extending and adding custom queries with JPQL
 * - Query Domain Specific Language (Query DSL)
 *
 * Just a Recap, to get the Spring Data REST working we need:
 * - Entity class
 * - A class that implementing the JpaRepository
 * - dependency for spring-boot-starter-data-rest in our pom.xml
 *
 * To customize Spring Data REST go to application.properties
 */