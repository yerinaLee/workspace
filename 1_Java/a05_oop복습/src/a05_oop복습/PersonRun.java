package a05_oop복습;

public class PersonRun {
	
	public static void main(String[] args) {
		
		Person p = new Person();
		
		p.setAge(30);
		int age = p.getAge();
		
		p.setGender('여');
		char gender = p.getGender();
		
		p.setName("윤정한");
		String name = p.getName();
		
		System.out.println(name + "님은 " + age + "세이고, 성별은 "+gender+"입니다.");
		
		
		
		Person p1 = new Person("이도겸", 27, '남');
		int age1 = p1.getAge();
		char gender1 = p1.getGender();
		String name1 = p1.getName();
		
		System.out.println(name1 + "님은 " + age1 + "세이고, 성별은 "+gender1+"입니다.");
		
		
		
		
		
		
		
		
		
	}
	
	

}
