package com.kh.MVC.orders;

import java.util.List;

public class OrderController {
	private OrderDAO dao;
	
	public OrderController(OrderDAO dao) {
		this.dao = dao;
	}
	
	
	public double calculateTotalPrice(List<OrderDTO> orders) {
		double totalPrice = 0;
		
		
		for(OrderDTO totalP : orders) {
			totalPrice += totalP.getTotal_price();		
	}
	return totalPrice;
	}
	
	public List<OrderDTO> getAllOrders(){
		return dao.getAllOrders(3);
	}
}
