const inputId = document.getElementById("input-id");
const inputPw = document.getElementById("input-pw");
const inputPwCheck = document.getElementById("input-pw-check");

const checkList = {
  "input-id" : false,
  "input-pw" : false,
  "input-pw-check" : false
}

const signupForm = document.signupForm;


inputId.addEventListener("input", ()=>{
  const val = inputId.value.trim();
  const span = inputId.nextElementSibling.nextElementSibling;

  inputId.value = val;

  if(val.length ===0){
    span.innerText = "필수 입력 항목 입니다";

    checkList["input-id"] = false;
    return;
  } else {
    checkList["input-id"] = true;
  }
})


inputPw.addEventListener("click", ()=>{
  const span = inputPw.nextElementSibling.nextElementSibling;
  span.innerText = "영문자 대/소문자 특수문자, 숫자 포함 8~32글자";
})


inputPw.addEventListener("input", e=>{
  const val = inputPw.value.trim();
  const span = inputPw.nextElementSibling.nextElementSibling;

  inputPw.value = val;

  if(val.length ===0){
    span.innerText = "필수 입력 항목 입니다";

    checkList["input-pw"] = false;
    return;
  } 
  
  const regEx = /^[A-Za-z\d\!\@\#\$\%\^\&\*]{8,32}$/;

  if(regEx.test(val)){
    checkList["input-pw"] = true;
  } else{
    checkList["input-pw"] = false;
  }
})


inputPwCheck.addEventListener("input", ()=>{
  const val = inputPwCheck.value.trim();
  const span = inputPwCheck.nextElementSibling.nextElementSibling;

  inputPwCheck.value = val;

  if(val.length ===0){
    span.innerText = "필수 입력 항목 입니다";

    checkList["input-pw-check"] = false;
    return;
  } 
  
  const pwVal = inputPw.value;

  if(val == pwVal){
    checkList["input-pw-check"] = true;
  } else{
    checkList["input-pw-check"] = false;
  }
})


signupForm.addEventListener("submit", e=> {

  for(let key in checkList){
    if(!checkList[key]){
      alert("다시 입력해주세요");
      e.preventDefault();
      document.getElementById(key).focus();
    }
  }
})

