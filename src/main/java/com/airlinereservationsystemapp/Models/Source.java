package com.airlinereservationsystemapp.Models;

import java.io.Serializable;

public class Source implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
