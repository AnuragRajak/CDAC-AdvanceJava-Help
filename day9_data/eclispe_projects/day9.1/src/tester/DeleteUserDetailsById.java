package tester;

import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;

public class DeleteUserDetailsById {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				SessionFactory sf = getSf()) {
			System.out.println("hib started....");
			System.out.println("Enter user id for delete");
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println(dao.deleteUserDetails(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
