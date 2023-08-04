package edu.kh.oarr.model.service;

import java.util.Random;

import edu.kh.oarr.model.dto.Student;

public class StudentService {

	// 필드
	private Student[] studentArr = new Student[10];
	// 학생 객체 참조 변수 10개의 묶음 Student[]을 할당하고
	// 그 주소를 studentArr에 대입
	
	// studentArr[0], studentArr[1], studentArr[2] ...
	// 각 배열 요소 하나하나는 Student 객체 참조변수가 된다.
	
	
	//- 기본생성자
	//  학생 객체배열에 들어갈 샘플 학생 데이터를 3개 추가
	public StudentService() {
		
		studentArr[0] = new Student(1, 2, 3, "전원우");
		studentArr[1] = new Student(2, 3, 20, "이도겸");
		studentArr[2] = new Student(3, 6, 8, "조슈아");
		
		
		Random random = new Random(); // 랜덤 객체 생성(자바에서 제공)
		
		for(int i = 0; i < studentArr.length; i++) {
			// studentArr[3] 부터 참조하는 학생 객체가 없음
			// studentArr[3] 부터 저장된 값은 null
			// * null : 참조하는 객체가 없음을 뜻하는 값
			
			if(studentArr[i] == null) {
				break; // 학생 객체가 없으면 반복문 멈춤
			}
			
			// random.nextInt(101)
			// - 정수형 난수 0 이상 101미만의 정수형 난수를 반환
			studentArr[i].setKor(random.nextInt(101));
			studentArr[i].setEng(random.nextInt(101));
			studentArr[i].setMath(random.nextInt(101));
		}
	}
	
	
	/** 학생 추가 서비스 입니다. */
	public boolean addStudent(int grade, int ban, int number, String name) {
		
		// 1. studentArr의 요소 중
		//   참조하는게 없는 배열 요소를 찾아
		//   그 중 index 번호가 가장 낮은 요소에 학생 객체 주소를 대입
		//   true 반환
		for (int i = 0; i < studentArr.length; i++) {
			
			if(studentArr[i] == null) { //참조하는게 없을 경우
				// 학생 객체를 생성하여 주소를 대입
				
				studentArr[i] = new Student(grade, ban, number, name);
				
				// return : 현재 메서드를 즉시 멈추고 호출한 곳으로 돌아감
				return true;
			}
		}

		// 2. studentArr의 요소 중
		//   참조하는게 없는 배열 요소가 없을 경우 (꽉 찬 경우)
		//   false를 반환
		return false;
	}

	
	/** 학생 전체 조회 서비스 입니다. */
	public Student[] selectAll() {
		return studentArr;
	}


	/** 학생 1명 정보 조회(인덱스) */
	public Student selectIndex(int index) {

		// index가 배열 범위를 초과하거나
		// studentArr[index] 요소가 저장한 값이 null인 경우
		// null 반환
		if ( index < 0 ||
			 index >= studentArr.length ||
			 studentArr[index] == null) {
			return null;
		}
		
		// index번째 요소에 학생 객체를 참조하는 주소가 있는 경우
		// 그 주소를 반환
		return studentArr[index];
	}
	
	
	// (서비스)
	// 인덱스 범위를 초과하거나 참조하는 학생 객체가 없으면
	// "해당 인덱스에 학생 정보가 존재하지 않습니다." (문자열)
	
	// 있으면
	// "[홍길동] 국어:30, 영어:40, 수학:50, 합계:120, 평균:40.0"
	// 문자열을 반환
//	public Student selectScore(int index) {
//		
//		if(index < 0 || index >= studentArr.length || studentArr[index] == null) {
//			return null;
//		}
//		
//		return studentArr[index];
//		
//	}
	
