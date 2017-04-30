package com.sandeep.web.controller;

import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldResource {

	
	
	@GET
	@Produces("text/plain")
	public String getHelloSandeepMsg() {
		String message = "Hello Sandeep : ";
		return message;
	}
	

	
	@GET
	@Path("/{message}")
	public Response getMsg(@PathParam("message") String msg) {
		String output = " GET  Message : " + msg;
		return Response.status(200).entity(output).build();

	}


	@GET
	@Path("/{message}/{mobile}")
	public Response getMsg(@PathParam("message") String msg,@PathParam("mobile") String mobile) {
		String output = " GET  Message : " + msg +" Sent to Mobile "+mobile;
		return Response.status(200).entity(output).build();
	}
	
	
	
	@GET
	@Path("/queryparam")
	public Response getMsgQueryParam(@DefaultValue("Cognizant") @QueryParam("message") String msg,@QueryParam("message2") String msg2,
			@HeaderParam("Accept-Language") String lang, @CookieParam("JSESSIONID") String sessionid) {
		String output = " GET  Message : " + msg + " Accept Langauge Header " + lang + " Cookie Param " + sessionid;
		return Response.status(200).entity(output).build();

	}

}