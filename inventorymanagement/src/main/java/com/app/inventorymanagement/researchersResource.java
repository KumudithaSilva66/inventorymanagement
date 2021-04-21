package com.app.inventorymanagement;

import java.util.List;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import controller.researchersRepository;
import model.researcher;

@Path("Researcher")
public class researchersResource 
{

	researchersRepository repo = new researchersRepository();
	
	//get all researcher
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<researcher> getItems() 
	{
		return repo.getresearchers();
	}
	
	
	@POST
	@Path("insert")
	public researcher createItem(researcher a1)
	{
		System.out.println(a1);
		repo.createresearcher(a1);
		return a1;
	}	
	
	
	
	@PUT
	@Path("update")
	public researcher updateItem(researcher a1)
	{
		System.out.println(a1);
		repo.updateresearcher(a1);
		return a1;
	}
	
	
	@DELETE
	@Path("delete")
	public researcher deleteItem(researcher a1)
	{
		System.out.println(a1);
		repo.deleteresearcher(a1);
		return a1;
		
	}
	
}
