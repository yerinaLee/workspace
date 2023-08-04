package a00_testProject;

// 주석 : 코드에 대한 설명을 작성하는 부분 (컴파일러(번역기) 해석 x)

// 한줄주석

/* 여러줄
 주석은
 이렇게
 하세요
 범위주석임*/


// class : 하나의 단위. 자바 코드를 작성하는 영역
public class JavaTest {

	// main 메서드(method, 기능)
	// 자바 프로그램(프로젝트, 애플리케이션)을 실행시키기 위해 반드시 필요한 구문(기능)
	public static void main(String[] args) { //메인 메서드의 선언부
		
		// 실행방법 1. Run버튼 2.ctrl + F11
		
		// () 안의 문자열을 출력 후 엔터 a.k.a.한줄출력
		System.out.println("Hello world^^");
		System.out.println("안녕하세요");
				
		// 숫자만 작성하면 연산이 됨
		System.out.println(3500 + 6000);

		// '+' means 문자열을 추가한다는 뜻도 갖고 있음
		// 사칙연산 우선순위를 그대로 적용 / 연산 순서는 왼쪽에서 오른쪽으로
		// 숫자 + "문자열" = 숫자문자열 (이어쓰기, 추가하기, 덧붙이기)
		System.out.println(1000 + 2000 + "원");

		// 띄어쓰기도 문자열임. 공백문자
		System.out.println("이예리나");
		System.out.println("만 " + 30 + "세");

		// 김밥 : 2000원, 떡볶이 : 3000원
		// "문자열" + 숫자 = 문자열숫자, 연산우선순위문제
		System.out.println("합계 : " + (2000 + 3000) + " 원"); // 합계 : 5000원
		
		
		
	}

}
