const input1 = document.querySelector("#input-1");
const input2 = document.querySelector("#input-2");
// const input2 = document.getElementById(input-2);

const result = document.getElementById("result");


// 연산자 버튼 클릭 시 동작
// 매개 변수 btn (btn == 클릭된 버튼 자체(this))
function calc(btn){

  console.log(btn); // 클릭한 버튼
  console.log(btn.innerText); // 버튼에 작성된 내용(== 연산자)

  const op = btn.innerText; // 클릭한 버튼에 작성된 연산자를 얻어와 op변수에 저장

  
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