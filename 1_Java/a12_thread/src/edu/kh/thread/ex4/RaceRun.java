package edu.kh.thread.ex4;

import java.util.Scanner;

public class RaceRun {
	
	// 하트, 별이 움직인 거리를 카운트(띄어쓰기 횟수)
	// static : 정적 메모리 영역
	// (여기에 생성되면 '클래스명.필드명'으로 어디서든 공유 가능) 
	public static int heartCount = 0;
	public static int starCount = 0;
	
	public static void main(String[] args) {
		
		Thread th1 = new Thread( new RaceHeart() );
		Thread th2 = new Thread( new RaceStar() );


		// 승패 여부 맞추기
		Scanner sc = new Scanner(System.in);
		
		System.out.println("<승패 여부를 예상해보세요>");
		System.out.print("1.♡ 승  /  2.★ 승  /  3.무승부 >> ");
		int input = sc.nextInt();
		
		System.out.println("<배팅할 포인트를 입력해 주세요>");
		int point = sc.nextInt();
		
		// 승패 여부 저장할 변수
		int win = 0; // 1.♡ 승  /  2.★ 승  /  3.무승부
		
		try {
			th1.start();
			Thread.sleep(500);
			th2.start();
			
			// Thread.join()
			// - 지정된 스레드(th1, th2)가 끝날 때 까지
			//   현재 스레드(main)를 대기시킴
			th1.join();
			th2.join();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 하트, 별 중 누가 더 멀리 이동했는가에 따라 
		// 승패 여부 출력
		
		System.out.println("\n~~~~ 결과 ~~~~\n");
		String result = null;
		
		if(heartCount > starCount) { // 하트가 더 멀리간 경우
			result = "[♡ 승!!]";
			win = 1;
		} else if (heartCount < starCount) {
			result = "[★ 승!!]";
			win = 2;
		} else {
			result = "[무승부!!]";
			win = 3;
		}

		System.out.println(result);
		
		// 예측 성공 시
		if(input == win) {
			System.out.println("\n[예측 성공!!!!]");
			
			if(win == 3) { //무승부 예측 성공 시 포인트 3배
				point *= 3;
				
			} else { //나머지 2배
				point *=2;
			}
			
			System.out.println("포인트 : " + point + "를 획득했습니다.");
			
		// 예측 실패 시	
		} else {
			System.out.println("\n[아쉽게도 포인트를 모두 잃었습니다....]");
		}
	}
	
	
	// 콘솔창 클리어(엔터 많이 하기)
	public static void clear() {
		// StringBuffer : String의 업그레이드 버전. String의 불변성 문제를 해결한 객체
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i<30; i++) {
			sb.append("\n"); // 엔터 30번 누적 코드 sb += "\n"
		}
		
		System.out.println(sb.toString()); // 엔터 30번 + 1번 출력
		
	}
	
	

}
