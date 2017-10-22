package mystuff;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.*;
import java.net.*;
import java.util.*;

@Path("/customers")
public class CustomerResource {
	
   Map<Integer, String> customers = new HashMap<Integer, String>();
   {
	   customers.put(1, "A Unmodified Inc.");
   }

   @GET
   public String getAllCustomers() {
   	   System.out.println("GET /customers");
	   return "here are all " + customers.size() + " customers:" + customers;
   }

   @GET
   @Path("{id}")
   public String getCustomer(@PathParam("id") int id) {
	  System.out.println("GET /customers/" + id);
	  return "here is one customer with id " + id + ": " + customers.get(id);
   }

   @POST
   @Consumes("application/xml")
   public Response createCustomer(String sRequest) {
	  System.out.println("POST /customers");
	  
	  String newCustomer = "" + (char)(customers.size() + 65) + " Unmodified Inc.";
	  customers.put(customers.size() + 1, newCustomer);
	  
      return Response.created(URI.create("/customers/" + customers.size())).build();
   }
   
   @PUT
   @Path("{id}")
   @Consumes("application/xml")
   // make this a void before production
   // this is coded this way so that you can interact easier with it
   public String updateCustomer(@PathParam("id") int id, InputStream is) {
	  System.out.println("PUT /customers/" + id);
	  try {
		  String sCustomer = customers.get(id);
		  String updatedCustomer = "" + sCustomer.charAt(0) + " " + "Updated Inc.";
		  customers.put(id, updatedCustomer);
		  return "updated customer with id " + id;
	  }
	  catch (Exception exc) {  // ideally catch NullPointerException
		  System.out.println(exc);
		  throw new WebApplicationException(Response.Status.NOT_FOUND);
	  }
   }
}
