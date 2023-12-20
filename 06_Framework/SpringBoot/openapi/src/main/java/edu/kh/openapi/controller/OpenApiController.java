package edu.kh.openapi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class OpenApiController {
	
	@GetMapping("ex1")
	public String ex1() {
		return "ex1";
	}
	
	
	/** Java에서 OpenAPI 요청하기
	 * @return
	 * @throws JSONException 
	 */
	@GetMapping("ex2")
	public String ex2(Model model, @RequestParam(value="regionName", required=false, defaultValue = "서울") String regionName) throws IOException, JSONException {
		
		// 인증키
		final String serviceKey ="zICFxRCxeKNDk0eZH240WS8zMz0oqxcxx5MzyqcDCG62vDweuJMmeVOa8tsFAYQSARpg2uBfAaJo%2BxauvnvhDw%3D%3D";
		
		// 지역 좌표가 저장된 map
		final Map<String, String> coordinateList = new HashMap<>();
		
	      coordinateList.put("서울", "60/127");
	      coordinateList.put("경기", "60/120");
	      coordinateList.put("인천", "55/38");
	      coordinateList.put("제주", "52/127");
	      coordinateList.put("세종", "66/103");
	      coordinateList.put("광주", "58/74");
	      coordinateList.put("대구", "89/90");
	      coordinateList.put("대전", "67/100");
	      coordinateList.put("부산", "76");
	      coordinateList.put("울산", "102/84");
	      coordinateList.put("강원", "73/134");
	      coordinateList.put("경북", "89/91");
	      coordinateList.put("경남", "91/77");
	      coordinateList.put("전북", "63/89");
	      coordinateList.put("전남", "51/67");
	      coordinateList.put("충북", "69/107");
	      coordinateList.put("충남", "68/100");
	      
	   // 현재 시간 얻어와 baseDate, baseTime가공
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd/HH/mm");
	      String[] arr = (sdf.format(new Date())).split("/");
	      
	      String baseDate = arr[0];
	      
	      int hour = Integer.parseInt(arr[1]);
	      int minute  = Integer.parseInt(arr[2]);
	      
	      // 매시간 30분에 생성되고 10분마다 최신 정보로 업데이트(기온, 습도, 바람)
	      String baseTime = "";
	      if(minute <= 45) { 
	         if(hour == 0) hour = 24;
	         
	         baseTime = String.format("%02d30", hour-1);
	      }else {
	         
	         baseTime = String.format("%02d30", hour );
	      }
	      
	      String[] coordinate = (coordinateList.get(regionName)).split("/");
	      String nx = coordinate[0];
	      String ny = coordinate[1];
	      
	      
	      StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst"); /*URL*/
	        
	      urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
	        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(baseDate, "UTF-8")); /*‘21년 6월 28일 발표*/
	        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(baseTime, "UTF-8")); /*06시 발표(정시단위) */
	        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8")); /*예보지점의 X 좌표값*/
	        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8")); /*예보지점의 Y 좌표값*/
	        
	        // URL : 주소 관리하는 객체(연결 등의 작업 진행)
	        URL url = new URL(urlBuilder.toString());
	        
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        
	        conn.setRequestMethod("GET"); // GET 방식 요청
	        
	        conn.setRequestProperty("Content-type", "application/json");
	        
	        // HTTP 응답 상태 코드(200번대 성공을 의미)
	        System.out.println("Response code: " + conn.getResponseCode());
	        
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) { // 성공시
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        
	        rd.close();
	        conn.disconnect();
	        
	        // 결과 데이터가 JSON 형태로 존재하는 것을 확인
	        System.out.println(sb.toString());
	        
	        // ----------------------------------------------------------------------------
	        
	        // JSONObject : Spring Boot에서 제공하는 JSON 다루기 용도의 객체 
	        JSONObject j1 = new JSONObject(sb.toString());
	        
	        // JSON 데이터에서 response만 얻어오기
	        String response = j1.getString("response");
	        
	        // body 부분만 얻어오기
	        JSONObject j2 = new JSONObject(response);
	        String body = j2.getString("body");
	        
	        // items 부분만 얻어오기
	        JSONObject j3 = new JSONObject(body);
	        String items = j3.getString("items");
	        
	        // item 부분만 얻어오기
	        JSONObject j4 = new JSONObject(items);
	        String item = j4.getString("item");

	        // JSON -> Map으로 변경
	        
	        //ObjectMapper : Jackson 라이브러리에서 제공하는 객체
	        // JSON 데이터를 Java 객체로 변환하는 객체
	        ObjectMapper om = new ObjectMapper();
	        
	        // item변수에 담긴 JSON 데이터 하나하나를
	        // Map으로 변경한 후 list에 추가
	        List<Map<String, Object>> list = om.readValue(item, List.class);
	        
	        
	        // list에서 필요한 데이터만 꺼내는 작업
	           Map<String, Object> weatherMap = new HashMap<>();
	           
	           
	           weatherMap.put("fcstDate", list.get(0).get("fcstDate"));
	           weatherMap.put("fcstTime", list.get(0).get("fcstTime"));
	           
	           for(Map<String, Object> map : list){
	               if(map.get("fcstDate").equals(weatherMap.get("fcstDate")) &&
	                  map.get("fcstTime").equals(weatherMap.get("fcstTime"))){

	                  weatherMap.put((String)map.get("category"), map.get("fcstValue"));
	               }
	           }
	           
	           String sky = null;
	           switch((String)weatherMap.get("SKY")){
	           case "1": sky = "맑음";       break;
	           case "3": sky = "구름많음"; break;
	           case "4": sky = "흐림";    break;
	           }
	           
	           
	           String pty = null;
	           switch((String)weatherMap.get("PTY")){
	           case "0": pty = "없음";       break;
	           case "1": pty = "비";       break;
	           case "2": pty = "비/눈";       break;
	           case "3": pty = "눈";       break;
	           case "5": pty = "빗방울"; break;
	           case "6": pty = "빗방울눈날림";    break;
	           case "7": pty = "눈날림";    break;
	           }
	           
	           weatherMap.put("SKY", sky);
	           weatherMap.put("PTY", pty);
	           
	          
	          model.addAttribute("weatherMap", weatherMap);
	        
	        return "ex2";
	}
	
	

}
