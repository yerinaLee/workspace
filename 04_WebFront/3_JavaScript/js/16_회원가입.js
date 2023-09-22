// 유효성 검사 여부를 체크해두는 객체 생성

// JS 객체 : { K : V, K : V, ....}

// JS 객체 다루는 방법
// checkList["KEY"];        (GET)
// checkList["KEY"] = true; (SET)

const checkList = {
  "input-id" : false,
  "input-pw" : false,
  "input-pw-check" : false,
  "input-name" : false
};

const signupForm = document.signupForm;
const inputId = document.getElementById("input-id");
const inputPw = document.getElementById("input-pw");
const inputPwCheck = document.getElementById("input-pw-check");
const inputName = document.getElementById("input-name");

// 입력 요소 모두 얻어오기(성별 제외)
const inputList = document.querySelectorAll(".signup-input");

//---------------------------------------------------------------

/* 아이디 유효성 검사 */
inputId.addEventListener("input", e =>{

  // 양쪽 공백을 제거한 입력 값을 얻어와 val에 저장
  const val = inputId.value.trim();
  const span = e.target.nextElementSibling.nextElementSibling;

  inputId.value = val; // 공백이 제거된 값을 input 값으로 대입

  if(val.length === 0){ // 입력된 값이 없을 경우
    span.innerText = "영어, 숫자, -, _ 6~16글자 사이";
    span.classList.remove("check");
    span.classList.remove("error");
    
    // 유효성 검사 여부 저장 객체에서
    // "input-id"의 값을 false로 변경 (유효하지 않다를 뜻함)
    checkList["input-id"] = false;
    return;
  }

  // 정규표현식 객체 생성
  const regEx = /^[A-Za-z\d\-\_]{6,16}$/;

  if(regEx.test(val)){ // 유효한 경우
    span.innerText = "유효한 아이디 형식입니다";
    span.classList.add("check");
    span.classList.remove("error");
    checkList["input-id"] = true;
  } else{
    span.innerText = "유효하지 않은 아이디 형식입니다";
    span.classList.add("error");
    span.classList.remove("check");
    checkList["input-id"] = false;
  }
});


