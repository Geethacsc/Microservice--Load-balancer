package com.microservice.employee.service.impl;

import java.util.Optional;

import com.microservice.employee.client.AddressClient;
import com.microservice.employee.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

import com.microservice.employee.dao.EmployeeRepo;
import com.microservice.employee.entity.Employee;
import com.microservice.employee.response.EmployeeResponse;
import com.microservice.employee.service.EmployeeService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/*
REST API CALL USING:
RESTTemplate
Web Client/Web Flux
Feign Client- Netflix
 */
@Component
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private ModelMapper mapper;

	//@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient webClient;

//	@Value("${microservice.address.base.url}")
//	private String addressBaseUrl;

	@Autowired
	private AddressClient addressClient;

	public EmployeeServiceImp(@Value("${microservice.address.base.url}") String addressBaseUrl,RestTemplateBuilder builder) {
		this.restTemplate = builder.rootUri(addressBaseUrl).build();
	}


	public EmployeeResponse getEmployeeDetails(int id) {
		Optional<Employee> employee = repo.findById(id);
		return mapper.map(employee, EmployeeResponse.class);
	}

	@Override
	public EmployeeResponse getEmployeeDetailsUsingRestTemplate(int id) {
		System.out.println("REST API Call to Address Service Using RESTTemplate");
		EmployeeResponse employeeResponse=getEmployeeDetails(id);
		AddressResponse address= restTemplate.getForObject("/getAddress/{id}",AddressResponse.class,id);
		employeeResponse.setAddress(address);
		return employeeResponse;
	}

	@Override
	public EmployeeResponse getEmployeeDetailsUsingWebClient(int id) {
		EmployeeResponse employeeResponse=getEmployeeDetails(id);
//		Mono<AddressResponse> monoResponse=webClient.get().uri("getAddress/{id}").retrieve().bodyToMono(AddressResponse.class);
//		AddressResponse address= monoResponse.block();
		AddressResponse address=webClient.get().uri("/getAddress/"+id).retrieve().bodyToMono(AddressResponse.class).block();
		employeeResponse.setAddress(address);
		return employeeResponse;
	}

	@Override
	public EmployeeResponse getEmployeeDetailsUsingOpenFeign(int id) {
		EmployeeResponse employee=getEmployeeDetails(id);
		AddressResponse address=addressClient.getAddressByEmployeeId(id).getBody();
		employee.setAddress(address);
		return employee;
	}
}
