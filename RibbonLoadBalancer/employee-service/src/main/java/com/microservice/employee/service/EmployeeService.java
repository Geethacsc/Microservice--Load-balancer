package com.microservice.employee.service;

import org.springframework.stereotype.Service;

import com.microservice.employee.response.EmployeeResponse;

@Service
public interface EmployeeService {

	EmployeeResponse getEmployeeDetailsUsingRestTemplate(int id);

	EmployeeResponse getEmployeeDetailsUsingWebClient(int id);

	EmployeeResponse getEmployeeDetailsUsingOpenFeign(int id);

}
