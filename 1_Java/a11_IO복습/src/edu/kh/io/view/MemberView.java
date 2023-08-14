package edu.kh.io.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.io.model.dto.Member;
import edu.kh.io.model.service.MemberService;

public class MemberView {

	private Scanner sc = new Scanner(System.in);
	MemberService service = new MemberService();
	
	
	public void displayMenu() {

		int input=0;
		
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
					input = -1;
					sc.nextLine();
				}

			} while ( input != 0);
			
	}
	
	
	/**
	 * 회원 목록 조회 view
	 */
	private void selectAll() {
		
		System.out.println("\n**** 회원 목록 조회 ****\n");
		
		List<Member> members = service.selectAll();
		
		if(members.isEmpty())	System.out.println("회원 목록이 없습니다.");
		for(Member mem : members)	System.out.println(mem);
		
	}
	
	
	/**
	 * 회원 가입 view
	 */
	private void signUp() {
		System.out.println("\n**** 회원 가입 ****\n");
		
		System.out.print("ID : ");
		String id = sc.next();
		
		// 아이디 중복 검사
		boolean result = service.signUp1(id);
		
		// 중복 결과가 참이면 다시 입력
		if(result) {
			System.out.println("중복된 아이디가 있습니다. 다시 입력해주세요!");
			return;
		} else {
			System.out.println("사용 가능한 아이디입니다.");
		}
		
		System.out.print("PW : ");
		String pw = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("포인트 : ");
		int point = sc.nextInt();
		
		// 회원가입
		boolean result2 = service.signUp2(id, pw, name, point);
		
		if(result2) System.out.println(name + "님의 회원가입이 완료되었습니다.");
		
	}
	
	
	/**
	 * 아이디/비밀번호 일치하는 회원 조회 view
	 */
	private void selectOne() {
		System.out.println("\n**** 아이디/비밀번호 일치하는 회원 조회 ****\n");
		
		System.out.print("ID : ");
		String id = sc.next();
		
		System.out.print("PW : ");
		String pw = sc.next();
		
		Member mem = service.selectOne(id, pw);
		
		if (mem == null) {
			System.out.println("찾으시는 회원 정보가 없습니다.");
		}
		else {
			System.out.println("찾으시는 회원 정보는 아래와 같습니다.");
			System.out.println(mem);
		}

	}
	
	
	/**
	 * 아이디/비밀번호 일치하는 회원의 비밀번호 변경 view
	 */
	private void changePw() {
		System.out.println("\n**** 회원 비밀번호 변경 ****\n");
		
		System.out.print("ID : ");
		String id = sc.next();
		
		System.out.print("PW : ");
		String pw = sc.next();
		
		Member mem = service.selectOne(id, pw);
		
		if (mem == null) {
			System.out.println("찾으시는 회원 정보가 없습니다.");
			return;
		}
		
		System.out.print("변경할 PW : ");
		String pw2 = sc.next();
		
		service.changePw(mem, pw2);
		System.out.println(mem.getName() + "님의 비밀번호 변경이 완료되었습니다.");
		
	}
	
	
	/**
	 * id/pw 일치 회원 탈퇴 view
	 */
	private void withdrawal() {
		System.out.println("\n**** 회원 탈퇴 ****\n");
		
		System.out.print("ID : ");
		String id = sc.next();
		
		System.out.print("PW : ");
		String pw = sc.next();
		
		Member mem = service.selectOne(id, pw);
		
		if (mem == null) {
			System.out.println("찾으시는 회원 정보가 없습니다.");
			return;
		}
		
		System.out.print(mem.getName() + "회원님 탈퇴 하시겠습니까?(Y/N) : ");
		char yn = sc.next().toUpperCase().charAt(0);
				
		if(yn == 'Y') {
			service.withdrawal(mem);
			System.out.println(mem.getName() + "님의 탈퇴가 완료되었습니다.");
			
		} else if (yn == 'N'){
			return;
		} else {
			System.out.println("Y 또는 N을 입력해주세요.");
		}
	}
	



}