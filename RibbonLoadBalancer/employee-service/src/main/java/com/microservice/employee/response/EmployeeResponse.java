package com.microservice.employee.response;

public class EmployeeResponse {

	private int id;

	private String name;

	private String doj;

	private double ctc;

	private AddressResponse address;

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

	public AddressResponse getAddress() {
		return address;
	}

	public void setAddress(AddressResponse address) {
		this.address = address;
	}

}
