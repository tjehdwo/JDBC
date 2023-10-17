package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {	
			//selectBank();
			//selectKhcafe();
			selectIf();
	}
	static void selectBank() {
		
		// 1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 2. 오라클 내 컴퓨터 연결 : 데이터 베이스 연결 정보
		//                               나의IP주소:port번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khabank";
		String password = "kh1234";
		Connection con = null;
		try {
			// 연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			
			//SELECT 쿼리
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			// result.next() : result 객체에서 다음 행(row)으로 이동
			// 다음행이 있으면 true 반환,그렇지 않으면 false
			
			while(result.next()) {
				// khbank에 있는 bank 테이블 결과집합에서 account_id를 가져옴
				int accountID = result.getInt("account_id");
				// 함께해보기 : accountNumber
				String accountNumber = result.getString("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2. 함께해보기 : branchName
				String branchName = result.getString("branch_name");
				//3. java.sql import Date lastTransactionDate 가져오기
				Date lastTransactionDate = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + accountID + "  ACCOUNT_NAME : " + accountName + 
						"  balance : " + balance + "  ACCOUNT_NUMBER : " + accountNumber + "  BRANCHNAME : "
						+ branchName + "  LAST_TRANSACTION_DATE : " + lastTransactionDate);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	static void selectKhcafe() {	
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			//select * from menu 작성해서 menu table 가져오기
			String selectQuery = "SELECT * FROM MENU WHERE DESCRIPTION LIKE '%진짜%' ORDER BY PRICE DESC";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				int menuID = result.getInt("menu_id");
				int cafeID = result.getInt("cafe_id");
				String menuName = result.getString("menu_name");
				double price = result.getDouble("price");
				String description = result.getString("description");
				
				System.out.println("MENU_ID : " + menuID + "  CAFE_ID : " + cafeID + "  MENU_NAME : " + menuName + "  PRICE : " + price + "  DESCRIPTION : " + description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	static void selectIf() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khabank";
		String password = "kh1234";
		Connection con = null;
	
	try {
		con = DriverManager.getConnection(url, user, password);
		System.out.println("연결 성공");
		/*where절 사용하여 조건추가
		String selectQuery = "SELECT * FROM BANK WHERE account_id in (?,?)";
		String selectQuery = "SELECT * FROM BANK WHERE account_number in (?,?)";
		PreparedStatement selectState = con.prepareStatement(selectQuery);
		String[] targetAN = {"110-449-067680","110-332-405955"};
		selectState.setString(1, targetAN[0]);
		selectState.setString(2, targetAN[1]);
		ResultSet result = selectState.executeQuery();
		
		String selectQuery = "SELECT * FROM BANK WHERE account_name in (?,?)";
		PreparedStatement selectState = con.prepareStatement(selectQuery);
		String[] targetAN = {"김유민","김철준"};
		selectState.setString(1,targetAN[0]);
		selectState.setString(2,targetAN[1]);
		ResultSet result = selectState.executeQuery();*/
		
		String selectQuery = "SELECT * FROM BANK WHERE balance in (?,?)";
		PreparedStatement selectState = con.prepareStatement(selectQuery);
		String[] targetB = {"5500.00","3300.00"};
		selectState.setString(1,targetB[0]);
		selectState.setString(2,targetB[1]);
		ResultSet result = selectState.executeQuery();//주석
		
		if (!result.isBeforeFirst()) {
			System.out.println("존재하는 데이터가 없습니다.");
		}
		
		 while(result.next()) {
			int a = result.getInt("account_id");
			String b = result.getString("account_number");
			String c = result.getString("account_name");
			double d = result.getDouble("balance");
			String e = result.getString("branch_name");
			Date f = result.getDate("last_transaction_date");
			System.out.println("ACCOUNT_ID : " + a + "  ACCOUNT_NUMBER : " + b +"  ACCOUNT_NAME : " + c + "  BALANCE : " + d + "  BRANCH_NAME : " + e+ "  LAST_TRANSACTION_DATE : " + f);
		 }
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}
		
		
	

