const input1 = document.querySelector("#input-1");
const input2 = document.querySelector("#input-2");
// const input2 = document.getElementById(input-2);

const result = document.getElementById("result");


function calc(op){

  v1 = Number(input1.value);
  v2 = Number(input2.value);

  let res;

  switch(op){
    case '+' : res = v1 + v2; break;
    case '-' : res = v1 - v2;  break;
    case '*' : res = v1 * v2;  break;
    case '/' : res = v1 / v2;  break;
    case '%' : res = v1 % v2;  break;
  }

  result.innerHTML = res;
}