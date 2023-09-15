// 컬러입력 가져오기

const boxInputArr = document.querySelectorAll(".input");
const boxArr = document.querySelectorAll(".colorbox");

function changeColor(){

  for(let i=0; i < boxArr.length; i++){
    boxArr[i].style.backgroundColor = boxInputArr[i].value;
  }
}

