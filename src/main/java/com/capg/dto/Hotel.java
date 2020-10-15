package com.capg.dto;

public class Hotel {
	String name;
	int rateForRegCustomer;

	public Hotel(String name, int rateForCustomer) {
		this.name = name;
		this.rateForRegCustomer = rateForCustomer;
	}

	public Hotel() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRateForRegCoustomer() {
		return rateForRegCustomer;
	}

	public void setRateForRegCoustomer(int rateForRegCoustomer) {
		this.rateForRegCustomer = rateForRegCoustomer;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", Regular Customer Rate =" + rateForRegCustomer + "]";
	}
}
