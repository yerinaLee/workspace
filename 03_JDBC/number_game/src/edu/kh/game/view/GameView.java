package edu.kh.game.view;

import java.util.Random;
import java.util.Scanner;

import edu.kh.game.model.dto.Gamer;
import edu.kh.game.service.GameService;

public class GameView {

	private GameService service = new GameService();
	private Scanner sc = new Scanner(System.in);
	
	// 로그인 정보 저장
	private Gamer loginGamer = null;

	
	/**
	 * 메뉴 선택
	 */
	public void menudisplay() {
		
		int input = -1;
		
		do {
			
			if(loginGamer != null) {
				System.out.println("--------------------------------------");
				System.out.printf("(%s) \n", loginGamer.getGamerNickname() );
				System.out.println("--------------------------------------");
			}
			
			System.out.println("\n~~~~~~~숫자맞추기 게임~~~~~~~");
			
			System.out.println();
			System.out.println("▼▼▼ 메뉴를 고르새오 ▼▼▼");
			System.out.println("1. 회원 가입");
			System.out.println("2. 숫자 게임 플레이");
			System.out.println("3. 내 기록 보기");
			System.out.println("4. 랭킹 보기");
			System.out.println("0. 게임 종료");
			
			try {
				
				System.out.print("메뉴 선택 >>> ");
				input = sc.nextInt();
				sc.nextLine(); // 개행 문자 제거
				
				switch(input) {
				
				case 1 : insertGamer(); break;
				case 2 : gamePlay();  break;
				case 3 : records(); break;
				case 4 : ranking(); break;
				case 0 : System.out.println("게임을 종료합니다. 바이바이!"); break;
				default : System.out.println("메뉴 번호만 입력해주세요~");break;
				
				}
				
			} catch(Exception e) {
				e.printStackTrace();
				sc.nextLine();
			}
			
		} while(input != 0);
	}
	
	
	/**
	 * 회원가입 view (기록 없음)
	 */
	private void insertGamer() {
		
		System.out.println("\n~~~~ 회원가입 ~~~~\n");
		
		System.out.print("닉네임 : ");
		String nickName = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		sc.nextLine();
		
		Gamer gamer = new Gamer(nickName, pw);
		
		int result = service.insertGamer(gamer);
		
		if (result > 0) System.out.println(nickName + " 님의 회원가입이 완료되었습니다.");
		else			System.out.println("회원가입 실패");
		
	}
	
	
	/**
	 * 회원가입 view (기록 있음)
	 */
	private void insertGamerRecords(int gamerRecords) {
		
		System.out.println("\n~~~~ 회원가입 ~~~~\n");
		
		System.out.print("닉네임 : ");
		String nickName = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		sc.nextLine();
		
		Gamer gamer = new Gamer(nickName, pw, gamerRecords); // 여기부터하세욧!!
		
		int result = service.insertGamerRecords(gamer);
		
		if (result > 0) System.out.println(nickName + " 님의 회원가입이 완료되었습니다.");
		else			System.out.println("회원가입 실패");
		
	}
	
	
	
	/**
	 * 게임진행 view
	 */
	private void gamePlay() {
		
		System.out.println("\n~~~~ 숫자맞추기 게임 ~~~~\n");
		
		Random random = new Random();
		int input = 0; // 정답 입력 변수
		int answer = random.nextInt(3000); // 난수 생성
		int count = 0; // try 횟수 입력

		do {

			System.out.print("숫자를 입력 : ");
			input = sc.nextInt();
			
			if (input > answer) {
				System.out.println("DOWN!");
				count++;

			} else if (input < answer) {
				System.out.println("UP!");
				count++;
			
			} else{
				System.out.println("정답!!!");
				System.out.printf("%d회 만에 정답을 맞추셨습니다.\n", count);
				
				System.out.print("현재 기록을 저장하시겠습니까?(Y/N) : ");
				char yn = sc.next().toUpperCase().charAt(0);
				sc.nextLine();
				
				if(yn == 'Y') insertGamerRecords(count); // 회원가입 진행!
				else System.out.println("\n굿게임! 또봐요!^^");
			}

		} while(input != answer);
		
	}
	
	
	/**
	 * 로그인 view
	 */
	private void login() {
		
		System.out.println("\n~~~~ 로그인 ~~~~\n");
		
		System.out.print("닉네임 : ");
		String nickName = sc.next();
		
		System.out.print("비밀번호 : ");
		String pass = sc.next();
		sc.nextLine();
		
		Gamer gamer = service.login(nickName, pass);
		
		if(gamer != null) {
			System.out.println(nickName + "님 로그인이 되었습니다.");
			loginGamer = gamer;
		} else {
			System.out.println("가입 정보가 없습니다.");
		}
	}
	
	
	
	/**
	 * 게임 기록보기 view
	 */
	private void records() {
		
		
		// 로그인 확인
		
		
		
	}
	
	
	
	/**
	 * 랭킹보기 view
	 */
	private void ranking() {
		
		
		
		
	}
	
	
	
	

}
