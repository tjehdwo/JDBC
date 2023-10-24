package com.kh.MVC.Books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "kh1234";
	
	public BookDAO() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<BookDTO> getAllBooks(){
		List<BookDTO> books = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM BOOK");
			ResultSet rs = st.executeQuery();
			
		while(rs.next()) {
			int book_id = rs.getInt("book_id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			String publication_year	= rs.getString("publication_year");
			String isbn = rs.getString("isbn");
			String genre = rs.getString("genre");
			String description = rs.getString("description");
			double price = rs.getDouble("price");
			String publication_date = rs.getString("publication_date");
			String created_date = rs.getString("created_date");
			String updated_date = rs.getString("updated_date");
			String is_available = rs.getString("is_available");
			
			BookDTO book = new BookDTO(book_id,title,author,publication_year,isbn,genre,description,price,publication_date,created_date,updated_date,is_available);
			books.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
}
