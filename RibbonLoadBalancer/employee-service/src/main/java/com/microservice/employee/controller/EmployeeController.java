package com.microservice.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.employee.response.EmployeeResponse;
import com.microservice.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	//REST API call to Address service using RESTTemplate
	@GetMapping("rest-template/get-employee/{Employee_id}")
	public ResponseEntity<EmployeeResponse> getEmployee1(@PathVariable("Employee_id") int id) {
		//return new ResponseEntity<EmployeeResponse>(service.getEmployeeDetails(id), HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(service.getEmployeeDetailsUsingRestTemplate(id));
	}

	//REST API call to Address Service using WEB FLUX
	@GetMapping("web-client/get-employee/{Employee_id}")
	public ResponseEntity<EmployeeResponse> getEmployee2(@PathVariable("Employee_id") int id) {
		//return new ResponseEntity<EmployeeResponse>(service.getEmployeeDetails(id), HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(service.getEmployeeDetailsUsingWebClient(id));
	}

	@GetMapping("open-feign/get-employee/{Employee_id}")
	public ResponseEntity<EmployeeResponse> getEmployee3(@PathVariable("Employee_id") int id) {
		//return new ResponseEntity<EmployeeResponse>(service.getEmployeeDetails(id), HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(service.getEmployeeDetailsUsingOpenFeign(id));
	}

}
