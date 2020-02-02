package ser_deserial;
import static utils.IOUtils.*;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Customer;

import static utils.CollectionUtils.*;

public class Test1 {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
			System.out.println("Enter file name");
			//restore customer dtls from bin file using de-serialization
			HashMap<String, Customer> hm=readData(sc.next());
			System.out.println("restored customer details ");
			for(Customer c:hm.values())
				System.out.println(c);
			System.out.println("terminating appln ...");
			
			//store HM on bin file using serialization
			writeData(populateMap());
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
