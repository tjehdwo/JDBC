package chap2_MVC;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//�𵨰� �並 ������� ������
	public cafeController(cafeModel model,cafeView view) {
		this.model = model;
		this.view = view;
	}
	//run
	public void run() {
		boolean isTrue = true;
		while(isTrue) {
		Scanner sc = new Scanner(System.in);
		//������ ��ȣ ��� �޼���� �Է�
		System.out.println("1. ī�� ���� �߰�");
		System.out.println("2. �޴� ���� ������Ʈ");
		System.out.println("3.ī�� �����ð� ����");
		System.out.println("4.ī�� ���� ����");
		System.out.println("5.�޴� ���� ����");
		System.out.println("6.����.");
		System.out.println("���ϴ� ������ �������ּ���.");
		
		int choice = sc.nextInt(); 
		switch (choice) {
		case 1:
			view.addCafeName();
			isTrue = false;
			break;
		case 2:
			view.updateMenu();
			isTrue = false;
			break;
		case 3:
			view.updateCafe();
			isTrue = false;
			break;
		case 4:
			view.deleteCafe();
			isTrue = false;
			break;
		case 5:
			view.deleteMenu();
			isTrue = false;
			break;
		case 6:
			System.out.println("���α׷��� �����մϴ�.");
			isTrue = false;
			break;
		default:
			System.out.println("�߸��� ��ȣ �Դϴ�.");
		
		}
	}

 }
}
