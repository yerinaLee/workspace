package edu.kh.collection.set.ex;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.list.model.dto.Student;

public class SetEx {
	
	// 컬렉션의 특징 : 크기 제한 X, 다양한 기능 제공, 객체만 저장
	// 제네릭<T> : 컬렉션 타입 제한
	
	// Set(집합)
	// - 중복 데이터 저장 불가(같은 객체를 덮어 씌움)
	// - 순서를 유지하지 않음(index 없음)
	//	  -> get() 메서드가 없음

	// 대표적인 자식 클래스
	// HashSet : hashCode()를 이용해서 중복 비교
	//			hashCode() 오버라이딩 필수
	//			빠른 검색 지원
	
	// LinkedHashSet : 순서가 유지되는 Set
	//				   hashCode() 오버라이딩 필수
	
	// TreeSet : 저장되는 값을 자동으로 정렬
	//			Comparable 상속 필수
	
	
	public void ex1() {
		// 기본적인 Set 사용법
		
		// String, Integer 등 Java 제공 객체는
		// 기본적으로 hashCode(), equals(), compareTo() 등이
		// 오버라이딩 되어 있음

		Set<String> set = new HashSet<String>(); // hashcode 순서로 정렬됨
//		Set<String> set = new LinkedHashSet<String>(); // 정렬하느라고 내부적으로 속도가 좀 느림
		
		// 1. boolean set.add(E e) : 추가
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의 민족");
		set.add("당근마켓");
		set.add("토스");
		set.add("직방");
		set.add("야놀자");
		
		System.out.println(set);
		// HashSet은 순서 유지 X
		
		
		// 중복 저장 확인 -> 중복 저장 X (제거)
		set.add("야놀자");
		set.add("야놀자");
		set.add("야놀자");
		set.add("야놀자");
		set.add("야놀자");
		
		System.out.println(set);
		
		set.add(null);
		// null : 참조하는 객체가 없음 == 주소 저장 X
		// set에 null도 저장되나 1개만 가능(중복 X)
		
		set.add(null);
		set.add(null);
		set.add(null);
		
		System.out.println(set);
		
		
		// 2. int set.size() : 저장된 객체의 수 반환
		System.out.println("size : " + set.size());
		
		// 3. boolean remove(E e) : 
		//	e와 똑같은 요소가 set에 있으면 삭제 후 true 반환
		//	없으면 false 반환
		
		if( set.remove("직방") ) {
			System.out.println("직방이 제거되었습니다.");
		} else {
			System.out.println("직방이 없습니다.");
		}
		
		System.out.println(set);
		
		// 4. boolean set.contains(E e)
		//  set에 저장된 객체 중 e와 똑같은 객체가 있으면 true, 아니면 false
		System.out.println("네이버 " + (set.contains("네이버") ? "있음" : "없음"));
		System.out.println("직방 " + (set.contains("직방") ? "있음" : "없음"));
		
		// 5. void set.clear() : set에 저장된 객체를 모두 지움
		set.clear();
		System.out.println("clear 후 size : " + set.size());
		
		// 6. boolean set.isEmpty()
		// set에 저장된 객체가 없다면(비어있다면) true, 아님 false
		// = set.size() == 0 과 같은 뜻
		
		System.out.println("set이 " + (set.isEmpty() ? "비어있음" : "비어있지 않음"));
		
	}
	
	
	
	public void ex2() {
		// Set에 저장된 값 꺼내쓰는 방법
		// set은 인덱스가 없어서 어쩔 수 없이 다 꺼내봐야한다
		
		// 1. Iterator (반복자)
		// - 컬렉션 객체의 요소를 하나씩 꺼내서 반복 접근할 수 있는 객체
		//	(순서대로 요소를 하나씩 꺼내는 객체)
		
		Set<String> set = new HashSet<String>();
		set.add("포카칩");
		set.add("빅파이");
		set.add("몽쉘");
		set.add("꼬북칩");
		set.add("하겐다즈");
		set.add("메로나");
		
		// Iterator set.iterator():
		// set의 내용을 순차(반복) 접근할 수 있는 형태로 변경해서 반환
		Iterator<String> it = set.iterator();
		
		// boolean it.hasNext() : 
		// 다음 꺼낼 요소가 있으면 true, 없으면 false
		while(it.hasNext()) {
			
			// E it.next() : 다음 요소 꺼내서 반환
			String temp = it.next();
			
			System.out.println(temp);
			
		} // 이런게 있구나~ 정도 알고있음됩니당
		
		// --------------------------------------------------------------
		
		// 2. 향상된 for문
		System.out.println("---------------------------------");
		
		for ( String s : set  ) {
			System.out.println(s);
		}
	}
	
	
	public void ex3() {
		
		// Set이 중복을 확인하는 방법
		// -> 새로 추가하려는 객체와
		//	  Set에 있는 객체가
		//	  equals() 수행 시 true &&
		//	  hashCode() 비교 시 true이면 중복으로 판단
		
		// * Set 이용하려면 equals()와 hashCode() 둘 다 필수로 오버라이딩
		
		Set<Student> set = new HashSet<Student>();
		
		set.add( new Student(2, 3, 11, "최한솔", 'M', 78));
		set.add( new Student(2, 3, 11, "최한솔", 'M', 78));
		
		System.out.println("size : " + set.size());
		
		for(Student s : set) {
			System.out.println(s);
		}
		
	}

	
	public void createLottoNumber() {
		
		// 로또번호 (1~45, 6개, 중복X, 오름차순)
		
		
		Random random = new Random(); // 난수 생성 객체
		
		// 컬렉션은 기본 자료형 저장 불가
		// -> Wrapper 클래스 이용
//		Set<Integer> lotto = new HashSet<Integer>(); 
		Set<Integer> lotto = new TreeSet<Integer>(); //  오름차순 정렬 set 
		
		while(lotto.size() < 6) { // lotto에 저장된 난수가 6개 미만이면 반복
			lotto.add( random.nextInt(45) + 1 );
		}
		
		System.out.println(lotto);
		
	}
	
	public void lottoVersion2() {
		
		// 금액을 입력 받아서(천원 단위)
		// 3천원이면 3회, 5천원이면 5회 치
		// 로또 번호를 자동으로 생성해서 출력
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			
			try {
				
				System.out.print("\n금액을 입력하세요 : ");
				int money = sc.nextInt();
				
				if(money == 0) {
					break; //return
				}
				
				if(money < 1000) {
					System.out.println("1000원 이상을 입력해주세요");
//					return;
				}
				
				for(int i = 1; i <= money/1000; i++) {
					System.out.print(i+"회 : ");
					createLottoNumber();
				}
				
			} catch(InputMismatchException e) {
				System.out.println("숫자만 입력해주세요");
				sc.nextLine(); // 입력버퍼에 남은 문자열 제거
			}

		}
		
		
		
				
		
//		System.out.println("얼마치 로또를 구매하실건가요? : ");
//		int lottoturn = sc.nextInt();
//		
//		int turn = money / 1000;
//		int 잔돈 = money % 1000;
//		
//		Set<Integer> lotto = new TreeSet<Integer>();
//		
//		Random random = new Random();
//		
//		for(int i = 1; i<= turn; i++) {
//			
//			System.out.print(i + "회 : ");
//			while(lotto.size() < 6) {
//				lotto.add( random.nextInt(45) + 1 );
//			}
//			
//			System.out.println(lotto);
//			lotto.clear();
//		}		
		
//		System.out.println("잔돈은 "+잔돈+"원 입니다.");
		
	}
	
	
	

}
