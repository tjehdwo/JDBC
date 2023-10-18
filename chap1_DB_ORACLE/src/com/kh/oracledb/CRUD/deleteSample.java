package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteSample {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khabank";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl,username,password);
			String deleteQuery = "DELETE FROM BANK WHERE account_id = ?";
			PreparedStatement deletePs = con.prepareStatement(deleteQuery);
			deletePs.setDouble(1, 2);
			
			int rowsdelete = deletePs.executeUpdate();
			System.out.println(rowsdelete + " 삭제되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
