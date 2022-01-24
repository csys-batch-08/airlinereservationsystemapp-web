package com.airlinereservationsystemapp.Models;

import java.sql.Date;

public class Flight 
{
	private String Name;
	private String Emailid;
	private String Username;
	private String Password;
	private String Gender;
	private long Phonenumber;
	private Date RegisterDate;

	

		public Flight(String name, String emailid, String username, String password, String gender, long phonenumber,
			Date registerDate) {
		super();
		Name = name;
		Emailid = emailid;
		Username = username;
		Password = password;
		Gender = gender;
		Phonenumber = phonenumber;
		RegisterDate = registerDate;
	}
		public Date getRegisterDate() {
		return RegisterDate;
	}
	public void setRegisterDate(Date registerDate) {
		RegisterDate = registerDate;
	}
		public Flight(String name, String emailid, String username, String password, String gender, long phonenumber) {
		super();
		Name = name;
		Emailid = emailid;
		Username = username;
		Password = password;
		Gender = gender;
		Phonenumber = phonenumber;
	}
		public long getPhonenumber() {
		return Phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		Phonenumber = phonenumber;
	}
		public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailid() {
		return Emailid;
	}
	public void setEmailid(String emailid) {
		Emailid = emailid;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	

	

}
