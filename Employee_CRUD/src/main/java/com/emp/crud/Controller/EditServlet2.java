package com.emp.crud.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.crud.DAO.EmployeeDAO;
import com.emp.crud.DTO.Employee;


@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
          
        Employee e=new Employee();  
        e.setId(id);  
        e.setName(name);
		e.setPwd(password);
		e.setEmail(email);
		e.setCtry(country);  
          
        int status=EmployeeDAO.update(e);  
        if(status>0)
        {  
            response.sendRedirect("ViewServlet");  
        }else
        {  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close(); 
	}

}
