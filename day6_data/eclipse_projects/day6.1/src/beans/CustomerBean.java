package beans;

import dao.CustomerDaoImpl;
import pojos.Customer;

public class CustomerBean {
	// properties --clnt's conversatinal state --req params
	private String email, password;
	//hidden prop --for internal working 
	private CustomerDaoImpl custDao;
	//clnt specific results
	private String message;
	private Customer details;

	public CustomerBean() throws Exception {
		System.out.println("in cust bean constr");
		// create DAO instance
		custDao = new CustomerDaoImpl();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerDaoImpl getCustDao() {
		return custDao;
	}

	public void setCustDao(CustomerDaoImpl custDao) {
		this.custDao = custDao;
	}
	

	public String getMessage() {
		return message;
	}
	
	

	public Customer getDetails() {
		return details;
	}

	// B.L method for customer auth.
	public String validateCustomer() throws Exception {
		details= custDao.signIn(email, password);
		if (details == null) {
			message="Invalid Login ,pls retry....";
			return "login";
		}
		message ="Login successful";
		return "category";
	}
	

}
