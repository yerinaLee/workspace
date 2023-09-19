function inlineEventModel(btn){
  
  console.log(btn.style.backgroundColor);

  if(btn.style.backgroundColor != "pink"){
    btn.style.backgroundColor = "pink";
  } else {
    btn.removeAttribute("style");
  }
}

const a = document.querySelector("#test2-1");
a.onclick = function(){
  alert("test2-1클릭ㅆ");
}


const b = document.querySelector("#test2-2");
b.onclick = function(){
  a.onclick = undefined;
  alert("제거완료");
}


const c = document.querySelector("#test2-3");

c.onclick = function(){
  c.style.backgroundColor = "yellow";
}

c.onclick = function(){
  c.style.fontSize = "30px";
}


document.querySelector("#test3").addEventListener("click", function(){
  
  console.log(this.clientWidth);
  
  this.style.width = this.clientWidth + 10 + "px";
})


document.querySelector("#test3").addEventListener("click", function(e){
  // console.log(e);
  // console.log(e.target);
  
  this.style.height = this.clientHeight + 10 + "px";
  // e.target.style.height = e.target.clientHeight + 10 + 'px';
})

const box4 = document.querySelector("#box4");
const text = document.querySelector("#input4");
const btn4 = document.querySelector("#btn4");

btn4.addEventListener("click", function(){
  box4.style.backgroundColor = text.value;
})

text.addEventListener("keyup", function(e){
  
  if(e.key == 'Enter'){
    box4.style.backgroundColor = e.target.value;
  }
})


document.querySelector("#move").addEventListener("click", function(e){
    e.preventDefault();
})


// document.getElementById("login").addEventListener("submit", function(e){
//   alert("제출!");
//   e.preventDefault();
// })


function testFn(){
  const id = document.getElementById("input-id");
  const pw = document.getElementById("input-pw");

  if(id.value.trim().length == 0 || pw.value.trim().length == 0){
    alert("모두 입력해주세용");
    return false;
  }

  return true;
}



const loginBtn2 = document.getElementById("login-btn2");
loginBtn2.addEventListener("click", function(){

    const id = document.getElementById("input-id");
    const pw = document.getElementById("input-pw");

    if(id.value.trim().length != 0 && pw.value.trim().length != 0){
      document.loginform.submit();
    }
})


const inputN = document.querySelector("#count-input");
const ul = document.querySelector("#list");
const btn1 = document.querySelector("#create-btn");
const btn2 = document.querySelector("#calc");
const inputLi = document.querySelector(".list-input");


btn1.addEventListener("click", function(){ listAddFn(); });

function listAddFn(){

  for(let i = 0; i <= inputN.value; i++){
    ul.innerHTML += "<li> <input type='number' class='list-input'></li>";
  }

  document.body.scrollIntoView(false);
}


btn2.addEventListener("click", function(){
  const arr = document.querySelector()


})