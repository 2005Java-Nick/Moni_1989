package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.trms.dao.RegisterDao;
import com.trms.model.Employee;

public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RegisterDao register = new RegisterDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String emailId = req.getParameter("emailId");
		String contactNo = req.getParameter("contactNo");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String empTitle = req.getParameter("empTitle");
		String hireDate = req.getParameter("hireDate");
		String reportsTo = req.getParameter("reportsTo");
		String username = req.getParameter("uname");
		String password = req.getParameter("psw");

		
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmailId(emailId);
		employee.setContactNo(contactNo);
		employee.setCity(city);
		employee.setState(state);
		employee.setEmpTitle(empTitle);
		employee.setHireDate(hireDate);
		employee.setReportsTo(reportsTo);
		employee.setUsername(username);
		employee.setPassword(password);
		
			try {
				String empRegistered=register.RegisterEmployee(employee);
				if(empRegistered.equals("SUCCESS")) {
					resp.sendRedirect("/TRMS_backend/welcome");
				}else {
					req.setAttribute("errMessage",empRegistered);
					resp.sendRedirect("/TRMS_backend/registerservlet");
				}
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		}
}
