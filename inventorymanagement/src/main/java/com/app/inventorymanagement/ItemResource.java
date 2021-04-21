package com.app.inventorymanagement;

import java.util.List;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import controller.ItemRepository;
import model.Item;

@Path("Item")
public class ItemResource 
{

	
	ItemRepository repo = new ItemRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Item> getItems() 
	{
		return repo.getItems();
	}

	
	
	
	@POST
	@Path("insert")
	public Item createItem(Item a1)
	{
		System.out.println(a1);
		repo.createItem(a1);
		return a1;
	}	
	
	
	
	@PUT
	@Path("update")
	public Item updateItem(Item a1)
	{
		System.out.println(a1);
		repo.updateItem(a1);
		return a1;
	}
	
	
	@DELETE
	@Path("delete")
	public Item deleteItem(Item a1)
	{
		System.out.println(a1);
		repo.deleteItem(a1);
		return a1;
		
	}
	

	

	
	
	

	
	
}
