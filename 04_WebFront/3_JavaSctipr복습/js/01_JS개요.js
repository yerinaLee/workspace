function externalFn(){
  alert("익스터널방식 ㄱㄱ")
}

const body = document.querySelector("body");

function lightMode(){
  body.style.backgroundColor = "white";
  body.style.color = "black";
}

function darkMode(){
  body.style.backgroundColor = "black";
  body.style.color = "white";
}