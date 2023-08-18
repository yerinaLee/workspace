package practice.yrn.local.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import practice.yrn.local.model.dto.Local;

public class LocalService {
	
	private List<Local> localList = new ArrayList<Local>();
	
	public LocalService() {
		
		localList.add( new Local("서울", 02, "9,911,088", 605.23, "오세훈"));
		localList.add( new Local("부산", 051, "3,466,563", 765.82, "박형준"));
		localList.add( new Local("인천", 032, "2,981,553", 1_067.0, "유정복"));
		localList.add( new Local("대전", 042, "1,444,898", 539.5, "이장우"));
		localList.add( new Local("광주", 062, "1,424,305", 501.0, "강기정"));
		localList.add( new Local("울산", 052, "1,105,326", 1_062.8, "김두겸"));
		localList.add( new Local("대구", 053, "2,379,086", 1_499.5, "홍준표"));
		localList.add( new Local("제주", 064, "492,647", 978.67, "강병삼"));

	}
	
	// 1. 지역 전체조회
	public List<Local> searchAll() {
		return localList;
	}
	
	
	
	
	
	
	
	

}
