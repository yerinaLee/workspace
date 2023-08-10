package practice.yrn.local.model.dto;

import java.util.HashMap;
import java.util.Map;

public class Local {
	
	private String name; // 지역명
	private int localNumber; // 지역번호
	private int theNumberOfPeople; // 인구수
	private double area; // 면적
	private String mayor; // 시장이름

	private Map<String, String> historicalPlace = new HashMap<String, String>(); // 역사적 명소 
	private Map<String, String> naturePlace = new HashMap<String, String>(); // 자연 명소
	private Map<String, String> religiousPlace = new HashMap<String, String>(); // 종교적 명소
	private Map<String, String> youngPlace = new HashMap<String, String>(); // 시내
	
	
	public Local() {
	}

//

	public Local(String name, int localNumber, int theNumberOfPeople, double area, String mayor,
			Map<String, String> historicalPlace, Map<String, String> naturePlace, Map<String, String> religiousPlace,
			Map<String, String> youngPlace) {
		super();
		this.name = name;
		this.localNumber = localNumber;
		this.theNumberOfPeople = theNumberOfPeople;
		this.area = area;
		this.mayor = mayor;
		this.historicalPlace = historicalPlace;
		this.naturePlace = naturePlace;
		this.religiousPlace = religiousPlace;
		this.youngPlace = youngPlace;
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


	public int getTheNumberOfPeople() {
		return theNumberOfPeople;
	}


	public void setTheNumberOfPeople(int theNumberOfPeople) {
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


	public Map<String, String> getHistoricalPlace() {
		return historicalPlace;
	}


	public void setHistoricalPlace(Map<String, String> historicalPlace) {
		this.historicalPlace = historicalPlace;
	}


	public Map<String, String> getNaturePlace() {
		return naturePlace;
	}


	public void setNaturePlace(Map<String, String> naturePlace) {
		this.naturePlace = naturePlace;
	}


	public Map<String, String> getReligiousPlace() {
		return religiousPlace;
	}


	public void setReligiousPlace(Map<String, String> religiousPlace) {
		this.religiousPlace = religiousPlace;
	}


	public Map<String, String> getYoungPlace() {
		return youngPlace;
	}


	public void setYoungPlace(Map<String, String> youngPlace) {
		this.youngPlace = youngPlace;
	}


	@Override
	public String toString() {
		return "Local [name=" + name + ", localNumber=" + localNumber + ", theNumberOfPeople=" + theNumberOfPeople
				+ ", area=" + area + ", mayor=" + mayor + ", historicalPlace=" + historicalPlace + ", naturePlace="
				+ naturePlace + ", religiousPlace=" + religiousPlace + ", youngPlace=" + youngPlace + "]";
	}

	
	
	
	

}
