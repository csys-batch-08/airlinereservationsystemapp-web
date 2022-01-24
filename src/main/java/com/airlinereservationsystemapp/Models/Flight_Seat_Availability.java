package com.airlinereservationsystemapp.Models;

import java.sql.Date;

public class Flight_Seat_Availability 
{
	private int flightId;
	private String flightname;
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightname() {
		return flightname;
	}
	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}
	private String source;
	private String destination;
	private Date Departure_Date;
	private int Economy_class;
	private int premium_Economy_class;
	private int Bussiness_class;
	private double Economy_rate;
	private double  Premium_Economy_rate;
	private double Bussiness_rate;
	private String ArrivalTime ;
	
	private String DepartureTime ;

	public String getArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return DepartureTime;
	}
	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}
	public Flight_Seat_Availability(int flightId, String flightname, String source, String destination,
			Date departure_Date, int economy_class, int premium_Economy_class, int bussiness_class, double economy_rate,
			double premium_Economy_rate, double bussiness_rate) {
		super();
		this.flightId = flightId;
		this.flightname = flightname;
		this.source = source;
		this.destination = destination;
		Departure_Date = departure_Date;
		Economy_class = economy_class;
		this.premium_Economy_class = premium_Economy_class;
		Bussiness_class = bussiness_class;
		Economy_rate = economy_rate;
		Premium_Economy_rate = premium_Economy_rate;
		Bussiness_rate = bussiness_rate;
	}
	public double getEconomy_rate() {
		return Economy_rate;
	}
	public void setEconomy_rate(double economy_rate) {
		Economy_rate = economy_rate;
	}
	public double getPremium_Economy_rate() {
		return Premium_Economy_rate;
	}
	public void setPremium_Economy_rate(double premium_Economy_rate) {
		Premium_Economy_rate = premium_Economy_rate;
	}
	public double getBussiness_rate() {
		return Bussiness_rate;
	}
	public void setBussiness_rate(double bussiness_rate) {
		Bussiness_rate = bussiness_rate;
	}
	public Flight_Seat_Availability(int flightId, String flightname, String source, String destination,
			Date departure_Date, int economy_class, int premium_Economy_class, int bussiness_class, double economy_rate,
			double premium_Economy_rate, double bussiness_rate, String arrivalTime, String departureTime) {
		super();
		this.flightId = flightId;
		this.flightname = flightname;
		this.source = source;
		this.destination = destination;
		Departure_Date = departure_Date;
		Economy_class = economy_class;
		this.premium_Economy_class = premium_Economy_class;
		Bussiness_class = bussiness_class;
		Economy_rate = economy_rate;
		Premium_Economy_rate = premium_Economy_rate;
		Bussiness_rate = bussiness_rate;
		ArrivalTime = arrivalTime;
		DepartureTime = departureTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getDeparture_Date() {
		return Departure_Date;
	}
	public void setDeparture_Date(Date departure_Date) {
		Departure_Date = departure_Date;
	}
	public int getEconomy_class() {
		return Economy_class;
	}
	public void setEconomy_class(int economy_class) {
		Economy_class = economy_class;
	}
	public int getPremium_Economy_class() {
		return premium_Economy_class;
	}
	public void setPremium_Economy_class(int premium_Economy_class) {
		this.premium_Economy_class = premium_Economy_class;
	}
	public int getBussiness_class() {
		return Bussiness_class;
	}
	public void setBussiness_class(int bussiness_class) {
		Bussiness_class = bussiness_class;
	}
	public Flight_Seat_Availability(int flightId, String flightname, String source, String destination,
			Date departure_Date, int economy_class, int premium_Economy_class, int bussiness_class) {
		super();
		this.flightId = flightId;
		this.flightname = flightname;
		this.source = source;
		this.destination = destination;
		Departure_Date = departure_Date;
		Economy_class = economy_class;
		this.premium_Economy_class = premium_Economy_class;
		Bussiness_class = bussiness_class;
	}
	
}
