package com.emp.crud.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.crud.DAO.EmployeeDAO;
import com.emp.crud.DTO.Employee;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        EmployeeDAO.delete(id);  
        System.out.println("e");
        response.sendRedirect("ViewServlet"); 
	}

}
