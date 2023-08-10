package edu.kh.collection.map.ex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.kh.collection.list.model.dto.Student;

public class MapEx {
	
	/* Map : 특정 키워드(key)를 입력하면
	 * 		해당되는 상세한 값(value)를 얻을 수 있는 컬렉션 객체
	 * 
	 * - K:V 한 쌍으로 데이터를 저장 (K:V 한쌍을 묶어서 Entry라고 부름)
	 * 
	 * - Key : 키워드 역할
	 *  1) 중복 X (Key 중복 시 Value를 새로운 내용으로 덮어씌움)
	 *  	* Key 역할을 하는 객체에는
	 *  	  equals(), hashCode()가 오버라이딩 되어있어야 한다!
	 *  
	 *  2) 순서 유지 X
	 *  --> Map에서 Key만 묶어 놓으면 Set과 같은 특징을 지님
	 *  
	 *  
	 *  - Value : 키워드에 대응되는 값의 역할
	 *  1) key로 인해서 구분됨 -> 중복 허용
	 *	--> Value만 묶어놓으면 List와 같은 특징을 지님
	 *
	 */
	
	
	public void ex1() {
		//  key제한  value제한
		Map<Integer, String> map = new HashMap<Integer, String>(); 
		
		// 1. V map.put(K k, V v) : Map에 추가
		// Map에 추가 시 Key가 중복되면 새로운 Value로 덮어씌우고
		// 이전 Value가 반환된다.
		// 중복 아니면 null 반환
		
		System.out.println( map.put(1, "에그마요") );
		System.out.println( map.put(2, "미트볼") );
		System.out.println( map.put(3, "비엘티") );
		
		System.out.println( map.put(3, "서브웨이클럽") );

		System.out.println(map);
		
//		null
//		null
//		null
//		비엘티
//		{1=에그마요, 2=미트볼, 3=서브웨이클럽}
		
		
		
		// 2. V map.get(K k) : 
		// map에서 key에 해당하는 Value를 반환
		// 일치하는 Key가 없으면 null 반환
		
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(3));
		
		// Value가 String이니까 String 변수에 저장
		String s = map.get(1);
		
		// 3. int map.size() : 저장된 K:V 쌍의 수를 반환 (총 몇 쌍)
		System.out.println("K:V 몇 쌍? : " + map.size());
		
		// 4. V map.remove(K k) : 
		// map에서 Key가 일치하는 요소(K:V 쌍)을 제거
		// 제거되는 V 반환, 없으면 null 반환
		System.out.println( map.remove(1) + "제거" );
		System.out.println( map.remove(9) + "제거" );
		
		// 5. void map.clear() : map 다 지움
		map.clear();
		
		// 6. boolean map.isEmpty() : 비었으면 true, 아님 false
		System.out.println("비었음? " + map.isEmpty());
		
		
	}
	
	
	public void ex2() {
		// Map에 저장된 값 순차 접근(반복해서 순서대로 하나씩 꺼내기)
		
		// 1. Set map.keySet() : 
		// Key만을 모아놓은 집합(Set)을 반환
		
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("집", "부산 해운대");
		map.put("학원", "서울시 중구");
		map.put("스타필드 하남", "경기도 하남시");
		map.put("롯데타워", "서울시 송파구");
		
		Set<String> set = map.keySet();
		
		System.out.println(set);
		
		
		// 2. keySet을 이용해서 Map에 있는 모든 요소 순차 접근
		
		System.out.println("---------------------");
		
		for( String key : set) {
			System.out.printf("[%s] %s \n", key, map.get(key));
		}
	}
	
	
	// Map 사용예시!
	public void ex3() {
		
		// Map은 언제 사용하면 좋을까??
		
		// 1) 한번에 많은 양의 데이터를 
		//	  명확하게 구분할 수 있는 형태로
		//	  전달해야하는 경우
		
		// 2) DTO(Date Transfer Object) : 값 / 전달용 / 객체
		// DTO가 없거나, 있어도 사용 빈도가 낮은 경우
		// Map으로 대체해서 사용
		
		Map<String, Object> s1 = new HashMap<String, Object>();
		
		// Value의 타입이 Object로 제한되어있다
		// == 어떤 객체든 Value에 들어올 수 있다
		
		s1.put("grade", 3); // 3(int) -> Integer로 Auto Boxing
		s1.put("ban", 5);
		s1.put("number", 17);
		s1.put("name", "전원우");
		s1.put("gender", 'M');
		s1.put("score", 75);
		
		Set<String> set = s1.keySet(); // key들의 집합
		
		for(String key : set) {
			System.out.printf("%s : %s \n", key, s1.get(key) );
		}
		
		System.out.println("----------------------------------");
		
		
		// Map과 DTO 비교
		Student s2 = new Student();
		s2.setGrade(2);
		s2.setBan(7);
		s2.setNumber(24);
		s2.setName("최한솔");
		s2.setGender('F');
		s2.setScore(80);
		
		// s1, s2의 학년 반 번호 이름만 출력
		System.out.printf("s1 : %d학년 %d반 %d번 %s\n",
				s1.get("grade"), s1.get("ban"), s1.get("number"), s1.get("name"));
		// s1.get("grade")는 자료형이 Object이지만
		// 이 객체가 갖고 있는 toString이 %d int형의 toString으로 동적바인딩 되어서 문제없이 출력됨
		
		System.out.printf("s2 : %d학년 %d반 %d번 %s\n", s2.getGrade(), s2.getBan(), s2.getNumber(), s2.getName());
		
		
		
		
		
		
		
			
	}
}
