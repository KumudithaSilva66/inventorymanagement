package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.buyer;

public class buyerRepository
{

	Connection con=null;
	
	public buyerRepository() 
	
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
	
	
	public List<buyer> getbuyers()
	{
		List<buyer> buyers = new ArrayList<>();
		String sql = "select * from buyer";
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				buyer i = new buyer();		

				i.setId(rs.getString(1));
				i.setName(rs.getString(2));
				i.setCountry(rs.getString(3));
				i.setInterest(rs.getString(4));
				i.setPhone(rs.getInt(5));
				
				buyers.add(i);
			}
		}
		catch (Exception e)
		{
			
			System.out.println(e);
		}
		return buyers;
	}
	
	
	public void createbuyer(buyer a1) 
	{
		
		String sql = "insert into buyer values (?,?,?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,a1.getId());
			st.setString(2,a1.getName());
			st.setString(3,a1.getCountry());
			st.setString(4,a1.getInterest());
			st.setInt(5, a1.getPhone());
			st.executeUpdate();
		} 
		catch (Exception e)
		{
			
			System.out.println(e);
		}
	}
	
	
	public void updatebuyer(buyer a1) 
	{
		
		String sql = "update buyer set name=?,country=?,interest=?,phone=? where id=?";
		
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,a1.getName());
			st.setString(2,a1.getCountry());
			st.setString(3,a1.getInterest());
			st.setInt(4,a1.getPhone());
			st.setString(5,a1.getId());
			st.executeUpdate();
		} 
		catch (Exception e)
		{
			
			System.out.println(e);
		}
		
	}
	
	
	
	
	public void deletebuyer(buyer a1) 
	{
		String sql = "delete from buyer where id=?";
		
		try
		{
			PreparedStatement st = con.prepareStatement(sql);	
			st.setString(1,a1.getId());
			st.executeUpdate();
		} 
		catch (Exception e)
		{
			
			System.out.println(e);
		}

		
		
		
		
	}
	
	
	
	
	
	
	
	
}
