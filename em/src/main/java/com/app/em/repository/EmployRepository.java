package com.app.em.repository;

import com.app.em.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface EmployRepository extends MongoRepository<Employee, String> {

}
