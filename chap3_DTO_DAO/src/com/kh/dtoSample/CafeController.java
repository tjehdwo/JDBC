package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

// model�� view �������ִ� �߰� �ٸ�
public class CafeController {
	//�ʵ�
	private CafeModel model; //�� �������
	private CafeView view; //�� �������
	
	// �Ķ���͸� �ۼ��� ������
	public CafeController(Connection con, CafeView view) {
		this.model = new CafeModel(con);
		this.view = view;
	}
	
	//��� �޼ҵ�
	public void displayALLCafeS() {
		List<CafeDTO> cafes = model.getCafes();
		view.diplayCafes(cafes);
	}
}