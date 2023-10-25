function sample6_execDaumPostcode() {
  new daum.Postcode({
      oncomplete: function(data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 각 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var addr = ''; // 주소 변수

          //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
          if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
              addr = data.roadAddress;
          } else { // 사용자가 지번 주소를 선택했을 경우(J)
              addr = data.jibunAddress;
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.getElementById('sample6_postcode').value = data.zonecode;
          document.getElementById("sample6_address").value = addr;
          // 커서를 상세주소 필드로 이동한다.
          document.getElementById("sample6_detailAddress").focus();
      }
  }).open();
}


// -------------------------------------------------------------------------------------

/****** 회원가입 유효성 검사 ******/
// .confirm : 초록색 / .error : 빨간색 / 아무것도 없음 : 검은색

/* 모든 입력이 유효성 검사가 진행되었는지 체크할 객체를 생성 */
const checkObj = {
    "memberEmail" : false,
    "authKey" : false,
    "memberPw" : false,
    "memberPwConfirm" : false,
    "memberNickname" : false,
    "memberTel" : false
};

/* 이메일 유효성 검사 */

// 1) 이메일 유효성 검사에 사용할 요소 모두 얻어오기
const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.getElementById("emailMessage");

// 2) 이메일이 입력(input) 될 때 마다 유효성 검사 실행
memberEmail.addEventListener("input", ()=>{
    
    // 3) 입력된 이메일이 없을 경우
    if(memberEmail.value.trim().length == 0){
        memberEmail.value = '';
        emailMessage.innerText = "메일을 받을 수 있는 이메일을 입력해주세요";

        // emailMessage의 클래스를 제거해서 글자색을 검은색으로 만들기
        emailMessage.classList.remove("confirm", "error");

        // checkObj의 memberEmail 값을 false로 변경
        // == 이메일이 유효하지 않음을 의미
        checkObj.memberEmail = false;
        return;
    }

    // 4) 이메일 정규식 검사
    const regEx = /^[A-Za-z\d\-\_]{4,}@[가-힣\w\-\_]+(\.\w+){1,3}$/;

    // 입력 받은 이메일이 정규식과 일치하는 경우
    if( regEx.test(memberEmail.value) ){

        /* ============== 이메일 중복 검사(비동기) ============== */
        fetch("/member/checkEmail?email=" + memberEmail.value)
        .then(response => response.text())
        .then(result => { 

            // 중복되는 이메일이 없음
            if(result == 0){ 
                emailMessage.innerText = "사용 가능한 이메일입니다.";
                emailMessage.classList.add("confirm"); // 초록색 글씨
                emailMessage.classList.remove("error"); // 빨간글씨 제거
                checkObj.memberEmail = true; // 유효한 상태임을 기록
            } else{ // 중복 O
                emailMessage.innerText = "이미 사용중인 이메일입니다.";
                emailMessage.classList.add("error"); // 초록색 글씨
                emailMessage.classList.remove("confirm"); // 빨간글씨 제거
                checkObj.memberEmail = false;
            }
         })
        .catch(e => console.log(e))

        /* ====================================================== */
    }

    // 입력 받은 이메일이 정규식과 일치하지 않은 경우
    else {
        emailMessage.innerText = "알맞은 이메일 형식으로 작성해주세요.";
        emailMessage.classList.add("error"); // 빨간글씨 글씨
        emailMessage.classList.remove("confirm"); // 초록색 제거
        checkObj.memberEmail = false; // 유효하지 않은 상태임을 기록
    }
})


//============================= 이메일 인증 ============================

/* 인증번호 메일로 보내기 + DB INSERT */
const sendAuthKeyBtn = document.getElementById("sendAuthKeyBtn")
const authKeyMessage = document.getElementById("authKeyMessage")

// 인증번호 보내기 버튼을 클릭 하면
// authKeyMessage에 5분 타이머를 출력

let authTimer;
let authMin = 4;
let authSec = 59;

// 인증번호를 보낸 이메일을 저장할 변수
let tempEmail;

