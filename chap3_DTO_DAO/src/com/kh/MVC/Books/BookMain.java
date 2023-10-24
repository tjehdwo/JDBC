package com.kh.MVC.Books;

import java.util.List;

public class BookMain {
	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		BookController controller = new BookController(dao);
		BookView view = new BookView();
		
		List<BookDTO> books = controller.getAllBooks();
		view.showBookList(books);
		
		double totalPrice = controller.calculateTotalPrice(books);
		view.showTotalPrice(totalPrice);
		
	}

}
