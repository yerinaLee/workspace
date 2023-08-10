package edu.kh.collection.list.mode.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.kh.collection.list.mode.dto.Student;

public class StudentService {
	
	private List<Student> studentList //= new ArrayList<Student>();
									= new LinkedList<Student>();
	
	
	public StudentService() {
		studentList.add( new Student(3, 6, 36, "최승철", 'M', 100));
		studentList.add( new Student(1, 3, 8, "윤정한", 'M', 98));
		studentList.add( new Student(2, 4, 11, "홍지수", 'F', 36));
		studentList.add( new Student(1, 1, 1, "전원우", 'F', 67));
		studentList.add( new Student(2, 4, 4, "이도겸", 'M', 74));
	}
	
	
	
	/** 학생 추가 서비스 메서드
	 * @param grade
	 * @param ban
	 * @param number
	 * @param name
	 * @param gender
	 * @param score
	 * @return boolean
	 */
	public boolean addStudent(int grade, int ban, int number, String name, char gender, int score) {
		return studentList.add( new Student(grade, ban, number, name, gender, score));
	}
	
	
	/** 학생 List 반환 service 메서드
	 * @return studentList
	 */
	public List<Student> selectAllStudent() {
		return studentList;
	}
	
	
	/** 인덱스가 일치하는 학생 1명 조회
	 * @param index
	 * @return Student 객체 주소 또는 null
	 */
	public Student selectOne(int index) {
		
		if(index < 0 || index >= studentList.size()) {
			return null;
		}
		return studentList.get(index);
	} 
	
	
	
	
	

}
