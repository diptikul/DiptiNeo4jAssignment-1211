package com.neo4j.assignment;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;


public interface EmployeeRepository extends Neo4jRepository<Employee, Integer> {

	Employee findByName(String name);

	Employee findById(Id id);

}
