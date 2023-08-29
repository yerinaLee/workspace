package practice.yrn.local.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import practice.yrn.local.model.dto.Local;
import practice.yrn.local.model.service.LocalService;

public class LocalView {

	private Scanner sc = new Scanner(System.in);
	private LocalService service = new LocalService();

	
	/**
	 * 메뉴 출력용 view 메서드
	 */
	public void displayMenu() {
		
		
		int input = 0;
		
		do {
		
			try {
			System.out.println();
			System.out.println("#_한국_지역_서치_프로그램\n");
			System.out.println("▼▼▼▼ 로컬인의 지식충전 ▼▼▼▼");
			System.out.println("#1_전체 지역 정보 조회");
			System.out.println("#2_선택 지역 정보 조회");
			System.out.println("#3_선택 지역 지역번호 조회");
			System.out.println("#4_가까운 지역 조회");
			
//			System.out.println("\n▼▼▼▼ 떠나볼까? ▼▼▼▼");
//			System.out.println("#5_선택 지역 명소 조회");
//			System.out.println("#6_선택 테마 명소 조회");
//			System.out.println("#7_내가 찾은 지역 명소 추가");
//	
//			System.out.println("\n▼▼▼▼ !!!! ▼▼▼▼");
//			System.out.println("#8_선택 지역 최신 뉴스");
			System.out.println("\n#0_ByeByeBye");
			
			
			System.out.print("\n메뉴 선택 : ");
			input = sc.nextInt();
			
			
			switch(input) {
			case 1 : searchAll(); break;
			case 2 : select(); break;
			case 3 : selectLocalNumber(); break;
			case 4 : break;
//			case 5 : break;
//			case 6 : break;
//			case 7 : break;
//			case 8 : break;
			
			case 0 : System.out.println("프로그램 종료 뾰로롱!"); break;
			default : System.out.println("메뉴를 다시 선택해주세요!");
			}
			
			} catch (InputMismatchException e) {
				System.out.println("메뉴를 0~8까지의 숫자로 입력해주세요!");
				sc.nextLine();
			}
		
		} while( input != 0 );
	}
	

	
	/**
	 * 전체 지역 정보 조회 view 메서드
	 */
	private void searchAll() {
		
		System.out.println("\n#_전체 지역 정보 조회\n");
		
		
		
		List<Local> localList = service.searchAll();
		int count = 0;
		
		for ( Local l : localList) {
			System.out.println("["+ ++count +"] " + l);
			System.out.println();
		}
	}
	
	
	/**
	 * 선택 지역 정보 조회 view
	 */
	private void select() {
		System.out.println("\n#_선택 지역 정보 조회\n");
		
		System.out.print("찾으실 지역명을 작성해주세요 : ");
		String name = sc.next();
		
		Local selectLocal = service.select(name);
		
		if(selectLocal == null) {
			System.out.println("찾으시는 지역이 없습니다.");
		} else {
			System.out.println(selectLocal);
		}
	}
	
	
	/**
	 * 선택 지역 지역 번호 조회 view
	 */
	private void selectLocalNumber() {
		System.out.println("\n#_선택 지역 정보 조회\n");
		
		System.out.print("지역번호를 찾을 지역명을 작성해주세요 : ");
		String name = sc.next();
		
		Local selectLocal = service.select(name);
		
		if(selectLocal == null) {
			System.out.println("찾으시는 지역이 없습니다.");
		} else {
			System.out.println(selectLocal.getLocalNumber());
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
