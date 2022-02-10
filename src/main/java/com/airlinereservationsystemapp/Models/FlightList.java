package com.airlinereservationsystemapp.Models;

import java.sql.*;

public class FlightList 
{
	private int flightId;
	private String flightName;
	private String source;
	private String destination;
	private int economyClass;
	private int premiumEconomyClass;
	private int bussinessClass;
	private Date arrivalTime;
	private Date Departure_time;
	private int Economyseats;
	private int premiumseats;
	private int businessseats;
	private String  Arrivaltime;
	private String DepartureTime;
	private String Flightstatus;



	

		public String getFlightstatus() {
		return Flightstatus;
	}
	public void setFlightstatus(String flightstatus) {
		Flightstatus = flightstatus;
	}
		public String getDepartureTime() {
		return DepartureTime;
	}
	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}
		public FlightList(int flight_id, String flight_name,Date arrival_Time, Date departure_time
				,String source, String destination, int economy_class,
			int premium_Economy_class, int bussiness_class) {
		super();
		flightId = flight_id;
		flightName = flight_name;
		this.source = source;
		this.destination = destination;
		economyClass = economy_class;
		this.premiumEconomyClass = premium_Economy_class;
		bussinessClass = bussiness_class;
		arrivalTime = arrival_Time;
		Departure_time = departure_time;
	}
		public int getFlight_id() {
		return flightId;
	}
	public void setFlight_id(int flight_id) {
		this.flightId = flight_id;
	}
	public String getFlight_name() {
		return flightName;
	}
	public void setFlight_name(String flight_name) {
		flightName = flight_name;
	}
	public Date getArrival_Time() {
		return arrivalTime;
	}
	public void setArrival_Time(Date arrival_Time) {
		arrivalTime = arrival_Time;
	}
	public Date getDeparture_time() {
		return Departure_time;
	}
	public void setDeparture_time(Date departure_time) {
		Departure_time = departure_time;
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
	public int getEconomy_class() {
		return economyClass;
	}
	public void setEconomy_class(int economy_class) {
		economyClass = economy_class;
	}
	public int getPremium_Economy_class() {
		return premiumEconomyClass;
	}
	public void setPremium_Economy_class(int premium_Economy_class) {
		this.premiumEconomyClass = premium_Economy_class;
	}
	public int getBussiness_class() {
		return bussinessClass;
	}
	public void setBussiness_class(int bussiness_class) {
		bussinessClass = bussiness_class;
	}
	public FlightList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEconomyseats() {
		return Economyseats;
	}
	public FlightList(int flight_id, String flight_name, String source, String destination, int economy_class,
			int premium_Economy_class, int bussiness_class, Date arrival_Time, Date departure_time, int economyseats,
			int premiumseats, int businessseats, String arrivaltime, String departureTime, String flightstatus) {
		super();
		flightId = flight_id;
		flightName = flight_name;
		this.source = source;
		this.destination = destination;
		economyClass = economy_class;
		this.premiumEconomyClass = premium_Economy_class;
		bussinessClass = bussiness_class;
		arrivalTime = arrival_Time;
		Departure_time = departure_time;
		Economyseats = economyseats;
		this.premiumseats = premiumseats;
		this.businessseats = businessseats;
		Arrivaltime = arrivaltime;
		DepartureTime = departureTime;
		Flightstatus = flightstatus;
	}
	public void setEconomyseats(int economyseats) {
		Economyseats = economyseats;
	}
	public int getPremiumseats() {
		return premiumseats;
	}
	public void setPremiumseats(int premiumseats) {
		this.premiumseats = premiumseats;
	}
	public int getBusinessseats() {
		return businessseats;
	}
	public void setBusinessseats(int businessseats) {
		this.businessseats = businessseats;
	}
	public String getArrivaltime() {
		return Arrivaltime;
	}
	public void setArrivaltime(String arrivaltime) {
		Arrivaltime = arrivaltime;
	}
	
	public FlightList(int flight_id, String source, String destination, int economy_class, int premium_Economy_class,
			int bussiness_class, Date departure_time, int economyseats, int premiumseats, int businessseats) {
		super();
		flightId = flight_id;
		this.source = source;
		this.destination = destination;
		economyClass = economy_class;
		this.premiumEconomyClass = premium_Economy_class;
		bussinessClass = bussiness_class;
		Departure_time = departure_time;
		Economyseats = economyseats;
		this.premiumseats = premiumseats;
		this.businessseats = businessseats;
	}


	
	

}