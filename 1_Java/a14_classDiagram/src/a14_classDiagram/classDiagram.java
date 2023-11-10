package a14_classDiagram;

public class classDiagram {
	
	public class BuyCar{
		private Driver bestDriver;
		private Car carType;
		
		public BuyCar(Driver d) {
			this.bestDriver = d;
			this.carType = new Benz();
		}
	}
	
	
	public abstract class Car{
		public void defaultFunction() {}
		protected abstract void specialFunction();
	}

	
	public class Status{
		private int speed;
		private String engineStatus;
		private String oilStatus;
	}
	
	
	public class Driver{
		private String name;
		private int age;
	}
	
	
	public class Benz extends Car{
		private static int price;
		
		public Status autoDrive(){
			Status status = new Status();
			return status;
		}
		
		@Override
		protected void specialFunction() {}
	}
	
	
	public class Audi extends Car{
		private int price;
		
		public void saveMode() {}
		
		@Override
		protected void specialFunction() {}
	}
	
	

}


