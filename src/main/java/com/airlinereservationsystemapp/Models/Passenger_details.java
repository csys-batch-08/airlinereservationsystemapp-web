package com.airlinereservationsystemapp.Models;

import java.sql.Date;
import java.time.LocalDate;
import java.sql.*;
import java.util.*;


public class Passenger_details 
{
	private String  Passenger_name;
	private String Class_details;
	private long  Mobile_number;
	
	private String Source;
	private String Destination ;
	private LocalDate Arrival_date;
	private int TicketNo;
	private int seatno;
	private int Economyseat;
	private int premiumeconomyseats;
	private int businessseats;
	private String Status;
	private LocalDate Bookingdate;
	private String mode;
	private int Amount;

	

	
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Passenger_details(String passenger_name, long mobile_number, String source,
			String destination, LocalDate arrival_date, int ticketNo, int seatno, int economyseat,
			String status, LocalDate bookingdate) {
		super();
		Passenger_name = passenger_name;
		Class_details = getClass_details();
		Mobile_number = mobile_number;
		Source = source;
		Destination = destination;
		Arrival_date = arrival_date;
		TicketNo = ticketNo;
		this.seatno = seatno;
		Economyseat = economyseat;
//		this.premiumeconomyseats = premiumeconomyseats;
//		this.businessseats = businessseats;
		Status = status;
		Bookingdate = bookingdate;
		Flight_id = getFlight_id();
		NoOfPassengers = getNoOfPassengers();
	}
	public LocalDate getBookingdate() {
		return Bookingdate;
	}
	public void setBookingdate(LocalDate bookingdate) {
		Bookingdate = bookingdate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Passenger_details(String passenger_name, String class_details, long mobile_number, String source,
			String destination, LocalDate arrival_date, int economyseat, int premiumeconomyseats, int businessseats,
			int flight_id, int noOfPassengers,int TicketNo,int Amount) {
		super();
		Passenger_name = passenger_name;
		Class_details = class_details;
		Mobile_number = mobile_number;
		Source = source;
		Destination = destination;
		Arrival_date = arrival_date;
		Economyseat = economyseat;
		this.premiumeconomyseats = premiumeconomyseats;
		this.businessseats = businessseats;
		Flight_id = flight_id;
		NoOfPassengers = noOfPassengers;
		this.TicketNo =TicketNo;
		this.Amount = Amount;
	}
	public int getEconomyseat() {
		return Economyseat;
	}
	public void setEconomyseat(int economyseat) {
		Economyseat = economyseat;
	}
	public int getPremiumeconomyseats() {
		return premiumeconomyseats;
	}
	public void setPremiumeconomyseats(int premiumeconomyseats) {
		this.premiumeconomyseats = premiumeconomyseats;
	}
	public int getBusinessseats() {
		return businessseats;
	}
	public void setBusinessseats(int businessseats) {
		this.businessseats = businessseats;
	}
	public Passenger_details(String passenger_name, String class_details, long mobile_number, String source,
			String destination, int ticketNo, int seatno, int flight_id,LocalDate arrival_date) {
		super();
		Passenger_name = passenger_name;
		Class_details = class_details;
		Mobile_number = mobile_number;
		Source = source;
		Destination = destination;
		Arrival_date = arrival_date;
		TicketNo = ticketNo;
		this.seatno = seatno;
		Flight_id = flight_id;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	public Passenger_details(String passenger_name, String class_details, long mobile_number, String source,
			String destination, int TicketNo, int flight_id,LocalDate bookingdate) {
		super();
		Passenger_name = passenger_name;
		Class_details = class_details;
		Mobile_number = mobile_number;
		Source = source;
		Destination = destination;
		//TicketNo = TicketNo;
		this.TicketNo = TicketNo;

		Flight_id = flight_id;
		Arrival_date = bookingdate;

	}
//	public int getTicketNo() {
//		return TicketNo;
//	}
//	public void setTicketNo(int TicketNo) {
//		TicketNo = TicketNo;
//	}
	
	public int getNoOfPassengers() {
		return NoOfPassengers;
	}
	public int getTicketNo() {
		return TicketNo;
	}
	public void setTicketNo(int ticketNo) {
		TicketNo = ticketNo;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		NoOfPassengers = noOfPassengers;
	}
	private int Flight_id;
	private int NoOfPassengers;
	public String getPassenger_name() {
		return Passenger_name;
	}
	public void setPassenger_name(String passenger_name) {
		Passenger_name = passenger_name;
	}
	public String getClass_details() {
		return Class_details;
	}
	public void setClass_details(String class_details) {
		Class_details = class_details;
	}
	public long getMobile_number() {
		return Mobile_number;
	}
	public void setMobile_number(long mobile_number) {
		Mobile_number = mobile_number;
	}
		public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public  LocalDate getArrival_date() {
		return Arrival_date;
	}
	public void setArrival_date(LocalDate arrival_date) {
		Arrival_date = arrival_date;
	}
	public int getFlight_id() {
		return Flight_id;
	}
	public void setFlight_id(int flight_id) {
		Flight_id = flight_id;
	}
	public Passenger_details(String passenger_name, String class_details, long mobile_number, String source,
			String destination, LocalDate arrival_date, int TicketNo, int flight_id, int noOfPassengers) {
		super();
		Passenger_name = passenger_name;
		Class_details = class_details;
		Mobile_number = mobile_number;
		Source = source;
		Destination = destination;
		Arrival_date = arrival_date;
//		TicketNo = TicketNo;
		this.TicketNo = TicketNo;

		Flight_id = flight_id;
		NoOfPassengers = noOfPassengers;
	}
	public Passenger_details(String passenger_name, String class_details, long mobile_number, String source,
			String destination, LocalDate arrival_date, int ticketNo, int seatno, String status, LocalDate bookingdate,
			int flight_id) {
		super();
		Passenger_name = passenger_name;
		Class_details = class_details;
		Mobile_number = mobile_number;
		Source = source;
		Destination = destination;
		Arrival_date = arrival_date;
		TicketNo = ticketNo;
		this.seatno = seatno;
		Status = status;
		Bookingdate = bookingdate;
		Flight_id = flight_id;
	}
	public Passenger_details(String class_details, long mobile_number, String source, String destination,
			LocalDate arrival_date, int ticketNo, int seatno, String status, LocalDate bookingdate, int flight_id,
			String mode , int Amount) {
		super();
		Class_details = class_details;
		Mobile_number = mobile_number;
		Source = source;
		Destination = destination;
		Arrival_date = arrival_date;
		TicketNo = ticketNo;
		this.seatno = seatno;
		Status = status;
		Bookingdate = bookingdate;
		Flight_id = flight_id;
		this.mode = mode;
		this.Amount = Amount;
		
		
	}
				
}
