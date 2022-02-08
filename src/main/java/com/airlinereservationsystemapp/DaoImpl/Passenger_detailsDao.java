package com.airlinereservationsystemapp.DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import com.airlinereservationsystemapp.Dao.PassengerDetailsInterface;
import com.airlinereservationsystemapp.Models.Flight_list;
import com.airlinereservationsystemapp.Models.Passenger_details;
import com.util.Connectutil;

public class Passenger_detailsDao implements PassengerDetailsInterface {
	public int Setnogenerated(Passenger_details obj, int ticketno, String username) {
		int seatno = 0;
		String returnCols[] = { "Seat_no" };
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = Connectutil.getdbconnect();
			String sql = "insert into passenger_details (PASSENGER_NAME,CLASS,MOBILE_NUMBER,SOURCE,DESTINATION,FLIGHT_ID,Departured_Date,Ticket_no,Status,User_name,Booked_Date) values(?,?,?,?,?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql, returnCols);
			stmt.setString(1, obj.getPassenger_name());
			stmt.setString(2, obj.getClass_details());
			stmt.setLong(3, obj.getMobile_number());
			stmt.setString(4, obj.getSource());
			stmt.setString(5, obj.getDestination());
			stmt.setInt(6, obj.getFlight_id());
			stmt.setDate(7, java.sql.Date.valueOf(obj.getArrival_date()));
			stmt.setInt(8, ticketno);
			stmt.setString(9, "Booked");
			stmt.setString(10, username);
			stmt.setDate(11, getcurrentdate());
			int str2 = stmt.executeUpdate();
			java.sql.ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next())
				seatno = generatedKeys.getInt(1);
		} catch (Exception e) {
			e.getMessage();
		} finally {
			Connectutil.close(con, stmt);

		}
		return seatno;
	}

	private static java.sql.Date getcurrentdate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public List<Passenger_details> Bookinglist() {
		List<Passenger_details> booklist = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = Connectutil.getdbconnect();
			String sql = "select PASSENGER_NAME,CLASS,MOBILE_NUMBER,SOURCE,DESTINATION,DEPARTURED_DATE,FLIGHT_ID,SEAT_NO,TICKET_NO,STATUS,BOOKED_DATE from passenger_details";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("PASSENGER_NAME");
				String classdetails = rs.getString("CLASS");
				long mobno = rs.getLong("MOBILE_NUMBER");
				String Source = rs.getString("SOURCE");
				String destination = rs.getString("DESTINATION");
				LocalDate Bookingdate = rs.getDate("DEPARTURED_DATE").toLocalDate();
				int flightid = rs.getInt("FLIGHT_ID");
				int seatno = rs.getInt("SEAT_NO");
				int ticketno = rs.getInt("TICKET_NO");
				String status = rs.getString("STATUS");
				LocalDate Registereddate = rs.getDate("BOOKED_DATE").toLocalDate();
				Passenger_details passenegr = new Passenger_details(name, classdetails, mobno, Source, destination,
						Bookingdate, ticketno, seatno, status, Registereddate, flightid);
				booklist.add(passenegr);
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			Connectutil.close(con, stmt, rs);
		}
		return booklist;
	}

	public void Updatepassenger(int economyseats, int premiumseats, int businessseats, String Coach, int Flightid) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = Connectutil.getdbconnect();
			String sql = "";
			if (Coach.equalsIgnoreCase("Economy")) {
				sql = "update flight_seats_availabilty set ECOMOMY_SEATS = ?   where FLIGHT_ID = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, economyseats);
				stmt.setInt(2, Flightid);
				stmt.executeUpdate();
			} else if (Coach.equalsIgnoreCase("premium")) {
				sql = "update flight_seats_availabilty set PREMIUM_ECONOMY_SEATS = ?   where FLIGHT_ID = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, premiumseats);
				stmt.setInt(2, Flightid);
				stmt.executeUpdate();
			} else if (Coach.equalsIgnoreCase("Bussiness")) {
				sql = "update flight_seats_availabilty set BUSINESS_SEATS = ?   where FLIGHT_ID = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, businessseats);
				stmt.setInt(2, Flightid);
				stmt.executeUpdate();
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			Connectutil.close(con, stmt);
		}
	}

	public List<Passenger_details> CancelTicket(String Username) {
		List<Passenger_details> canceldetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = Connectutil.getdbconnect();
			String sql = "select a.Class , a.Mobile_number, a. Source , a.Destination, a.FLight_id,c.flight_departure_date ,a.ticket_no , a.Seat_no , a.Status,a.Booked_date,"
					+ "b.TotalAmount , b.ModeofTransaction from passenger_details a inner join paymentdetails b "
					+ "on a.seat_no = b.seatno inner join flight_seats_availabilty c on a.FLight_id = c.flight_id  where user_name = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, Username);
			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					String Class = rs.getString(1);
					long mobno = rs.getLong(2);
					String source = rs.getString(3);
					String destination = rs.getString(4);
					Date Departreddate = rs.getDate(6);
					LocalDate localDate2 = Departreddate.toLocalDate();
					int flightid = rs.getInt(5);
					int seatno = rs.getInt(8);
					int ticketno = rs.getInt(7);
					String status = rs.getString(9);
					Date bookingdate = rs.getDate(10);
					LocalDate bookdate = bookingdate.toLocalDate();
					String amountmode = rs.getString(12);
					int amount = rs.getInt(11);
					Passenger_details passenegr = new Passenger_details(Class, mobno, source, destination, localDate2,
							ticketno, seatno, status, bookdate, flightid, amountmode, amount);
					canceldetails.add(passenegr);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			Connectutil.close(connection, pst, rs);
		}
		return canceldetails;
	}

	public void Updatecancelstatus(int seatno) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = Connectutil.getdbconnect();
			String sql = "";
			sql = "update passenger_details set status = ?   where Seat_no = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "Cancelled");
			stmt.setInt(2, seatno);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			Connectutil.close(con, stmt);
		}
	}

	public void Updateticketcount(int flightid, LocalDate DepartureDate, String classdetails, int seats) {
		Connection con = null;
		PreparedStatement stmt = null;


		try {
			con = Connectutil.getdbconnect();
			String sql = "";
			if (classdetails.equalsIgnoreCase("Economy")) {
				sql = "update flight_seats_availabilty set Ecomomy_seats =  ?   where flight_id = ? and Flight_Departure_Date = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, seats + 1);
				stmt.setInt(2, flightid);
				stmt.setDate(3, java.sql.Date.valueOf(DepartureDate));
				stmt.executeUpdate();
			}
			if (classdetails.equalsIgnoreCase("premium")) {
				sql = "update flight_seats_availabilty set Premium_Economy_Seats =  ?   where flight_id = ? and Flight_Departure_Date = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, seats + 1);
				stmt.setInt(2, flightid);
				stmt.setDate(3, java.sql.Date.valueOf(DepartureDate));
				stmt.executeUpdate();
			}
			if (classdetails.equalsIgnoreCase("Bussiness")) {
				sql = "update flight_seats_availabilty set Business_Seats =  ?   where flight_id = ? and Flight_Departure_Date = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, seats + 1);
				stmt.setInt(2, flightid);
				stmt.setDate(3, java.sql.Date.valueOf(DepartureDate));
				stmt.executeUpdate();
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			Connectutil.close(con, stmt);
		}
	}

	public int getticketcount(String classdetails, int flightid, LocalDate DepartureDate) {
		int seats = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = Connectutil.getdbconnect();
			String sql = "select SOURCE,DESTINATION,ECOMOMY_SEATS,BUSINESS_SEATS,PREMIUM_ECONOMY_SEATS,FLIGHT_DEPARTURE_DATE,FLIGHT_ID,DEPARTURETIME,FLIGHT_STATUS from flight_seats_availabilty where Flight_Departure_Date = ? and flight_id =?";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, java.sql.Date.valueOf(DepartureDate));
			stmt.setInt(2, flightid);
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (classdetails.equalsIgnoreCase("Economy")) {
					seats = rs.getInt("Ecomomy_Seats");
					return seats;
				} else if (classdetails.equalsIgnoreCase("premium")) {
					seats = rs.getInt("Premium_Economy_Seats");
					return seats;
				}
				// else if(classdetails.equalsIgnoreCase("business"))
				else {
					seats = rs.getInt("Business_Seats");
					return seats;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			Connectutil.close(con, stmt, rs);
		}
		return seats;
	}

	@Override
	public int PassengerDetails(Passenger_details obj, int ticketno, String username) {
		return ticketno;
		// TODO Auto-generated method stub

	}
}
