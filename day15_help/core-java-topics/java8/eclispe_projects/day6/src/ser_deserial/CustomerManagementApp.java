package ser_deserial;

import java.util.HashMap;
import java.util.Scanner;
import static utils.CollectionUtils.*;
import com.app.core.Customer;

import static utils.IOUtils.*;

public class CustomerManagementApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			boolean exit = false;
			while (!exit) {
				System.out.println("Enter file name");
				// restore dtls
				HashMap<String, Customer> hm = readData(sc.next());
				try {
					System.out.println("Options : 1 Un-subscribe 10:Exit ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter em & pass for un-subscription");
						Customer ref = authenticate(sc.next(), sc.next(), hm);
						System.out.println("Authenticated...");
						System.out.println("Rec removed " + hm.remove(ref.getEmail()));
						break;

					case 10:
						exit = true;
						writeData(hm);
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				// read off pending data from scanner
				sc.nextLine();
			} // end of while
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("application over...");

	}

}
