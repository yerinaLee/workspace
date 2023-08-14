package practice.yrn.local.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import practice.yrn.local.model.dto.Local;

public class LocalService {
	
	private List<Local> localList = new ArrayList<Local>();
	
	public LocalService() {
		

		localList.add( new Local("서울", 02, 97_760_000, 605.2, "오세훈", "경복궁", "북한산", "봉은사", "홍대"));
		localList.add( new Local("부산", 051, 34_290_000, 770, "박형준", "임시정부", "어딘가", "범어사", "해운대"));
	

		
		
	}
	
	
	
	
	
	
	

}
