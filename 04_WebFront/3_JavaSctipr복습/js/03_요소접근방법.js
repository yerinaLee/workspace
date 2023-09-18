function idTest(){
  const div1 = document.getElementById("div1");

  const colorArray = ['red', 'orange', 'greem', 'blue', '#455ba8'];

  const ran = Math.floor( Math.random() * colorArray.length );

  div1.style.backgroundColor = colorArray[ran];
}


function classTest(){
  const arr = document.getElementsByClassName("div2");

  arr[0].style.backgroundColor= "rgb(16,43,140)";
  arr[0].innerText = "arr[0]입니다욥"

  arr[1].style.backgroundColor= "yellowgreen";
  arr[1].innerText = "arr[1]입니다욥";

  arr[2].style.backgroundColor= "yellow";
  arr[2].innerText = "arr[2]입니다욥";
}

function tagTest(){
  const arr = document.getElementsByTagName("li");

  for(let i = 0; i < arr.length; i++){
    arr[i].style.backgroundColor = "rgb(14,6,"+ arr[i].innerText +")";
  }
}


function nameTest(){

  const hobbyArray = document.getElementsByName("hobby");

  let str = "";
  let count = 0;

  for(let i = 0; i < hobbyArray.length; i++){

    if(hobbyArray[i].checked){
      count++;
      str += hobbyArray[i].value + " ";
    }
  }

  const div = document.getElementById("name-div");
  
  div.innerHTML = str + "<br><br> 선택된 input 개수 : " + count;
}



function cssTest(){
  document.querySelector("#css-div").style.border = "3px solid red";

  document.querySelector("#css-div > div").style.fontSize = "40px";

  const arr = document.querySelectorAll("css-div > div");

  arr[0].style.backgroundColor = "tomato";
  arr[1].style.backgroundColor = "yello";
}


function readValue(){
  const bg = document.querySelector("#chatting-bg");
  const input = document.querySelector("#user-input");

  if(input.value.trim().length == 0) {
    alert("채팅 내용 입력 ㄱㄱ");
  } else {
    bg.innerHTML += "<p><span>"+input.value+"</span></p>";
    bg.scrollTop = bg.scrollHeight;
  }
  input.value = "";
  input.focus();
}

document.querySelector("#user-input").addEventListener("keyup", function(e){
  
  if(e.key == "Enter") {
    readValue();
  }

});