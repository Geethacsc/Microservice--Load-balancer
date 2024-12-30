package com.microservice.employee.entity;

import com.microservice.employee.response.AddressResponse;

import javax.persistence.*;

@Entity(name="myEmployee")
@Table(name="employee_details")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Emp_id")
	private int id;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "doj")
	private String doj;

	@Column(name = "ctc")
	private double ctc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public double getCtc() {
		return ctc;
	}

	public void setCtc(double ctc) {
		this.ctc = ctc;
	}

}
