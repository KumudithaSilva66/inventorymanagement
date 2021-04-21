package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.warehouse;

public class warehouseRepository 
{

	
	Connection con=null;
	
	public warehouseRepository()
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
	
	public List<warehouse> getwarehouse()
	{
		List<warehouse> warehouses = new ArrayList<>();
		String sql = "select * from warehouse";
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				warehouse i = new warehouse();	
				
				i.setWarehouesid(rs.getInt(1));
				i.setWarehouesname(rs.getString(2));	
				i.setWarehoueslocation(rs.getString(3));				
				i.setWarehouesitems(rs.getString(4));
				
				
				warehouses.add(i);
			}
		}
		catch (Exception e)
		{
			
			System.out.println(e);
		}
		return warehouses;
	}
	
	public void createwarhouse(warehouse a1) 
	{
		
		String sql = "insert into warehouse values (?,?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,a1.getWarehouesid());
			st.setString(2,a1.getWarehouesname());
			st.setString(3,a1.getWarehoueslocation());
			st.setString(4, a1.getWarehouesitems());
			st.executeUpdate();
		} 
		catch (Exception e)
		{
			
			System.out.println(e);
		}
	}
	
	public void updatewarehouse(warehouse a1) 
	{
		
		String sql = "update warehouse set name=?,location=?,itemtype=? where id=?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,a1.getWarehouesname());
			st.setString(2,a1.getWarehoueslocation());
			st.setString(3,a1.getWarehouesitems());
			st.setInt(4,a1.getWarehouesid());
			st.executeUpdate();
		} 
		catch (Exception e)
		{
			
			System.out.println(e);
		}
		
	}
	
	
	public void deletewarehouse(warehouse a1) 
	{
		String sql = "delete from warehouse where id=?";
		
		try
		{
			PreparedStatement st = con.prepareStatement(sql);	
			st.setInt(1,a1.getWarehouesid());
			st.executeUpdate();
		} 
		catch (Exception e)
		{
			
			System.out.println(e);
		}

		
		
		
		
	}
	
	
	
	
	
	
}
