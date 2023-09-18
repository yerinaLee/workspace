const boxQ = document.getElementById("boxQ");
const boxW = document.querySelector("#boxW");
const boxE = document.querySelector("#boxE");
const boxR = document.querySelector("#boxR");

const color = "rgb(75, 116, 250)";

// 문서 내에서 키다운 이벤트가 발생했을 때
document.addEventListener("keydown", function(e){
  if(e.key == "q" || e.key == "Q"){
    boxQ.style.backgroundColor = color;
  } else if (e.key =="w" || e.key =="W"){
    boxW.style.backgroundColor = color;
  } else if (e.key =="e" || e.key =="E"){
    boxE.style.backgroundColor = color;
  } else if(e.key == "r" || e.key == "R"){
    boxR.style.backgroundColor = color;
  }
})

// 문서 내에서 키업 이벤트가 발생했을 때
document.addEventListener("keyup", function(e){

  if(e.key == "q" || e.key == "Q"){
    boxQ.style.backgroundColor = "white";
  } else if (e.key =="w" || e.key =="W"){
    boxW.style.backgroundColor = "white";
  } else if (e.key =="e" || e.key =="E"){
    boxE.style.backgroundColor = "white";
  } else if(e.key == "r" || e.key == "R"){
    boxR.style.backgroundColor = "white";
  }
})