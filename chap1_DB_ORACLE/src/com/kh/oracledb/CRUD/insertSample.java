package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertSample {

	public static void main(String[] args) {	
			//selectBank();
			//selectKhcafe();
			//selectIf();
			//insertBank();
			
	}
	
	
	static void insertAll() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khabank";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
					+"VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			/*insertState.setInt(1, 13);
			insertState.setString(2,"110-445-561432");
		    insertState.setString(3,"ªÁ¿⁄");
		    insertState.setDouble(4,1500.00);
		    insertState.setString(5, "kh");
		    insertState.setDate(6, Date.valueOf("2023-10-16"));
			insertState.setInt(1, 12);
			insertState.setString(2, "110-332-455066");
			insertState.setString(3, "ƒ⁄≥¢∏Æ");
			insertState.setDouble(4,700.25);
			insertState.setString(5,"¡ﬂæ”¡ˆ¡°");
			insertState.setDate(6,Date.valueOf("2023-10-10"));*/
			
			insertState.setInt(1, 11);
			insertState.setString(2, "110-544-120345");
			insertState.setString(3, "±‚∏∞");
			insertState.setDouble(4, 1500.50);
			insertState.setString(5, "≥≤¬ ¡ˆ¡°");
			insertState.setDate(6, Date.valueOf("2023-10-12"));
			
		    int rowsInsert = insertState.executeUpdate();
		    System.out.println(rowsInsert + "row √ﬂ∞°µ ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static void insertOne() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
			
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				String insertQuery = "INSERT INTO BOOK (book_id, title, author, publication_year, isbn, genre, description, price, publication_date, created_date, updated_date, is_available)"
						+"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement insertState = con.prepareStatement(insertQuery);
				insertState.setInt(1,22);
				insertState.setString(2,"28ºº ±Ë√∂¡ÿ¿« ∑π¿ÃµÂ µµ¿¸±‚");
				insertState.setString(3,"±Ë√∂¡ÿ");
				insertState.setInt(4,2023);
				insertState.setString(5,"978-8930453319");
				insertState.setString(6,"Fantasy");
				insertState.setString(7,"28ºº ≈ªÁ¿⁄ ±Ë√∂¡ÿ¿« ∑π¿ÃµÂ µµ¿¸±‚");
				insertState.setDouble(8,10.99);
				insertState.setString(9,"2023-10-07");
				insertState.setString(10,"2023-10-18");
				insertState.setString(11,null);
				insertState.setString(12,"Y");
				
				int rowsInsert = insertState.executeUpdate();
			    System.out.println(rowsInsert + "row √ﬂ∞°µ ");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
}
		
		
	

