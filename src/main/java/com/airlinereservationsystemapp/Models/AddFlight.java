package com.airlinereservationsystemapp.Models;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class AddFlight 
{
	private String flightName;
	private String source;
	private String destination;
	private int economyClass;
	private int premiumEconomyclass;
	private int bussinessClass;
    private LocalDate arrivalDate;
    private LocalDate  departureDate;
	private int flightId;
	private LocalTime ArrivalTime;
	private int economySeats;
	private int businesSeats;
	private int preeconomySeats;
	

	public int getEconomyseats() {
		return economySeats;
	}
	public void setEconomyseats(int economyseats) {
		economySeats = economyseats;
	}
	public int getBusinesseats() {
		return businesSeats;
	}
	public void setBusinesseats(int businesseats) {
		businesSeats = businesseats;
	}
	public int getPreeconomyseats() {
		return preeconomySeats;
	}
	public void setPreeconomyseats(int preeconomyseats) {
		this.preeconomySeats = preeconomyseats;
	}
	
	

	
	public int getFlight_id() {
		return flightId;
	}
	public void setFlight_id(int flight_id) {
		flightId = flight_id;
	}
	
	public String getflightName() {
		return flightName;
	}
	public void setFlight_name(String FlightName) {
		flightName = FlightName;
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
		return premiumEconomyclass;
	}
	public void setPremium_Economy_class(int premium_Economy_class) {
		this.premiumEconomyclass = premium_Economy_class;
	}
	public int getBussiness_class() {
		return bussinessClass;
	}
	public void setBussiness_class(int bussiness_class) {
		bussinessClass = bussiness_class;
	}
	
	
		
		
		public LocalDate getArrival_Date() {
		return arrivalDate;
	}
	public void setArrival_Date(LocalDate arrival_Date) {
		arrivalDate = arrival_Date;
	}
	public LocalDate getDeparture_Date() {
		return departureDate;
	}
	public void setDeparture_Date(LocalDate departure_Date) {
		departureDate = departure_Date;
	}
	public LocalTime getArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		ArrivalTime = arrivalTime;
	}
	public AddFlight(String flight_name, String source, String destination, int economy_class,
			int premium_Economy_class, int bussiness_class, LocalDate arrival_Date, LocalDate departure_Date,
			int flight_id, LocalTime arrivalTime) {
		super();
		flightName = flight_name;
		this.source = source;
		this.destination = destination;
		economyClass = economy_class;
		this.premiumEconomyclass = premium_Economy_class;
		bussinessClass = bussiness_class;
		arrivalDate = arrival_Date;
		departureDate = departure_Date;
		flightId = flight_id;
		ArrivalTime = arrivalTime;
	}
	
	public AddFlight(String flight_name, String source, String destination, int economy_class,
			int premium_Economy_class, int bussiness_class, LocalDate arrival_Date, LocalDate departure_Date,
			LocalTime time) {
		super();
		flightName = flight_name;
		this.source = source;
		this.destination = destination;
		economyClass = economy_class;
		this.premiumEconomyclass = premium_Economy_class;
		bussinessClass = bussiness_class;
		arrivalDate = arrival_Date;
		departureDate = departure_Date;
		ArrivalTime = time;
	}
	
	
    
    
    




}
