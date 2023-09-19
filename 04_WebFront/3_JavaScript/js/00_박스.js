const btn = document.querySelector("#btn");
const box = document.querySelector("#box");

// 적용하기 버튼 클릭 시
btn.addEventListener("click", function(){
  
  const infoAll = document.querySelectorAll(".info");

  const width = document.querySelector("#width");
  // box.style.width = infoAll[0].value+ "px";

  // 너비를 입력하는 input에 값이 작성되어있다면
  if(width.value.trim().length != 0){
    box.style.width = width.value + "px";
  }

  if(infoAll[1].value.trim().length != 0){
    box.style.height = infoAll[1].value+ "px";
  }

  if(infoAll[2].value.trim().length != 0){
    box.style.fontSize = infoAll[2].value + "px";
  }

  if(infoAll[3].value.trim().length != 0){
    box.style.color = infoAll[3].value;
  }

  if(infoAll[4].value.trim().length != 0){
    box.style.backgroundColor = infoAll[4].value;
  }

  if(infoAll[5].value.trim().length != 0){
    box.innerHTML = infoAll[5].value;
  }

  // f-weight -> 체크된게 없으면 null이 나와요
              // -> 체크된게 있으면 null 아님
  if(document.querySelector("[name='f-weight']:checked").value != null){ // 글자 굵기가 체크되었을때
    // 글자 굵기 적용
    box.style.fontWeight = document.querySelector("[name='f-weight']:checked").value;
  }

  
  if(document.querySelector("[name='h-align']:checked") != null){ // 가로정렬 체크되었을때
    box.style.justifyContent = document.querySelector("[name='h-align']:checked").value;
  }

  if(document.querySelector("[name='v-align']:checked") != null){ // 세로정렬 체크되었을때
    box.style.alignItems = document.querySelector("[name='v-align']:checked").value;
  }


})
