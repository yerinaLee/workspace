// - serviceKey : 공공데이터포털에서 훈련생 개인이 승인받은 OpenAPI 인증키

// - returnType (json으로 출력결과 받음)

// - sidoName : 파라미터로 전달받은 String location (데이터 내용은 서울 or 부산 or 대전)


/* 개인 API 인증키 */

const serviceKey = "zICFxRCxeKNDk0eZH240WS8zMz0oqxcxx5MzyqcDCG62vDweuJMmeVOa8tsFAYQSARpg2uBfAaJo%2BxauvnvhDw%3D%3D";

const getAirPollution = (sidoName) => {
  const requestUrl = 'http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty';

  // 쿼리 스트링 생성 (URLSearchParams.toString())
  const searchParams = new URLSearchParams();

  searchParams.append('returnType', 'JSON');
  searchParams.append('sidoName', sidoName);
  searchParams.append('serviceKey', serviceKey); // 필수 전달항목인 서비스키가 추가되지 않았다.

  fetch(`${requestUrl}?${searchParams.toString()}`) // 서버에 작성된 파라미터들을 전송하지 않았다.
  .then(resp => resp.json())
  .then(result => {
    console.log(result);
  })
  .catch(e => console.log(e));
}

