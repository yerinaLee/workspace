const apple = document.getElementById("apple"); // 사과 갯수인풋 저장
const banana = document.getElementById("banana");
const melon = document.getElementById("melon");

const checkApple = document.getElementById("check-apple");
const checkBanana = document.getElementById("check-banana");
const checkMelon = document.getElementById("check-melon");

const btn = document.getElementById("btn");
const result = document.getElementById("result"); // 결과 출력할 result 저장


btn.addEventListener("click", ()=>{

  result.innerHTML = "";  

  // 1. 품목이 체크되어있는지 먼저 확인
  // 2. 체크되어 있는 것들의 input 갯수 얻어와서 각각의 가격들을 계산
  // 3. 이걸 각 과일별로 함수를 만들고, str을 어떻게할건지 저장하고
  // 4. 마지막에 총합까지 더해서 출력?? 여기가 각이 안나오네ㅔ 일단 가보자고

  let applePrice = 0;
  let bananaPrice = 0;
  let melonPrice = 0;

  // 사과 체크시
  if(checkApple.checked){
    //인풋의 수량 가져오고 수량에 맞게 계산하기
    applePrice = 2000 * Number(apple.value);
    result.innerHTML += "사과 " + apple.value + "개 ";
  }

  // 바나나 체크시
  if(checkBanana.checked){
    bananaPrice = 3000 * Number(banana.value);
    result.innerHTML += "바나나 " + banana.value + "개 ";
  } 

  // 멜론 체크시
  if(checkMelon.checked){
    melonPrice = 5000 * Number(melon.value);
    result.innerHTML += "멜론 " + melon.value + "개 ";
  }

  result.innerHTML += "총합 " + Number(Number(applePrice) + Number(bananaPrice) + Number(melonPrice)) + "원";

});
