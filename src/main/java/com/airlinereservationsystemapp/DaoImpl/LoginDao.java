package com.airlinereservationsystemapp.DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.airlinereservationsystemapp.Dao.LoginDaoInterface;
import com.airlinereservationsystemapp.Models.Flight;
import com.airlinereservationsystemapp.Models.Flight_Seat_Availability;
import com.airlinereservationsystemapp.Models.Flight_list;
import com.util.Connectutil;

public class LoginDao implements LoginDaoInterface {
	public Boolean Loginfile(String username, String password)  {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = Connectutil.getdbconnect();
		String sql = "SELECT NAMES,EMAIL_ID,USER_NAME,PASSWORD,GENDER,PHONE_NUMBER,REGISTERED_DATE,IS_ADMIN FROM register WHERE user_name = ? AND password =?";
		 pst = connection.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, password);
		 rs = pst.executeQuery();
		while (rs.next()) {
			return true;
		}
		}
		catch(Exception e)
		{
		  e.printStackTrace();	
		}
		finally
		{
			Connectutil.close(connection,pst,rs);
		}
		return false;
	}
	public String CheckAdmin(String username, String password)  {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String admin = "";
		try
		{
		 connection = Connectutil.getdbconnect();
		String sql = "SELECT NAMES,EMAIL_ID,USER_NAME,PASSWORD,GENDER,PHONE_NUMBER,REGISTERED_DATE,IS_ADMIN FROM register WHERE user_name = ? AND password =?";
		 pst = connection.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, password);
		 rs = pst.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				admin = rs.getString("Is_Admin");
				if (admin.equalsIgnoreCase("yes")) {
					return admin = "yes";
				} else {
					return admin = "No";
				}
			}
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
			finally
			{
				Connectutil.close(connection,pst,rs);
			}
		return admin;
	}
	public void updatepassword(String username, String password) 
	{
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = Connectutil.getdbconnect();
		String sql = "update register set password = ?   where user_name = ?";
		 pst = connection.prepareStatement(sql);
		pst.setString(1, password);
		pst.setString(2, username);
		pst.executeUpdate();
		}
		catch(Exception e)
		{
		  e.printStackTrace();	
		}
		finally
		{
			Connectutil.close(connection,pst);
		}
	}
}