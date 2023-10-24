package com.kh.MVC.Books;

import java.util.List;

public class BookController {
	private BookDAO dao;
	
	public BookController(BookDAO dao) {
		this.dao = dao;
	}
	
	public double calculateTotalPrice(List<BookDTO> books) {
		double totalPrice = 0;
		
		for(BookDTO totalP : books) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
	}
	public List<BookDTO> getAllBooks(){
		return dao.getAllBooks();
	}
}
