package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookExam {
	public static void main(String[] args) throws SQLException{
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "khcafe";
	String password = "kh1234";
	
	
		Connection con = DriverManager.getConnection(jdbcUrl,userName,password);
		String insertSQL = "INSERT INTO book(book_id,title,author)"+"VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertSQL);
		ps.setInt(1, 31);
		ps.setString(2, "위대한 KH");
		ps.setString(3, "kh");
		ps.executeUpdate();
		
		System.out.println("책 insert 저장");
		
		
	}
			
}
