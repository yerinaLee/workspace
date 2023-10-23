// 쿠키 얻어오기 함수
// function 함수명(){} // 함수 정의

// 변수에 함수 대입 (== 변수로 인식)
// - 해당 변수가 해석될 때 까지 변수에 대입된 함수 호출 불가
// const 함수명 = function(){}
// const 함수명 = () => {}
const getCookie = (key) => {

  // 현재 존재하는 쿠키를 모두 얻어옴
  const cookies = document.cookie; // 'saveId=2'

  // 배열.map(()=>{}) : 배열 내 요소를 하나씩 순차접근 후
                    // 함수 수행 후 반환되는 결과를 새로운 배열에 담아서 반환

  // cookies 문자열을 '; ' 구분자로 하여 배열 생성 후
  // map을 이용해서 cookies의 요소를 '='로 나누어 2차원 배열 생성
  const list = cookies.split('; ').map(entry => entry.split('='));

  // list를 JS 객체로 옮겨 담기
  const obj = {} ; // 비어있는 객체 생성

  for(let i=0; i<list.length; i++){
    obj[ list[i][0] ] = list[i][1];
  }

  return obj[key];
}

// 쿠키에 saveId가 있을 경우
// 이메일 input 태그에 value로 추가
// + 아이디 저장 체크박스가 체크 되어있게 하기
const memberEmail = document.querySelector("input[name='memberEmail']");
const saveId = document.querySelector("input[name='saveId']");

// 화면에 이메일 input, 체크박스가 있을 경우! (로그인기능은 로그아웃 후 사라지기때문에 이런 if문 써주는게 좋음)
if(memberEmail != null && saveId != null){

  // 쿠키에서 key가 "saveId"인 요소의 값을 얻어옴
  const email = getCookie("saveId");
  
  if(email != undefined){ // saveId가 있을 경우
    memberEmail.value = email; // input 값 대입
    saveId.checked = true; // 체크
  }
}



//-------------------------------------------------------------------------

/* 이메일, 비밀번호 미 입력 시 로그인 시도 막기 */

// 로그인 form 태그
const loginFrm = document.getElementById("loginFrm");

// 로그인 form 태그가 있을 경우(로그인 X 상태)
if(loginFrm != null){

  // 로그인 form 태그가 submit되는 것을 감지했을 때 함수 수행
  loginFrm.addEventListener("submit", e => {

    const memberEmail = document.querySelector("input[name='memberEmail']");
    const memberPw = document.querySelector("input[name='memberPw']");

    // 이메일 미입력 시
    if(memberEmail.value.trim().length == 0){
      alert("이메일을 입력해주세요");

      memberEmail.value = ''; // 입력된 공백 제거
      memberEmail.focus(); // 이메일 input에 커서 깜빡이게함

      // submit 이벤트 발생 시 form태그의 기본 이벤트(제출) 제거
      e.preventDefault(); 
      return;
    }

    // 비밀번호 미입력 시
    if(memberPw.value.trim().length == 0){
      alert("비밀번호를 입력해주세요");

      memberPw.value = ''; // 입력된 공백 제거
      memberPw.focus(); // 비밀번호 input에 커서 깜빡이게함

      // submit 이벤트 발생 시 form태그의 기본 이벤트(제출) 제거
      e.preventDefault(); 
      return;
    }



  })

}
















