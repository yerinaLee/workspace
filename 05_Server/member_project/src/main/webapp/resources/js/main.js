// 로그아웃 버튼 얻어오기(없으면 null)
const logoutBtn = document.getElementById("logout-btn");

if(logoutBtn != null){ // 로그아웃 버튼이 있을 때
  
  logoutBtn.addEventListener("click", ()=>{
    location.href = "/logout";
  })
}

// 회원 목록 조회 버튼이 있을 경우 클릭 이벤트 추가
const memberListBtn = document.querySelector("#member-list-btn");

if(memberListBtn != null){

  memberListBtn.addEventListener("click", ()=>{
    location.href = "/memberList";    
  })
}