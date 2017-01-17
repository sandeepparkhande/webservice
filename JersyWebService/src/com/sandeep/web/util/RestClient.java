/*package com.sandeep.web.util;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RestClient {

	public static void main(String[] args) throws URISyntaxException {
		
		Client client = ClientBuilder.newClient();
		URI uri=new URI("http://localhost:8080/JersyWebService/rest/employee");
		WebTarget target= client.target(uri);
		System.out.println(" URL "+target.getUri());
		Response employee=target.request().get();
		System.out.println(" Employee "+employee.toString());
	}
}
*/