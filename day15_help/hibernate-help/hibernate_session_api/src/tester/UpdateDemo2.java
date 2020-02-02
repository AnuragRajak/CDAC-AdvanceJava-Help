//user supplies --title & hib  updates price , if book title  exists
package tester;


import java.util.Scanner;

import org.hibernate.*;

import pojos.*;
import static utils.HibernateUtils.*;

public class UpdateDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {
			System.out.println("Enter existing book id");
			int id = sc.nextInt();
			Session session = sf.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Book b1 = (Book) session.get(Book.class, id);
			tx.commit();
			System.out.println("Book Details " + b1);
			System.out.println("Enter book price increment");
			b1.setPrice(b1.getPrice() +sc.nextDouble());
			session = sf.getCurrentSession();
			tx = session.beginTransaction();
			System.out.println("session contains b1"+session.contains(b1));
			session.update(b1);
			System.out.println(session.contains(b1));
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
