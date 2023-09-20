const bingoBoard = document.querySelector("#bingo-board");
const fontColor = document.querySelector("#font-color");
const createBtn = document.querySelector("#create-btn");

// 생성 버튼 클릭 시
createBtn.addEventListener("click", e =>{

  /* 난수 생성 */

  // 생성 버튼의 이전 형제 요소(input)의 값 얻어오기
  const bingoLength = e.target.previousElementSibling.value;

  // bingoLength * bingoLength 한 수 만큼 중복되지 않는 난수 생성
  // - Java 컬렉션 중 Set(중복X)과 똑같은 객체 존재

  const set = new Set(); // Set 생성

  // set.size : set에 저장된 요소의 수
  // set.add("값") : set에 값 추가
  while(set.size < bingoLength * bingoLength){
    
    // Math.floor : 난수생성 중 소수점 없애기
    const r = Math.floor( Math.random() * bingoLength * bingoLength + 1);
    set.add(r);
  }

  // set을 array(배열) 변경
  // - Array.from(set) : set을 배열로 변경하여 반환
  const arr = Array.from(set);
  
  // --------------------------------------------------------------------

  /* 빙고판 생성 */
  
  // 재사용 용도의 변수 생성
  let row;
  let col;

  bingoBoard.innerHTML = ""; // 이전 빙고판 삭제

  for(let i = 0; i < arr.length; i++){

    // 각 행의 첫 번째 값이 들어갈 index 차례일 때
    if(i % bingoLength == 0){
      // 행(div.bingo-row) 만들기
      row = document.createElement("div");
      row.classList.add("bingo-row");

      // 만들어진 행을 #bingo-board에 추가
      bingoBoard.append(row);
    }

    // 열(div.bingo-col) 생성
    col = document.createElement("div");
    col.classList.add("bingo-col");
    col.innerText = arr[i]; // 생성된 열에 난수를 순서대로 대입

    /* ****************************************** */

    // 생성된 열(col)이 클릭되었을 때 
    // .check가 없으면 추가, 있으면 제거

    col.addEventListener("click", e => {
      // e.target : 이벤트가 발생한 요소(클릭된 열)

      // 이벤트가 발생한 요소가 check 클래스를 포함하는지 확인
      // console.log(e.target.classList.contains("check"));
      
      // check가 있을 때
      if(e.target.classList.contains("check")){
        e.target.classList.remove("check"); // check 클래스 제거

      } else { // check가 없을 때
        e.target.classList.add("check"); // check 클래스 추가
      }

      // 빙고 여부 검사
      checkBingo();
    });

    /* ****************************************** */

    // 행에 열을 마지막 자식으로 추가
    row.append(col);

  }
})


// 빙고 여부 검사
function checkBingo(){

  let board = []; // 비어있는 배열 생성
  // (참고. JS의 배열은 Java의 List와 비슷)
  
  // 현재 빙고의 행들을 모두 얻어와 배열로 저장
  const rows = document.querySelectorAll(".bingo-row");
  // console.log(rows);

  for(let i=0; i<rows.length; i++){
    // rows[i].children : 각 행의 모든 열(자식 요소)을 배열로 반환

    // 배열.puch( 값/객체 ) : 배열 마지막 요소로 추가
    //                        (Java : List.add())

    board.push(rows[i].children);
  }

  // 모든 행, 열이 담긴 2차원 배열 생성
  // console.log(board);

  /* 모든 col에 있는 bingo 클래스 제거 */
  for(let i =0; i<board.length; i++){
    for(let k =0; k < board[i].length; k++){
      board[i][k].classList.remove("bingo");
    }
  }

  // 1. 행 빙고 검사
  rowCheck(board);

  // 2. 열 빙고 검사
  colCheck(board);

  // 3. 대각선 빙고 검사
  diaCheck(board);

}

// 행 빙고 검사
function rowCheck(board){
  // board : 빙고판을 나타내는 2차원 배열
  // board[i] : i번째 행
  // board[i][k] : i번째 행의 k번째 열

  for(let i = 0; i < board.length; i++){
    
    // 한 행씩 접근해서 모든 열에 check 클래스가 있는지 검사
    let count = 0; // 현재 행의 check 개수 count

    for(let k = 0; k < board[i].length; k++){
      
      // 열에 체크 클래스가 있다면 count 증가
      if(board[i][k].classList.contains("check")){
        count++;
      }
    }

    // 행의 길이와 check 개수가 같다면
    // == 해당 행의 모든 열이 check 되어있음
    if(board[i].length == count){
      for(let k = 0; k < board[i].length; k++){
        board[i][k].classList.add("bingo");
      }
    }
  }
}


// 열 빙고 검사
function colCheck(board){
  // board : 빙고판을 나타내는 2차원 배열
  // i == 행의 인덱스
  // k == 열의 인덱스

  // board[i][k] : i번째 행의 k번째 열

  // board.length == 행의 길이
  // board[0].length == 0행의 열의 길이
  // 빙고판은 정사각형 == 행과 열의 길이가 같다

  const bingoLength = board.length; // 빙고판 길이
  for(let k=0; k < bingoLength; k++ ){ // 열 제어
    
    let count = 0; // check 개수 count

    for(let i=0; i < bingoLength; i++){ // 행 제어
      
      if(board[i][k].classList.contains("check")){
        count++;
      }
    }

    if(count == bingoLength){ // 모든 열이 체크되어있다면
      for(let i=0; i < bingoLength; i++){ // 행 제어
        board[i][k].classList.add("bingo");
      }
    }
  }
}


// 대각선 빙고 검사
function diaCheck(board){

  let count1 = 0; // 왼쪽 위 -> 오른쪽 아래 대각선 카운트
  let count2 = 0; // 오른쪽 위 -> 왼쪽 아래 대각선 카운트
  const bingoLength = board.length; // 빙고판 길이

  for(let i = 0; i < bingoLength; i++){
    // 좌상 -> 우하 요소에 check 클래스가 있다면
    if(board[i][i].classList.contains("check")){
      count1++;
    }

    // 우상 -> 좌하 요소에 check 클래스가 있다면
    if(board[i][bingoLength -i -1].classList.contains("check")){
      count2++;
    }
  } // for 끝

  // 좌상 -> 우하 방향이 모두 체크되어있다면
  if(bingoLength == count1){
    
    for(let i=0; i < bingoLength; i++){
      board[i][i].classList.add("bingo");
    }
  }

  // 우상 -> 좌하 방향이 모두 체크되어있다면
  if(bingoLength == count2){
    
    for(let i=0; i < bingoLength; i++){
      board[i][bingoLength -i -1].classList.add("bingo");
    }
  }
}



/* 엔터 입력 시 색상 변경 */
fontColor.addEventListener("keyup", e => {
  
  if (e.key == "Enter"){
    bingoBoard.style.color=e.target.value
  }

})


/* 색상 입력 시 빙고판 글자색 변경 */
fontColor.addEventListener("keyup", e=>{
  bingoBoard.style.color = e.target.value;
})
