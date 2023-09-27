/* 현재 시간 만들기 */
function getCurrentDate(){
  const now = new Date();

  const year = now.getFullYear();
  const month = now.getMonth() < 10 ? "0"+now.getMonth() : now.getMonth();
  const date = now.getDate() < 10 ? "0"+now.getDate() : now.getDate();
  const hour = now.getHours() < 10 ? "0"+now.getHours() : now.getHours();
  const minute = now.getMinutes() < 10 ? "0"+now.getMinutes() : now.getMinutes();
  const second = now.getSeconds() < 10 ? "0"+now.getSeconds() : now.getSeconds();

  return `${year}-${month}-${date} ${hour}:${minute}:${second}`;
}

const subBtn = document.getElementById("submit-btn");
const name = document.getElementsByClassName("name");
const inputText = document.getElementById("input-text");

const deleteBtn = document.querySelector(".delete-btn");




subBtn.addEventListener("click", (e)=>{
  // 입력된 값들을 객체 생성해서 입력하고, 알러트 띄우기

  // 1. div 생성
  const section = document.createElement("div");
  div.classList.add("comment-area");


  






  alert("댓글이 등록 되었습니다");
})



/* 삭제 기능 */
deleteBtn.addEventListener("click", e=>{

  const parent = e.target.parentElement.parentElement;

  if(confirm("정말 삭제 하시겠습니까?")){
    parent.remove();
  } else {
    return;
  }
})


