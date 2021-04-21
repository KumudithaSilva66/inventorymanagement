package com.app.inventorymanagement;

import java.util.List;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import controller.warehouseRepository;
import model.warehouse;

@Path("Warehouse")
public class warehouseResource
{

	warehouseRepository repo = new warehouseRepository();
	
	//get all warehosue
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<warehouse> getwarehouse() 
	{
		return repo.getwarehouse();
	}
	
	
	@POST
	@Path("insert")
	public warehouse createItem(warehouse a1)
	{
		System.out.println(a1);
		repo.createwarhouse(a1);
		return a1;
	}	
	
	
	@PUT
	@Path("update")
	public warehouse updatewIt(warehouse a1)
	{
		System.out.println(a1);
		repo.updatewarehouse(a1);
		return a1;
	}
	
	@DELETE
	@Path("delete")
	public warehouse deleteItem(warehouse a1)
	{
		System.out.println(a1);
		repo.deletewarehouse(a1);
		return a1;
		
	}
	
	
	
	
}
