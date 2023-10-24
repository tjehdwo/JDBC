package com.kh.MVC.Books;

import java.util.List;

public class BookView {
	
	public void showBookList(List<BookDTO> books) {
		for(BookDTO b : books) {
			System.out.println("å ID : " + b.getBook_id());
			System.out.println("å�̸� : " + b.getTitle());
			System.out.println("�۰� �̸� : " + b.getAuthor());
			System.out.println("���� : " + b.getPrice());
			System.out.println("======================");
		}
	}

	public void showTotalPrice(double totalPrice) {
		System.out.println("�� ���� : " + totalPrice);
	}
	
}
