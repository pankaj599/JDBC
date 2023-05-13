import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		boolean answer=false;
		System.out.println("Welcome");
		//This is the the second branch, now time to change
		while(true)
		{
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("press 1 to add");
			System.out.println("press 2 to delete");
			System.out.println("press 3 to display");
			System.out.println("press 4 to exit");
			int c=Integer.parseInt(br.readLine());
			if(c==1)
			{
				//ADD

				System.out.println("enter name");
				String name=br.readLine();

				System.out.println("enter phone");
				String phone=br.readLine();

				System.out.println("enter city");
				String city= br.readLine();

				Student st= new Student(name, phone, city);

				answer=StudentDao.InsertToDb(st);
				//System.out.println(st);
				if(answer)
				{System.out.println("Successfully insertion");}
				else
					System.out.println("unable to insert");

			}
			else if(c==2)
			{
				//DELETE
				System.out.println("enter id no to delete");
				
				int id=Integer.parseInt(br.readLine());
				answer=StudentDao.delete(id);
				if(answer)
				{
					System.out.println("Successfully deleted");
				}
				else
					System.out.println("uanble to delete");
			}
			else if(c==3)
			{
				StudentDao.show();
			}
			else if(c==4)
				{
					break;
				}
		}
		System.out.println("bye bye");
	}
}
