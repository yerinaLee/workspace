package edu.kh.inheritance.run.복습;

import edu.kh.inheritance.model.dto.복습.Child1;
import edu.kh.inheritance.model.dto.복습.Child2;
import edu.kh.inheritance.model.dto.복습.Parent;

public class TestRun {
	
	
	public static void main(String[] args) {
		
		Parent p1 = new Parent();
		Parent p2 = new Parent(100, "하");
		
		System.out.println("-----------------------------");
		
		Child1 c1 = new Child1("마세라티");
		Child2 c2 = new Child2("한남동");
		
		
		
		
	}

}
