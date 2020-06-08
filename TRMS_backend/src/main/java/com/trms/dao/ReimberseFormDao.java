package com.trms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.trms.model.ReimburseForm;
import com.trms.utility.ConnectionFactory;

public class ReimberseFormDao {
	static Connection con = ConnectionFactory.getConnection();
	static PreparedStatement ps = null;

	public String ReiubursementFormDao(ReimburseForm form) throws ClassNotFoundException {

		try {
			
			String category = form.getCategory();
			String coursedate=form.getCourseDate();
			String currentdate = form.getCurrentDate();
			String grade = form.getGrade();
			Double amount=form.getAmount();
			String description=form.getCourseDes();
			String INSERT_NEW_FORM_SQL = "insert into TRMS.ReimRequest (ReimRequest_category,ReimRequest_courseDate,ReimRequest_submissionDate,ReimRequest_amount,ReimRequest_description,ReimRequest_grading) values(?,?,?,?,?,?)";
			
			
			ps = con.prepareStatement(INSERT_NEW_FORM_SQL);
			ps.setString(1, category);
			ps.setString(2, coursedate);
			ps.setString(3, currentdate);
			ps.setString(4, grade);
			ps.setDouble(5, amount);
			ps.setString(6, description);
			
			// ps.executeUpdate();

			int i = ps.executeUpdate();

			if (i != 0) // Just to ensure data has been inserted into the database
				return "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!"; // On failure, send a message from here.
	}

}
