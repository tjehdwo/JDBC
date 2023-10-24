package com.kh.MVC.Books;
/*BOOK_ID
TITLE
AUTHOR
PUBLICATION_YEAR
ISBN
GENRE
DESCRIPTION
PRICE
PUBLICATION_DATE
CREATED_DATE
UPDATED_DATE
IS_AVAILABLE*/
public class BookDTO {
	private int book_id;
	private String title;
	private String author;
	private String publication_year;
	private String isbn;
	private String genre;
	private String description;
	private double price;
	private String publication_date;
	private String created_date;
	private String updated_date;
	private String is_available;
	
	
	
	public BookDTO(int book_id, String title, String author, String publication_year,
			String isbn, String genre,String description, double price, 
			String publication_date, String created_date, String updated_date,
			String is_available) {
	this.book_id = book_id;
	this.title = title;
	this.author = author;
	this.publication_year = publication_year;
	this.isbn = isbn;
	this.genre = genre;
	this.description = description;
	this.price = price;
	this.publication_date = publication_date;
	this.created_date = created_date;
	this.updated_date = updated_date;
	this.is_available = is_available;
	
	
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublication_year() {
		return publication_year;
	}
	public void setPublication_year(String publication_year) {
		this.publication_year = publication_year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}
	public String getIs_available() {
		return is_available;
	}
	public void setIs_available(String is_available) {
		this.is_available = is_available;
	}

}
