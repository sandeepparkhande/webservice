package com.sandeep.web.bean;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement
public class Employee {
	private String employeeName;
	private String employeeId;
	private int salary;
    private String link;
        
	public Employee() {
	}

	public String getEmployeeName() {
		return employeeName;
	}

	@XmlElement
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	@XmlElement
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public int getSalary() {
		return salary;
	}

	@XmlElement
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee(String employeeName, String employeeId, int salary) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId=" + employeeId + ", salary=" + salary + "]";
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Employee(String employeeName, String employeeId, int salary, String link) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.salary = salary;
		this.link = link;
	}

}

