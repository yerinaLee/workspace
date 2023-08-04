package edu.kh.oarr.model.service;

import java.util.Random;

import edu.kh.oarr.model.dto.Student;

public class StudentService {
	
	Student[] studentArr = new Student[10];
	
	// 기본생성자 + 3명정보입력
	public StudentService() {
		
		studentArr[0] = new Student(2, 7, 14, "전원우");
		studentArr[1] = new Student(1, 2, 28, "이석민");
		studentArr[2] = new Student(3, 1, 3, "최승철");
		
		Random random = new Random();

		for(int i = 0; i < studentArr.length; i++) {
			
			if(studentArr[i] == null) {
				break;
			}
			studentArr[i].setKor(random.nextInt(101));
			studentArr[i].setEng(random.nextInt(101));
			studentArr[i].setMath(random.nextInt(101));
		}
	}
	
	// 1. 학생 추가 서비스
	public boolean addStudent(int grade, int ban, int number, String name) {
		
		for(int i = 0; i < studentArr.length; i++) {
			
			if (studentArr[i] == null) {
				studentArr[i] = new Student(grade, ban, number, name);
				
				return true;
			}
		}
	
		return false;
	}
	
	
	
	// 2. 학생 전체 조회 서비스
	public Student[] selectAll() {
		return studentArr;
	}

	
	// 3. 학생 1명 정보 조회(인덱스)
	public Student selectIndex(int index) {
		
		if (index < 0 || index >= studentArr.length || studentArr[index] == null) {
			return null;	
		}
		
		return studentArr[index];
		

		
	}

	
	// 6. 학생 1명 점수 조회(점수, 합계, 평균)
	public String selectScore(int index) {

		if(index < 0 || index >= studentArr.length || studentArr[index] == null) {
			return "해당 인덱스에 학생 정보가 존재하지 않습니다.";
		}
		
		Student s = studentArr[index];
		int sum = s.getKor() + s.getEng() + s.getMath();
		
		return String.format("[%s] 국어:%d, 영어:%d, 수학:%d, 합계:%d, 평균:%f",
				s.getName(), s.getKor(), s.getEng(), s.getMath(), sum, sum/3.0);
		
	}


	
	
	

}
