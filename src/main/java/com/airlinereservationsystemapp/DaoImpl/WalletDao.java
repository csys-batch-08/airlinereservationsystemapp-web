package com.airlinereservationsystemapp.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.airlinereservationsystemapp.Dao.WalletInterface;
import com.util.Connectutil;

public class WalletDao implements WalletInterface {
	public int getclosingbalance(String username) {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int Closing_balance = 0;
		try {
			connection = Connectutil.getdbconnect();
			String sql = "SELECT wallet_amount FROM wallet_details WHERE user_name = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
//		if(rs != null)
//		{
			Closing_balance = 0;
			while (rs.next()) {
				Closing_balance = rs.getInt("wallet_amount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connectutil.close(connection, pst, rs);

		}
		return Closing_balance;
	}

	public int checkusername(String username) {
		int Closing_balance = 0;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = Connectutil.getdbconnect();
			String sql = "SELECT wallet_amount FROM wallet_details WHERE user_name = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
//		if(rs != null)
//		{
			while (rs.next()) {
				Closing_balance = rs.getInt("wallet_amount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connectutil.close(connection, pst, rs);
		}
		return Closing_balance;
	}

	public void refundbalance(String username, int refundamount) {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			int balance = checkusername(username);
			int discountamount = (int) (refundamount * 0.05);
			refundamount = balance + refundamount - discountamount;
			connection = Connectutil.getdbconnect();
			String sql = "update wallet_details set wallet_amount =?  WHERE user_name = ?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, refundamount);
			pst.setString(2, username);
			rs = pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connectutil.close(connection, pst, rs);
		}
	}

	public void insetbalance(String username, int Amount) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = Connectutil.getdbconnect();
			String query = "insert into wallet_details (user_name,wallet_amount)values(?,?)";
			pst = connection.prepareStatement(query);
			pst.setString(1, username);
			pst.setInt(2, Amount);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connectutil.close(connection, pst);
		}
	}

	public void updatebalance(String username, int Amount) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = Connectutil.getdbconnect();
			String sql = "update wallet_details set wallet_amount = ?   where user_name = ?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, Amount);
			pst.setString(2, username);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connectutil.close(connection, pst);
		}
	}

	public void InserPaymentdetails(int Flightid, int Ticketno, int amount, String modeoftransaction, String username,
			int seatno) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = Connectutil.getdbconnect();
			String sql = "insert into PaymentDetails (FLIGHTID,TICKETNO,TOTALAMOUNT,MODEOFTRANSACTION,Username,Seatno) values(?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, Flightid);
			pst.setInt(2, Ticketno);
			pst.setInt(3, amount);
			pst.setString(4, modeoftransaction);
			pst.setString(5, username);
			pst.setInt(6, seatno);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connectutil.close(connection, pst);
		}
	}
}
