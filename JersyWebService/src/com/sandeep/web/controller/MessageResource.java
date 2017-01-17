package com.sandeep.web.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/messagenew")
public class MessageResource {

	@GET
	@Path("/{message}")
	public String  getMessageCognizant(){
		return "Cognizant";
	}
	
	@POST
	@Path("/uc")
	public String  getMessageCognizantUC(){
		return "Cognizant".toUpperCase();
	}
	
	
}
