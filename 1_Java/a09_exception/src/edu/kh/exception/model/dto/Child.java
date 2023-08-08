package edu.kh.exception.model.dto;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketException;
import java.util.zip.DataFormatException;

// 클래스간의 상속 : extends
// 인터페이스 - 클래스 상속 : implements
public class Child extends Parent {

	// 상속 : 부모의 멤버를 자식이 자신의 것처럼 사용
	// 오버라이딩 : 상속받은 부모의 메서드를 자식이 재정의하는 것
	
	// 예외를 똑같이 쓰면 문제 없음
	// @Override
	// public void method() throws IOException {}
		
	// 예외의 범위를 좁게(자식 예외)를 쓰면? 문제 없음
	//@Override
	//public void method() throws EOFException {}
	
	// 예외의 범위를 넓게(부모 예외보다)를 쓰면 문제 발생!!!!(불가능) 
	//@Override
	//public void method() throws Exception {	}
	
	// 예외의 개수를 다르게 쓰면
	// 1) 상속 관계가 아닌 다른 예외 여러 개 작성은 불가!
	// 2) 상속 관계의 자식 예외를 여러 개 작성하는 건 가능!
	@Override
//	public void method() throws IOException, DataFormatException {	}
	public void method() throws EOFException, SocketException {	}
	
	
	
	

}
