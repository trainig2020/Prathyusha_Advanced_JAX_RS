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
	   
	   Message newMessage = new Message(4,"My New Message for JAX-RS Client", "Prathyusha");
	   Response postResponse = messagesTarget
	       .request()
	       .post(Entity.json(newMessage));
	   if(postResponse.getStatus() != 201) {
		   System.out.println("Error");
	   }
	   Message createMessage = postResponse.readEntity(Message.class);
	   
	   System.out.println(createMessage.getMessage());
	   
	 
	  
		
	}
}