// 인증번호 받기 버튼 클릭 시
sendAuthKeyBtn.addEventListener("click", function(){
    authMin = 4;
    authSec = 59;

    checkObj.authKey = false;

    if(checkObj.memberEmail){ // 중복이 아닌 이메일인 경우


        /* fetch() API - POST방식, 단일 데이터 요청 */
        fetch("/email/signup", {
            method : "POST",
            headers : {"Content-Type" : "application/text"},
            body : memberEmail.value // 전달되는 데이터가 한 개
        })
        .then(resp => resp.text())
        .then(result => {
            if(result > 0){
                console.log("인증 번호가 발송되었습니다.")
                tempEmail = memberEmail.value;
            }else{
                console.log("인증번호 발송 실패")
            }
        })
        .catch(err => {
            console.log("이메일 발송 중 에러 발생");
            console.log(err);
        });
        

        alert("인증번호가 발송 되었습니다.");

        
        authKeyMessage.innerText = "05:00";
        authKeyMessage.classList.remove("confirm");

        authTimer = window.setInterval(()=>{

            authKeyMessage.innerText = "0" + authMin + ":" + (authSec<10 ? "0" + authSec : authSec);
            
            // 남은 시간이 0분 0초인 경우
            if(authMin == 0 && authSec == 0){
                checkObj.authKey = false;
                clearInterval(authTimer);
                return;
            }

            // 0초인 경우
            if(authSec == 0){
                authSec = 60;
                authMin--;
            }

            authSec--; // 1초 감소

        }, 1000)

    } else{
        alert("중복되지 않은 이메일을 작성해주세요.");
        memberEmail.focus();
    }

});


/* 인증번호 확인 */
const authKey = document.getElementById("authKey");
const checkAuthKeyBtn = document.getElementById("checkAuthKeyBtn");

checkAuthKeyBtn.addEventListener("click", function(){

    if(authMin > 0 || authSec > 0){ // 시간 제한이 지나지 않은 경우에만 인증번호 검사 진행
        /* fetch API */
        const obj = {"inputKey":authKey.value, "email":tempEmail}

        fetch("/email/checkAuthKey",  {
            method : "POST",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(obj)
        })
        .then(resp => resp.text())
        .then(result => {
            if(result > 0){
                clearInterval(authTimer);
                authKeyMessage.innerText = "인증되었습니다.";
                authKeyMessage.classList.add("confirm");
                checkObj.authKey = true;

                authKey.disabled = true; // 비활성화
            } else{
                alert("인증번호가 일치하지 않습니다.")
                checkObj.authKey = false;
            }
        })
        .catch(err => console.log(err));


    } else{
        alert("인증 시간이 만료되었습니다. 다시 시도해주세요.")
    }

});


//======================================================================


/* 비밀번호 유효성 검사 */
/*  비밀번호/비밀번호 확인 유효성 검사 */
const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const pwMessage = document.getElementById("pwMessage");

