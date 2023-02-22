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

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out=res.getWriter();
		
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		String ctry=req.getParameter("ctry");
		
		Employee e=new Employee();
		e.setName(name);
		e.setPwd(pwd);
		e.setEmail(email);
		e.setCtry(ctry);
		
		int status=EmployeeDAO.saveEmployee(e);
		if(status>0)
		{
			out.print("<p>record saved successfully</p>");
			req.getRequestDispatcher("intex.html").include(req, res);
		}
		else
		{
			out.print("sorry..! unable to save the record");
		}
		out.close();
	}

}
