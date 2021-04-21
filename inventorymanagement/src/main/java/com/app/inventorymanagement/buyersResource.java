package com.app.inventorymanagement;

import java.util.List;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import controller.buyerRepository;
import model.buyer;



@Path("Buyer")
public class buyersResource
{

	buyerRepository repo = new buyerRepository();
	
	//get all item
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<buyer> getItems() 
	{
		return repo.getbuyers();
	}
	
	@POST
	@Path("insert")
	public buyer createBuyer(buyer a1)
	{
		System.out.println(a1);
		repo.createbuyer(a1);
		return a1;
	}
	
	
	@PUT
	@Path("update")
	public buyer updateItem(buyer a1)
	{
		System.out.println(a1);
		repo.updatebuyer(a1);
		return a1;
	}
	
	
	
	
	@DELETE
	@Path("delete")
	public buyer deleteItem(buyer a1)
	{
		System.out.println(a1);
		repo.deletebuyer(a1);
		return a1;
		
	}
}
