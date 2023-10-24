package com.kh.MVC.orders;
/*
 * ORDER_ID 
CAFE_ID
MENU_ID
ORDER_DATE
TOTAL_PRICE
QUANTITY
 * */
public class OrderDTO {
	private int order_id;
	private int cafe_id;
	private int menu_id;
	private String order_date;
	private double total_price;
	private int quantity;
	
	public OrderDTO(int order_id, int cafe_id, int menu_id, String order_date, double total_price, int quantity) {
		this.order_id = order_id;
		this.cafe_id = cafe_id;
		this.menu_id = menu_id;
		this.order_date = order_date;
		this.total_price = total_price;
		this.quantity = quantity;
	}

	public int getOrder_id() {
		return order_id;
	}
	public int getCafe_id() {
		return cafe_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public double getTotal_price() {
		return total_price;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public void setCafe_id(int cafe_id) {
		this.cafe_id = cafe_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
