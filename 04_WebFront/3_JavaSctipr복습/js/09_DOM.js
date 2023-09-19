document.body.scrollIntoView(false);


// 노드 확인하기
document.getElementById("btn1").addEventListener("click", () => {
  const test = document.getElementById("test");

  // #test의 모든 자식 노드 얻어오기(요소.childNodes)
  // -> 자식 노드 == #test내부에 작성된 모든 글자, 주석, 요소
  const list = test.childNodes;

  console.log(list);
  console.log(list[3].innerText);


  /* 노드 탐색 */

  // 1) 부모 노드 탐색 : parentNode

  // #li1 요소의 부모 노드 출력하기
  const li1 = document.getElementById("li1");
  console.log(li1.parentNode);

  // #li1 부모 노드에 배경색 추가
  li1.parentNode.style.backgroundColor = "pink";

  // --------------------------------------------
  // 2) 첫 번째 자식 노드 탐색 : firstChild
  // #test의 첫 번째 자식 노드 출력
  console.log(test.firstChild);

  // --------------------------------------------
  // 3) 마지막 자식 노드 탐색 : lastChild
  // #test의 마지막 자식 노드 출력
  console.log(test.lastChild);

  // --------------------------------------------
  // 4) 원하는 위치(인덱스)에 존재하는 자식 노드 탐색
  // : childNodes[인덱스]

  // #test의 마지막 자식 노드 리스트(list)에서 9번 인덱스 노드 얻어오기
  console.log(list[9]);
  list[9].style.backgroundColor="yellowgreen";

  // --------------------------------------------
  // 5) 이전 형제 노드 탐색 : previousSibling 
  // 6) 다음 형제 노드 탐색 : nextSibling
  
  // list[9]의 다음, 다음 형제 노드
  console.log(list[9].nextSibling.nextSibling); // == list[11]

  // #test의 마지막 자식 노드의 이전 형제 노드
  console.log(test.lastChild.previousSibling); // == list[11]


  // --------------------------------------------

  /* 노드 추가 */

  // 1) appendChild("내용" 또는 노드) : 마지막 자식 노드로 추가

  // list[11]의 마지막 자식으로 "ZZZ" 추가

  // document.createTextNode("내용") : 
  list[11].appendChild(document.createTextNode("ZZZ"));

  // --------------------------------------------

  // 2) append("내용" 또는 노드 또는 요소)
  // : 마지막 자식 내용/노드/요소로 추가
  //   + 매개변수로 여러 값을 작성해 한 번에 추가 가능 (더 많이 사용!)
  list[11].append(" 1234", " abc", " 안뇽");

  // --------------------------------------------
  
  // 3) prepend("내용" 또는 노드 또는 요소)
  // : 첫번째 자식으로 내용/노드/요소를 추가
  //   + 매개변수로 여러 값을 작성해 한 번에 추가 가능
  list[11].prepend("갉가가", "냐ㅏ나나", "다다알");
  list[11].prepend("라라랄"); // 제일 앞에 작성됨

  // --------------------------------------------

  // 4) before("내용" 또는 노드 또는 요소) : 이전에 추가
  // 5) after("내용" 또는 노드 또는 요소)  : 다음에 추가

  // #test 요소 전/후에 추가하기
  test.before("이전이요~")
  test.after("이후요~~~")
});



// -----------------------------------------------------------------------------

/* 요소(Element) 탐색 */

/*
children : 자식 요소만 모두 선택
parentElement : 부모 요소 선택

firstElementChild : 첫 번째 자식 요소 선택
lastElementChild  : 마지막 자식 요소 선택

previousElementSibling : 이전 형제 요소 선택
nextElementSibling     : 다음 형제 요소 선택
*/

const test2 = document.getElementById("test2");
const btn2 = document.getElementById("btn2");

btn2.addEventListener("click", () => {

  // 1. test2의 모든 자식 요소
  console.log(test2.children);

  // 2. test2의 부모 요소
  console.log(test2.parentElement);
  
  // 3. test2의 첫 번째 자식 요소
  console.log(test2.firstElementChild);

  // 4. test2의 마지막 자식 요소
  console.log(test2.lastElementChild);
  
  // 5. test2의 이전 형제 요소 선택
  console.log(test2.previousElementSibling);

  // 6. test2의 다음 형제 요소 선택
  console.log(test2.nextElementSibling);

  // #test2를 기준으로 body 태그의 첫 번째 자식 요소 선택
  test2.parentElement.firstElementChild.style.color="orange"

})


// -----------------------------------------------------------------------------

/* innerHTML로 요소 만들기 */

const btn3 = document.getElementById("btn3");
const div3 = document.getElementById("div3");

btn3.addEventListener("click", () => {
  div3.innerHTML += '<input type="text">';
})


// -----------------------------------------------------------------------------

/* document.createElement()로 요소 생성하기 */
const btn4 = document.getElementById("btn4");
const div4 = document.getElementById("div4");

btn4.addEventListener("click", () => {


  // 1) input 요소 생성
  //   -> 생성만 된 것이지 배치되지 않은 상태
  const input = document.createElement("input");


  // input에 속성 "type", 속성값 "text" 추가

  // ★ 요소에 속성 추가 : 요소.setAttribute("속성", "속성값");
  input.setAttribute("type", "text");
  // input.setAttribute("name", "key");

  // 이 방식도 가능하지만 setAttribute보다는 사용 빈도가 낮음.
  // 속성들 중 안되는 것도 있음
  input.type = "text";

  console.log(input);


  // 2) 원하는 위치에 추가
  // append : 마지막 자식으로 추가
  div4.append(input)

})



