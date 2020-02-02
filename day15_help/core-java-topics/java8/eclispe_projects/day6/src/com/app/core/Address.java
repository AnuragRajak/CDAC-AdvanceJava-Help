package com.app.core;

import java.io.Serializable;

public class Address implements Serializable
{
	private String city,state,country;

	public Address(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address city=" + city + ", state=" + state + ", country=" + country;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}
	
	
}
