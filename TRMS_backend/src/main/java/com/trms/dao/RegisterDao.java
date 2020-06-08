package com.trms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.trms.model.Employee;
import com.trms.utility.ConnectionFactory;

public class RegisterDao {
	static Connection con = ConnectionFactory.getConnection();
	static PreparedStatement ps = null;

	public String RegisterEmployee(Employee employee) throws ClassNotFoundException {
		
		String firstName=employee.getFirstName();
		String lastName=employee.getLastName();
		String emailId=employee.getEmailId();
		String contactNo=employee.getContactNo();
		String city=employee.getCity();
		String state=employee.getState();
		String empTitle=employee.getEmpTitle();
		String hireDate=employee.getHireDate();
		String reportsTo=employee.getReportsTo();
		String username=employee.getUsername();
		String password=employee.getPassword();
		try {

			String INSERT_NEW_EMPLOYEE_SQL = "insert into TRMS.Employee (employee_firstName,employee_lastName,employee_emailId,employee_contactNo,employee_city,employee_state,employee_empTitle,employee_hireDate,employee_reportsTo,employee_username,employee_password) values(?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(INSERT_NEW_EMPLOYEE_SQL);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, emailId);
			ps.setString(4, contactNo);
			ps.setString(5, city);
			ps.setString(6, state);
			ps.setString(7, empTitle);
			ps.setString(8, hireDate);
			ps.setString(9, reportsTo);
			ps.setString(10, username);
			ps.setString(11, password);
			//ps.executeUpdate();

			int i= ps.executeUpdate();
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }

	}
