package com.app.core;

import java.io.Serializable;
import java.util.Date;
import static utils.CollectionUtils.*;

public class Customer implements Serializable{
	private String email, password;
	private double regAmount;
	private Date regDate;
	private  Address custAdr;

	public Customer(String email, String password, double regAmount, Date regDate) {
		super();
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	public void linkAddress(String city, String state, String country) {
		custAdr = new Address(city, state, country);
	}

	@Override
	public String toString() {
		return "Customer : " + email +" "+ regAmount +" "+ sdf.format(regDate) + " "
				+ custAdr;
	}

	public String getEmail() {
		return email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public String getPassword() {
		return password;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public Address getCustAdr() {
		return custAdr;
	}
	

}
