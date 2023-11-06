// 미리보기 관련요소 모두 얻어오기

// img 태그 5개
const previewList = document.getElementsByClassName("preview");

// input type="file" 태그 5개
const inputImageList = document.getElementsByClassName("inputImage");

// x 버튼 5개
const deleteImageList = document.getElementsByClassName("delete-image");

// 요소 개수가 모두 같음
// -> n번 인덱스 요소가 한 곳에 모여있음

// inputImageList 크기만큼 백업용 배열을 생성
// - 파일선택 -> 취소 시 사용할 input type="file" 요소 저장
const backupInputList = new Array(inputImageList.length);

/* 이미지 선택 시 수행할 함수 */
const changeImageFn = (imageInput, order)=>{

  // imageInput : 파일이 선택/취소 된 input 태그
  // order : input 태그 순서(썸네일 0, 나머지 1~4)

  // 업로드 파일 최대 크기(10MB)
  const maxSize = 1024 * 1024 * 10;

  // 업로드한 파일 정보가 담긴 객체
  const uploadFile = imageInput.files[0];


  console.log(uploadFile);
  
  // ---------------- 파일을 한 번 선택한 후 취소했을 때 ------------------
  if(uploadFile == undefined){
    console.log("파일 선택이 취소됨");

    // 1) backup한 order번째 요소를 복제
    const temp = backupInputList[order].cloneNode(true);

    // 2) 화면에 원본 input을 temp로 바꾸기
    imageInput.after(temp); // 원본 다음에 temp 추가
    imageInput.remove(); // 원본을 화면에서 제거
    imageInput = temp; // temp를 imageInput 변수에 대입

    // 복제본에 이벤트까지 복제되지 않으니 다시 이벤트를 추가함
    imageInput.addEventListener("change", ()=>{
      changeImageFn(imageInput, order);
    });

    return;
  }

  // ---------------- 선택된 파일의 크기가 지정된 크기를 초과하는 경우 ---------

  if(uploadFile.size > maxSize){
    alert("10MB 이하의 이미지를 선택 해주세요");

    // 없다 -> 추가한 경우
    if(backupInputList[order] == undefined){
      imageInput.value = ''; // file 타입 input태그 value를 빈칸으로 만듦
                            // == 선택된 파일을 제거
    } 
    
    // 기존에 이미지 선택 -> 다시 새 이미지 선택
    else {

      // 1) backup한 order번째 요소를 복제
      const temp = backupInputList[order].cloneNode(true);

      // 2) 화면에 원본 input을 temp로 바꾸기
      imageInput.after(temp); // 원본 다음에 temp 추가
      imageInput.remove(); // 원본을 화면에서 제거
      imageInput = temp; // temp를 imageInput 변수에 대입

      // 복제본에 이벤트까지 복제되지 않으니 다시 이벤트를 추가함
      imageInput.addEventListener("change", ()=>{
        changeImageFn(imageInput, order);
      });
    }

    return;
  }


  // ---------------- 선택된 이미지 파일을 읽어와 미리보기 만들기 --------------

  // JS에서 파일을 읽는 객체
  // -> 파일을 읽고 클라이언트 컴퓨터에 파일을 저장할 수 있음
  const reader = new FileReader();

  // 매개변수에 작성된 파일을 읽어서 파일을 나타내는 URL 형태로 변경
  // -> FileReader.result 필드에 저장되어 있음
  reader.readAsDataURL(uploadFile);

  // 파일을 다 읽은 경우
  reader.onload = e=> {
    const url = e.target.result; // 이미지가 변환된 DateUrl

    // order번째 .preview에 이미지 추가
    previewList[order].src = url;

    // 파일이 업로드된 input 태그를 복제해서 backupInputList에 추가
    backupInputList[order] = imageInput.cloneNode(true);
  };
}


for(let i=0; i<inputImageList.length; i++){

  /* 이미지 선택 또는 취소 시 */
  inputImageList[i].addEventListener("change", e => {
    changeImageFn(e.target, i);
            // inputImage, order
  });

  /* x버튼 클릭 시 */  
  deleteImageList[i].addEventListener("click", ()=>{

    // 미리보기 삭제
    previewList[i].removeAttribute("src"); // src 속성 제거

    // input 태그 파일 제거
    inputImageList[i].value = "";

    // 같은 위치 backup 요소 제거
    backupInputList[i].value = undefined;
  });
}

//---------------------------------------------------------------------

/* 제출 시 유효성 검사 */
const boardWriteFrm = document.getElementById("boardWriteFrm");

boardWriteFrm.addEventListener("submit", e=>{

  const title = document.querySelector("[name='boardTitle']");
  const content = document.querySelector("[name='boardContent']");

  // 제목 미입력
  if(title.value.trim().length == 0){
    alert("제목을 입력해주세요");
    e.preventDefault(); // form 제출 X

    title.value = "";
    title.focus();
    return;
  }

  // 내용 미입력
  if(content.value.trim().length == 0){
    alert("내용을 입력해주세요");
    e.preventDefault(); // form 제출 X

    content.value = "";
    content.focus();
    return;
  }
})