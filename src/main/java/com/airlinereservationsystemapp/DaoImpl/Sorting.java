package com.airlinereservationsystemapp.DaoImpl;

import java.util.Comparator;

import com.airlinereservationsystemapp.Models.FlightSeatAvailability;


public class Sorting implements Comparator<FlightSeatAvailability>
{

	@Override
	public int compare(FlightSeatAvailability o1, FlightSeatAvailability o2) 
	{
		if(o1.getEconomy_class()==o2.getEconomy_class())
		{
			return 0;
		}
		else if(o1.getEconomy_class()>o2.getEconomy_class())
		{
			return 1;

		}
		else
		{

		return -1;
		}
	}

	

}
