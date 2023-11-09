/* 웹소켓 테스트 */

// 1. SockJS 라이브러리 추가

// 2. SockJS를 이용해 클라이언트용 웹소켓 객체 생성
let testSock = new SockJS("/testSock");
// -> 해당 웹소켓 객체로 서버와 통신 시 사용할 주소 지정
// (메세지 보낼 때 /testSock 주소로 제출)


// 3. 웹소켓을 이요해서 서버로 메세지 전달
const sendMessage = (name, str) => {

  // 다량의 데이터를 JS -> Java로 전달할 때 JSON 사용이 효율적!

  let messageObj = {}; // 메세지 담을 객체
  messageObj.name = name;
  messageObj.str = str;

  // 웹소켓 연결된 곳(웹소켓 핸들러)로 메시지 전달
  testSock.send( JSON.stringify(messageObj) );
}


/* 웹소켓 객체(testSock)가 서버로부터 메세지를 전달 받았을 때(이벤트) */
testSock.onmessage = e => {
  // e : 이벤트 객체
  // e.data : 전달 받은 메세지 (JSON 형태로 받았다!)

  // JSON.parse : JSON -> 객체
  // JSON.stringify : 객체 -> JSON
  let obj = JSON.parse(e.data);

  console.log(obj);

}