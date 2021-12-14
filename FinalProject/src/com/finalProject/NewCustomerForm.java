package com.finalProject;

public class NewCustomerForm {
	public int id;
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String country;
	public String phone;
	public String email;
	public NewCustomerForm(String[] values) {
		this.id = Integer.valueOf(values[0]);
		this.firstName = values[1];
		this.lastName = values[2];
		this.address= values[3];
		this.city= values[4];
		this.state = values[5];
		this.zip = values[6];
		this.country = values[7];
		this.phone = values[8];
		this.email = values[9];
	}
	/*
	public String getID() {
		return this.id;
	}
	public String getfirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getAddress() {
		return this.address;
	}
	public String getCity() {
		return this.city;
	}
	public String getState() {
		return this.state;
	}
	public String getZip() {
		return this.zip;
	}
	public String getCountry() {
		return this.country;
	}
	public String getPhone() {
		return this.phone;
	}
	public String getEmail() {
		return this.email;
	}
	*/


}
