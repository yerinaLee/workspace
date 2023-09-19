/* 
  요소.classList : 요소 클래스 관련 속성
  
  요소.classList.add("클래스명")    : 클래스 추가
  요소.classList.remove("클래스명") : 클래스 제거

  요소.remove() : 요소 제거
*/



// 만드려는 기능 중 공통적으로 사용되는 요소를 전역 변수로 선언

const addBtn = document.getElementById("add");
const calcBtn = document.getElementById("calc");

// querySelector() -> 여러 요소가 선택되어도 첫 번째 요소만 얻어옴
const container = document.querySelector(".container");


/* 추가 버튼 클릭 시 */
addBtn.addEventListener("click", () => {
  
  
  // 1) div.row 생성
  const row = document.createElement("div");

  // 요소에 class 추가하기 (클래스만 이런식! 나머진 다 셋어트리븃)
  row.classList.add("row"); // <div class="row"></div>

  
  // 2) input 만들기
  const input = document.createElement("input");

  // type="number" 추가
  input.setAttribute("type", "number");

  // 클래스 "input-number" 추가
  input.classList.add("input-number"); // <input type="number" class="input-number">


  // 3) span 만들기
  const span = document.createElement("span");
  
  // 클래스 "remove-row" 추가
  span.classList.add("remove-row");
  
  // 내용으로 &times; 추가(innerHTML 사용)
  span.innerHTML = "&times;"; // <span class="remove-row">×</span>

  /* ************************************************** */
  // 클릭된 x 버튼의 부모요소를 제거


  // [1] 만들어지는 X버튼(span)에 이벤트 리스너 추가
  span.addEventListener("click", e => {

    // [2] 현재 이벤트가 발생한 요소(클릭된 X버튼)의
    //     부모 요소를 선택(탐색)
    const parent = e.target.parentElement; // == div.row

    // [3] 부모 요소를 제거
    parent.remove();
  });

  /* ************************************************** */

  // ----- 조립시작 조각조각땃따다 부셔놓고땃따따 -----

  // 4) div.row의 자식으로 input, span 추가
  row.append(input, span);

  // 5) div.row를 .container의 마지막 자식으로 추가
  container.append(row);

})


/* 계산 버튼 클릭 시 */
calcBtn.addEventListener("click", () => {

  const sumArr = document.querySelectorAll(".input-number");
  let sum = 0;
  
  for(let i = 0; i < sumArr.length; i++){
    sum += Number(sumArr[i].value);
  }

  alert(sum);
})
