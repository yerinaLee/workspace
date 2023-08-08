package edu.kh.collection.list.ex;

import java.util.ArrayList;
import java.util.List;

public class ListEx {
	
	
	public void ex1() {
		
		List list = new ArrayList(3);
		
		list.add("아무거나");
		list.add(123);
		list.add('c');
		
		System.out.println(list);
		
		
		list.add("크기3초과삐용삐용");
		System.out.println(list);
		
		
		System.out.println( list.get(2) );
		System.out.println( list.get(3) );
		
		System.out.println("---------------------------");
		
		
		System.out.println( list.get(1) instanceof Integer);
		System.out.println( list.get(2) instanceof Character);
		
		for(int i = 0; i < list.size(); i++) {
			
			if(list.get(i) instanceof String) {
				String s = (String)list.get(i);
				System.out.println("첫 글자 " + s.charAt(0));
			}
			
			
			if(list.get(i) instanceof Integer) {
				int number = (Integer)list.get(i);
				System.out.println(100 + number);
			}
			
			
			if(list.get(i) instanceof Double) {
				Double d = (Double)list.get(i);
				System.out.println(d.BYTES + "바이트");
			}
			
			
			
			
			
		}
		
		
		
		
		
	}
	
	

}
