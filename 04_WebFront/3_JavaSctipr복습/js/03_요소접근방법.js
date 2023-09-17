function idTest(){
  const div1 = document.getElementById("div1");

  const colorArray = ['red', 'orange', 'greem', 'blue', '#455ba8'];

  const ran = Math.floor( Math.random() * colorArray.length );

  div1.style.backgroundColor = colorArray[ran];
}


function classTest(){
  const arr = document.getElementsByClassName("div2");

  arr[0].style.backgroundColor= "rgb(16,43,140)";
  arr[0].innerText = "arr[0]입니다욥"

  arr[1].style.backgroundColor= "yellowgreen";
  arr[1].innerText = "arr[1]입니다욥";

  arr[2].style.backgroundColor= "yellow";
  arr[2].innerText = "arr[2]입니다욥";
}

function tagTest(){
  const arr = document.getElementsByTagName("li");

  for(let i = 0; i < arr.length; i++){
    arr[i].style.backgroundColor = "rgb(14,6,"+ arr[i].innerText +")";
  }



}