package com.xenosgrilda.springbootemployeerest.dao;

import com.xenosgrilda.springbootemployeerest.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
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