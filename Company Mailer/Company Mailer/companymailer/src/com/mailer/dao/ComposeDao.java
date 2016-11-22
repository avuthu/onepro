package com.mailer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ComposeDao {

	public static int save(String sender, String receiver, String subject,
			String message) {
		int status = 0;
		try {
			Connection con = ConProvider.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into company_mailer_message(sender,receiver,subject,message,trash,messagedate,id) values(?,?,?,?,?,?,?)");
			ps.setString(1, sender);
			ps.setString(2, receiver);
			ps.setString(3, subject);
			ps.setString(4, message);
			ps.setString(5, "no");
			ps.setDate(6, Formatter.getCurrentDate());
			ps.setInt(7, generateVal());

			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static int generateVal() {
		int val = 0;
		String qry = "select MAILER_MESSAGE.NEXTVAL from dual";
		try {
			Connection connection = ConProvider.getConnection();
			PreparedStatement ps = connection.prepareStatement(qry);
			ResultSet rs = ps.executeQuery();
			rs.next();
			val = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}
}
