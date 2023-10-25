/* 회원 번호를 입력 받아 일치하는 회원의 이메일 조회 하기(비동기) */

const inputMemberNo = document.getElementById("inputMemberNo");
const selectMemberNo = document.getElementById("selectMemberNo");
const result1 = document.getElementById("result1");

// 조회 버튼 클릭 시
selectMemberNo.addEventListener("click", ()=>{

  /* fetch() API를 이용한 GET 방식 요청 */
  // GET : 조회(SELECT)
  // 쿼리 스트링(querystring) :
  //  - 주소에 담겨진 파라미터를 지칭하는 단어
  //  - ?key=value&key=value (띄어쓰기 No!!)

  // fetch("주소?쿼리스트링")

  // then : 그리고 나서, (앞 동작이) 완료된 후에

  fetch("/ajax/selectMemberNo?memberNo=" + inputMemberNo.value)

  // 요청에 대한 응답이 돌아왔을 때 수행
  .then( (response) => { // response : 응답이 담겨져있는 객체(promise)
    console.log(response); // promise 객체
    return response.text(); // promise에 담긴 응답 결과를 text형태로 파싱 후 반환
  }) 

  // 첫 번째 then()에서 반환된 결과를 이용해 기능을 수행
  .then( (email) => { // email : 첫 번째 then에서 파싱된 데이터 (변수명은 맘대로해도댐)
    console.log("email : " + email);

    // 응답 결과(email)이 존재하는 경우
    // 있으면 : 이메일 문자열
    // 없으면 : 빈칸

    if(email == ''){ // 빈칸일 경우
      result1.innerText = "일치하는 회원이 없습니다";
    } else {
      result1.innerText = email;
    }
  } )

  // 비동기통신 중 예외 발생 시 수행 (try-catch의 그 catch)
  .catch( (e)=>{ // e: 예외 관련 정보 객체
    console.log(e);
  } )

})



/* 이메일이 일치하는 회원의 전화번호 조회(비동기) */
const inputEmail = document.getElementById("inputEmail");
const btn2 = document.getElementById("btn2");
const result2 = document.getElementById("result2");

btn2.addEventListener("click", ()=>{

  // get방식이니까 쿼리스트링으로~
  fetch( "/ajax/selectEmail?inputEmail=" + inputEmail.value )
  .then( response => response.text() ) // 응답이 돌아왔을 때 수행, 응답 결과를 text로 파싱

  // 첫번째 then의 반환된 결과를 이용해 기능 수행
  .then( tel => {

    if(tel == ''){
      result2.innerText = "이메일이 일치하는 회원이 없습니다";
    } else {
      result2.innerText = tel;
    }
  } ) 

  // catch는 선택사항~
  .catch(e => {console.log(e);}) // 예외 발생 시 수행
})



/* 회원번호가 일치하는 회원 정보 모두 조회 */
const no2 = document.getElementById("inputMemberNo2");
const btn3 = document.getElementById("btn3");
const result3 = document.getElementById("result3");

btn3.addEventListener("click", ()=>{

  fetch("/ajax/selectMember?no=" + no2.value)
  // 응답 데이터가 JSON인 경우 JS객체로 파싱
  .then(resp => resp.json()) // JS객체 반환 또는 예외 발생
  .then( (member) => {
    
    result3.innerHTML=""; // #result3 내용 삭제

    const ul = document.createElement("ul"); // ul 태그 만듦 (화면에 넣은건 X)

    // 객체 전용 향상된 for문
    for(let key in member){
      const li = document.createElement("li"); // li 요소 생성
      li.innerText = `${key} : ${member[key]}`; // li 내용 추가
      ul.append(li); // ul의 마지막 자식으로 li 추가
    }

    result3.append(ul); // result3의 마지막 자식으로 ul 추가
  })

  .catch(e => { // 조회 결과가 null이면 JSON 파싱에서 예외 발생
    result3.innerHTML = ""; // 기존내용 삭제

    const h4 = document.createElement("h4");
    h4.innerText = "일치하는 회원이 없습니다";

    result3.append(h4);
  })
})


// 알짜! 검색할때 사용
/* 문자열을 입력 받아 일부라도 일치하는 모든 이메일 조회 */
const input4 = document.getElementById("input4");
const btn4 = document.getElementById("btn4");
const result4 = document.getElementById("result4");

btn4.addEventListener("click", ()=>{

  fetch("/ajax/selectEmailList?keyword=" + input4.value)
  .then( resp => resp.json()) // List객체 -> JSON Array -> JS객체 배열 변환
  .then( emailList => {

    result4.innerHTML =""; // 이전 내용 삭제

    if(emailList.length == 0){ // 조회 결과 X
      const tr = document.createElement("tr");

      const th = document.createElement("th");
      th.innerText = "조회결과가 없습니다.";

      tr.append(th);
      result4.append(tr);

    } else { // 조회 결과 O
      
      // JS의 향상된 for문 : for...of
      for( let email of emailList ){
        const tr = document.createElement("tr");
        const td = document.createElement("td");
        td.innerText = email;

        // td 클릭 시 해당 이메일 회원 정보 상세 조회
        td.addEventListener("click", e=>{
          location.href="/admin/selectMember?inputEmail=" + e.target.innerText
        });
  
        tr.append(td);
        result4.append(tr);
      }
    }
  })

  .catch( e=> console.log(e))
})


//---------------------------------------------------------------


