package edu.kh.poly.run;

import edu.kh.poly.model.dto.Animal;
import edu.kh.poly.model.dto.Fish;
import edu.kh.poly.model.dto.Person;

public class AbstractRun {

	public static void main(String[] args) {
		
		
		Person p = new Person("포유류", "잡식", "김길동", 64);
		Fish f = new Fish("어류", "초식", 2);
		
		Animal a1 = p;
		Animal a2 = f;
		
		System.out.println(a1.toString());
		a1.breath();
		
		System.out.println(a2.toString());
		a2.breath();
		
		System.out.println("------------------");
		System.out.println(a1);
		
		
		
		
		
		
	}
	
	
	
	
}
