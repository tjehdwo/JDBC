package com.kh.MVC.Books;

import java.util.List;

public class BookView {
	
	public void showBookList(List<BookDTO> books) {
		for(BookDTO b : books) {
			System.out.println("책 ID : " + b.getBook_id());
			System.out.println("책이름 : " + b.getTitle());
			System.out.println("작가 이름 : " + b.getAuthor());
			System.out.println("가격 : " + b.getPrice());
			System.out.println("======================");
		}
	}

	public void showTotalPrice(double totalPrice) {
		System.out.println("총 가격 : " + totalPrice);
	}
	
}
