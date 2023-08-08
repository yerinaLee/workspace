package edu.kh.poly.run;

import edu.kh.poly.model.dto.Car;
import edu.kh.poly.model.dto.Porsche;
import edu.kh.poly.model.dto.Spark;
import edu.kh.poly.model.service.PolyService;

public class CarRun {
	
	public static void main(String[] args) {
		
		Car c1 = new Car();
		
		Porsche p1 = new Porsche();
		Spark s1 = new Spark();
		
		Car c2 = new Porsche();
		
		c2.setWheel(4);
		
		System.out.println("업캐스팅 확인");
		
		Car[] carArr = new Car[3];
		
		carArr[0] = new Car(4, 5, "경유");
		carArr[1] = new Porsche(4, 2, "휘발유", true);
		carArr[2] = new Spark(4, 4, "휘발유", 0.5);
		
		for (int i = 0; i < carArr.length; i++) {
			System.out.printf("%d / %d / %s \n", carArr[i].getWheel(), carArr[i].getSeat(), carArr[i].getFuel());
		}
		
		
		System.out.println("다운 캐스팅 확인");
		System.out.println(((Porsche)carArr[1]).isOpenTheDoor());
		System.out.println(((Spark)carArr[2]).getDiscountRate());
		
		
		System.out.println("---------------------------------------------");
		
		
		PolyService service = new PolyService();
		
		service.selectOne(2);
		service.printCar();
		
		
		
		
		
		
	}

}
