// 글쓰기 버튼이 존재할 때
// 해당 게시판 글쓰기 화면으로 이동

// 현재 주소 : /board/{boardCode}

// 요청 주소 : /editBoard/{boardCode}/insert
const insertBtn = document.getElementById("insertBtn");

if(insertBtn != null){
  insertBtn.addEventListener("click", ()=>{
    location.href = `/editBoard/${boardCode}/insert`;
  })
}


// --------------------------------------------------------------------

/* 검색창에 이전 검색 기록 남겨두기! */
const options = document.querySelectorAll("#searchKey > option"); // id가 searchKey인 요소의 자식인 option 태그들 모두 얻어오기
const searchQuery = document.getElementById("searchQuery");

// 즉시 실행 함수(해석되자마자 실행되는 함수, 속도가 빠름)
(()=>{
  // 주소에 있는 파라미터(쿼리스트링)을 얻어오기
  const params = new URL(location.href).searchParams;

  const key = params.get("key"); // t, c, tc, w 중 하나
  const query = params.get("query"); // 검색어

  // 검색을 했을 경우
  if(key != null && query != null){
    searchQuery.value = query; // 검색어를 input에 추가

    for (let op of options){
      if(op.value == key){ // option의 value와 key가 일치하면
        op.selected = true; // 해당 옵션 선택
        break;
      }
    }

  }

})();