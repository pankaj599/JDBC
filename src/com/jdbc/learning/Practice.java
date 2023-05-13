package com.jdbc.learning;
import java.sql.*;

public class Practice{
	
	public static void main(String[] args) throws Exception {
		String url="jdbc:mysql://localhost:3306/api_learn";
		String username="root";
		String password="admin";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, username, password);
		Statement st=con.createStatement();
//		String s="Select * from carapi where id=1";
//		ResultSet rs=st.executeQuery(s);
//		rs.next();
//		String string = rs.getString("name");
//		System.out.println(string);
		
		//To fetch all the data
		String q = "select * from carapi";
		ResultSet rs2 = st.executeQuery(q);
		while(rs2.next())
		{
			System.out.println(rs2.getString("colour")+":"+rs2.getString("name"));
		}
		st.close();
		con.close();
	}


}
