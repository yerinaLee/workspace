const input1 = document.querySelector("#input-1");
const input2 = document.querySelector("#input-2");
// const input2 = document.getElementById(input-2);

const result = document.getElementById("result");


// 연산자 버튼 클릭 시 동작
// 매개 변수 op : + - * / % 기호
function calc(op){
  
  // 입려고딘 값을 number타입으로 변환하여 저장
  v1 = Number(input1.value);
  v2 = Number(input2.value);

  // switch문을 이용해 op 매개 변수 값에 따라 결과 도출
  let res; // 결과 저장

  switch(op){
    case '+' : res = v1 + v2;  break;
    case '-' : res = v1 - v2;  break;
    case '*' : res = v1 * v2;  break;
    case '/' : res = v1 / v2;  break;
    case '%' : res = v1 % v2;  break;
  }

  result.innerText = res;
}

// JS 문자열비교 == , !=