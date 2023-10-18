package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookExam {

    public static void main(String[] args) {
        // �����ͺ��̽� ���� �Ű� ����
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "khcafe";
        String password = "kh1234";

        try {

            // �����ͺ��̽� ���� ����
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String insertQuery = "INSERT INTO book (book_id, title, author, publication_year, isbn, genre, description, price, publication_date, updated_date, is_available) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // �Ķ���Ϳ� ���� ���� ����
            preparedStatement.setInt(1, 50); // book_id
            preparedStatement.setString(2, "������ KH"); // title
            preparedStatement.setString(3, "F. Scott Fitzgerald"); // author
            preparedStatement.setInt(4, 1925); // publication_year
            preparedStatement.setString(5, "978-0743273565"); // isbn
            preparedStatement.setString(6, "�Ҽ�"); // genre
            preparedStatement.setString(7, "���߰� ���������� �̾߱��Դϴ�."); // description
            preparedStatement.setDouble(8, 12.99); // price

            // publication_date�� ���� �м��ϰ� ����
            Date publicationDate = Date.valueOf("1936-01-01");
            preparedStatement.setDate(9, new Date(publicationDate.getTime()));

            preparedStatement.setNull(10, java.sql.Types.DATE); // updated_date (NULL�� ����)
            preparedStatement.setString(11, "Y"); // is_available

            // ���� �� ����
            preparedStatement.executeUpdate();

            // PreparedStatement �� ���� �ݱ�
            preparedStatement.close();
            connection.close();

            System.out.println("å insert ����");
        } catch ( SQLException  e) {
            e.printStackTrace();
        }
    }
}