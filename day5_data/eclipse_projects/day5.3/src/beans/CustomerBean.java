package beans;

import dao.CustomerDaoImpl;
import pojos.Customer;

public class CustomerBean {
	// properties
	private String email, password;
	private CustomerDaoImpl custDao;

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

	// B.L method for customer auth.
	public String validateCustomer() throws Exception {
		Customer c = custDao.signIn(email, password);
		if (c == null)
			return "invalid login!!!!!";
		return "successful login";
	}

}
