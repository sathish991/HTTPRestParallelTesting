package jerseyClient;

import javax.ws.rs.core.MediaType;

/**
 * @author Sathishkanna.s
 */

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class JerseyClientCall {

	String httpusername = "premseth";
	String httppassword = "Prem@123";

	private Client client = null;

	private Client jerseyclient() {
		if (client == null) {
			client = Client.create();
			client.addFilter(new HTTPBasicAuthFilter(httpusername, httppassword));
		}
		return client;
	}

	public ClientResponse jerseypostresponse(String applink, String requestType, String requestmethod,Object clazzname) {
		Client requestclient = jerseyclient();
		WebResource webResource = requestclient.resource(applink);
		ClientResponse response = null;
		if (requestType.contains(RequestType.HTTP.toString())) {
			response = webResource.accept("text/html").get(ClientResponse.class);
		} else {
			switch (requestmethod) {
			case "POST":
				ClientResponse postresponse = webResource.type(MediaType.APPLICATION_JSON).accept("application/json")
						.post(ClientResponse.class, clazzname);
				response = postresponse;
				break;
			case "GET":
				ClientResponse getresponse = webResource.type(MediaType.APPLICATION_JSON).accept("application/json")
						.get(ClientResponse.class);
				response = getresponse;
				break;
			case "PUT":
				ClientResponse putresponse = webResource.type(MediaType.APPLICATION_JSON).accept("application/json")
						.put(ClientResponse.class, clazzname);
				response = putresponse;
				break;
			case "DELETE":
				ClientResponse deleteresponse = webResource.type(MediaType.APPLICATION_JSON).accept("application/json")
						.delete(ClientResponse.class, clazzname);
				response = deleteresponse;
				break;
			default:
				System.out.println("not a valid option");
				break;
			}			
		}
		return response;
	}
	
	
	private enum RequestType {
		POST, PUT, GET, DELETE,HTTP,REST
	}
}
