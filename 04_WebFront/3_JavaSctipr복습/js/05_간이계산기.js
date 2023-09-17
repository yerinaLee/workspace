input1 = document.querySelector("#input-1"); // CSS 선택자
// input2 = document.querySelector("#input-2");
input2 = document.getElementById("input-2"); // 

function print(){
  document.getElementById("result").innerText= result;
}

/* 더하기 함수 */
function plusFn(){
  // console.log("콘솔창에 출력하면서 테스트");
  // 입력요소.value : 입력 요소에 작성된 값 반환
  console.log(input1.value);
  console.log(input2.value);

  // Number("123") == 123 (숫자로 변환)
  // result = (Number(input1.value) + Number(input2.value));
  // print();

  // 요소.innerText : <시작>내용</종료> 내용에 글자 대입
  result.innerText = Number(input1.value) + Number(input2.value);
}

/* 빼기 함수 */
function minusFn(){
  result = ((Number)(input1.value) - (Number)(input2.value));
  print();
}

/* 곱하기 함수 */
function multiFn(){
  result = ((Number)(input1.value) * (Number)(input2.value));
  print();
}

/* 나누기 함수 */
function divFn(){
  result = ((Number)(input1.value) / (Number)(input2.value));
  print();
}

/* 나머지 함수 */
function restFn() {
  result = ((Number)(input1.value) % (Number)(input2.value));
  print();
}
