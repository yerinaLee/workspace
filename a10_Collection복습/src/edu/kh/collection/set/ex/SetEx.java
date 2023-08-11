package edu.kh.collection.set.ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx {
	
	
	public void ex1() {
		
		Set<String> set = new HashSet<String>();
		
		set.add("나에게넌");
		set.add("해질녘");
		set.add("노을처럼");
		set.add("한편의");
		set.add("아름다운");
		set.add("추억이되고");
		set.add("소중했던");
		set.add("우리푸르렀던");
		set.add("함께하며");
		
		System.out.println(set);
		
		set.add("나에게넌");
		set.add("나에게넌");
		set.add("나에게넌");
		set.add("나에게넌");
		set.add("나에게넌");
		set.add("나에게넌");
		set.add("나에게넌");
		
		System.out.println(set);
		
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		
		System.out.println(set);
		
		System.out.println(set.size());
		
		if ( set.remove(null)) {
			System.out.println("빈방이 삭제되었습니다");
		} else {
			System.out.println("빈방이 없습니다");
		}
		
		
		System.out.println("나에게넌 " + (set.contains("나에게넌") ? "해질녘노을춰럼" : "가사추가요망"));
		
	}
	
	
	
	
	public void ex2() {
		
		Set<String> set = new HashSet<String>();
		
		set.add("땅을보고계속");
		set.add("올랐지");
		set.add("정상까지");
		set.add("많은시간을");
		set.add("보란듯이");
		set.add("아얼웨즈윈");
		set.add("강한맘이");
		set.add("중요하지");
		set.add("미래는도");
		set.add("망가지않아");
		set.add("내가놓기");
		set.add("전까지!!!!!!!");
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String temp = it.next();
			System.out.println(temp);
		}
		
		
		
		
	}
	
	
	
	
	
	
	

}
