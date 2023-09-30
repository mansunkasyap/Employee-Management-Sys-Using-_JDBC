package com.jsp.dao;
import java.util.*; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.jsp.configuration.*;
import com.jsp.dto.*;
import exception.EmployeeException;
public class EmployeeDao
{
	Scanner sc = new Scanner(System.in);
	Configuration config = new Configuration();
	public void create(EmployeeDto dto) throws Exception
	{	
		while(true)
		{
			PreparedStatement prep = config.configure().prepareStatement("insert into employee values (?, ?, ?, ?)");
			prep.setInt(1, dto.getId());
			System.out.println(dto.getId());
			prep.setString(2, dto.getName());	
			prep.setString(3, dto.getDesignation());
			prep.setDouble(4, dto.getSalary());
			boolean b = prep.execute();
			System.out.println(b); 
			prep.close();
			System.out.println(dto.getName() + " Successfully added");
			System.out.println("Want to add More? Press 1 else press 0");
			int o = sc.nextInt();
			if(o == 1)
				continue;
			else
				break;
		} 
	}
	
	public void readById(EmployeeDto dto) throws Exception 
	{
		PreparedStatement prep = config.configure().prepareStatement("select * from employee where id=?");
		prep.setInt(1, dto.getId());
		ResultSet res = prep.executeQuery();
		if(res.next())
		{
			System.out.println("ID: "+res.getInt(1));
			System.out.println("Name: "+ res.getString(2));
			System.out.println("Designation: "+ res.getString(3));
			System.out.println("Salary: "+res.getInt(4));
		}
			else {
			throw new EmployeeException("EmployeeDoesNotExist");
		}
		System.out.println("----------------------------------");
		res.close();
		prep.close();
	}
	public void readAll() throws Exception
	{
		PreparedStatement prep = config.configure().prepareStatement("select * from employee");
		ResultSet res = prep.executeQuery();
		while(res.next())
		{
			System.out.println("ID: "+res.getInt(1));
			System.out.println("Name: "+ res.getString(2));
			System.out.println("Designation: "+ res.getString(3));
			System.out.println("Salary: "+res.getInt(4));
			System.out.println("----------------------------------");
		}
		res.close();
		prep.close();
	}
	public void update(EmployeeDto dto)
	{
		PreparedStatement prep = config.configure().prepareStatement("update table employee set ")
	}
	public void delete() 
	{
		
	}
}

