package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//cafes insert 작성해서 여러 카페 추가하기

public class insertExam {

	public static void main(String[] args) {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "kh1234";
		
		try {
			/*Connection con = DriverManager.getConnection(jdbcurl,userName,password);
			String insertSQL = "INSERT INTO cafes(cname,address,phone_number,operating_hours)"
					+"VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			insertCafes(ps,"원두가 맛있는 집","서울시 동작구 흑석동 12-25","02-123-0998","월-금 09:00~21:00");
			insertCafes(ps,"커피가 맛있는집","서울시 강남구 학동 37-12","02-513-1234","주말 09:00~21:00");
			insertCafes(ps,"편히 쉴수 있는곳","서울시 마포구  31-32","02-876-3414","월-금 09:00~21:00, 주말 09:00~18:00");
			insertCafes(ps,"테라스가 넓은 집","서울시 종로구 23-11","02-834-2344"," 주말 09:00~18:00");
			ps.close();*/
			
			Connection con = DriverManager.getConnection(jdbcurl,userName,password);
			String insertSQL = "INSERT INTO book(book_id,title,author,publication_year,isbn,genre,description,price,publication_date,created_date,updated_date,is_available)"
					+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			insertBook(ps,26,"깁선장의 위대한 여정","농촌민",2020,"978-3040304034","Fantasy","깁",9.99,"2023-10-05","2023-10-01",null,"Y");
			insertBook(ps,27,"제라티온의 1달간의 휴식","마라톤",2022,"978-1234506660","Essay","마라톤이 실제로 마라톤하는 내용",13.99,"2023-10-03","2023-09-30",null,"Y");
			insertBook(ps,28,"개과천선의 그림일기","정우준",2021,"978-3124050394","Essay","우준이의 요리 도전기",8.99,"2023-09-25","2023-10-03",null,"Y");
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void insertCafes(PreparedStatement ps,String cname,String address,String phone_number,String operating_hours)throws SQLException {
		
		ps.setString(1,cname);
		ps.setString(2, address);
		ps.setString(3, phone_number);
		ps.setString(4, operating_hours);
		ps.executeUpdate();
	}
	static void insertBook(PreparedStatement ps,int book_id,String title,String author,int publication_year,String isbn,String genre,String description,double price,String publication_date,String created_date,String updated_date,String is_available)throws SQLException{
		ps.setInt(1, book_id);
		ps.setString(2,title);
		ps.setString(3, author);
		ps.setInt(4,publication_year);
		ps.setString(5,isbn);
		ps.setString(6,genre);
		ps.setString(7,description);
		ps.setDouble(8,price);
		ps.setString(9,publication_date);
		ps.setString(10,created_date);
		ps.setString(11,updated_date);
		ps.setString(12,is_available);
		ps.executeUpdate();
	}
}