/* 비밀번호 유효성 검사 */
inputPw.addEventListener("input", e =>{

  // 양쪽 공백을 제거한 입력 값을 얻어와 val에 저장
  const val = e.target.value.trim();
  const span = e.target.nextElementSibling.nextElementSibling;

  e.target.value = val; // 공백이 제거된 값을 input 값으로 대입

  if(val.length === 0){ // 입력된 값이 없을 경우
    span.innerText = "영어, 숫자, !@#$%^&* 8~20글자 사이";
    span.classList.remove("check");
    span.classList.remove("error");
    checkList["input-pw"] = false;
    checkPwFn();
    return;
  }

  // 정규표현식 객체 생성
  const regEx = /^[A-Za-z\d\!\@\#\$\%\^\&\*]{8,20}$/;
  
  if(regEx.test(val)){ // 유효한 경우
    span.innerText = "유효한 비밀번호 형식입니다";
    span.classList.add("check");
    span.classList.remove("error");
    checkList["input-pw"] = true;
  } else{
    span.innerText = "유효하지 않은 비밀번호 형식입니다";
    span.classList.add("error");
    span.classList.remove("check");
    checkList["input-pw"] = false;
  }

  checkPwFn();

});



/* 비밀번호 확인 유효성 검사 */
inputPwCheck.addEventListener("input", e =>{
  // 비밀번호(#input-pw)에 입력된 값이 유효한 경우
  // #input-pw의 다음, 다으 형제 요소(span)에
  // check 클래스가 있는 경우
  const pwSpan = inputPw.nextElementSibling.nextElementSibling;

  const span = e.target.nextElementSibling.nextElementSibling;

  // contains(클래스명) : 클래스가 존재하면 true, 없으면 false
  if(!pwSpan.classList.contains("check")){
    span.innerText = "유효한 형식의 비밀번호를 먼저 입력해주세요";
    span.classList.add("error");
    span.classList.remove("check");
    checkList["input-pw-check"] = false;
    return; // 유효성 검사 진행 X
  }

  const val = inputPwCheck.value.trim();
  inputPwCheck.value = val;

  if(val.length === 0){
    span.innerText = "비밀번호를 먼저 입력해주세요";
    span.classList.remove("check");
    span.classList.remove("error");
    return;
  }

  const pwVal = inputPw.value;

  if(pwVal == val){ // 비밀번호&비밀번호 확인이 일치할 경우
    span.innerText = "비밀번호 일치";
    span.classList.add("check");
    span.classList.remove("error");
    checkList["input-pw-check"] = true;
  } else{
    span.innerText = "비밀번호 불일치";
    span.classList.add("error");
    span.classList.remove("check");
    checkList["input-pw-check"] = false;
  }

});


// 비밀번호, 비밀번호 확인 같은지 체크하는 함수
function checkPwFn(){

  const span = inputPwCheck.nextElementSibling.nextElementSibling;

  // 비밀번호, 비밀번호 확인 값 얻어와 변수에 저장
  const pwVal = inputPw.value.trim();
  const checkVal = inputPwCheck.value.trim();

  if(pwVal.length == 0 || checkVal.length == 0){ // 비밀번호 미입력시
    span.innerText="비밀번호를 먼저 입력해주세요";
    span.classList.remove("check");
    span.classList.remove("error");

    checkList["input-pw-check"] = false;

    return;
  }

  if(pwVal === checkVal){
    span.innerText="비밀번호 일치";
    span.classList.add("check");
    span.classList.remove("error");
    checkList["input-pw-check"] = true;

  } else {
    span.innerText="비밀번호 불일치";
    span.classList.add("error");
    span.classList.remove("check");
    checkList["input-pw-check"] = false;
  }
}

/* 이름 유효성 검사 */
inputName.addEventListener("input", e =>{

  // 양쪽 공백을 제거한 입력 값을 얻어와 val에 저장
  const val = inputName.value.trim();
  const span = e.target.nextElementSibling.nextElementSibling;

  inputName.value = val; // 공백이 제거된 값을 input 값으로 대입

  if(val.length === 0){ // 입력된 값이 없을 경우
    span.innerText = "한글 2~15(단자음, 단모음 제외)";
    span.classList.remove("check");
    span.classList.remove("error");
    checkList["input-name"] = false;
    return;
  }

  // 정규표현식 객체 생성
  const regEx = /^[가-힣]{2,15}$/;

  if(regEx.test(val)){ // 유효한 경우
    span.innerText = "유효한 이름 형식입니다";
    span.classList.add("check");
    span.classList.remove("error");
    checkList["input-name"] = true;
  } else{
    span.innerText = "유효하지 않은 이름 형식입니다";
    span.classList.add("error");
    span.classList.remove("check");
    checkList["input-name"] = false;
  }
});


/* form태그 제출 시 */
signupForm.addEventListener("submit", e=>{

  // HTML 요소가 가지고 있는 기본 이벤트를 막다(제거)
  // e.preventDefault();

  /* 객체 전용 향상된 for문 : for(let key in 객체명) 
    -> 객체가 가지고 있는 K를 순서대로 하나씩 key에 대입
  */

  for(let key in checkList){
    // console.log(key);

    if( !checkList[key] ){ // 유효하지 않은 입력이 있을 경우
      
      let str;
      switch(key){
        case "input-id" : str = "아이디가 "; break;
        case "input-pw" : str = "비밀번호가 "; break;
        case "input-pw-check" : str = "비밀번호 확인이 "; break;
        case "input-name" : str = "이름이 "; break;
      }

      alert(str + "유효하지 않습니다");
      e.preventDefault(); // form 제출 막기

      document.getElementById(key).focus();
      return;
    }
  } // for in 끝

  // 성별 선택 여부 검사

  // 성별이 선택되지 않았을 때
  if(document.querySelector("[name='gender']:checked") == null){
    alert("성별을 선택해주세요");
    e.preventDefault();
    document.querySelector("[name='gender']").focus();
  }

})

