const btn = document.querySelector("#btn");
const box = document.querySelector("#box");

// 적용하기 버튼 클릭 시
btn.addEventListener("click", function(){
  // input에 입력된 내용들을 다 불러오고
  // 순서에 맞게 box에 세팅한다~
  
  const infoAll = document.querySelectorAll(".info");
  // console.log(infoAll[2].value); // 성공!!

  width = document.querySelector("#width");
  // console.log(width.value); // ok
  box.style.width = width.value + "px";

  // box.style.width = infoAll[0].value+ "px";
  box.style.height = infoAll[1].value+ "px";
  box.style.fontSize = infoAll[2].value+ "px";
  box.style.color = infoAll[3].value;
  box.style.backgroundColor = infoAll[4].value;
  box.innerHTML = infoAll[5].value;
  box.style.fontWeight = document.querySelector("[name='f-weight']:checked").value;
  box.style.textAlign = document.querySelector("[name='h-align']:checked").value;
  // box.style.verticalAlign = document.querySelector("[name='v-align']:checked").value;
  // console.log(document.querySelector("[name='v-align']:checked").value);
})

// 라디오 체크된거 갖고오는법
// document.querySelector("[name='fw']:checked").value