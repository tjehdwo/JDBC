package com.kh.MVC.orders;

import java.util.List;

public class OrderView {
	
	public void showOrderList(List<OrderDTO> orders) {
		for(OrderDTO o : orders) {
			System.out.println("주문 발생 카페 ID : " + o.getCafe_id());
			System.out.println("주문한 메뉴 ID : " + o.getMenu_id());
			System.out.println("총 가격 : " + o.getTotal_price());
			System.out.println("주문 수량 : " + o.getQuantity());
			System.out.println("===============");
		}
	}

	public void showTotalPrice(double totalPrice) {
		System.out.println("총 가격 : " + totalPrice);
	}
}
