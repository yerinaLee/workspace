package edu.kh.oarr.view;

import java.util.Scanner;

import edu.kh.oarr.model.dto.Student;
import edu.kh.oarr.model.service.StudentService;


public class StudentView {
	
	private Scanner sc = new Scanner(System.in);
	private StudentService service = new StudentService();
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
		System.out.println("===== 학생 관리 프로그램 =====");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 전체 조회");
		System.out.println("3. 학생 1명 정보 조회(인덱스)");
		System.out.println("4. 학생 이름으로 조회");
		System.out.println("5. 학생 정보 수정(인덱스)");
		System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
		System.out.println("7. 평균 최고점, 최저점 학생");
		System.out.println("0. 종료");
		
		System.out.print("프로그램 선택 : ");
		input = sc.nextInt();

		
		switch(input) {
		
			case 1 : System.out.println( addStudent() ); break;
			case 2 : selectAll() ; break;
			case 3 : selectIndex(); break;
			case 4 : break;
			case 5 : break;
			case 6 : selectScore(); break;
			case 7 : break;
	
			case 0 : System.out.println("[프로그램 종료]"); break;
			default : System.out.println("잘못 입력하셨습니다."); 
			}
		
		} while (input != 0);
		
		
	}
	
	
	
	// 1. 객체 배열에 학생을 추가하는 서비스
	public String addStudent() {
		
		System.out.println("\n----- 학생 추가 -----");
		
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int ban = sc.nextInt();
		
		System.out.print("번호 : ");
		int number = sc.nextInt();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		// 학년, 반, 번호, 이름을 StudentService로 전달하여
		// 객체 배열에 추가
		// 성공시 true, 실패시 false 반환
		boolean result = service.addStudent(grade, ban, number, name);
		
		if(result) { // true
			return name + " 학생이 추가되었습니다";
		} else {
			return "학생을 더 이상 추가할 수 없습니다";
		}
		
		
	}
	
		
	// 2. 학생 전체 조회
	public void selectAll() {
		
		System.out.println("\n----- 학생 전체 조회 -----");
		
		Student[] arr = service.selectAll();
		
		for(Student s : arr) {
			if (s == null) {
				break;
			}
			System.out.println(s.toString());
		}
	}
	
	
	
	
	// 3. 학생 1명 정보 조회(인덱스)
	public void selectIndex() {
		
		System.out.println("\n----- 학생 1명 정보 조회 -----");
		
		System.out.print("조회할 인덱스 넘버입력 : ");
		int index = sc.nextInt();
		
		Student s = service.selectIndex(index);
		
		if (s==null) {
			System.out.println("해당 인덱스에 학생 정보가 존재하지 않습니다.");
		} else {
			System.out.println("학년 : " + s.getGrade());
			System.out.println("반 : " + s.getBan());
			System.out.println("번호 : " + s.getNumber());
			System.out.println("이름 : " + s.getName());
			
			System.out.println("국어 점수 : " + s.getKor() + "점");
			System.out.println("영어 점수 : " + s.getEng() + "점");
			System.out.println("수학 점수 : " + s.getMath() + "점");			
		}
	}

	
	
	// 4. 학생 이름으로 조회
	
	
	// 5. 학생 정보 수정(인덱스)
	
	
	
	
	
	// 6. 학생 1명 점수 조회(점수, 합계, 평균)
	
	public void selectScore() {
		System.out.println("\n----- 학생 1명 점수 조회 -----");
		
		System.out.print("조회할 학생의 인덱스 번호를 입력하세요 : ");
		int index = sc.nextInt();
		
		String str = service.selectScore(index);
		
		System.out.println(str);
		
	}
	
	
	
	// 7. 평균 최고점, 최저점 학생
	
	
	
	
	
	
	
	

}


