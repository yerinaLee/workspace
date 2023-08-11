package practice.yrn.local.model.dto;

import java.util.HashMap;
import java.util.Map;

public class Local {
	
	private String name; // 지역명
	private int localNumber; // 지역번호
	private int theNumberOfPeople; // 인구수
	private double area; // 면적
	private String mayor; // 시장이름
	
	private String historicalPlace;
	private String naturePlace;
	private String religiousPlace;
	private String youngPlace;

	
	public Local() {
	}


	public Local(String name, int localNumber, int theNumberOfPeople, double area, String mayor, String historicalPlace,
			String naturePlace, String religiousPlace, String youngPlace) {
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


	public String getHistoricalPlace() {
		return historicalPlace;
	}


	public void setHistoricalPlace(String historicalPlace) {
		this.historicalPlace = historicalPlace;
	}


	public String getNaturePlace() {
		return naturePlace;
	}


	public void setNaturePlace(String naturePlace) {
		this.naturePlace = naturePlace;
	}


	public String getReligiousPlace() {
		return religiousPlace;
	}


	public void setReligiousPlace(String religiousPlace) {
		this.religiousPlace = religiousPlace;
	}


	public String getYoungPlace() {
		return youngPlace;
	}


	public void setYoungPlace(String youngPlace) {
		this.youngPlace = youngPlace;
	}


	@Override
	public String toString() {
		return "Local [name=" + name + ", localNumber=" + localNumber + ", theNumberOfPeople=" + theNumberOfPeople
				+ ", area=" + area + ", mayor=" + mayor + ", historicalPlace=" + historicalPlace + ", naturePlace="
				+ naturePlace + ", religiousPlace=" + religiousPlace + ", youngPlace=" + youngPlace + "]";
	}
	
	
	


}
