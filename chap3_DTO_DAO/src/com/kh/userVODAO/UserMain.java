package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		//um.selectAll();
		um.selectScanner();
	}
	public void selectScanner() {
		//1. DB ���� URL, USERNAME, PASSWORD
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		
		try {
			Connection cc = DriverManager.getConnection(jdbcurl, dbUserName, dbPassWord);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("User ID �Է����ּ���.");
				System.out.println("�����ϰ� �ʹٸ� Ư������ ���� [e] �Է�");
				String input = sc.nextLine();
				if("e".equalsIgnoreCase(input)) {
					System.out.println("�����ϰڽ��ϴ�.");
					break; //break�� ������ ������� ���� �����ϰڽ��ϴ� ���� ����
				}
				
				System.out.println("email�� �Է����ּ���.");
				System.out.println("�����ϰ� �ʹٸ� Ư������ ���� [e] �Է�");
				String email = sc.nextLine();
				
				//���࿡ e�� �Է��ߴٸ�
				//if("e" == input || "E" == input ) {
				if("e".equalsIgnoreCase(input)) {
					System.out.println("�����ϰڽ��ϴ�.");
					break; //break�� ������ ������� ���� �����ϰڽ��ϴ� ���� ����
				}
				
				int userId = Integer.parseInt(input);
			 
				//select �� ����ϱ�
				String sql = "SELECT * FROM USERINFO WHERE user_id = ? AND email = ?";
				PreparedStatement st = cc.prepareStatement(sql);
				st.setInt(1, userId);
				st.setString(2, email);
				ResultSet rs = st.executeQuery();
				
				//selectOne if
				if(rs.next()) {
					System.out.println("user ID : " + rs.getInt("user_id"));
					System.out.println("userName : "+ rs.getString("username"));
					System.out.println("E M A I L : "+ rs.getString("email"));
					System.out.println("Registration date : "+ rs.getDate("reg_date"));
					System.out.println();
				}else {
					System.out.println("User�� ã�� �� �����ϴ�.");
					System.out.println();
				}
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectAll() {
		//1. DB ���� URL, USERNAME, PASSWORD
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcurl,dbUserName,dbPassWord);
			UserDAO userDAO = new UserDAO(connection);
			
			List<UserVO> users = userDAO.getAllUsers();
			
			for(UserVO u : users) {
				System.out.println("User ID: " + u.getUserId());
				System.out.println("User Name : " + u.getUserName());
				System.out.println("User Email : " + u.getEmail());
				System.out.println("Registration Date : " + u.getRegDate());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertRun() {
		//1. DB ���� URL, USERNAME, PASSWORD
				String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
				String dbUserName = "khcafe";
				String dbPassWord = "kh1234";
			
		try {
			Connection connection = DriverManager.getConnection(jdbcurl,dbUserName,dbPassWord);
			UserDAO	userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("User ID : ");
			int userId = sc.nextInt();
			
			System.out.println("���̵� �Է� ���ּ��� : ");
			String userName = sc.next();
			
			System.out.println("ȸ�������� ���Ǵ� �������ϴ�.");
			System.out.println("���������� �̸��� �ۼ����ּ���.");
			String email = sc.next();
			
			Date regDate = new Date(); //���� ��¥�� �ð��� ����Ѵٴ� �ǹ�
			
			//DB�� ��� ���� �ν��Ͻ� ���� �� �ۼ����� ���� �����ϱ�
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			//�����Ͱ� ���������� ������ Ȯ�� boolean�� ����ؼ� Ȯ��
			
			if(userDao.createUser(newUser)) {//true
				System.out.println("������ ���������� ��ϵǾ����ϴ�.");
			}else {
				System.out.println("���� ��Ͽ� �����Ͽ����ϴ�.");
			}
			//���� �ݱ�
			connection.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
