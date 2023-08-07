package edu.kh.poly.run;

import edu.kh.poly.model.dto.Car;
import edu.kh.poly.model.dto.Porsche;
import edu.kh.poly.model.dto.Spark;

public class CarRun {
	
	public static void main(String[] args) {
		
		
		// 선수 지식
		// 1. 컴퓨터의 값 처리 원칙
		//	- 같은 자료형끼리만 연산 가능, 연산 결과도 같은 자료형
		// 2. 상속 메모리 구조
		//	- 자식 객체 생성 시
		//	  부모 객체가 먼저 생성되고
		//	  그 부모를 자식 객체가 포함하는 형태(감싸고 있는 형태)
		
		// 부모 참조 변수 = 부모 객체 생성
		// import 자동완성 : ctrl + shift + o
		Car c1 = new Car();
		
		// 자식 참조 변수 = 자식 객체 생성
		Porsche p1 = new Porsche();++
		Spark s1 = new Spark();
		
		
		// * 다형성(업캐스팅) ! *
		
		// 부모 참조 변수 = 자식 객체 생성
		Car c2 = new Porsche(); // 오잉? 왜 에러가 발생 안함?
		
		// -> 컴퓨터의 값 처리 원칙이 위배된걸로 보임
		
		// c2 부모 타입 참조 변수가
		// 자식 타입의 객체를 참조하게되면
		// 자식 내 부모 부분만 참조가 가능하다
		
		// * c2가 자식 객체를 참조하고 있지만
		//  부모 객체만 바라 보고 있으므로
		//  c2가 Car 객체를 참조하고 있는 것 처럼 느껴짐
		//  -> 자식 Porsche가 Car로 변한 것처럼 느껴짐
		//	-> 자식이 부모로 변했다 -> Up Casting (부모로 변함)
		
		// c2.setOpenTheDoor(true);
		c2.setWheel(4);
		
		
		
		System.out.println("업캐스팅 확인");
		// 다형성 업캐스팅
		// - 부모 타입 참조 변수로
		//	 자식 타입의 객체를 참조하는 것
		
		// - 참조하는 자식 객체 중 부모 부분만 참조
		
		// 1. 다형성과 객체배열
		Car[] carArr = new Car[3];
					// Car(부모) 객체 참조 변수 3개의 묶음
		
		// 부모 = 부모
		carArr[0] = new Car(4, 5, "경유");
		
		// 부모 = 자식 -> 부모 (업캐스팅)
		carArr[1] = new Porsche(4, 2, "휘발유", true);
		
		// 부모 = 자식 -> 부모 (업캐스팅)
		carArr[2] = new Spark(4, 4, "휘발유", 0.5);
		
		for (int i = 0; i < carArr.length; i++) {
			System.out.printf("%d / %d / %s \n",
								carArr[i].getWheel(),
								carArr[i].getSeat(),
								carArr[i].getFuel());
		}

		// 다운 캐스팅
		// - 부모 참조 변수 = 자식 객체 형태에서
		// 	 부모 참조 변수를 자식 타입으로 강제 형변환해서
		//	 다시 자식 객체를 온전히 참조할 수 있게 만드는 것
		
		System.out.println("다운 캐스팅 확인");
							// 다운 캐스팅
		System.out.println(( (Porsche)carArr[1] ).isOpenTheDoor());
		System.out.println( ( (Spark)carArr[2] ).getDiscountRate());
		
		// 공부함!
		
		
		// 집에서 복습했음 꺄루루룩
		
		
		
		
	}

}
