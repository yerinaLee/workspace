// 아이디, 비밀번호, 이름이 작성되지 않은 경우 회원가입 X

/* form태그 name 속성 값이 있으면 document.name속성값으로 얻어올 수 있음 */
document.signupForm.addEventListener("submit", e=>{

  if (inputCheck("id")) {
    e.preventDefault(); // 기본 이벤트(제출) 막기
    return;
  };

  if (inputCheck("pw")) {
    e.preventDefault();
    return;
  };

  if (inputCheck("name")) {
    e.preventDefault();
    return;
  };

});


/* input 태그 작성 여부 확인 */
function inputCheck(idValue){
  const target = document.getElementById(idValue);
  const val = target.value.trim(); // 입력한 값(공백 제거)

  if(val.length == 0){ // 미작성된 경우
    alert(idValue + "가 입력되지 않았습니다");
    target.focus();
    return true;
  }

  // 작성된 경우
  return false;
}
