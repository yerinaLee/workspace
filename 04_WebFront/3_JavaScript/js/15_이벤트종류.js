// focus 이벤트
const focusTest = document.getElementById("focus-test");

// 포커스가 맞춰졌을 때
focusTest.addEventListener("focus", ()=>{
  focusTest.classList.add("focus");
})

// 포커스를 잃었을 때
focusTest.addEventListener("blur", ()=>{
  focusTest.classList.remove("focus");
})


// checkbox - change 이벤트
document.getElementById("check-test").addEventListener("change", e => {
  console.log(e.target.checked);
});

// text - change 이벤트
document.getElementById("input-change").addEventListener("change", e => {
  alert("change 이벤트 발생");
});


// input 이벤트
document.getElementById("test").addEventListener("input", e=>{
  
  console.log(e);
  console.log(e.target.value);
} )

