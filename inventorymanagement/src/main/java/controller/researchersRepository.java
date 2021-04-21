package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.researcher;

public class researchersRepository 
{

	Connection con=null;
	
	public researchersRepository()
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
	
	
	
	public List<researcher> getresearchers()
	{
		List<researcher> researchers = new ArrayList<>();
		String sql = "select * from researcher";
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				researcher i = new researcher();	
				
				i.setId(rs.getInt(1));
				i.setName(rs.getString(2));	
				i.setCountry(rs.getString(3));	
				i.setSpecialization(rs.getString(4));	
				i.setPnumber(rs.getInt(5));
				i.setAge(rs.getInt(6));	
				
				researchers.add(i);
			}
		}
		catch (Exception e)
		{
			
			System.out.println(e);
		}
		return researchers;
	}
	
	
	
	public void createresearcher(researcher a1) 
	{
		
		String sql = "insert into researcher values (?,?,?,?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,a1.getId());
			st.setString(2,a1.getName());
			st.setString(3,a1.getCountry());
			st.setString(4,a1.getSpecialization());
			st.setInt(5, a1.getPnumber());
			st.setInt(6, a1.getAge());
			st.executeUpdate();
		} 
		catch (Exception e)
		{
			
			System.out.println(e);
		}
	}
	
	public void updateresearcher(researcher a1) 
	{
		
		String sql = "update researcher set name=?,country=?,specialization=?,pnumber=?,age=? where id=?";		
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,a1.getName());
			st.setString(2,a1.getCountry());
			st.setString(3,a1.getSpecialization());
			st.setInt(4,a1.getPnumber());
			st.setInt(5,a1.getAge());
			st.setInt(6,a1.getId());
			st.executeUpdate();
		} 
		catch (Exception e)
		{
			
			System.out.println(e);
		}
		
	}
	
	
	public void deleteresearcher(researcher a1) 
	{
		String sql = "delete from researcher where id=?";
		
		try
		{
			PreparedStatement st = con.prepareStatement(sql);	
			st.setInt(1,a1.getId());
			st.executeUpdate();
		} 
		catch (Exception e)
		{
			
			System.out.println(e);
		}

	}
	
	
	
	
	
}
