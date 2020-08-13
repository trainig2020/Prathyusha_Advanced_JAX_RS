package org.demo.rest;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secured")
public class SecureResource {
	
	 @GET
	 @Path("message")
     @Produces(MediaType.TEXT_PLAIN)
     public String securedMethod() {
	    return "This API is secured" ;
     }

}