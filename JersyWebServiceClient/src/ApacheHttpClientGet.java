import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;


public class ApacheHttpClientGet {

	public static void main(String[] args) throws ClientProtocolException, IOException {
	    HttpClient client = new DefaultHttpClient();
	    
		HttpGet getRequest = new HttpGet("http://localhost:8080/JersyWebService/rest/hello/RESTWebService");
		HttpResponse response = client.execute(getRequest);
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output;
		System.out.println(" Apache Http Client : Output from Service .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		
	}

}