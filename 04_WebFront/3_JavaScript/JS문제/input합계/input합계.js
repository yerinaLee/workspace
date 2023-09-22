const inputBox = document.getElementById("input-box");
const btnCreate = document.getElementById("btn-create");
const btnAdd = document.getElementById("btn-add");
const result = document.getElementById("result");
const inputAdd = document.getElementById("input-add");


btnCreate.addEventListener("click", ()=>{
  for(let i = 0; i<inputBox.value; i++){
    inputAdd.innerHTML += '<div><input type="number" class="numbers"></div>';
  }
})


btnAdd.addEventListener("click", ()=>{
  
  const arr = document.querySelectorAll(".numbers");
  let sum = 0;

  for(let i = 0; i < inputBox.value; i++){
    sum += Number(arr[i].value);
  }

  result.innerHTML = sum;
})
