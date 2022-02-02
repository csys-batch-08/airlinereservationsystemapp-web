package com.airlinereservationsystemapp.Models;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class AddFlight 
{
	private String Flight_name;
	private String Source;
	private String Destination;
	private int Economy_class;
	private int premium_Economy_class;
	private int Bussiness_class;
    private LocalDate Arrival_Date;
    private LocalDate  Departure_Date;
	private int Flight_id;
	private LocalTime ArrivalTime;
	private int Economyseats;
	private int Businesseats;
	private int preeconomyseats;
	

	public int getEconomyseats() {
		return Economyseats;
	}
	public void setEconomyseats(int economyseats) {
		Economyseats = economyseats;
	}
	public int getBusinesseats() {
		return Businesseats;
	}
	public void setBusinesseats(int businesseats) {
		Businesseats = businesseats;
	}
	public int getPreeconomyseats() {
		return preeconomyseats;
	}
	public void setPreeconomyseats(int preeconomyseats) {
		this.preeconomyseats = preeconomyseats;
	}
	
	

	
	public int getFlight_id() {
		return Flight_id;
	}
	public void setFlight_id(int flight_id) {
		Flight_id = flight_id;
	}
	
	public String getFlight_name() {
		return Flight_name;
	}
	public void setFlight_name(String flight_name) {
		Flight_name = flight_name;
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
	
	
		
		
		public LocalDate getArrival_Date() {
		return Arrival_Date;
	}
	public void setArrival_Date(LocalDate arrival_Date) {
		Arrival_Date = arrival_Date;
	}
	public LocalDate getDeparture_Date() {
		return Departure_Date;
	}
	public void setDeparture_Date(LocalDate departure_Date) {
		Departure_Date = departure_Date;
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
		Flight_name = flight_name;
		Source = source;
		Destination = destination;
		Economy_class = economy_class;
		this.premium_Economy_class = premium_Economy_class;
		Bussiness_class = bussiness_class;
		Arrival_Date = arrival_Date;
		Departure_Date = departure_Date;
		Flight_id = flight_id;
		ArrivalTime = arrivalTime;
	}
	
	public AddFlight(String flight_name, String source, String destination, int economy_class,
			int premium_Economy_class, int bussiness_class, LocalDate arrival_Date, LocalDate departure_Date,
			LocalTime time) {
		super();
		Flight_name = flight_name;
		Source = source;
		Destination = destination;
		Economy_class = economy_class;
		this.premium_Economy_class = premium_Economy_class;
		Bussiness_class = bussiness_class;
		Arrival_Date = arrival_Date;
		Departure_Date = departure_Date;
		ArrivalTime = time;
	}
	
	
    
    
    




}
