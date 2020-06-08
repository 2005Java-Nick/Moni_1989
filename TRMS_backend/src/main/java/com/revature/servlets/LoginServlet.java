package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.trms.dao.LoginValidate;


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String user = req.getParameter("uname");
		String pass = req.getParameter("psw");
		//LoginValidate lv=new LoginValidate();
		
		if (LoginValidate.checkUser(user, pass)) {
			resp.sendRedirect("/TRMS_backend/welcome");
			//RequestDispatcher rs = req.getRequestDispatcher("/welcome");
			//rs.forward(req, resp);
		/*} else if (LoginValidate.checkUser(user, pass)) {
			resp.sendRedirect("/TRMS_backend/l");*/
		}
		else {
			PrintWriter out = resp.getWriter();
			//System.out.println("Invalid Username/Password");
			out.println("Invalid Username/Password");
			resp.sendRedirect("/TRMS_backend/login");
//			RequestDispatcher rs = req.getRequestDispatcher("login.html");
//			rs.include(req, resp);
		}

	}

}
