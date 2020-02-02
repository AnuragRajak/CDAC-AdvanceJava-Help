package tester;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.User;

public class BulkUpdateUsers {

	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		try (Scanner sc = new Scanner(System.in);
				SessionFactory sf = getSf()) {
			System.out.println("hib started....");
			System.out.println("Enter discount n reg date for updation");
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println(dao.bulkUpdateUserDetails(sc.nextDouble(), sdf.parse(sc.next())));
			} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
