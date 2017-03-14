import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JavaNetClient {

	public static void main(String[] args) throws IOException {

				URL url = new URL("http://localhost:8080/JersyWebService/rest/hello/RESTWebService");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String output;
				System.out.println("Java Net : Output from Service .. \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

				conn.disconnect();

	}
}
