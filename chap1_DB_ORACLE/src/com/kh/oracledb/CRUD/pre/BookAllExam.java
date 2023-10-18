package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookAllExam {
	public static void main(String[] args) throws SQLException{
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "kh1234";
	
		Connection con = DriverManager.getConnection(jdbcUrl,userName,password);
		
	
	}

	public static void insertBook(PreparedStatement ps,int book_id,String title,String author,int publication_year,String isbn,String genre,String description,double price, String pdate,String isAvailable) throws SQLException {
		ps.setInt(1, book_id);
		ps.setString(2,title);
		ps.setString(3,author);
		ps.setInt(4,publication_year);
		ps.setString(5,isbn);
		ps.setString(6,genre);
		ps.setString(7,description);
		ps.setDouble(8,price);
		ps.setString(9,pdate);
		ps.setString(10,isAvailable);
		
		int rows = ps.executeUpdate();
		
		if(rows>0) {
			System.out.println("책 " + title + " 들어갔습니다.");
		}else {
			System.out.println("들어온 책이 없습니다.");
		}
		
		
		
		
	}
}
