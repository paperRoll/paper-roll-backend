package com.app.em.repository;

import com.app.em.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployRepository extends MongoRepository<Employee, String>{

}
