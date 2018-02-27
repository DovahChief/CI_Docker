package com.sixdelta.exposp.model;

public class Account {
	
	private String name;
	private String phone;
	private String address;
	private String email;
	private String excecutive;
	private double amount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getExcecutive() {
		return excecutive;
	}
	public void setExcecutive(String excecutive) {
		this.excecutive = excecutive;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) throws RuntimeException {
		if (amount < 0) throw new RuntimeException();
		this.amount = amount;
	}
	
	

}