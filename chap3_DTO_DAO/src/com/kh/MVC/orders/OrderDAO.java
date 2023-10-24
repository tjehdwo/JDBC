package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "kh1234";
	
	public OrderDAO() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<OrderDTO> getAllOrders(int cafeId){
		List<OrderDTO> orders = new ArrayList<>();
		
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM ORDERS WHERE cafe_id = ?");
			st.setInt(1,cafeId);
			int rowsSelect = st.executeUpdate();
			System.out.println(rowsSelect + "개의 행이 조회되었습니다.");
			
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				int order_id = rs.getInt("order_id");
				int cafe_id = rs.getInt("cafe_id");
				int menu_id = rs.getInt("menu_id");
				String order_date = rs.getString("order_date");
				double total_price = rs.getDouble("total_price");
				int quantity = rs.getInt("quantity");
				
				OrderDTO order = new OrderDTO(order_id,cafe_id,menu_id,order_date,total_price,quantity);
				orders.add(order);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}
	
	
}