/* 회원 조회 버튼 클릭 시 모든 회원 정보 조회 */
const btn5 = document.getElementById("btn5");
const result5 = document.getElementById("result5");

btn5.addEventListener("click", ()=>{

  // 파라미터(쿼리스트링)이 없는 GET 방식 비동기 요청
  fetch("/ajax/selectAll")
  .then( response => {
    // response == 응답 정보가 담긴 객체(상태코드, 데이터 등)

    console.log(response);
    console.log(response.status);
    console.log(response.body);
    if(response.ok){console.log("비동기통신 성공! 에브리띵퐈인");}

    // console.log(response.json()); // promise 객체

    // json 형태의 응답 데이터를(memberList)
    // JS 객체 형태로 변환해서 반환
    // (첫번째 then에서 리턴 시 promise객체에 데이터만 반환됨)
    return response.json(); 
  } )

  .then(memberList => {
    // memberList : 첫 번째 then에서 반환된 JS 객체(변환까지 완료)
    console.log(memberList);

    result5.innerHTML = ""; // tbody 내용 제거
    
    for(let member of memberList){ // 향상된 for문
      const tr = document.createElement("tr");
      
      const td1 = document.createElement("td");
      const td2 = document.createElement("td");
      const td3 = document.createElement("td");
      const td4 = document.createElement("td");
      const td5 = document.createElement("td");

      td1.innerText = member.memberNo; // 회원번호
      td2.innerText = member.memberEmail; // 회원이메일
      td3.innerText = member.memberNickname; // 닉네임
      td4.innerText = member.memberTel; // 전화번호

      // td5(탈퇴여부) 컬럼에는 버튼을 만들어서 집어넣기
      const btn = document.createElement("button");

      if(member.memberDelFl == 'Y'){ // 탈퇴 상태인 경우
        btn.innerText = "복구"
        btn.style.backgroundColor = "greenyellow";
      } else { // 'N'
        btn.innerText = "탈퇴"
        btn.style.backgroundColor = "pink";
      }
      
      // 탈퇴 여부(Y, N)을 속성으로 추가
      btn.setAttribute("data-flag", member.memberDelFl);

      // ======================================================
      // 버튼 클릭 시 회원 탈퇴/복구 ajax

        btn.addEventListener("click", e =>{
          // 버튼의 속성 중 "data-flag" 값이 'N'이면 'Y', 'Y'면 'N' 저장
          // -> DB UPDATE 시 MEMBER_DEL_FL에 대입할 값으로 이용
          const flag = e.target.getAttribute("data-flag") == 'N' ? 'Y' : 'N';

          // 회원번호
          // -  클릭된 버튼의 부모(td)의 부모(tr)의 자식들 중 0번째(td1)
          const temp = e.target.parentElement.parentElement.children[0];
          const targetNo = temp.innerText;

          // 필요한 데이터를 한 번에 저장한 JS 객체 생성
          const obj = {};
          obj.flag = flag;
          obj.targetNo = targetNo;

          // AJAX 코드 작성
          fetch("/ajax/updateFlag", {

            method : "PUT", // PUT 방식 요청
            headers : {"Content-Type": "application/json"},
            body : JSON.stringify(obj)
          })

          .then(resp => resp.text())
          .then (result => { 
            if(result > 0){ // 성공시
              if(flag == 'Y') {
                btn.innerText = "복구";
                btn.style.backgroundColor = "greenyellow";
              } else{
                btn.innerText = "탈퇴";
                btn.style.backgroundColor = "pink";
              }

              btn.setAttribute("data-falg", flag);
            } 

            else{ // 실패시
              alert("탈퇴여부 변경 실패~~~");
            }
           })
          .catch(e => console.log(e))
        })

      // ======================================================

      td5.append(btn); // td5에 추가

      // tr에 생성한 td 모두 추가
      tr.append(td1, td2, td3, td4, td5);

      // tbody(result5)에 td 추가
      result5.append(tr);
    }
  })

})



/* 샘플 계정 생성 */
const sampleInputList = document.querySelectorAll("#sample-container > input");
const btn6 = document.querySelector("#btn6");

btn6.addEventListener("click", ()=>{

  // 입력된 값들을 한 번에 저장할 JS 객체 생성
  const member = {};

  // JS 객체에 key, value 추가
  // (JS 객체는 key가 존재하지 않으면 자동으로 추가되는 특징이 있음)
  member.memberEmail = sampleInputList[0].value;
  member.memberNickname = sampleInputList[1].value;
  member.memberTel = sampleInputList[2].value;

  console.log(member); // JS 객체에 key/value 추가 확인

  // 비동기로 샘플 회원 가입

  /* 
    요청 방식에 따른 용도 (REST API 참고)
    GET    == SELECT
    POST   == INSERT
    PUT    == UPDATE
    DELETE == DELETE 
  */

  fetch("/ajax/insertMember", {
    method : "POST", // 요청 방식
    headers : {"Content-Type" : "application/json"}, // 요청 관련 정보 작성(요청 데이터의 형식 등)
    body : JSON.stringify(member) // POST, PUT, DELET는 body에 데이터를 담아서 전달
    // JSON.stringify(member) : member 객체를 JSON으로 변환(문자열화)
  })
  .then( resp => resp.text() )
  .then( result => {
    if(result > 0){
      alert("가입 성공~");

      // input 태그 작성 값 모두 삭제
      sampleInputList.forEach( input => input.value = "");
    } 

    else{ alert("가입 실패...");}
  } )
  .catch(e=>console.log(e));
});