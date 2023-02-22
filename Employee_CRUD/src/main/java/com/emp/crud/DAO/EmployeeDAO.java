package com.emp.crud.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.emp.crud.DTO.Employee;

public class EmployeeDAO 
{
	public static Connection getConnection() 
	{
		Connection con=null;
		try
		{
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_crud","root","admin");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	
	public static int saveEmployee(Employee emp) 
	{
		int status=0;
		try 
		{
			Connection con=EmployeeDAO.getConnection();
			PreparedStatement stmt=con.prepareStatement("insert into emp_table(name,password,email,country)values(?,?,?,?)");
			stmt.setString(1, emp.getName());
			stmt.setString(2, emp.getPwd());
			stmt.setString(3, emp.getEmail());
			stmt.setString(4, emp.getCtry());
			status=stmt.executeUpdate();
			con.close();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return status;
	}
	public static List<Employee> getEmployee()
	{
		ArrayList<Employee> l1=new ArrayList<Employee>();
		
		try {
			Connection con=EmployeeDAO.getConnection();
			PreparedStatement stmt=con.prepareStatement("select * from emp_table");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				Employee e1=new Employee();
				e1.setId(rs.getInt(1));
				e1.setName(rs.getString(2));
				e1.setPwd(rs.getString(3));
				e1.setEmail(rs.getString(4));
				e1.setCtry(rs.getString(5));
				l1.add(e1);
			}
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return l1;
	}



    public static int update(Employee e){  
        int status=0;  
        try{  
            Connection con=EmployeeDAO.getConnection();  
            PreparedStatement stmt=con.prepareStatement("update emp_table set name=?,password=?,email=?,country=? where id=?");  
            stmt.setString(1,e.getName());  
            stmt.setString(2,e.getPwd());  
            stmt.setString(3,e.getEmail());  
            stmt.setString(4,e.getCtry());  
            stmt.setInt(5,e.getId());  
              
            status=stmt.executeUpdate();  
              
            con.close();  
        }
        catch(Exception ex)
        {
        	System.out.println(ex);
        }  
          
        return status;
    }


	public static Employee getId(int id)
	{
		 Employee e=new Employee();  
         
	        try{  
	            Connection con=EmployeeDAO.getConnection();  
	            PreparedStatement stmt=con.prepareStatement("select * from emp_table where id='"+id+"'");  
	          //  stmt.setInt(1,id);  
	            ResultSet rs=stmt.executeQuery();  
	            if(rs.next()){  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setPwd(rs.getString(3));  
	                e.setEmail(rs.getString(4));  
	                e.setCtry(rs.getString(5));  
	            }  
	            con.close();  
	        }
	        catch(Exception ex)
	        {
	        	System.out.println(ex);
	        	}  
	        System.out.println("hai");
	        return e;  
	        
	}


	  public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=EmployeeDAO.getConnection();  
	            PreparedStatement stmt=con.prepareStatement("delete from emp_table where id=?");  
	            stmt.setInt(1,id);  
	            status=stmt.executeUpdate();  
	              
	            con.close();  
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        	}  
	          
	        return status;  
	    } 


	
  

}
