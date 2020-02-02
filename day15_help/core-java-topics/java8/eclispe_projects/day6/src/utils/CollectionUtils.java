package utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import com.app.core.Customer;

import cust_excs.CustomerHandlingException;

public class CollectionUtils {
	public static SimpleDateFormat sdf;
	static {
		sdf=new SimpleDateFormat("dd-MM-yyyy");
	}
	public static HashMap<String, Customer> populateMap() throws Exception{
		HashMap<String, Customer> hm=new HashMap<>();
		Customer c1=new Customer("abc5@gmail", "1234", 500, sdf.parse("1-2-2019"));
		c1.linkAddress("pu", "mh", "in");
		hm.put(c1.getEmail(), c1);
		Customer c2=new Customer("abc2@gmail", "2234",1500, sdf.parse("11-2-2018"));
		c2.linkAddress("mumbai", "mh", "in");
		hm.put(c2.getEmail(), c2);

		Customer c3=new Customer("abc3@gmail", "5234", 1000, sdf.parse("1-4-2017"));
		c3.linkAddress("pu", "mh", "in");
		hm.put(c3.getEmail(), c3);

		return hm;
	}
	//sorting cust dtls as per reg date
	public static ArrayList<Customer> sortCustomers(HashMap<String, Customer> hm)
	{
		//HM --- Collection<V>
		Collection<Customer> coll=hm.values();
		//Collection -- List
		ArrayList<Customer> l1=new ArrayList<>(coll);
		Collections.sort(l1, new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				// TODO Auto-generated method stub
				return o1.getRegDate().compareTo(o2.getRegDate());
			}
			
		});
		return l1;
	}
	public static Customer authenticate(String em,String pass,HashMap<String,Customer> hm)throws Exception
	{
		//em 
		Customer c=hm.get(em);
		if(c == null)
			throw new CustomerHandlingException("Invalid Email");
		//pass
		if(!c.getPassword().equals(pass))
			throw new CustomerHandlingException("Invalid Password");
		return c;
	}
	
	
	
	
	
	
	
	
	
	
	
}
