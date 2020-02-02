package com.app.dao;

import com.app.pojos.*;

public interface CustomerDao {
	public Customer validateCustomer(String em, String pass) ;
	public Customer registerCustomer(Customer c) ;
	public Customer unsubscribeCustomer(String email) ;
	public Customer updateCustomer(Customer c) ;

}
