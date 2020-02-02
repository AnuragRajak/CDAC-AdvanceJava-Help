package tester;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.pojos.Customer;
import com.app.service.CustomerService;

public class UpdateCustomer {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
						"spring-config.xml")) {
			System.out.println("SC started");
			System.out.println("Enter email & password ");

			// get service layer bean from SC & call B.L
			CustomerService service = ctx.getBean("cust_service",
					CustomerService.class);
			Customer c=service.validateCustomer(sc.next(), sc.next());
			if (c != null)
			{
				System.out.println("Enter new password");
				c.setPassword(sc.next());
				service.updateCustomer(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
