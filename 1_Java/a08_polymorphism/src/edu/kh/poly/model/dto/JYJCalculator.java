package edu.kh.poly.model.dto;

// extends (확장하다) : 클래스 간의 상속 또는 인터페이스 간의 상속
// implements (구현하다) : 부모 인터페이스 - 자식 클래스 상속
//                     인터페이스는 다중 상속 가능

// 정유진 계산기
public class JYJCalculator implements Calculator {

   
   @Override
   public int plus(int a, int b) {
      return a+b;
   }

   @Override
   public int minus(int a, int b) {
      return a-b;
   }

   @Override
   public int multi(int a, int b) {
      return a*b;
   }

   @Override
   public int div(int a, int b) {
      return a/b;
   }

   @Override
   public int mod(int a, int b) {
      return a%b;
   }

   @Override
   public double areaOfCircle(double r) {
      return PI*r*r;
   }
   
   
   @Override
   public int pow(int a, int x) {
	   // x가 무조건 양수인 경우
	   					   // 재귀 호출
	   return x == 1 ? a : a * pow(a, x-1);
   }

//   @Override
//   public int pow(int a, int x) {
//      int answer =1;
//      for(int i = 0; i<x; i++) {
//         answer *= a;
//      }
//      return answer;
//   }

}