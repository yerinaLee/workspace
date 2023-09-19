const input1 = document.querySelector("#input-1");
const input2 = document.querySelector("#input-2");

const result = document.getElementById("result");

function calc(btn){

  const op = btn.innerText; // 버튼에 작성된 연산자
  
  v1 = Number(input1.value); // 입력 숫자 1
  v2 = Number(input2.value); // 입력 숫자 2

  result.innerText
   = new Function("return " + v1 + op + v2)();



}

