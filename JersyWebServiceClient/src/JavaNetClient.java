import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public class JavaNetClient {

	public static void main(String[] args) throws IOException, JAXBException {

		URL url = new URL("http://localhost:8080/JersyWebService/rest/employee/addEmployee");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/xml");

		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());

		StringWriter sw = JAXBToXmlObjects();
		String xmlString = sw.toString();
		wr.write(xmlString.getBytes());
		
		wr.flush();
		wr.close();

		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
		conn.disconnect();

	}

	private static StringWriter JAXBToXmlObjects() throws JAXBException, PropertyException {
		JAXBContext contextObj = JAXBContext.newInstance(Employee.class);

		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		Employee employee = new Employee("Deep", "1111", 50000);
		StringWriter sw = new StringWriter();
		marshallerObj.marshal(employee, sw);
		return sw;
	}
}
