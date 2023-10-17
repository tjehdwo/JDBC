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
			selectKhcafe();
	}
	static void selectBank() {
		
		// 1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 2. ����Ŭ �� ��ǻ�� ���� : ������ ���̽� ���� ����
		//                               ����IP�ּ�:port��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khabank";
		String password = "kh1234";
		Connection con = null;
		try {
			// ������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
			
			//SELECT ����
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			// result.next() : result ��ü���� ���� ��(row)���� �̵�
			// �������� ������ true ��ȯ,�׷��� ������ false
			
			while(result.next()) {
				// khbank�� �ִ� bank ���̺� ������տ��� account_id�� ������
				int accountID = result.getInt("account_id");
				// �Բ��غ��� : accountNumber
				String accountNumber = result.getString("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2. �Բ��غ��� : branchName
				String branchName = result.getString("branch_name");
				//3. java.sql import Date lastTransactionDate ��������
				Date lastTransactionDate = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + accountID + "  ACCOUNT_NAME : " + accountName + "  balance : " + balance + "  ACCOUNT_NUMBER : " + accountNumber + "  BRANCHNAME : " + branchName + "  LAST_TRANSACTION_DATE : " + lastTransactionDate);
				
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
			System.out.println("�����ͺ��̽� ���� ����!");
			//select * from menu �ۼ��ؼ� menu table ��������
			String selectQuery = "SELECT * FROM MENU WHERE DESCRIPTION LIKE '%��¥%' ORDER BY PRICE DESC";
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
}
