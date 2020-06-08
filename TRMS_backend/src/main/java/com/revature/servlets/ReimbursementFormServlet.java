package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.trms.dao.ReimberseFormDao;
import com.trms.model.ReimburseForm;


public class ReimbursementFormServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	ReimberseFormDao reform = new ReimberseFormDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String category = req.getParameter("category");
		//System.out.println(category);
		String coursedate = req.getParameter("start");
	//	System.out.println(coursedate);
		String currentdate = req.getParameter("submission");
		//System.out.println(currentdate);
		String grade = req.getParameter("grade");
		//System.out.println(grade);
		Double amount = Double.parseDouble(req.getParameter("amount"));
		//System.out.println(amount);
		String description = req.getParameter("description");
		//System.out.println(description);
		
		ReimburseForm rf=new ReimburseForm();
		rf.setCategory(category);
		rf.setCourseDate(coursedate);
		rf.setCurrentDate(currentdate);
		rf.setGrade(grade);
		rf.setAmount(amount);
		rf.setCourseDes(description);
		
		try {
			String reimForm=reform.ReiubursementFormDao(rf);
			//if(reimForm.equals("SUCCESS")) {
			
				resp.sendRedirect("/TRMS_backend/fileuploadservlet");
			//}else {
			//	req.setAttribute("errMessage",reimForm);
			//	resp.sendRedirect("/TRMS_backend/newform");
		//	}
	} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
