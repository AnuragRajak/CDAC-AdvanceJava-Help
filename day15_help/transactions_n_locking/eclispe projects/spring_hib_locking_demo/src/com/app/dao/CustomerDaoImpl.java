package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	// Dependency -- SF
	@Autowired
	private SessionFactory sf;

	@Override
	public Customer validateCustomer(String em1, String pass1)  {
		String hql = "select c from Customer c where c.email = :em and c.password = :pass";
		return (Customer)sf.getCurrentSession().createQuery(hql).setParameter("em", em1)
				.setParameter("pass", pass1).uniqueResult();
	}

	@Override
	public Customer registerCustomer(Customer c)  {
		System.out.println("in dao : reg cust " + c);
		sf.getCurrentSession().persist(c);
		System.out.println("dao reted " + c);
		return c;
	}

	@Override
	public Customer unsubscribeCustomer(String email)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Customer c)  {
		sf.getCurrentSession().update(c);
		return c;
	}

}
