package com.microservice.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.employee.entity.Employee;

//@Repository In spring boot there is no need to mention @Repository in Jparepository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
