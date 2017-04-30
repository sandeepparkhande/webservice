package com.sandeep.web.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.sandeep.web.bean.Bank;
import com.sandeep.web.bean.Employee;
import com.sandeep.web.bean.Error;
import com.sun.jersey.api.ConflictException;
import com.sun.jersey.api.NotFoundException;

@Path("/employee")
public class EmployeeResource {

	@Context UriInfo uriInfo;
	
	static HashMap<String, Employee> employeeMap = new HashMap<String, Employee>();
	static HashMap<String, Bank> bankMap = new HashMap<String, Bank>();

	static {
		employeeMap.put("370941", new Employee("Sandeep", "370941", 9999));
		employeeMap.put("371124", new Employee("Aayush", "371124", 8000));
		employeeMap.put("281125", new Employee("Sameer", "281125", 7000));
	}
	static {
		bankMap.put("370941", new Bank("370941", "Sandeep","ICICI","1111"));
		bankMap.put("371124", new Bank("371124", "Aayush", "HDFC","5555"));
		bankMap.put("281125", new Bank("281125","Sameer","BARCLAYS", "7777"));

	}

	@GET
	@Produces({"application/xml,application/json"})
	public Employee getEmployee() {
		Employee employee = new Employee("Sandeep", "370941", 9999);
		return employee;
	}

	@GET
	@Path("/{employeeId}")
	@Produces({ MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getEmployeeById(@PathParam("employeeId") String employeeId) {
		Employee employee = employeeMap.get(employeeId);
		/*if (employee==null) {
		// throw new WebApplicationException(Response.Status.NOT_FOUND);
		  throw new ConflictException();
		}*/ 
		
		if (employee==null) {
		return Response.status(200).entity(new Error("200","Employee Not Found", "Send your queries to hr@cognizant.com")).build();
		}
			
		return Response.status(200).entity(employee).build();
	}
	
	@GET
	@Path("/banks/{employeeId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Bank getEmployeeBanks(@PathParam("employeeId") String employeeId) {
		Employee employee = employeeMap.get(employeeId);
		Bank bank=bankMap.get(employee.getEmployeeId());
		return bank;
	}


	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getEmployees() throws Exception {
		 Set<String> employeeKeySet=employeeMap.keySet();
		for (String employeeKey:employeeKeySet) {
			Employee employeeRecord=employeeMap.get(employeeKey);
			employeeRecord.setLink(returnHATEOSLink(employeeRecord));
		}
		return Response.status(200).entity(employeeMap).build();
	}

	@POST
	@Path("/addEmployee")
	@Consumes({MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addEmployee(Employee employee) throws Exception{
		employeeMap.put(employee.getEmployeeId(), employee);
		System.out.println("Employee is successfully added"+employeeMap.toString());
		return getEmployees();
	}
	
	@DELETE
	@Path("/deleteEmployee")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteEmployee(Employee employee) throws Exception{
		System.out.println(" Removed Employee "+employee);
		employeeMap.remove(employee.getEmployeeId());
		System.out.println("Employee is successfully removed"+employeeMap.toString());
		return getEmployees();
	}
	
	@PUT
	@Path("/updateEmployee")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response putEmployee(Employee employee) throws Exception{
		System.out.println(" Updated  Employee "+employee);
		employeeMap.put(employee.getEmployeeId(), employee);
		System.out.println("Employee is successfully Updated"+employeeMap.toString());
		return getEmployees();
	}
	
	
	public String returnHATEOSLink(Employee employee) throws Exception{
		UriBuilder ub = uriInfo.getBaseUriBuilder();
		ub.path("employee");
		ub.path("banks");
		URI userUri = ub.path(employee.getEmployeeId()).build();
		return userUri.toURL().toString();
	}
	
}