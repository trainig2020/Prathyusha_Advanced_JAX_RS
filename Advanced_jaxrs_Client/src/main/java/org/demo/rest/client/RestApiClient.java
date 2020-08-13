package org.demo.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.demo.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
	  Client client = ClientBuilder.newClient();
	  
	  WebTarget baseTarget = client.target("http://localhost:8085/Advanced_jaxrs_Client/webapi/");
	  WebTarget messagesTarget = baseTarget.path("messages");
	  WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
	  
	  Message  message1 = singleMessageTarget
			    .resolveTemplate("messageId", "1")
			    .request(MediaType.APPLICATION_JSON)
			    .get(Message.class);
	 
	   
	   Message  message2 = singleMessageTarget
			    .resolveTemplate("messageId", "2")
			    .request(MediaType.APPLICATION_JSON)
			    .get(Message.class);
	   
	 
	            
	   
	   
	   System.out.println(message1.getMessage());
	   System.out.println(message2.getMessage());
	  
		/*
		 * Message message = client
		 * .target("http://localhost:8085/Advanced_jaxrs_Client/webapi/messages/2")
		 * .request(MediaType.APPLICATION_JSON) .get(Message.class); // Message message
		 * = response.readEntity(Message.class);
		 * System.out.println(message.getMessage());
		 */
	}
}
