package com.airlinereservationsystemapp.DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.airlinereservationsystemapp.Dao.FlightRegisterInterface;
import com.airlinereservationsystemapp.Models.Flight;
import com.airlinereservationsystemapp.Models.Passenger_details;
import com.util.Connectutil;

public class FlightRegisterDao implements FlightRegisterInterface {
	private static Date getcurrentdate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public int Fileregistration(Flight objFlightRegister) throws ClassNotFoundException {
		int str = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = Connectutil.getdbconnect();
			String sql = "insert into register (Names,Email_id,User_name,Password,gender,Phone_number,Registered_date) values(?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, objFlightRegister.getName());
			stmt.setString(2, objFlightRegister.getEmailid());
			stmt.setString(3, objFlightRegister.getUsername());
			stmt.setString(4, objFlightRegister.getPassword());
			stmt.setString(5, objFlightRegister.getGender());
			stmt.setLong(6, objFlightRegister.getPhonenumber());
			stmt.setDate(7, getcurrentdate());
			str = stmt.executeUpdate();
			insertwalletFlight(objFlightRegister);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connectutil.close(con, stmt);
		}
		return str;
	}

	public void insertwalletFlight(Flight objFlightRegister) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {

			con = Connectutil.getdbconnect();
			String query = "insert into wallet_details (User_name,Wallet_amount) values(?,?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, objFlightRegister.getUsername());
			stmt.setInt(2, 0);
			int fdgdgstr = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connectutil.close(con, stmt);
		}
	}

	public String guestcheck(long phone, String mail) {
		String roles = null;
		String returnCols[] = { "ROLES" };
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			System.out.println("Method COme Inisdedssdds");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");

			String sql = "select * from Guestvalid where Phone_Number = ? and Email_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setLong(1, phone);
			stmt.setString(2, mail);
			rs = stmt.executeQuery();
			System.out.println("Ready For Login Vlaidation");
			if (rs.next()) {
				roles = rs.getString("Roles");
			} else {
				return roles;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connectutil.close(con, stmt, rs);
		}
		return roles;
	}

	public void insertguestvalid(long phone, String mail) {
		Connection con = null;
		PreparedStatement state = null;
		try {
			con = Connectutil.getdbconnect();

			String query = "insert into Guestvalid (PHONE_NUMBER,EMAIL_ID) values(?,?)";
			state = con.prepareStatement(query);
			state.setLong(1, phone);
			state.setString(2, mail);
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connectutil.close(con, state);
		}
	}

	public List<Passenger_details> CancelTicket(long mobile) {
		List<Passenger_details> canceldetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = Connectutil.getdbconnect();
			String sql = "select a.Class , a.Mobile_number, a. Source , a.Destination, a.FLight_id,c.flight_departure_date ,a.ticket_no , a.Seat_no ,a.Status,a.Booked_date,b.TotalAmount , b.ModeofTransaction from passenger_details a inner join paymentdetails b on a.seat_no = b.seatno inner join flight_seats_availabilty c on a.FLight_id = c.flight_id  inner join Guestvalid e on e.PHONE_NUMBER = a.Mobile_number where Mobile_number = ?";
			pst = connection.prepareStatement(sql);
			pst.setLong(1, mobile);
			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					String Class = rs.getString(1);
					System.out.println(Class);
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
			e.printStackTrace();
		} finally {
			Connectutil.close(connection, pst, rs);
		}
		return canceldetails;
	}

	@Override
	public String Registration(Flight objFlightRegister) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
