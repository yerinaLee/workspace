// 제목 클릭 시
// alert(000은 XXX원 입니다.) 출력

const bookTitleList = document.querySelectorAll(".book-title");
// bookTitleList == 배열
// -> 요소 하나씩 꺼내온 경우 == 제목 td 요소
// -> 요소 하나씩 꺼내서 클릭된 경우라는 이벤트 리스너 추가

// 요소 하나씩 다 꺼내기 좋은 방법 == 향상된 for문(for of)

for(let title of bookTitleList){
  
  title.addEventListener("click", e => {
    // e : 이벤트 객체
    // console.log(e.target.innerText);
    // console.log(e.target.nextElementSibling.nextElementSibling.innerText);

    // 제목
    const t = e.target.innerText;

    // 가격
    // const p = e.target.nextElementSibling.nextElementSibling.innerText;
    const p = e.target.getAttribute("data-price");

    // `${백틱}`
    alert(`${t}은/는 ${p}원 입니다`);
  })
}


