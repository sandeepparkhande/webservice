import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientGet {

  public static void main(String[] args) {

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/JersyWebService/rest/hello/RESTWebService");
		ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
		String output = response.getEntity(String.class);
		System.out.println("Jersy Client Output from Server .... \n");
		System.out.println(output);

	}
}