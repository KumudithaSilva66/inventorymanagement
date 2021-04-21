package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Item;


public class ItemRepository 
{

	
	Connection con=null;
	
	public ItemRepository()
	{
		String url = "jdbc:mysql://localhost:3306/inventorysystem";
		String username = "root";
		String password = "";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		} 
		catch (Exception e) 
		{
			
			System.out.println(e);
		}
	}
	
	
	public List<Item> getItems()
	{
		List<Item> items = new ArrayList<>();
		String sql = "select * from item";
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Item i = new Item();	
				
				i.setItemcode(rs.getString(1));
				i.setItemcategory(rs.getString(2));	
				i.setItemspecific(rs.getString(3));				
				i.setPrice(rs.getInt(4));
				
				items.add(i);
			}
		}
		catch (Exception e)
		{
			
			System.out.println(e);
		}
		return items;
	}
	
	
	public void createItem(Item a1) 
	{
		
		String sql = "insert into item values (?,?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,a1.getItemcode());
			st.setString(2,a1.getItemcategory());
			st.setString(3,a1.getItemspecific());
			st.setInt(4, a1.getPrice());
			st.executeUpdate();
		} 
		catch (Exception e)
		{
			
			System.out.println(e);
		}
	}
	
	public void updateItem(Item a1) 
	{
		
		String sql = "update item set itemcategory=?,itemspecific=?,price=? where itemcode=?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,a1.getItemcategory());
			st.setString(2,a1.getItemspecific());
			st.setInt(3,a1.getPrice());
			st.setString(4,a1.getItemcode());
			st.executeUpdate();
		} 
		catch (Exception e)
		{
			
			System.out.println(e);
		}
		
	}
	
	
	public void deleteItem(Item a1) 
	{
		String sql = "delete from item where itemcode=?";
		
		try
		{
			PreparedStatement st = con.prepareStatement(sql);	
			st.setString(1,a1.getItemcode());
			st.executeUpdate();
		} 
		catch (Exception e)
		{
			
			System.out.println(e);
		}

		
		
		
		
	}
	
	
	
	
	
	
	
}
