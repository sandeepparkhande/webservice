import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientGet {

  public static void main(String[] args) {

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/JersyWebService/rest/employee/370941");
		ClientResponse responseXML = webResource.accept("application/xml").get(ClientResponse.class);
		ClientResponse responseJSON = webResource.accept("application/json").get(ClientResponse.class);
		String outputXML = responseXML.getEntity(String.class);
		String outputJSON = responseJSON.getEntity(String.class);
		
		System.out.println("Jersy Client : Output from Server .... \n");
		System.out.println("**XML** ");
		System.out.println(outputXML);

		System.out.println("**JSON**");
		System.out.println(outputJSON);
	}
}