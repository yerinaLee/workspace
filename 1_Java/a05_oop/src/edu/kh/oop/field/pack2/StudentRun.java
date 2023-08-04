package edu.kh.oop.field.pack2;

public class StudentRun {

	public static void main(String[] args) {
		
		// Student 객체 생성
		Student s1 = new Student();
		
		s1.grade = 3;
		s1.ban = 5;
		s1.number = 11;
		s1.name = "이도겸";
		
		Student s2 = new Student();
		s1.grade = 2;
		s1.ban = 8;
		s1.number = 21;
		s1.name = "전원우";
		
		Student s3 = new Student();
		s1.grade = 3;
		s1.ban = 1;
		s1.number = 8;
		s1.name = "홍지수";
		
		
		// 프로그램 실행 중 학교명 변경 기능 추가
		
		System.out.println("-----변경 전 학교명-----");
		System.out.println(s1.schoolName);
		System.out.println(s2.schoolName);
		System.out.println(s3.schoolName);
		
		// 학교명 변경

//		s1.schoolName = "세봉 국제중학교";
//		s2.schoolName = "세봉 국제중학교";
//		s3.schoolName = "세봉 국제중학교";
		// 학생이 1000명이면 변경 코드를 1000번 작성해야됨...
		
		// * schoolName 필드를 static으로 변경하면
		//  한 학생의 학교명만 변경해도 모두 바뀜
		// s1.schoolName = "세봉 예술중학교";
		
		// * static 붙은 필드를 다룰때는 클래스명.필드명으로 작성을 권장!! *
		Student.schoolName = "세봉 외국어중학교";
		
		
		System.out.println("-----변경 후 학교명-----");
		System.out.println(s1.schoolName);
		System.out.println(s2.schoolName);
		System.out.println(s3.schoolName);
		
		
		
	}
	
	
}
