document.body.scrollIntoView(false);


/* 문자열 관련 함수 */
document.querySelector("#btn1").addEventListener("click", () => {

  /* 문자열.indexof(찾을 문자열) */
  const str1 = "Hello World임당";

  console.log(str1.indexOf("World")); // 6
  console.log(str1.indexOf("임당")); // 11
  console.log(str1.indexOf("아악")); // -1 (없는 문자열)


  /* 문자열.substring(시작, 종료(미포함)) */
  const str2 = "Javascript 하는 중...";
  
  console.log(str2.substring(0,4)); // Java
  console.log(str2.substring(4,10)); // script

  // 문자열.length : 문자열 길이
  // console.log("sctipt".length); // 6
  const start = str2.indexOf("script"); // 시작 인덱스
  const end = start + "script".length; // 종료 인덱스(미포함)
  console.log(str2.substring(start, end)); // 어떤 문자열이 오던간에 원하는 단어만 찾을수있음

  
  /* 문자열.split("구분자") */
  const str3 = "중고거래 / 쇼핑몰 / SNS / 블로그 / 웹게임";
  const arr = str3.split(" / ");
  for(let i = 0; i < arr.length; i++){
    console.log(arr[i]); // 쪼개져서 하나씩 나옴
  }
})


/* 숫자 관련 리터럴/함수 */
document.querySelector("#btn2").addEventListener("click", (e) => {
  
  // Infinity 확인
  console.log("5/0 = " + (5/0) ); // 5/0 = Infinity

  // NaN(Not a Number) 확인
  console.log("aaa" * 100); // NaN

  // 연산 결과가 NaN인 경우 alert("계산 불가")
  // -> isNaN(값) 사용
  //   --> 값이 NaN이면 true 반환
  if(isNaN("aaa"*100)){
    console.log("계산 불가");
  }
  
  /* toFixed() 확인 */
  console.log((3.45).toFixed(1)); // 3.5

  /* Math.random() 확인 */
  // 버튼의 배경색을 랜덤하게 변경(rgb, 0~255)
  
  const red = Math.floor(Math.random() * 256 + 1);
  const green = Math.floor(Math.random() * 256 + 1);
  const blue = Math.floor(Math.random() * 256 + 1);

  /* ******* 백틱(``) 을 이용한 문자열 생성 ******* */
  // e.target.style.backgroundColor = `rgb(${red}, ${green}, ${blue})`;
  e.target.style.backgroundColor = "rgb(red.value, green.value, blue.value)";
  // e.target.style.backgroundColor = "rgb(36, 24, 200)";

})


/* 형변환 함수 */
document.querySelector("#btn3").addEventListener("click", () => {

  // typeof(값) : 값의 자료형을 반환

  const num = "1.234";
  console.log( `${num}의 자료형 : ${typeof num}` ); // 1.234의 자료형 : string
  console.log( `${Number(num)}의 자료형 : ${typeof Number(num)}` ); // 1.234의 자료형 : number
  console.log( `${parseFloat(num)}의 자료형 : ${typeof parseFloat(num)}` ); // 1.234의 자료형 : number
  console.log( `${parseInt(num)}의 자료형 : ${typeof parseInt(num)}` ); // 1의 자료형 : number

})


/* 동등 / 동일 비교 연산자 */
document.querySelector("#btn4").addEventListener("click", () => {

  /* 동등 */
  console.log(`1 == "1" -> ${1 == "1"}`); // 1 == "1" -> true
  console.log(`1 == true -> ${1 == true}`); // 1 == true -> true

  /* 동일 */
  console.log(`1 === "1" -> ${1 === "1"}`); // 1 == "1" -> false
  console.log(`1 === true -> ${1 === true}`); // 1 == true -> false
  
  console.log(`1 === 1 -> ${1 === 1}`); // 1 == true -> true

})
