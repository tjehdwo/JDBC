package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel �̶�� Ŭ������ ������ ���� ���� ��������� ī�� ���� �߰���
	public cafeModel model;
	
	//model �Ű������� ���� �� �ִ� �����ڸ� ����������
	public cafeView(cafeModel model) {
		this.model = model;
	}
	//name,address,phoneNumber,operatingHours
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ �Է��ϼ���.");
		
		System.out.println("��ȣ�� : ");
		String name = sc.nextLine();
		
		System.out.println("ī�� �ּ� : ");
		String address = sc.nextLine();
		
		System.out.println("ī�� ����ó : ");
		String phoneNumber = sc.nextLine();
		
		System.out.println("ī�� ���� �ð� : ");
		String operatingHours = sc.nextLine();
		
		//ī�� �𵨿��� insertCafe ��� �޼��带 ������ �;���
		model.insertCafe(name, address, phoneNumber, operatingHours);
		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");
	}
	
	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �ð��� ������Ʈ�ϼ���.");
		
		System.out.print("ī�� ID : ");
		int cafeId = sc.nextInt();
		
		System.out.print("������ ���� �ð� : ");
		String operatingHours = sc.next();
		
		model.UpdateCafe(operatingHours, cafeId);
		System.out.println("ī�� ���� �ð��� ����Ǿ����ϴ�.");
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ�ϼ���.");
		
		System.out.print("������ �޴� ���� : ");
		String description = sc.nextLine();
		
		
		System.out.print("�޴� ID : ");
		int menuId = sc.nextInt();
		
		System.out.print("ī�� ID : ");
		int cafeId = sc.nextInt();
		
		//�𵨿� �ִ� updateMenu�� ������ͼ� ����ڰ� �ۼ��� ���� ���� �߰��ϱ�
		model.UpdateMenu(description, menuId, cafeId);
		System.out.println("�޴� ������ ������Ʈ �Ǿ����ϴ�.");
		
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ ī�� ID�� �Է��ϼ���.");
		
		System.out.print("ī�� ID : ");
		int cafeId = Integer.parseInt(sc.nextLine());
		//int cafedId_other = sc.nextInt();
		
		model.DeleteCafe(cafeId);
		System.out.println("ī�䰡 �����Ǿ����ϴ�.");
		
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �޴� ID�� �Է��ϼ���.");
		
		System.out.print("�޴� ID : ");
		int menuId = Integer.parseInt(sc.nextLine());
		
		model.deleteMenu(menuId);
		System.out.println("�޴��� �����Ǿ����ϴ�.");
		
		
	}

	public void deleteOrders() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ORDERS�� ID�� �Է��ϼ���.");
		
		System.out.println("ORDERS ID : ");
		int orderId = Integer.parseInt(sc.nextLine());
		
		model.deleteOrders(orderId);
		System.out.println("ORDERS�� ���������� �����Ǿ����ϴ�.");
	}
}
