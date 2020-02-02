package com.app.service;

import com.app.pojos.*;

public interface CustomerService {
	public Customer validateCustomer(String em, String pass) ;
	public Customer registerCustomer(Customer c) ;
	public Customer unsubscribeCustomer(String email) ;
	public Customer updateCustomer(Customer c) ;

}
