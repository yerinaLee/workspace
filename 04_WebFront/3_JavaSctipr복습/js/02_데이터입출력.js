const test1 = document.getElementById("test1");
const test2 = document.getElementById("test2");

function getBoxText(){
  console.log(test1.innerText);
}

function setBoxText(){
  test1.innerText
  = "innerText로 <br> 변경된 <b>내용임다</b>";
}


function getBoxHTML(){
  console.log(test2.innerHTML);
}

function setBoxHTML(){
  test2.innerHTML += "<ul>"
  +"<li>적용되나욤?</li>"
  +"<li>됩니당!</li>"
  +"</ul>";
}


function confirmFn(){
  const confirmBox = document.getElementById("confirm-box");

  if(confirm("배경색을 변경할까요?")){
    confirmBox.style.background="green";
  } else {
    confirmBox.style.background="white";
  }
}


function promptFn(){
  const result = document.getElementById("prompt-result");

  const name = prompt("이름을 입력해주세요");

  if(name != null){
    result.innerText = name + "님 안녕하쇼~!";
  } else {
    result.innerText = "이름이 입력 안댐"
  }
}

function addBox(){
  const con2 = document.getElementById("con2");

  con2.innerHTML += "<div class='box2'></div>"
}
