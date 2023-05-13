//sql query to insert, delete, display

package com.student.manage;
import java.sql.*;
public class StudentDao {
	public static boolean InsertToDb(Student st)
	{
		try {
			Connection c=CP.connection();

			String query="Insert into student_data(sname, sphone, scity) values(?,?,?)";

			//prepared Statement
			PreparedStatement p=c.prepareStatement(query);

			//inserting values to the parameter, here 1,2,3 are the question mark no. denoting different columns
			p.setString(1,st.getName());
			p.setString(2,st.getPhone());
			p.setString(3, st.getCity());

			//execute.... here we don't get any ResultSet, we get the no. of the rows affected so we can store it in the int variable
			p.executeUpdate();
			
			//close the connection
			c.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static boolean delete(int id) {
		// TODO Auto-generated method stub

		try {
			Connection c=CP.connection();

			String query="delete from student_data where sid=?";

			//prepared Statement
			PreparedStatement p=c.prepareStatement(query);

			//deleting values 
			p.setInt(1,id);


			//execute....
			p.executeUpdate();
			
			//close the connection
			c.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static void show() {
		// TODO Auto-generated method stub
		try {
			Connection c=CP.connection();

			String query="Select * from student_data";

			//prepared Statement
			Statement stmt=c.createStatement();

			//execute.... 
			// if query is bringing some data use executeQuery else use executeUpdate
			ResultSet set= (ResultSet) stmt.executeQuery(query);

			//printing data from the fetched data
			while(set.next())
			{
				//either pass column no (starting no. of is 1) or pass column name directly
				int i= set.getInt(1);
				String n=set.getString(2);
				String p=set.getString(3);
				String ci=set.getString("scity");

				System.out.println("id: "+ i);
				System.out.println("name: "+ n);
				System.out.println("phone:"+ p);
				System.out.println("city: "+ ci);
				System.out.println("+++++++++++++++++++++++++++++");
			}
			//close the connection
			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}


	}
}