	public String selectScore(int index) {
		
		if(index < 0 || index >= studentArr.length || studentArr[index] == null) {
			return "해당 인덱스에 학생 정보가 존재하지 않습니다.";
//			System.out.println("해당 인덱스에 학생 정보가 존재하지 않습니다.");
		}
		
		// studentArr[index] 쓰기 기니까 짧은 이름의 변수에 주소만 복사
		Student s = studentArr[index];
		int sum = s.getKor() + s.getEng() + s.getMath(); // 합계

//		return 	"["+studentArr[index].getName()+"] "
//				+ "국어:"+studentArr[index].getKor()+", "
//				+ "영어:"+studentArr[index].getEng()+
//				", 수학:"+studentArr[index].getMath()+
//				", 합계:"+(studentArr[index].getKor()+studentArr[index].getEng()+studentArr[index].getMath())+
//				", 평균:"+ (double)(studentArr[index].getKor()+studentArr[index].getEng()+studentArr[index].getMath())/3.0;
		
		
		return String.format("[%s] 국어:%d, 영어:%d, 수학:%d, 합계:%d, 평균:%.1f",
				s.getName(), s.getKor(), s.getEng(), s.getMath(), sum, sum/3.0); 
		
		
	}

//	/** 학생 정보 수정 1.*/
//	public Student updatesStudent(int index) {
//		
//		if (studentArr[index] == null) {
//			return null;
//		} else {
//			return studentArr[index];
//		}
//	}


	/** 학생 정보 수정 서비스 */
	public void updatesStudent(Student s, int kor, int eng, int math) {
		s.setKor(kor);
		s.setEng(eng);
		s.setMath(math);		
	}

	
	/** 4. 학생 이름으로 조회 (동명이인 감안) */
	public Student[] selectName(String name) {

		// 기본 자료형 || 참조형(주소) || null 비교시
		// 비교연산자 (==, !=)
		
		// String || 객체가 가지고 있는 모든 필드 비교시
		// A.equals(B) 메서드 사용!
		// "abc".equals("abc");
		
		// 1. 반환하려는 Student 객체 배열의 크기를
		//	studentArr과 똑같이 만든 후
		//  검색한 학생을 차례대로 배열에 추가 후 반환
		//  -> for문으로 출력 시 배열 요소가 null인 경우 반복 종료
		
		// 써본 구문이지만 불필요한 배열이 낭비될 수도
		
		
		// 2. 같은 이름의 학생을 studentArr 배열에서 찾아 카운트한 후
		//  카운트한 크기 만큼의 학생 객체 배열을 생성 후
		//  같은 이름의 학생을 찾아 생성한 배열에 추가
		
		
		int count = 0;
		
		for( Student s : studentArr ) {
			
			// NullPointerException (null을 참조해서 필드, 메서드 접근시 발생)
			// 방지하기
			if(s==null) {
				break;
			}
			
			if(s.getName().equals(name)) {
				// s.getName()과 name의 값이 같을 때
				count++;
			}
			
		}
		
		// count == 0인 경우 (같은 이름의 학생이 없음)
		if(count == 0) {
			return null;
		}
		
		// 검색된 학생을 저장할 배열 생성
		Student[] arr = new Student[count];
		
		int index = 0; // 검색된 학생 객체의 주소를
					   // arr 배열의 몇 번 인덱스에 대입해야 되는지를 제어 
		
		for ( Student s : studentArr ) {
			
			if (s == null) { // NullPointerException 방지
				break;
			}
			
			if(s.getName().equals(name)) { // 이름이 일치하는 학생일 경우
				arr[index] = s;
				index++;
			}
		}
		
		return arr;
	}
	
	
	/** 7. 평균 최고점, 최저점 학생 찾기  */
	public Student[] selectMaxMin() {
		
		
		Student[] arr = new Student[2]; // [0] : 최고점, [1] : 최저점
		
		// 인덱스
		int max = 0;
		int min = 0;
		
		for(int i = 0; i < studentArr.length ; i++) {
			
			if(studentArr[i] == null) { // 더이상 학생이 없으면 멈춤
				break;
			}
			
			// 최고점의 합
			Student s1 = studentArr[max];
			int maxSum = s1.getKor()+s1.getEng()+s1.getMath();

			// 최저점의 합
			Student s2 = studentArr[min];
			int minSum = s2.getKor()+s2.getEng()+s2.getMath();
			
			// 현재 인덱스(i)번째 요소의 합
			Student s3 = studentArr[i];
			int sum = s3.getKor()+s3.getEng()+s3.getMath();

			if(sum > maxSum) { // 최대값 보다 큰 경우
				max = i; // 현재 인덱스를 max에 저장
			}
			
			if(sum < minSum) {
				min = i;
			}
		}
		
		// 최고점 학생을 0번, 최저점 학생을 1번 인덱스에 대입
		arr[0] = studentArr[max];
		arr[1] = studentArr[min];
		
		return arr;
	}
	
}
