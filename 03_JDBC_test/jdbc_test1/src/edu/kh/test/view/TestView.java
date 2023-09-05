package edu.kh.test.view;

import java.util.Scanner;

import edu.kh.test.model.dto.ShopMember;
import edu.kh.test.model.service.ShopService;

public class TestView {
	
	private Scanner sc = new Scanner(System.in);
	private ShopService service = new ShopService();
	
	
	public void selectMember() {
		System.out.print("ID 입력 : ");
		String memberId = sc.next();
		
		ShopMember sm = service.selectMember(memberId);
		
		System.out.println(sm);
		
	}
	
	
}


