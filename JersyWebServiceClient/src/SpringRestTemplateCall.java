import org.springframework.web.client.RestTemplate;

public class SpringRestTemplateCall {

	public static void main(String[] args) {
		   final String uri = "http://localhost:8080/JersyWebService/rest/hello/RESTWebService";     
		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		    System.out.println("Response Recieved from Spring Web Service "+result);
		}
}
