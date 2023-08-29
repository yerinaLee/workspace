package a05_oop복습;

public class Person {
	
	private String name;
	private int age;
	private char gender;
	
	public Person() {};
	
	// 생성자
	public Person(String name, int age, char gender) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		
	}
	
	public void setName(String name) {
		this.name = name;
		return;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	public char getGender() {
		return gender;
	}
	


	public static void main(String[] args) {
		
		
		int[] array = {5, 2, 3, 1, 0};
		
        int temp = 0;
        
        for(int i=0; i < array.length-1; i++) {
        	
        	for(int j = i+1; j < array.length ; j++) {
            	if (array[i] > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;                
            	}
        	}
        	
        }
        

        for(int i : array) {
        	System.out.printf("%d", i);
        }
        
        
        
//        int answer = array[array.length / 2];
//        
//		System.out.println(answer);
		
	}
	
	
	
	
	

} // 원본 클래스 끝










