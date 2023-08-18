package practice.yrn.local.model.dto;

public class Local {
	
	private String name; // 지역명
	private int localNumber; // 지역번호
	private String theNumberOfPeople; // 인구수
	private double area; // 면적
	private String mayor; // 시장이름
	
	public Local() {}
	
	public Local(String name, int localNumber, String theNumberOfPeople, double area, String mayor) {
		this.name = name;
		this.localNumber = localNumber;
		this.theNumberOfPeople = theNumberOfPeople;
		this.area = area;
		this.mayor = mayor;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocalNumber() {
		return localNumber;
	}

	public void setLocalNumber(int localNumber) {
		this.localNumber = localNumber;
	}

	public String getTheNumberOfPeople() {
		return theNumberOfPeople;
	}

	public void setTheNumberOfPeople(String theNumberOfPeople) {
		this.theNumberOfPeople = theNumberOfPeople;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getMayor() {
		return mayor;
	}

	public void setMayor(String mayor) {
		this.mayor = mayor;
	}

	@Override
	public String toString() {
		
		return name + "의 지역정보입니다." +
				"\n지역번호 : " + localNumber +  
				"\n인구수 : " + theNumberOfPeople + "명" +  
				"\n면적 : " + area +  " km^2" +
				"\n시장 : " + mayor;  
	}

	
	
	

}
