package com.airlinereservationsystemapp.Models;

public class Source 
{
	private String Source;
	private String Destination;

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

	public Source() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Source(String source,String destination) {
		super();
		Source = source;
		Destination = destination;
	}
	

}
