package com.app.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDao;
import com.app.pojos.Customer;

@Service("cust_service")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao dao;

	@Override
	public Customer validateCustomer(String em, String pass)  {
		// TODO Auto-generated method stub
		return dao.validateCustomer(em, pass);
	}

	@Override
	public Customer registerCustomer(Customer c)  {
		
		return dao.registerCustomer(c);
	}

	@Override
	public Customer unsubscribeCustomer(String email)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Customer c)  {
		dao.updateCustomer(c);
		System.out.println("Press enter to cont");
		try {
			System.in.read();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return c;
	}

}
