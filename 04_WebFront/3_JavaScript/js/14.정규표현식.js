document.body.scrollIntoView(false);



/* 정규 표현식 객체 생성 / 패턴일치 확인 */
const check1 = document.getElementById("check1");
check1.addEventListener("click", ()=>{

  // 정규 표현식 객체 생성

  // 1) new RegExp("정규표현식")
  let regEx = new RegExp("\d{3}"); // 연속적으로 작성된 숫자 3개
  // d : digit (숫자 0~9)

  // 2) /정규표현식/ (많이 사용!)
  regEx = /\d{3}/;


  /* 패턴 일치 여부 확인 */
  const str1 = "정규표현식123";
  const str2 = "정규표89현식";
  const str3 = "정규표899현식";

  // 정규식객체.test(문자열) -> 패턴이 일치하면 true
  console.log(regEx.test(str1)); // true
  console.log(regEx.test(str2)); // false
  console.log(regEx.test(str3)); // true


  // 정규식객체.exec(문자열) -> 일치하는 패턴의 문자열 반환
                            // 없으면 null
  console.log(regEx.exec(str1)); // ['123', index: 5, input: '정규표현식123', groups: undefined]
  console.log(regEx.exec(str2)); // null

});


/* 메타 문자 확인하기 */
const check2 = document.querySelector('#check2');
check2.addEventListener('click', ()=>{

  //  a (일반문자열) : 문자열 내에 a라는 문자열이 존재하는 검색 
  let regEx = /java/; // 문자열 내에 java가 존재하는지 검색
  
  console.log(`javascript : ${regEx.test("javascript")}`); // javascript : true
  console.log(`jaaaaja : ${regEx.test("jaaaaja")}`); // jaaaaja : false


  // [abcd] : 문자열 내에 a,b,c,d 중 하나라도 일치하는 문자가 있는지 검색
  regEx = /[a-z][0-9][A-Z]/;
  // 1번 : 영어 소문자 / 2번 : 숫자 / 3번 : 영어 대문자
  let str = "a3T";
  console.log(`${str} : ${regEx.test(str)}`); // a3T : true
  
  str = "@@@a3T!!!!";
  console.log(`${str} : ${regEx.test(str)}`); // @@@a3T!!!! : true
  
  str = "b5q";
  console.log(`${str} : ${regEx.test(str)}`); // b5q : false
  
  
  // ^(캐럿) : 문자열의 시작을 의미
  regEx = /^Hello[0-9]/;
  str = "Hello9 world";
  console.log(`${str} : ${regEx.test(str)}`); // Hello9 world : true
  
  str = "Hello world"; /* Hello 뒤에 숫자 없음 */
  console.log(`${str} : ${regEx.test(str)}`); // Hello world : false
  
  str = " Hello8 world"; /* 띄어쓰기도 문자다 */
  console.log(`${str} : ${regEx.test(str)}`); //  Hello8 world : false
  
  
  // $(달러) : 문자열의 끝을 의미

  // \d : 아무 숫자 == [0-9]
  regEx = /\d\d\d$/; // 문자열이 끝에 숫자가 3칸 있는가
  str = "12345731"; 
  console.log(`${str} : ${regEx.test(str)}`); // 12345731 : true

  str = "123123123_99";
  console.log(`${str} : ${regEx.test(str)}`); // 123123123_99 : false
  
  /* ^, $를 같이 사용하는 경우
    문자열의 시작과 끝이 정해져있어
    포함(X), 문자열의 전체적인 형태를 제한
  */

  
  // 영어 소문자로 시작
  // 중간에 "TEST"
  // 끝은 1자리 숫자로 끝나는 문자열
  regEx = /^[a-z]TEST\d$/;
  str = "wTEST4";
  console.log(`${str} : ${regEx.test(str)}`); // wTEST4 : true
  str = "wtTEST4";
  console.log(`${str} : ${regEx.test(str)}`); // wtTEST4 : false
})


/* 이름 유효성 검사 */

const inputName = document.querySelector("#input-name");
const nameResult = document.querySelector("#name-result");

inputName.addEventListener("keyup", ()=> {
  // 1) 2~15글자 사이         -> {2,15}
  // 2) 처음부터 끝까지 한글  -> ^ 한글 $
  // 3) 단자음, 단모음 제외   -> [가-힣]

  const regEx = /^[가-힣]{2,15}$/;
  
  // 입력받은 값
  const value = inputName.value.trim(); // 좌우 공백 제거 상태

  inputName.value = value; // 좌우 공백이 제거된 값을 다시 대입



  if(value.length == 0){ // 입력 x
    nameResult.innerText = "한글 2~15자 사이 입력";
    nameResult.classList.remove("check");
    nameResult.classList.remove("error");
    return;
  } 

  // 정규식을 이용해서 검사
  if(regEx.test(value)){ // 유효한 경우
    nameResult.innerText ="유효한 이름입니다.";
    nameResult.classList.add("check"); // check 클래스 추가
    nameResult.classList.remove("error"); // error 클래스 제거
    
  } else{
    nameResult.innerText ="유효하지 않은 이름입니다.";
    nameResult.classList.add("error"); // error 클래스 추가
    nameResult.classList.remove("check"); // check 클래스 제거
  }
})



/* 전화번호 유효성 검사 */

const inputPhone = document.querySelector("#input-phone");
const phoneResult = document.querySelector("#phone-result");

inputPhone.addEventListener("keyup", ()=>{
  
  const regEx = /^01[0,1,6,7,9]-\d{3,4}-\d{4}$/;
  const input = inputPhone.value.trim();

  inputPhone.value = input;

  if(input.length == 0){
    phoneResult.innerText = "휴대폰 번호 입력(- 포함)";
    phoneResult.classList.remove("check");
    nameResult.classList.remove("error");
    return;
  }

  if(regEx.test(input)){
    phoneResult.innerText = "유효한 형식입니다.";
    phoneResult.classList.add("check");
    phoneResult.classList.remove("error");

  } else {
    phoneResult.innerText = "유효하지 않은 형식입니다.";
    phoneResult.classList.add("error");
    phoneResult.classList.remove("check");
  }
})







