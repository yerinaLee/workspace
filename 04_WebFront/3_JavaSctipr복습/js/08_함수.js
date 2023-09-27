const count = document.getElementById("count");
const increment = document.querySelector("#increment");

function countIncrement(){

  ++count.value;

  if(count.value > 10){
    count.value = 0;
  }
}

increment.addEventListener("click", countIncrement);



document.querySelector("#btn2").addEventListener("click", function(e){

  const bg = e.target.style.backgroundColor;

  if(bg == "pink"){
    e.target.removeAttribute("style");
  } else {
    e.target.style.backgroundColor = "pink";
  }
})

// changeText(); 순서상 안맞아서 오류남

const changeText = function(){
  const btn2 = document.querySelector("#btn2");
  
  if(btn2.innerText == "익명 함수 확인"){
    btn2.innerText = "확인완!";
  } else {
    btn2.innerText = "익명 함수 확인";
  }
}

function test2(){
  console.log("일반함수");
}
test2();

(function(){
  console.log("즉시 실행 함수");
})()

const str = "전역 변수";

(function(){
  const str = "즉시 실행 함수지역 변수";
  console.log(str);
})()

console.log(str);

const arrowList = document.querySelectorAll(".arrow");

arrowList[0].addEventListener("click", ()=>{
  alert("기본 형태!");
})

arrowList[1].addEventListener("click", e=>{
  console.log(e.target.innerText);
  e.target.style.backgroundColor = "white";
})

arrowList[2].addEventListener("click", ()=>{
  testFn( (a,b) =>{ return a * b; } );
})

function testFn(paramFn){
  alert( paramFn(2,3) );
}


arrowList[3].addEventListener("click", ()=>{

  printObject( (name, age) => {
    return {"name" : name, "age" : age}
  });
})


function printObject(objectFn){
  const obj = objectFn("홍길동", 20);

  console.log(obj);
  alert(obj.name + " / " + obj.age);

}