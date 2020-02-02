package tester;
import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.*;

import dao.DepartmentDaoImpl;
import pojos.Department;
import pojos.Employee;

public class CreateNewDept {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf=getSf())
		{
			System.out.println("hib started....");
			System.out.println("Enter dept dtls nm loc");
			Department d1=new Department(sc.next(), sc.next());
			for(int i=0;i<3;i++)
			{
				System.out.println("Enter emp dtls nm sal");
				d1.addEmp(new Employee(sc.next(), sc.nextDouble()));
			}
			//invoke dao's method
			DepartmentDaoImpl dao=new DepartmentDaoImpl();
			System.out.println(dao.createNewDept(d1));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
