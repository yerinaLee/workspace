package a05_oop복습;

public class PersonServiceRun {
	
	public static void main(String[] args) {
		
		PersonService service = new PersonService();
		String title = service.getTitle();
		System.out.println(title);
		
		Person p1 = service.createPerson();
		String person = service.personFeilds(p1);
//		String person = service.personFeilds(p);
//		   -> 이거 p는 왜 안돼지?
		
		System.out.println(person);
		
		
		
		
	}

}
