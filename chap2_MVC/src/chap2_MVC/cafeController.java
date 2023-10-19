package chap2_MVC;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//모델과 뷰를 가지고올 생성자
	public cafeController(cafeModel model,cafeView view) {
		this.model = model;
		this.view = view;
	}
	//run
	public void run() {
		boolean isTrue = true;
		while(isTrue) {
		Scanner sc = new Scanner(System.in);
		//선택할 번호 출력 메서드로 입력
		System.out.println("1. 카페 정보 추가");
		System.out.println("2. 메뉴 설명 업데이트");
		System.out.println("3.카페 영업시간 수정");
		System.out.println("4.카페 정보 삭제");
		System.out.println("5.메뉴 정보 삭제");
		System.out.println("6.종료.");
		System.out.println("원하는 직업을 선택해주세요.");
		
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
			System.out.println("프로그램을 종료합니다.");
			isTrue = false;
			break;
		default:
			System.out.println("잘못된 번호 입니다.");
		
		}
	}

 }
}
