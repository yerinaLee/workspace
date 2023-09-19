// 증가 버튼 클릭 시 #count 값 1 증가
const count = document.querySelector("#count");
const increment = document.querySelector("#increment");

// 카운트 증가 함수 선언
function countIncrement(){

  // 정의

  // +조건 : 10을 초과하면 0으로 초기화

  ++count.value;

  if(count.value > 10){
    count.value = 0;
  }
}

// #increment 버튼 클릭 시
// increment.addEventListener("click", function(){
//   countIncrement();
// })

// #increment 버튼 클릭 시 countIncrement 함수 코드를 수행
// -> 함수명만 작성하면 정의된 함수 코드가 그대로 반환 // API 예시 코드 중 이런 형태가 많아요~
increment.addEventListener("click", countIncrement);



// ---------------------------------


// 익명 함수

// #btn2 클릭시
document.querySelector("#btn2").addEventListener("click", function(e){
                                                      // 익명함수
  // 배경색 얻어오기
  const bg = e.target.style.backgroundColor;

  if(bg == "yellow"){
    //  style 속성 제거
    e.target.removeAttribute("style");
  } else {
    e.target.style.backgroundColor = "yellow";
  }
  changeText();
})

// 호출(오류 발생)
// changeText();

const changeText = function(){ // 선언, 정의
  const btn2 = document.querySelector("#btn2");

  if(btn2.innerText == "익명 함수 확인"){
    btn2.innerText = "확인 완료";
  } else {
    btn2.innerText = "익명 함수 확인";
  }
}


// 함수도 변수에 대입 가능!!!!!!!
// -> 이 때, 변수명이 함수명이 된다
const test = function(){ alert(123) };




// JS코드 해석 순서

// 1. 현재 HTML에 연결된 모든 JS에서
//    선언된 함수를 먼저 인식 (자바의 static처럼~)

// 2. 위 -> 아래로 차례대로 해석


/* ** 변수 = 함수명 형식으로 함수를 선언한 경우
  - 함수를 선언한 것으로 인식하는 것이 아닌
    변수를 선언한 것으로 인식되어

    해석 순서 1번(함수 위치 인식)으로 인식되지 않아
    함수 호출 코드가 선언 코드보다 앞에 작성되면 오류 발생
    (호출 불가)
*/

/* 
const temp = 10;

function test2(){}
test2();

(function(){
  const temp = 20;
})() */


// ---------------------------------

/* 즉시 실행 함수 */

// 일반 함수는 선언/정의, 호출을 따로 작성해서
// 즉시실행함수보다 상대적으로 느림
function test2(){ // 선언 / 정의
  console.log("일반 함수");
}

test2(); // 호출

// 선언+정의+호출 한 번에 수행해서
// 일반 함수보다 상대적으로 빠름
(function(){
  console.log("즉시 실행 함수");
})();


/* 변수명 중복 문제 해결(이 용도로 더 많이 사용!!) */
const str = "전역 변수";

(function(){
  const str = "즉시 실행 함수 지역 변수";
  console.log(str); // 즉시 실행 함수 지역 변수
})()

console.log(str); // 전역 변수


// ---------------------------------

/* 화살표 함수 */

// 클래스가 arrow인 요소를 모두 얻어옴(배열)
const arrowList = document.querySelectorAll(".arrow");

// 화살표 함수 기본 형태 확인
arrowList[0].addEventListener("click", () => {
  alert("기본형태임당");
});

// 매개변수가 1개인 경우
arrowList[1].addEventListener("click", e => {
  console.log(e.target.innerText);
  e.target.style.backgroundColor = "white";
});

// 매개변수가 n개인 경우
arrowList[2].addEventListener("click", () => {

  // 다른 함수 호출

  // 매개 변수로 a, b 두 값을 전달 받아
  // 곱한 값을 반환하는 익명 함수를 전달
  testFn( (a, b) => { return a * b; } );

})

function testFn(paramFn){
  //paramFn : 전달 받은 함수
  alert( paramFn(2, 3) );
}


// 함수 정의 부분이 return 한 줄이면
// { return }생략
arrowList[3].addEventListener("click", () => {
  testFn( (a, b) => a * b );
});

// 함수 정의 부분이 return 한 줄이지만
// return 값이 object 타입이면
// { return }생략 불가
arrowList[4].addEventListener("click", () => {

  // 함수 호출
  printObject( (name, age) => {
    return {"name" : name, "age" : age}
          //   K   :  V  ,   K   :  V
  } );

});

function printObject(objectFn){
  const obj = objectFn("홍길동", 20);
 
  console.log(obj);
  alert(obj.name + " / " + obj.age);
}


