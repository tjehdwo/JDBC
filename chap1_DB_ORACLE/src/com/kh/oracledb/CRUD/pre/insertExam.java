package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//cafes insert �ۼ��ؼ� ���� ī�� �߰��ϱ�

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
			insertCafes(ps,"���ΰ� ���ִ� ��","����� ���۱� �漮�� 12-25","02-123-0998","��-�� 09:00~21:00");
			insertCafes(ps,"Ŀ�ǰ� ���ִ���","����� ������ �е� 37-12","02-513-1234","�ָ� 09:00~21:00");
			insertCafes(ps,"���� ���� �ִ°�","����� ������  31-32","02-876-3414","��-�� 09:00~21:00, �ָ� 09:00~18:00");
			insertCafes(ps,"�׶󽺰� ���� ��","����� ���α� 23-11","02-834-2344"," �ָ� 09:00~18:00");
			ps.close();*/
			
			Connection con = DriverManager.getConnection(jdbcurl,userName,password);
			String insertSQL = "INSERT INTO book(book_id,title,author,publication_year,isbn,genre,description,price,publication_date,created_date,updated_date,is_available)"
					+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			insertBook(ps,26,"�鼱���� ������ ����","���̹�",2020,"978-3040304034","Fantasy","��",9.99,"2023-10-05","2023-10-01",null,"Y");
			insertBook(ps,27,"����Ƽ���� 1�ް��� �޽�","������",2022,"978-1234506660","Essay","�������� ������ �������ϴ� ����",13.99,"2023-10-03","2023-09-30",null,"Y");
			insertBook(ps,28,"����õ���� �׸��ϱ�","������",2021,"978-3124050394","Essay","�������� �丮 ������",8.99,"2023-09-25","2023-10-03",null,"Y");
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
