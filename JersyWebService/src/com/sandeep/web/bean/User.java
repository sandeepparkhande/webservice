package com.sandeep.web.bean;

import javax.ws.rs.FormParam;

public class User {

	@FormParam("name") 
	private String name;
	@FormParam("age")
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
