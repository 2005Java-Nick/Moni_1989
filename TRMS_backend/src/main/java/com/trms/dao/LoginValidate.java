package com.trms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trms.model.Employee;
import com.trms.utility.ConnectionFactory;

public class LoginValidate {
	static Connection con=ConnectionFactory.getConnection(); 
	  static PreparedStatement ps; 
	  static ResultSet rs=null;
	  
	public static boolean checkUser(String employee_username,String employee_password) 
    {
        boolean st =false;
        try {

    		String SELECT_EMPLOYEE_SQL="select * from TRMS.employee where employee_username=? and employee_password=?";
    		ps=con.prepareStatement(SELECT_EMPLOYEE_SQL);
			ps.setString(1, employee_username);
			ps.setString(2, employee_password);
			rs=ps.executeQuery();
			if (rs.next()) {
				st=true;
				return st;
			}

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st; 
}
}
	
