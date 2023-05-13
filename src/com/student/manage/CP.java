package com.student.manage;

//class to connect to the database

import java.sql.*;
public class CP {
	static Connection con;
public static Connection connection() throws SQLException
{
	try {
		//load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create the connection....
		String user="root";
		String password="admin";
		String url="jdbc:mysql://localhost:3306/student_manager"; //same for all, here student_manager is the database name
		
		con=DriverManager.getConnection(url, user, password);
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}

}
