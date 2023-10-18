package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class cafePractice {

	public static void main(String[] args) {
		/*selectAll();
		selectMenu();
		insertCafe();
		updatePrice();
		deleteCafeInfo();
		!countMenu();*/
		selectMenuP();
	}
		static void selectAll() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "kh1234";
	
		try {
			Connection con = DriverManager.getConnection(jdbcUrl,userName,password);
			String selectQuery = "SELECT * FROM CAFES";
			PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
			ResultSet result = preparedStatement.executeQuery();
			/*Statement st1 = con.createStatement();
			ResultSet result1 = st1.executeQuery();*/
			while(result.next()) {
				int cafeID = result.getInt("cafe_id");
				String cafeName = result.getString("cname");
				String address = result.getString("address");
				String pNumber = result.getString("phone_number");
				String operatingH = result.getString("operating_hours");
				
				System.out.println("CAFE_ID : " + cafeID + " CNAME : " + cafeName + " ADDRESS : " + address + " PHONE_NUMBER : " +pNumber + " OPERATING_HOURS : " + operatingH);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
			}
			
			}
		
		static void selectMenu() {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "khcafe";
			String password = "kh1234";
			try {
				Connection con = DriverManager.getConnection(jdbcUrl,userName,password);
				String selectQuery = "SELECT M.MENU_NAME,C.CNAME FROM MENU M JOIN CAFES C ON M.MENU_ID = C.CAFE_ID WHERE MENU_NAME = ?";
				PreparedStatement selectStatement = con.prepareStatement(selectQuery);
				
				String targetMN = "핫초코";
				selectStatement.setString(1, targetMN);
				
				ResultSet result = selectStatement.executeQuery();
				
				while(result.next()) {
					
					String cafeName = result.getString("cname");
					/*int cafeID = result.getInt("cafe_id");
					String address = result.getString("address");
					String pNumber = result.getString("phone_number");
					String operatingH = result.getString("operating_hours");*/
					
					System.out.println(" CNAME : " + cafeName);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		static void insertCafe() {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "khcafe";
			String password = "kh1234";
			try {
				Connection con = DriverManager.getConnection(jdbcUrl,userName,password);
				String insertQuery = "INSERT INTO CAFES(cafe_id,cname,address,phone_number,operating_hours)"+
				"VALUES(?,?,?,?,?)";
				PreparedStatement insertState = con.prepareStatement(insertQuery);
				insertState.setInt(1, 32);
				insertState.setString(2, "루프탑이 있는 카페");
				insertState.setString(3, "서울 동작구 흑석동");
				insertState.setString(4, "02-511-5044");
				insertState.setString(5, "매일 09:00~21:00");
				
				int rowsInsert = insertState.executeUpdate();
				System.out.println(rowsInsert + "row 추가됨");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		static void updatePrice() {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "khcafe";
			String password = "kh1234";
			try {
			Connection con = DriverManager.getConnection(jdbcUrl,userName,password);
			String updateQuery = "UPDATE MENU SET PRICE = ? WHERE CAFE_ID = ?";
			PreparedStatement updatePs = con.prepareStatement(updateQuery);
			updatePs.setDouble(1, 5.5);
			updatePs.setInt(2, 2);
			int rowsUpdate = updatePs.executeUpdate();
			System.out.println(rowsUpdate + "업데이트 되었습니다.");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
   }
		
		static void deleteCafeInfo() {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "khcafe";
			String password = "kh1234";
			try {
			Connection con = DriverManager.getConnection(jdbcUrl,userName,password);
			String deleteQuery = "DELETE FROM CAFES WHERE CAFE_ID = ?";
			PreparedStatement deletePs = con.prepareStatement(deleteQuery);
			deletePs.setInt(1, 20);
			int rowsDelete = deletePs.executeUpdate();
			System.out.println(rowsDelete + " 삭제되었습니다.");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}
		
		static void countMenu() {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "khcafe";
			String password = "kh1234";
			try {
			Connection con = DriverManager.getConnection(jdbcUrl,userName,password);
			String selectQuery = "SELECT SUM() FROM MENU WHERE CAFE_ID = ?";
			PreparedStatement selectPs = con.prepareStatement(selectQuery);
			selectPs.setInt(1, 2);
			ResultSet result = selectPs.executeQuery();
			
			while(result.next()) {
				
				int menuID = result.getInt("menu_id");
				System.out.println(" MENU_ID" + menuID);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

		}

		static void selectMenuP() {
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "khcafe";
			String password = "kh1234";
			try {
			Connection con = DriverManager.getConnection(jdbcUrl,userName,password);
			String selectQuery = "SELECT * FROM MENU WHERE PRICE BETWEEN ? AND ?";
			PreparedStatement selectPs = con.prepareStatement(selectQuery);
			selectPs.setDouble(1,3.0);
			selectPs.setDouble(2, 5.5);
			
			int rowsSelect = selectPs.executeUpdate();
			System.out.println(rowsSelect + "개의 행이 조회되었습니다.");
			
			ResultSet result = selectPs.executeQuery();
			
			while(result.next()) {
				
				String menuName = result.getString("menu_name");
				double price = result.getDouble("price");
				
				System.out.println("menu_name : " + menuName + "  price : " + price);
			}
			
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
}

