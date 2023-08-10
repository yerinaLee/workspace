package practice.yrn.local.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import practice.yrn.local.model.dto.Local;

public class LocalService {
	
	private List<Local> localList = new ArrayList<Local>();
	
	//Map<K, V>
	public LocalService() {
		
		Map<String, String> historicalPlace_서울 = new HashMap<String, String>();
		historicalPlace_서울.put("역사명소", "경복궁");
	
		Map<String, String> naturePlace_서울 = new HashMap<String, String>();
		naturePlace_서울.put("자연명소", "북한산");
		
		Map<String, String> religiousPlace_서울 = new HashMap<String, String>();
		religiousPlace_서울.put("종교명소", "봉은사");
		
		Map<String, String> youngPlace_서울 = new HashMap<String, String>();
		youngPlace_서울.put("시내", "홍대");
		
		localList.add( new Local("서울", 02, 6_900_000, 97.5, "오세훈",
				historicalPlace_서울, naturePlace_서울, religiousPlace_서울, youngPlace_서울));
		
		
		Map<String, String> historicalPlace_부산 = new HashMap<String, String>();
		historicalPlace_서울.put("역사명소", "경복궁");
	
		Map<String, String> naturePlace_부산 = new HashMap<String, String>();
		naturePlace_서울.put("자연명소", "북한산");
		
		Map<String, String> religiousPlace_부산 = new HashMap<String, String>();
		religiousPlace_서울.put("종교명소", "봉은사");
		
		Map<String, String> youngPlace_부산 = new HashMap<String, String>();
		youngPlace_서울.put("시내", "홍대");
		
		localList.add( new Local("서울", 02, 6_900_000, 97.5, "오세훈",
				historicalPlace_서울, naturePlace_서울, religiousPlace_서울, youngPlace_서울));
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
