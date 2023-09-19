const input1 = document.querySelector("#input-1");
const input2 = document.querySelector("#input-2");
const result = document.querySelector("#result");

function plusFn(){
  result.innerHTML = (Number(input1.value) + Number(input2.value));
}

function minusFn(){
  result.innerHTML = (Number(input1.value) - Number(input2.value));
}

function multiFn(){
  result.innerHTML = (Number(input1.value) * Number(input2.value));
}

function divFn(){
  result.innerHTML = (Number(input1.value) / Number(input2.value));
}

function restFn(){
  result.innerHTML = (Number(input1.value) % Number(input2.value));
}