// 비밀번호 입력 시 유효성 검사
memberPw.addEventListener("input", () => {

    // 비밀번호가 입력되지 않은 경우
    if(memberPw.value.trim().length == 0){
        memberPw.value = ""; // 띄어쓰지 못넣게 하기

        pwMessage.innerText = "영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이로 입력해주세요.";
        pwMessage.classList.remove("confirm", "error"); // 검정 글씨

        checkObj.memberPw = false; // 빈칸 == 유효 X
        return;
    }


    // 정규 표현식을 이용한 비밀번호 유효성 검사

    // 영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이
    const regEx = /^[a-zA-Z0-9\!\@\#\-\_]{6,20}$/;

    // 입력한 비밀번호가 유효한 경우
    if(regEx.test(memberPw.value)){
        checkObj.memberPw = true; 
        
        // 비밀번호가 유효하게 작성된 상태에서
        // 비밀번호 확인이 입력되지 않았을 때
        if(memberPwConfirm.value.trim().length == 0){

            pwMessage.innerText = "유효한 비밀번호 형식입니다";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
        }
        
        // 비밀번호가 유효하게 작성된 상태에서
        // 비밀번호 확인이 입력되어 있을 때
        else{
            // 비밀번호 == 비밀번호 확인  (같을 경우)
            if(memberPw.value == memberPwConfirm.value){
                pwMessage.innerText = "비밀번호가 일치합니다";
                pwMessage.classList.add("confirm");
                pwMessage.classList.remove("error");
                checkObj.memberPwConfirm = true;
                
            } else{ // 다를 경우
                pwMessage.innerText = "비밀번호가 일치하지 않습니다";
                pwMessage.classList.add("error");
                pwMessage.classList.remove("confirm");
                checkObj.memberPwConfirm = false;
            }
        }

        
    } else{ // 유효하지 않은 경우
        
        pwMessage.innerText = "비밀번호 형식이 유효하지 않습니다";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        checkObj.memberPw = false; 
    }
});


// 비밀번호 확인 유효성 검사
memberPwConfirm.addEventListener('input', ()=>{

    if(checkObj.memberPw){ // 비밀번호가 유효하게 작성된 경우에

        // 비밀번호 == 비밀번호 확인  (같을 경우)
        if(memberPw.value == memberPwConfirm.value){
            pwMessage.innerText = "비밀번호가 일치합니다";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
            checkObj.memberPwConfirm = true;
            
        } else{ // 다를 경우
            pwMessage.innerText = "비밀번호가 일치하지 않습니다";
            pwMessage.classList.add("error");
            pwMessage.classList.remove("confirm");
            checkObj.memberPwConfirm = false;
        }

    } else { // 비밀번호가 유효하지 않은 경우
        checkObj.memberPwConfirm = false;
    }
});






/* 닉네임 유효성 검사 */
const memberNickname = document.getElementById("memberNickname");
const nickMessage = document.getElementById("nickMessage");

memberNickname.addEventListener("input", ()=>{

    // 미입력 시
    if(memberNickname.value.trim().length == 0){
        memberNickname.value = '';
        nickMessage.innerText = "한글,영어,숫자로만 2~10글자";
        checkObj.memberNickname = false;
        nickMessage.classList.remove("confirm", "error");
        return;
    }

    const regEx = /^[가-힣\w\d]{2,10}$/;

    if( regEx.test(memberNickname.value) ){

        /* ============== 닉네임 중복 검사(비동기) ============== */

        fetch("/member/checkNickname?nickname=" + memberNickname.value)
        .then(response => response.text())
        .then(result => {

            if(result == 0) { // 중복 X
                nickMessage.innerText = "사용 가능한 닉네임 형식입니다";
                nickMessage.classList.add("confirm"); 
                nickMessage.classList.remove("error");
                checkObj.memberNickname = true;
            } else { // 중복 O
                nickMessage.innerText = "이미 사용중인 닉네임 형식입니다";
                nickMessage.classList.add("error"); 
                nickMessage.classList.remove("confirm");
                checkObj.memberNickname = false;
            }
        })
        .catch(e => console.log(e))
        
        /* ====================================================== */
    }
    
    else{
        nickMessage.innerText = "유효하지 않은 닉네임 형식입니다";
        nickMessage.classList.add("error");
        nickMessage.classList.remove("confirm");
        checkObj.memberNickname = false;
    }
})


/* 전화번호 유효성 검사 */
const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");

memberTel.addEventListener("input", ()=>{

    // 미입력 시
    if(memberTel.value.trim().length == 0){
        memberTel.value = '';
        telMessage.innerText = "전화번호를 입력해주세요.(- 제외)";
        checkObj.memberTel = false;
        telMessage.classList.remove("confirm", "error");
        return;
    }

    const regEx = /^0(1[01679]|2|[3-6][1-5]|70)[1-9]\d{2,3}\d{4}$/;

    if( regEx.test(memberTel.value) ){
        telMessage.innerText = "유효한 전화번호 형식입니다";
        telMessage.classList.add("confirm"); 
        telMessage.classList.remove("error");
        checkObj.memberTel = true;
    }
    
    else{
        telMessage.innerText = "유효하지 않은 전화번호 형식입니다";
        telMessage.classList.add("error");
        telMessage.classList.remove("confirm");
        checkObj.memberTel = false;
    }
})


/* 회원 가입 버튼이 클릭 되었을 때 */
document.getElementById("signUpFrm").addEventListener("submit", e => {

    /* checkObj의 모든 값을 검사해서
       하나라도 false이면 가입 시도 X */

    // 객체 전용 향상된 for문 (for .... in)

    for(let key in checkObj){

        // 객체에서 얻어온 값이 false인 경우
        // (유효하지 않은 것이 있을 경우)
        if( !checkObj[key] ){

            let str;
            switch(key){
            case "memberEmail"     : str = "이메일이 유효하지 않습니다"; break;
            case "memberPw"        : str = "비밀번호가 유효하지 않습니다"; break;
            case "memberPwConfirm" : str = "비밀번호가 일치하지 않습니다"; break;
            case "memberNickname"  : str = "닉네임이 유효하지 않습니다"; break;
            case "memberTel"       : str = "전화번호가 유효하지 않습니다"; break;
            case "authKey"         : str = "인증번호가 유효하지 않습니다"; break;
            }

            alert(str);

            // key == input id 속성 값
            // 유효하지 않은 input 태그로 focus 맞춤
            document.getElementById(key).focus();

            e.preventDefault(); // form 제출 X
            return;
        }
    }
})