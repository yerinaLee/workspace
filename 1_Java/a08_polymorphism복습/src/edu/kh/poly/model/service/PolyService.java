package edu.kh.poly.model.service;

import edu.kh.poly.model.dto.Car;
import edu.kh.poly.model.dto.Porsche;
import edu.kh.poly.model.dto.Spark;

public class PolyService {
	
	
	private Car[] arr = {
			new Porsche(4, 2, "고급 휘발유", false),
			new Spark(4, 4, "휘발유", 0.5),
			new Porsche(6, 4, "경유", true),
			new Spark(4, 2, "가솔린", 0.7),
			new Car(8, 3, "경유")
			};
	
	public Car selectOne(int index) {
		
		if(index >= 0 && index < arr.length) {
			return arr[index];
		}
		
		return null;
	}
	
	public void printCar() {
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] instanceof Porsche) {
				System.out.print("포르쉐 : ");

			} else if(arr[i] instanceof Spark) {
				System.out.print("스파크 : ");
				
			} else {
				System.out.print("자동차 : ");
			}
			
			
			System.out.println(arr[i].toString());
		}
		
		
		for( Car c : arr ) {
			c.bindingTest();
		}
		
		
		
		
	}
	
	
	
	
	

}
