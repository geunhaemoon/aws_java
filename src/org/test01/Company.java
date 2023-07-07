package org.test01;

import lombok.ToString;

@ToString
public class Company {	
	private int companyId;
	private String companyName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	
	public Company(int companyId, String companyName, String address, String city, String stae, String zipCode) {
		this.companyId = companyId;
		this.companyName= companyName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;

	}
}
