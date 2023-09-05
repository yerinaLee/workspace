package edu.kh.jdbc.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Member;
import edu.kh.jdbc.service.ProjectService;

public class ProjectView {

	private ProjectService service = new ProjectService();
	private Scanner sc = new Scanner(System.in);
	
	// 로그인 정보 Member객체 선언
	private Member loginMember = null;

	
	public void displaymenu() {
		
		int input = -1;
			
			do {
				
				try {
					if(loginMember != null) {// 로그인 상태인 경우
						System.out.println("--------------------------------------");
						System.out.printf("(%s) \n", loginMember.getMemberEmail() );
						System.out.println("--------------------------------------");
					}
					
					System.out.println("\n***** MEMBER/BOARD 테이블 사용 JDBC *****\n");
					
					System.out.println("1. 회원 가입");
					System.out.println("2. 로그인");
					System.out.println("3. 회원 정보 수정"); // 닉네임, 전화번호 UPDATE
					System.out.println("4. 회원 탈퇴"); // MEMBER_DEL_FL = 'Y' UPDATE
					System.out.println("5. MEMBER 테이블 전체 조회");
					System.out.println("6. 게시글 작성하기"); // BOARD 테이블에 INSERT
					System.out.println("7. 게시글 목록 조회"); // selectBoardList()
					System.out.println("0. 프로그램 종료");
					System.out.print("메뉴 선택 >> ");
					input = sc.nextInt();
					sc.nextLine(); // 입력 버퍼 개행 문자 제거
					
					switch(input) {
					case 1: insertMember(); break;
					case 2: login(); break;
					case 3: updateMember(); break;
					case 4: updateDelFl(); break;
					case 5: selectAllMember(); break;
					case 6: insertBoard(); break;
//					case 7: selectBoardList(); break;
			 
					case 0: System.out.println("\n--- 프로그램 종료 ---\n"); break;
					default: System.out.println("\n*** 메뉴 번호만 입력해주세요 ***\n"); 
					}
					
				} catch (InputMismatchException e) {
					System.out.println("\n잘못된 입력\n");
					sc.nextLine();
				}
			
		} while(input != 0);
		
	} // displayMenu 메서드 끝
	
	
	/**
	 * 회원가입
	 */
	private void insertMember() {
		
		System.out.println("\n***** 회원 가입 *****\n");
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		System.out.print("닉네임 : ");
		String nickname = sc.next();
		
		System.out.print("휴대폰 번호(- 제외) : ");
		String tel = sc.next();
		sc.nextLine(); // 입력 버퍼 개행문자 제거 (문제예방차원)
		
		System.out.print("주소 : ");
		String adress = sc.nextLine(); // 주소는 띄어쓰기가 있으니까 nextLine으로!
		
		
		Member member = new Member(email, pw, nickname, tel, adress);
		
		int result = service.insertMember(member);
		
		if (result > 0) {
			System.out.println("회원가입 성공!!!");
		} else {
			System.out.println("회원가입 실패....sosad");
		}
		
		
		
	}
	

	/**
	 * 로그인
	 */
	private void login() {
		
		System.out.println("\n***** 로그인 *****\n");
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		Member member = service.login(email, pw);		
		
		if (member != null) {
			
			System.out.println("\n로그인 성공~\n");
			System.out.println(member);
			
			loginMember = member;
			
		} else {
			System.out.println("\n*** 로그인 실패 흐규흐규 ***\n");
		}
	}
	
	
	
	/**
	 * 회원 정보 수정
	 */
	private void updateMember( ) {
		
		// 로그인 여부 확인
		if (loginMember == null) {
			System.out.println("로그인 후 이용해주세요");
			return;
		}
		
		
		// 로그인 O인 경우
		System.out.print("수정할 닉네임 : ");
		String nickname = sc.next();
		
		System.out.print("수정할 전화번호(- 제외) : ");
		String tel = sc.next();
				
		
		int result = service.updateMember(nickname, tel, loginMember.getMemberNo());
		
		if (result > 0) System.out.println("수정이 완료되었습니다.");
		else 		    System.out.println("수정 실패! ㅠ");		
		
	}
	
	
	
	/**
	 * 회원 탈퇴
	 */
	public void updateDelFl() {
		
		// 로그인 여부 확인
		if (loginMember == null) {
			System.out.println("로그인 후 이용해주세요");
			return;
		}
		
		// 로그인 O인 경우
		System.out.print("비밀번호를 입력해주세요 : ");
		String pw = sc.next();
		
		int result = service.updateDelFl(loginMember.getMemberNo(), pw);
		
		if (result > 0) {
			System.out.println("탈퇴 되었습니다.");
			loginMember = null; // 로그아웃
		} else {
			System.out.println("비밀번호가 일치하지 않습니다");
		}
	}
	
	
	/**
	 * 회원 전체 조회
	 */
	public void selectAllMember() {
		
		System.out.println("\n***** MEMBER 테이블 전체 조회 *****\n");
		
		System.out.print("내림차순 조회(1), 오름차순 조회(아무숫자) : ");
		int sort = sc.nextInt();
		
		
		List<Member> memberList = service.selectAllMember(sort);
		
		
		for(Member m : memberList) {
			System.out.println(m);
		}
		
	}
	
	
	/**
	 * 게시글 작성하기
	 */
	public void insertBoard() {
		
		System.out.println("\n***** 게시글 작성 *****\n");
		
		if (loginMember == null) {
			System.out.println("로그인 후 이용해주세요!");
			return;
		}
		
		System.out.printf("게시글 제목 : ");
		String title = sc.nextLine();
		
		while(true) {
			
		}
		
		
		
//		int result = service.insertBoard(loginMember.getMemberNo());
		
//		if (result > 0) System.out.println("\n게시글 등록이 완료되었습니다\n");
//		else 			System.out.println("\n게시글 등록 실패\n");
		
		
		
		
	}
	
	
	
	
	

} // 클래스 끝
