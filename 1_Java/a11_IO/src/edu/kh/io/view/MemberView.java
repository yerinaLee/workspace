package edu.kh.io.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.io.model.dto.Member;
import edu.kh.io.model.service.MemberService;

public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	// MemberService 객체 생성
	private MemberService service = new MemberService();

	/**
	 * 메뉴 출력 view
	 */
	public void displayMenu() {
		
		int input = 0;
		
		do {
			
			try {
				System.out.println();
				System.out.println("\n------ 회원 관리 프로그램 ------\n");
				
				System.out.println("1. 회원 목록 조회");
				System.out.println("2. 회원 가입");
				System.out.println("3. 아이디/비밀번호 일치하는 회원 조회");
				System.out.println("4. 아이디/비밀번호 일치하는 회원의 비밀번호 변경");
				System.out.println("5. 아이디/비밀번호 일치하는 회원의 탈퇴");
				System.out.println("0. 종료");

				System.out.print("메뉴 선택 :::::  ");
				input = sc.nextInt();
				
				switch(input) {
				case 1: selectAll(); break;
				case 2: signUp(); break;
				case 3: selectOne(); break;
				case 4: changePw(); break;
				case 5: withdrawal(); break;
				case 0: System.out.println("<프로그램이 종료됩니다>"); break;
				default : System.out.println("<메뉴의 번호만 입력해주세요>");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				input = -1; // 첫번째 반복에서 예외 발생시 while문 종료 방지
				sc.nextLine(); // 입력 버퍼에 잘못 입력된 문자열 제거
			} 
			
		} while (input != 0);
	}
	
	
	/**
	 * 회원 목록 조회 view 메서드
	 */
	private void selectAll() {
		System.out.println("\n----- 회원 목록 조회 -----\n");

		// Service로부터 회원 목록을 반환 받아서 모두 출력
		List<Member> memberList = service.selectAll();
		
		// 회원 목록이 비어있을 경우 == 회원이 없는 경우
		// == memberList.txt 파일이 없어서 읽어온 회원 목록이 없는 경우
		if(memberList.isEmpty()) {
			System.out.println("=== 회원이 존재하지 않습니다 ===");
			return;
		}
		
		// 회원이 있을 경우 향상된 for문으로 모두 출력
		for( Member mem : memberList )		System.out.println(mem);
	}
	
	
	/**
	 * 회원 가입 view 메서드
	 */
	private void signUp(){
		System.out.println("\n----- 회원 가입 -----\n");
		
		System.out.print("* ID : ");
		String id = sc.next();
		
		System.out.print("* PW : ");
		String pw = sc.next();

		System.out.print("* 이름 : ");
		String name = sc.next();

		System.out.print("* 포인트 : ");
		int point = sc.nextInt();
		
		// 입력 받은 값을 서비스로 전달 후
		// 회원가입(memberList에 추가) 성공 시 true, 
		// 아이디가 중복이면 false 반환
		boolean result = service.signUp(id, pw, name, point);
		
		if(result) {
			System.out.println(id + " 회원이 가입 되었습니다");			
		} else {
			System.out.println("!!이미 사용중인 아이디입니다!!");
		}
		
	}
	
	
	/**
	 * id/pw 일치 회원 조회 view
	 */
	private void selectOne() {
		System.out.println("\n----- 아이디/비밀번호 일치하는 회원 조회 -----\n");
		
		System.out.print("ID : ");
		String id = sc.next();

		System.out.print("PW : ");
		String pw = sc.next();
		
		// 입력받은 값을 서비스로 전달하여
		// 일치하는 회원(Member)반환, 없으면 null 반환
		Member mem = service.selectOne(id, pw);
		
		if(mem == null) {
			System.out.println("일치하는 회원이 없습니다.");
		} else {
			System.out.println("ID : " + mem.getId());
			System.out.println("PW : " + mem.getPw());
			System.out.println("이름 : " + mem.getName());
			System.out.println("포인트 : " + mem.getPoint());
		}
	}
	
	
	
	/**
	 * id/pw 일치 회원 조회 후 비밀번호 변경 view
	 */
	private void changePw() {
		System.out.println("\n----- 아이디/비밀번호 일치하는 회원 비밀번호 변경 -----\n");
		
		System.out.print("ID : ");
		String id = sc.next();

		System.out.print("PW : ");
		String pw = sc.next();
		
		Member mem = service.selectOne(id, pw);
		
		if(mem == null) {
			System.out.println("일치하는 회원이 없습니다.");
		}
		
		System.out.print("변경 후 PW : ");
		String newPw = sc.next();
		
		System.out.print("PW 확인 : ");
		String newPw2 = sc.next();
		
		boolean result = service.changePw(mem, newPw, newPw2);
//		-> 둘의 패스워드가 일치하면 변경 ㄱ, 일치하지 않으면 다시 입력
		
		if(result) { // 패스워드 일치, 패스워드 변경
			System.out.println("비밀번호가 변경되었습니다.");
		} else {
			System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
		}
		
	}
	
	
	
	/**
	 * id/pw 일치 회원 조회 후 탈퇴 view
	 */
	private void withdrawal() {
		System.out.println("\n----- 아이디/비밀번호 일치하는 회원 탈퇴 -----\n");
		
		System.out.print("ID : ");
		String id = sc.next();

		System.out.print("PW : ");
		String pw = sc.next();
		
		Member mem = service.selectOne(id, pw);
		
		if(mem == null) {
			System.out.println("일치하는 회원이 없습니다.");
		}
		
		System.out.print(mem.getName() + " 회원님 정말 탈퇴하십니까? Y/N : ");
		char yn = sc.next().toUpperCase().charAt(0);
		
		if(yn == 'Y') {
//			탈퇴 ㄱ
			
			Boolean result = service.withdrawal(mem);
			if(result) System.out.println("탈퇴가 완료되었습니다.");
			
		} else if (yn == 'N') {
			return;
		} else
			System.out.println("잘못된 문자를 입력하셨습니다.");
			return;
	}
	
	
	
	
}
