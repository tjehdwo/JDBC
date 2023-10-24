package com.kh.MVC.orders;

import java.util.List;

public class OrderView {
	
	public void showOrderList(List<OrderDTO> orders) {
		for(OrderDTO o : orders) {
			System.out.println("�ֹ� �߻� ī�� ID : " + o.getCafe_id());
			System.out.println("�ֹ��� �޴� ID : " + o.getMenu_id());
			System.out.println("�� ���� : " + o.getTotal_price());
			System.out.println("�ֹ� ���� : " + o.getQuantity());
			System.out.println("===============");
		}
	}

	public void showTotalPrice(double totalPrice) {
		System.out.println("�� ���� : " + totalPrice);
	}
}
