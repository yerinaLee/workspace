package edu.kh.poly.run;

import edu.kh.poly.model.dto.Car;
import edu.kh.poly.model.dto.Porsche;
import edu.kh.poly.model.dto.Spark;
import edu.kh.poly.model.service.PolyService;

public class CarRun {

	public static void main(String[] args) {

		// 선수 지식
		// 1. 컴퓨터의 값 처리 원칙
		// - 같은 자료형끼리만 연산 가능, 연산 결과도 같은 자료형
		// 2. 상속 메모리 구조
		// - 자식 객체 생성 시
		// 부모 객체가 먼저 생성되고
		// 그 부모를 자식 객체가 포함하는 형태(감싸고 있는 형태)

		// 부모 참조 변수 = 부모 객체 생성
		// import 자동완성 : ctrl + shift + o
		Car c1 = new Car();

		// 자식 참조 변수 = 자식 객체 생성
		Porsche p1 = new Porsche();
		Spark s1 = new Spark();

		// * 다형성(업캐스팅) ! *

		// 부모 참조 변수 = 자식 객체 생성
		Car c2 = new Porsche(); // 오잉? 왜 에러가 발생 안함?

		// -> 컴퓨터의 값 처리 원칙이 위배된걸로 보임

		// c2 부모 타입 참조 변수가
		// 자식 타입의 객체를 참조하게되면
		// 자식 내 부모 부분만 참조가 가능하다

		// * c2가 자식 객체를 참조하고 있지만
		// 부모 객체만 바라 보고 있으므로
		// c2가 Car 객체를 참조하고 있는 것 처럼 느껴짐
		// -> 자식 Porsche가 Car로 변한 것처럼 느껴짐
		// -> 자식이 부모로 변했다 -> Up Casting (부모로 변함)

		// c2.setOpenTheDoor(true);
		c2.setWheel(4);

		System.out.println("업캐스팅 확인");
		// 다형성 업캐스팅
		// - 부모 타입 참조 변수로
		// 자식 타입의 객체를 참조하는 것

		// - 참조하는 자식 객체 중 부모 부분만 참조

		// 1. 다형성과 객체배열
		Car[] carArr = new Car[3];
		// Car(부모) 객체 참조 변수 3개의 묶음

		// 부모 = 부모
		carArr[0] = new Car(4, 5, "경유");
//		
//		// 부모 = 자식 -> 부모 (업캐스팅)
		carArr[1] = new Porsche(4, 2, "휘발유", true);
//		
//		// 부모 = 자식 -> 부모 (업캐스팅)
		carArr[2] = new Spark(4, 4, "휘발유", 0.5);
//		
		for (int i = 0; i < carArr.length; i++) {
			System.out.printf("%d / %d / %s \n", carArr[i].getWheel(), carArr[i].getSeat(), carArr[i].getFuel());
		}

		// 다운 캐스팅
		// - 부모 참조 변수 = 자식 객체 형태에서
		// 부모 참조 변수를 자식 타입으로 강제 형변환해서
		// 다시 자식 객체를 온전히 참조할 수 있게 만드는 것

		System.out.println("다운 캐스팅 확인");
		// 다운 캐스팅
		System.out.println(((Porsche) carArr[1]).isOpenTheDoor());
		System.out.println(((Spark) carArr[2]).getDiscountRate());

		// 공부함!

		// 집에서 복습했음 꺄루루룩

		// 학원에서 내용 추가했음

		// -------------------------------------------------------------------

		System.out.println("---------------------------------------------");

		// polyService 객체 생성
		PolyService service = new PolyService();

		for (int i = 0; i < 6; i++) { // ctrl + shift + f : 자동정렬 (정확도가 높진 않음)

			Car car1 = service.selectOne(i); // arr에서 i번 인덱스 얻어오기
			
			System.out.println("===============================");
			
			if (car1 != null) { // 인덱스 정상 범위

				System.out.println("바퀴 수 : " + car1.getWheel());
				System.out.println("좌석 수 : " + car1.getSeat());
				System.out.println("연료 : " + car1.getFuel());

				// Porsche인 경우 뚜껑 열림?
				// Spark인 경우 할인율 :

				// 참조변수 instanceof 클래스명
				// -> 참조변수가 참조하는 객체가 클래스명 타입을 가지고 있는가?
				// 클래스명 객체인가?
				// 클래스명 타입과 상속 관계인가?
				// 클래스명 타입으로 형변환이 가능한가?

				if (car1 instanceof Porsche) {
					System.out.println("뚜껑 열림? " + ((Porsche) car1).isOpenTheDoor());
				}

				if (car1 instanceof Spark) {
					System.out.println("할인율 : " + ((Spark) car1).getDiscountRate());
				}

				// ClassCastException
				// -> 올바르지 않은 자료형으로 형변환 시 발생
				// -> Spark 객체를 참조하던 car1을 Porsche 타입으로 변경
				// Porsche 참조변수 = Spark 객체
				// -> 부모 자식이 아니니까 다형성 적용 X

			} else {
				System.out.println("해당하는 인덱스가 없습니다.");
			}

		} // for문 닫는괄호

		
		
		
		
		System.out.println("*********************************");

		// 바인딩 확인
		service.printCar();
		
		
		
	}

}
