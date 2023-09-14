/* js파일을 script 태그 내부라고 생각하면 됨 */
function externalFn(){
  alert("외부 파일에 작성된 externalFn() 함수 호출됨");
}

// JS 맛보기
const body = document.querySelector("body"); /* body 태그 */

/* JS는 카멜 표기법 사용 */
function lightMode(){
  body.style.backgroundColor = "white";
  body.style.color = "black";
}

function darkMode(){
  body.style.backgroundColor = "black";
  body.style.color = "white";
}


