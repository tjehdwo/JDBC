package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.sql.DATE;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "kh1234";
	
	public void insertCafe(String name,String address,String phoneNumber,String operatingHours) {
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("연결 성공!");
			String sql = "INSERT INTO CAFES(name,address,phone_number,operating_hours)"
			+"VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phoneNumber);
			ps.setString(4, operatingHours);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void UpdateCafe(/*매개변수 추가하기*/String operatingHours,int cafeId) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE cafes SET operating_hours = ? WHERE cafe_id = ?";
			PreparedStatement ps1 = con.prepareStatement(sql);
			ps1.setString(1, operatingHours);
			ps1.setInt(2, cafeId);
			ps1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void UpdateMenu(String description,int menuId,int cafeId) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE menu SET description = ? WHERE menu_id =? AND cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, description);
			st.setInt(2, menuId);
			st.setInt(3, cafeId);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void DeleteCafe(int cafeId) {
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			String sql = "DELETE FROM CAFES WHERE cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cafeId);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteMenu(/*파라미터(매개변수) 추가*/int menuId) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM MENU WHERE menu_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, menuId);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteOrders(int orderId) {
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			String sql = "DELETE FROM ORDERS WHERE ORDER_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, orderId);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
