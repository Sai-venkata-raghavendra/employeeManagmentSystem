package com.infosys.project.infosysdemo.vo;

import java.io.Serializable;

public class UpdateEmployeeInputVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String email;

	private String department;

	private double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public UpdateEmployeeInputVO( String name, String email, String department, double salary) {
		super();
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}

	public UpdateEmployeeInputVO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
