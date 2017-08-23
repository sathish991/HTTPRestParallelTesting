package com.kgfsl.testclasses;

/**
 * @author Sathishkanna.s
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.sun.jersey.api.client.ClientResponse;
import jerseyClient.JerseyClientCall;
import static org.junit.Assert.assertEquals;

public class ArtrailTestLinks {
	
	String appusername;
	String apppassword;
			
	JerseyClientCall clientCall = null;
	String loginlink = "http://10.100.4.13/arm/login";//http://localhost:8080/collection-ui/BODFileUpload
	
	@Before
	public void initializeparameter() {
		clientCall = new JerseyClientCall();
	}

	@Test
	public void appLoginCheck() {
		ClientResponse response =clientCall.jerseypostresponse(loginlink,RequestType.HTTP.toString(),null,null);
		assertEquals(200, response.getStatus());
	}

	@Test
	public void appfileupload() {
	    int ClientsearchId=123;
		String bodupload = "http://10.100.4.13/arm/api/home/advancesearch/?id="+ClientsearchId+"&chosenTab=Client";
		ClientResponse response =clientCall.jerseypostresponse(bodupload,RequestType.REST.toString(),RequestType.GET.toString(),null);
		System.out.println(response.getEntity(String.class));
		assertEquals(200, response.getStatus());		
	}

	@After
	public void testcomplete() {
		System.out.println("Test Completes");
	}
	
	
	
	private enum RequestType {
		POST, PUT, GET, DELETE,HTTP,REST
	}
}
