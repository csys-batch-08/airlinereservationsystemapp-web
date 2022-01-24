package com.airlinereservationsystemapp.Models;

public class UpdateFlight 
{
	private String Flight_name;
	private String Source;
	private String Destination;
	private int Economy_class;
	private int premium_Economy_class;
	private int Bussiness_class;
	private int Flight_id;
	private String ArrivalTime;
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
	public int getFlight_id() {
		return Flight_id;
	}
	public void setFlight_id(int flight_id) {
		Flight_id = flight_id;
	}
	public String getArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}
	public UpdateFlight(String flight_name, String source, String destination, int economy_class,
			int premium_Economy_class, int bussiness_class, int flight_id, String arrivalTime) {
		super();
		Flight_name = flight_name;
		Source = source;
		Destination = destination;
		Economy_class = economy_class;
		this.premium_Economy_class = premium_Economy_class;
		Bussiness_class = bussiness_class;
		Flight_id = flight_id;
		ArrivalTime = arrivalTime;
	}
	public UpdateFlight() {
		super();
		// TODO Auto-generated constructor stub
	}


}
