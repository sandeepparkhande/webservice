package com.sandeep.web.controller;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


// http://localhost:8080/JersyWebService/rest/stock/IBM

@Path("/stock")
public class StockResource {

	
	@GET
	@Path("/{stockName}")
	public String stockValue(@PathParam("stockName") String stockNm){
		System.out.println(" Reuqest for Stock Web Service");
		System.out.println(" Stock Name "+stockNm);
		// DB
		//Business
		
		return "$12.5";
	}
}
