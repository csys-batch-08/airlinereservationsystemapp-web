package com.airlinereservationsystemapp.Models;

import java.sql.Date;

public class Flight 
{
	private String name;
	private String emailId;
	private String userName;
	private String password;
	private String gender;
	private long phoneNumber;
	private Date registerDate;

	

		public Flight(String name, String emailid, String username, String password, String gender, long phonenumber,
			Date registerDate) {
		super();
		this.name = name;
		emailId = emailid;
		userName = username;
		this.password = password;
		this.gender = gender;
		phoneNumber = phonenumber;
		this.registerDate = registerDate;
	}
		public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
		public Flight(String name, String emailid, String username, String password, String gender, long phonenumber) {
		super();
		this.name = name;
		emailId = emailid;
		userName = username;
		this.password = password;
		this.gender = gender;
		phoneNumber = phonenumber;
	}
		public long getPhonenumber() {
		return phoneNumber;
	}
	public void setPhonenumber(long phonenumber) {
		phoneNumber = phonenumber;
	}
		public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailId;
	}
	public void setEmailid(String emailid) {
		emailId = emailid;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

	

}
