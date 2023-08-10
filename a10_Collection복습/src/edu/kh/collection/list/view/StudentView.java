package edu.kh.collection.list.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.list.mode.dto.Student;
import edu.kh.collection.list.mode.service.StudentService;

public class StudentView {
	
	private Scanner sc = new Scanner(System.in);
	private StudentService service = new StudentService();
	
	
	/**
	 * 메뉴 출력용 view 메서드
	 */
	public void displayMenu() {
				
		int input = 0;
		
		do {
			
			try {
				
				System.out.println();
				
				System.out.println("\n***** 학생 관리 프로그램 *****\n");
				System.out.println("1. 학생 추가");
				System.out.println("2. 학생 전체 조회");
				System.out.println("3. 학생 1명 조회(index)");
				System.out.println("4. 학생 1명 삭제(index)");
				System.out.println("5. 성별 조회");
				System.out.println("6. 같은 학년 조회");
				System.out.println("7. 이름으로 조회");
				System.out.println("8. 중복 확인");
				System.out.println("9. 성적 순서로 조회(정렬)");
				
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				
				
				switch(input) {
				case 1 : addStudent();		 break;
				case 2 : selectAllStudent(); break;
				case 3 : selectOne(); 		 break;
				case 4 : deleteStudent();    break;
				case 5 : selectGender();  	break;
				case 6 : selectGrade();   	break;
				case 7 : selectName(); 		break;
				case 8 : break;
				case 9 : break;
				
				case 0 : System.out.println("<프로그램 종료>"); break;
				default : System.out.println("* 유풋더 롱넘버 *");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("* 메뉴 번호만 입력해주세요");
				input = -1;
				sc.nextLine();
			}
			
		} while (input != 0);
	}
	
	
	/** 
	 * 학생 추가 view 메서드
	 */
	private void addStudent() {
		
		System.out.println("\n----- 학생 추가 -----\n");
		
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int ban = sc.nextInt();
		
		System.out.print("번호 : ");
		int number = sc.nextInt();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		
		System.out.print("성적 : ");
		int score = sc.nextInt();
		
		boolean result = service.addStudent(grade, ban, number, name, gender, score);
		
		if(result) {
			System.out.println(name + " 학생이 추가됨 ㅊㅋ");
		} else {
			System.out.println("추가 실패");
		}
		
	}
	
	
	/**
	 * 학생 전체 조회 view 메서드
	 */
	private void selectAllStudent() {
		
		System.out.println("\n----- 학생 전체 조회 -----\n");
		
		List<Student> studentList = service.selectAllStudent();
		
		for(int i = 0; i < studentList.size(); i++) {
			System.out.printf("[%d] %s \n", i, studentList.get(i));
		}
	}
	
	
	
	/**
	 * 학생 1명 조회 view 메서드
	 */
	private void selectOne() {
		System.out.println("\n----- 학생 1명 조회(index) -----\n");		
		
		System.out.print("조회할 학생의 index 입력 : ");
		int index = sc.nextInt();
		
		Student std = service.selectOne(index);
			
		if(std == null) {
			System.out.println("해당 인덱스에 학생 정보가 없습니다");
		} else {
			System.out.println(index + "인덱스의 학생 정보 : " + std);
		}
		
	}
	
	
	/**
	 * 학생 1명 삭제 view 메서드
	 */
	private void deleteStudent() {
		System.out.println("\n----- 학생 1명 삭제(index) -----\n");
		
		System.out.print("삭제할 학생의 index 번호 : ");
		int index = sc.nextInt();
		
		
		Student std = service.deleteStudent(index);
		
		if(std == null) {
			System.out.println("해당 인덱스에 학생 정보가 없습니다");
		} else {
			System.out.println(std.getName() + "학생의 정보가 삭제되었습니다");
		}
	}
	
	
	
	/**
	 * 성별 조회 view 메서드
	 */
	private void selectGender() {

		System.out.println("\n----- 성별 조회 -----\n");

		System.out.print("조회할 성별을 입력해주세요(M/F) : ");
		char gender = sc.next().toUpperCase().charAt(0);
		
		if(gender != 'M' && gender != 'F') {
			System.out.println("* M 또는 F를 입력해주세요.");
			return;
		}
		
		List<Student> searchList = service.selectGender(gender);
		
		if(searchList.isEmpty()) {
			System.out.println("해당하는 학생이 없습니다.");
		}
		
		for ( Student s : searchList) {
			System.out.println(s);
		}
		
	}
	
	
	/**
	 * 같은 학년 조회 view 메서드
	 */
	private void selectGrade() {
		System.out.println("\n----- 학년 조회 -----\n");
		
		System.out.print("조회할 학년을 입력해주세요 : ");
		int grade = sc.nextInt();
		
		if(grade < 1 || grade > 6) {
			System.out.println("* 1~6학년 내로 입력해주세요.");
			return;
		}
		
		List<Student> searchList = service.selectGrade(grade);
		
		if(searchList.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
		}
		
		for(Student s : searchList) {
			System.out.println(s);
		}
	}
	
	
	/**
	 * 같은 이름 조회 view 메서드
	 */
	private void selectName() {
		
		System.out.println("\n----- 이름 조회 -----\n");
		
		System.out.print("조회할 학생 이름 : ");
		String name = sc.next();
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
