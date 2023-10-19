package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel 이라는 클래스를 가지고 오기 위해 멤버변수로 카페 모델을 추가함
	public cafeModel model;
	
	//model 매개변수를 받을 수 있는 생성자를 만들어줘야함
	public cafeView(cafeModel model) {
		this.model = model;
	}
	//name,address,phoneNumber,operatingHours
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요.");
		
		System.out.println("상호명 : ");
		String name = sc.nextLine();
		
		System.out.println("카페 주소 : ");
		String address = sc.nextLine();
		
		System.out.println("카페 연락처 : ");
		String phoneNumber = sc.nextLine();
		
		System.out.println("카페 영업 시간 : ");
		String operatingHours = sc.nextLine();
		
		//카페 모델에서 insertCafe 라는 메서드를 가지고 와야함
		model.insertCafe(name, address, phoneNumber, operatingHours);
		System.out.println("카페가 성공적으로 추가되었습니다.");
	}
	
	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("영업 시간을 업데이트하세요.");
		
		System.out.print("카페 ID : ");
		int cafeId = sc.nextInt();
		
		System.out.print("수정할 영업 시간 : ");
		String operatingHours = sc.next();
		
		model.UpdateCafe(operatingHours, cafeId);
		System.out.println("카페 영업 시간이 변경되었습니다.");
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트하세요.");
		
		System.out.print("수정할 메뉴 설명 : ");
		String description = sc.nextLine();
		
		
		System.out.print("메뉴 ID : ");
		int menuId = sc.nextInt();
		
		System.out.print("카페 ID : ");
		int cafeId = sc.nextInt();
		
		//모델에 있는 updateMenu를 가지고와서 사용자가 작성한 수정 내용 추가하기
		model.UpdateMenu(description, menuId, cafeId);
		System.out.println("메뉴 설명이 업데이트 되었습니다.");
		
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삭제할 카페 ID를 입력하세요.");
		
		System.out.print("카페 ID : ");
		int cafeId = Integer.parseInt(sc.nextLine());
		//int cafedId_other = sc.nextInt();
		
		model.DeleteCafe(cafeId);
		System.out.println("카페가 삭제되었습니다.");
		
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 메뉴 ID를 입력하세요.");
		
		System.out.print("메뉴 ID : ");
		int menuId = Integer.parseInt(sc.nextLine());
		
		model.deleteMenu(menuId);
		System.out.println("메뉴가 삭제되었습니다.");
		
		
	}

	public void deleteOrders() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 ORDERS의 ID를 입력하세요.");
		
		System.out.println("ORDERS ID : ");
		int orderId = Integer.parseInt(sc.nextLine());
		
		model.deleteOrders(orderId);
		System.out.println("ORDERS가 성공적으로 삭제되었습니다.");
	}
}
