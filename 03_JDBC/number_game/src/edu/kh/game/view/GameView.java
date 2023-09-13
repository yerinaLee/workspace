package edu.kh.game.view;

import java.util.List;
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
			System.out.println("5. 로그인");
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
				case 5 : login(); break;
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
		
		Gamer gamer = new Gamer(nickName, pw, gamerRecords);
		
		int result = service.insertGamerRecords(gamer);
		
		if (result > 0) System.out.println(nickName + " 님의 회원가입이 완료되었습니다.");
		else			System.out.println("회원가입 실패");
		
	}
	
	
	
	/** 게임횟수, 기록 업데이트
	 * @param count
	 */
	private void countRanking(int count) {
		
		if(loginGamer != null) {
			
			// 게임카운트 +1
			service.gamePlayTry(loginGamer.getGamerNo());
			
			if(count < loginGamer.getGamerRecords()) { // 최고기록 갱신
				int result = service.gamePlay(loginGamer.getGamerNo(), count); 
				System.out.println("최고기록 갱신! 축하드립니다!");
			}
		}
		
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
				
				if(loginGamer != null) { //로그인 O
					
					// 게임카운트 +1
					countRanking(count);
					
				} else { // 로그인 X
					System.out.print("현재 기록을 저장하시겠습니까?(Y/N) : ");
					char yn = sc.next().toUpperCase().charAt(0);
					sc.nextLine();
					
					if(yn == 'Y') {
						
						System.out.print("1.로그인 / 2.회원가입 >> ");
						int input2 = sc.nextInt();
						sc.nextLine();
						
						switch(input2) {
						case 1 : loginRecords(count);
								 countRanking(count); break; // 로그인 진행
						case 2 : insertGamerRecords(count); break; // 회원가입 진행!
						default : System.out.println("잘못된 입력입니다."); break;
						}
					}
					else System.out.println("\n굿게임! 또봐요!^^"); break;
				}
			}

		} while(input != answer);
		
	}
	
	
	/**
	 * 로그인 view
	 */
	private void login() {
		
		System.out.println("\n~~~~ 로그인 ~~~~\n");
		
		if(loginGamer != null) {
			System.out.println("이미 로그인 되어있습니다.");
			return;
		}
		
		System.out.print("닉네임 : ");
		String nickName = sc.next();
		sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pass = sc.next();
		sc.nextLine();
		
		Gamer gamer = service.login(nickName, pass);
		
		if(gamer != null) {
			System.out.println(nickName + "님 로그인이 되었습니다.");
			loginGamer = gamer;
			
		} else {
			System.out.println("가입 정보가 없습니다.");
			
			System.out.print("회원가입 하시겠습니까?(Y/N) : ");
			char yn = sc.next().toUpperCase().charAt(0);
			sc.nextLine();
			
			if(yn == 'Y') insertGamer(); // 회원가입 진행!
			else System.out.println("\n다음에 또 만나요!^^");
		}
	}
	
	

	/**
	 * 로그인(기록있음) view
	 */
	private void loginRecords(int count) {
		
		System.out.println("\n~~~~ 로그인 ~~~~\n");
		
		if(loginGamer != null) {
			System.out.println("이미 로그인 되어있습니다.");
			return;
		}
		
		System.out.print("닉네임 : ");
		String nickName = sc.next();
		sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pass = sc.next();
		sc.nextLine();
		
		Gamer gamer = service.login(nickName, pass);
		
		if(gamer != null) {
			System.out.println(nickName + "님 로그인이 되었습니다.");
			loginGamer = gamer;
			
		} else {
			System.out.println("가입 정보가 없습니다.");
			
			System.out.print("회원가입 하시겠습니까?(Y/N) : ");
			char yn = sc.next().toUpperCase().charAt(0);
			sc.nextLine();
			
			if(yn == 'Y') insertGamerRecords(count); // 회원가입 진행!
			else System.out.println("\n다음에 또 만나요!^^");
		}
	}
	
	
	
	/**
	 * 게임 기록보기 view
	 */
	private void records() {
		
		System.out.println("\n~~~~ 게임 기록보기 ~~~~\n");
		
		// 로그인 확인
		if(loginGamer == null) {
			System.out.println("로그인 후 사용해주세요");
			login();
			return;  // 로그인 후 바로 게임기록보게하고싶은데 이건 잘 모르겠으니까 일단 리턴으로 함 ㅋㅋㅋ
		}
		
		System.out.printf("\n***%s님의 게임기록***\n", loginGamer.getGamerNickname());
		System.out.printf("총 게임 횟수 : %d회\n", loginGamer.getTryCount());
		System.out.printf("최고 기록 : %d번째 정답\n\n",loginGamer.getGamerRecords());
	}
	
	
	
	/**
	 * 랭킹보기 view
	 */
	private void ranking() {
		
		System.out.println("\n~~~~ 랭킹 보기 ~~~~\n");
		
		// DB orderby 레코드순, 탑 10명만 나오도록하기 (순위, 닉네임, 게임 기록)
		// List로 받기 
		
		List<Gamer> gamerList = service.ranking();
		
		if(gamerList.isEmpty()) {
			System.out.println("게임 기록이 존재하지 않습니다.");
			return;
		}
		
		System.out.printf("순위 | 닉네임 | 기록\n");
		System.out.println("====================");

		for(Gamer gamer : gamerList) {
			System.out.printf(" %d위 | %s | %d번째\n", gamer.getGamerRanking(), gamer.getGamerNickname(), gamer.getGamerRecords());
		}
		
	}
	
	
	
	

}
