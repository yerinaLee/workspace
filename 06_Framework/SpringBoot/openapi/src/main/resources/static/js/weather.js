// 화면 요소 얻어오기
const region = document.getElementById("region");
const regionName = document.getElementById("regionName");
const currentWeather = document.querySelector(".current-weather");

/* 서비스키 */
const serviceKey = "zICFxRCxeKNDk0eZH240WS8zMz0oqxcxx5MzyqcDCG62vDweuJMmeVOa8tsFAYQSARpg2uBfAaJo+xauvnvhDw==";

const numOfRows = 900;
const pageNo = 1;
const dataType = "JSON";

/* nx, ny */
// coordinates : 좌표
// 지역별 좌표(기상청 api excel 파일 참고)
const coordinateList = {
  "서울" : {"nx":60, "ny":127},
  "경기" : {"nx":60, "ny":120},
  "인천" : {"nx":55, "ny":124},
  "제주" : {"nx":52, "ny":38},
  "세종" : {"nx":66, "ny":103},
  "광주" : {"nx":58, "ny":74},
  "대구" : {"nx":89, "ny":90},
  "대전" : {"nx":67, "ny":100},
  "부산" : {"nx":98, "ny":76},
  "울산" : {"nx":102, "ny":84},
  "강원" : {"nx":73, "ny":134},
  "경북" : {"nx":89, "ny":91},
  "경남" : {"nx":91, "ny":77},
  "전북" : {"nx":63, "ny":89},
  "전남" : {"nx":51, "ny":67},
  "충북" : {"nx":69, "ny":107},
  "충남" : {"nx":68, "ny":100}
}


/* base_date, base_time 만드는 함수 */
const getBase = (type) => {
    
  const base = {};
  const now = new Date();

  // base_date(오늘 날짜 YYYYMMDD 형식) 계산
  const year = now.getFullYear();

  let month = now.getMonth() + 1;
  month = month < 10 ? "0" + month : month;

  let date = now.getDate();
  date = date < 10 ? "0" + date : date;

  base.baseDate = `${year}${month}${date}`;

  // --------------------------------------
  // 1. 초단기 예보
  if(type === 1){

    // 45분 이하인 경우 1시간 전을 baseTime으로 지정
    const hour = now.getMinutes() <= 45 ? now.getHours()-1 : now.getHours()

    if(hour < 10)    base.baseTime =  "0" + hour + "00";
    else             base.baseTime =  hour + "00";
    return base;
  }
}

// 하늘 상태(SKY) 코드 변환
const getSkyState = (code) => {
  code = Number(code);
  switch(code){
  case 1: return "맑음";
  case 3: return "구름많음";
  case 4: return "흐림";
  }
}

// 초단기 강수 형태(PTY) 코드 변환
const getUltraSrtPtyState = (code) => {
  code = Number(code);
  switch(code){
      case 0: return "없음";
      case 1: return "비";
      case 2: return "비/눈";
      case 3: return "눈";
      case 5: return "빗방울";
      case 6: return "빗방울눈날림";
      case 7: return "눈날림";
  }
}

//-----------------------------------------------------------------------

/* 초단기 예보 조회 */
// regionValue : 지역명
const getUltraSrtNcst = (regionValue)=>{

  const url = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst";

  const nx = coordinateList[regionValue].nx;
  const ny = coordinateList[regionValue].ny;

  // 쿼리스트링 관리하는 객체 생성
  const searchParams = new URLSearchParams();

  const base = getBase(1);

  searchParams.append("serviceKey", serviceKey);
  searchParams.append("numOfRows", numOfRows);
  searchParams.append("pageNo", pageNo);
  searchParams.append("dataType", dataType);
  searchParams.append("base_date", base.baseDate);
  searchParams.append("base_time", base.baseTime);
  searchParams.append("nx", nx);
  searchParams.append("ny", ny);


  /* Ajax로 regionName 지역의 초단기예보 요청하기 */
  fetch(`${url}?${searchParams.toString()}`)
  .then(resp => resp.json())
  .then(result => {

    console.log(result);

    const list = result.response.body.items.item;

    const weatherObj = {};

    weatherObj.fcstDate = list[0].fcstDate;
    weatherObj.fcstTime = list[0].fcstTime;
    
    for(let item of list){
        if(item.fcstDate == weatherObj.fcstDate && 
            item.fcstTime == weatherObj.fcstTime){

            weatherObj[item.category] = item.fcstValue;
        }
    }

    console.log(weatherObj);

    currentWeather.innerHTML = "";

    const h1 = document.createElement("h1");
    h1.innerText = weatherObj["T1H"] + "℃";

    const p1 = document.createElement("p");
    p1.innerText = getSkyState(weatherObj["SKY"] );

    const p2 = document.createElement("p");
    p2.innerText = "습도(%) :" + weatherObj["REH"];

    const p3 = document.createElement("p");
    p3.innerText = getUltraSrtPtyState(weatherObj["PTY"]);

    const p4 = document.createElement("p");
    p4.innerText = "강수 확률(%) : " + weatherObj["RN1"];

    currentWeather.append(h1, p1, p2, p3, p4);

  })
  .catch(e => console.log(e));
}


/* select 변경 시 해당 지역 날씨 조회 */
region.addEventListener("change", (e)=>{
  
  regionName.innerText = e.target.value; // 화면 지역명 바꾸기
  getUltraSrtNcst(e.target.value); // 해당 지역 초단기예보 조회하기

})

getUltraSrtNcst("서울"); // 화면 로딩되면 서울 날씨 얻어오기



