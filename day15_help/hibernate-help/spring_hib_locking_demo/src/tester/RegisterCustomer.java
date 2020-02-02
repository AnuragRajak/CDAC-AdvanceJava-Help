package tester;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.pojos.Customer;
import com.app.service.CustomerService;

public class RegisterCustomer {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
						"spring-config.xml")) {
			System.out.println("SC started");
			System.out.println("Enter customer details amt em nm pass dt role ");
			// transient customer POJO
			Customer c1 = new Customer(sc.nextDouble(), sc.next(), sc.next(),
					sc.next(), sdf.parse(sc.next()), sc.next());
			// get service layer bean from SC & call B.L
			CustomerService service = ctx.getBean("cust_service",
					CustomerService.class);
			System.out.println("Reged customer details "
					+ service.registerCustomer(c1));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
