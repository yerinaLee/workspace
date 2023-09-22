const num1 = document.getElementById("1");
const num2 = document.getElementById("2");
const num3 = document.getElementById("3");
const num4 = document.getElementById("4");
const num5 = document.getElementById("5");
const num6 = document.getElementById("6");
const num7 = document.getElementById("7");
const num8 = document.getElementById("8");
const num9 = document.getElementById("9");
const num0 = document.getElementById("0");

const input = document.getElementById("numbers");
const btn = document.getElementById("btn");


// 초기화 버튼
btn.addEventListener("click", ()=>{
  input.innerText = "";
})


// // 클릭한 숫자
// num1.addEventListener("click", ()=>{
//   input.innerText += "1";
// })

// num2.addEventListener("click", ()=>{
//   input.innerText += "2";
// })

// num3.addEventListener("click", ()=>{
//   input.innerText += "3";
// })

// num4.addEventListener("click", ()=>{
//   input.innerText += "4";
// })

// num5.addEventListener("click", ()=>{
//   input.innerText += "5";
// })

// num6.addEventListener("click", ()=>{
//   input.innerText += "6";
// })

// num7.addEventListener("click", ()=>{
//   input.innerText += "7";
// })

// num8.addEventListener("click", ()=>{
//   input.innerText += "8";
// })

// num9.addEventListener("click", ()=>{
//   input.innerText += "9";
// })

// num0.addEventListener("click", ()=>{
//   input.innerText += "0";
// })


const numberList = document.querySelectorAll(".number");

for(let num of numberList){
  num.addEventListener("click", e=>{
    if(numbers.innerText.length >= 10){
      alert("10글자 이상 안됨");
      return;
    }
    numbers.innerText += num.innerText;
  })
}
