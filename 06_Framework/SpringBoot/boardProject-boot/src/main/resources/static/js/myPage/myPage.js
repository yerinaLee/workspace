function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddress").focus();
        }
    }).open();
}

//---------------------------------------------------------------------

// input type="file" 태그의 특징
// - 파일이 선택되면 change 이벤트 발생
// - 파일이 선택화면에서 취소를 누르면
//   기존에 세팅된 value/files가 없어지게된다!
//   --> 1차 이미지 변경 후 2차 변경 과정에서 취소를 누르면
//       1차 이미지 value/files가 없어지게되어 
//       제출 시 파일이 서버로 전달되지 않는다

// - value에 대입 가능한 값은 빈칸("")뿐이다! (보안때문에 fakepath로 가려져있어서 작성이 불가)
// - files는 동일한 자료형(FileList) 또는 undefined 대입 가능



/* 프로필 이미지 미리보기, 제거 */
const profileImg = document.getElementById("profileImg"); // img 태그
let imageInput = document.getElementById("imageInput"); // input 태그
const deleteImage = document.getElementById("deleteImage"); // x버튼

// 프로필 이미지가 
// -1 : 변경되지 않았을 때
//  0 : 있었는데 없어짐 == x 버튼 클릭
//  1 : 새 이미지 선택 (없음 -> 있음, 있음 -> 다른 이미지)
let statusCheck = -1;

// input type="file" 태그의 값이 변경되었을 때 변경된 상태를 백업해둘 변수
// 요소.cloneNode(true/false) : 요소 복제(true이면 하위 요소도 복제_깊은복사 개념)
let backupInput;

if(imageInput != null){ // #imageInput 존재할때

    /* 프로필 이미지 변경(선택) 시 수행할 함수 */
    const changeImageFn = e => {

        console.log(e.target); // input 태그
        console.log(e.target.value); // 파일 경로(fakepath 형태로 출력) // C:\fakepath\sample4.jpg
        
        /* 이게 중요!!! */
        console.log(e.target.files); // 업로드된 파일의 정보가 담긴 배열 반환 // FileList {0: File, length: 1} 
                                    // /* 실제 파일 */

        console.log(e.target.files[0]); // 업로드된 파일 중 첫 번째 파일

        const uploadFile = e.target.files[0];

        // ---------------- 파일을 한 번 선택한 후 취소했을 때 ------------------
        if(uploadFile == undefined){ // 취소를 눌러서 files[0]에 파일이 없을 때
            console.log("파일 선택이 취소됨");

            // 1) backup한 요소를 한번 더 복제
            const temp = backupInput.cloneNode(true);

            // 2) 화면에 원본 input을 temp로 바꾸기
            imageInput.after(temp); // 원본 다음에 temp 추가
            imageInput.remove(); // 원본을 화면에서 제거
            imageInput = temp; // temp를 imageInput 변수에 대입

            // 복제본에 이벤트까지 복제되지 않으니 다시 이벤트를 추가함
            imageInput.addEventListener("change", changeImageFn);

            return;
        }

        // ---------------- 선택된 파일의 크기가 지정된 크기를 초과하는 경우 --------------
        const maxSize =  1024 * 1024 ; // 1MB (byte 단위) 1byte * 1024 = 1KB, 1KB * 1024 = 1MB

        if(uploadFile.size > maxSize){
            alert("1MB 이하의 이미지만 업로드 가능합니다");
            
            if(statusCheck == -1){ // 이미지 변경이 없었을 때

                // 최대 크기를 초과해도 input에 value가 남기 때문에
                // 이를 제거하는 코드가 필요하다!
                imageInput.value=''; // value 삭제 
                                    // 동시에 files도 삭제됨

                statusCheck = -1; // 선택 없음 상태


            } else { // 기존 이미지가 있었을 때

                // 1) backup한 요소를 한번 더 복제
                const temp = backupInput.cloneNode(true);

                // 2) 화면에 원본 input을 temp로 바꾸기
                imageInput.after(temp); // 원본 다음에 temp 추가
                imageInput.remove(); // 원본을 화면에서 제거
                imageInput = temp; // temp를 imageInput 변수에 대입
    
                // 복제본에 이벤트까지 복제되지 않으니 다시 이벤트를 추가함
                imageInput.addEventListener("change", changeImageFn);

                statusCheck = 1; // 값이 변경되었음
            }

            return;
        }

        // ---------------- 선택된 이미지 파일을 읽어와 미리보기 만들기 --------------

        // JS에서 파일을 읽는 객체
        // -> 파일을 읽고 클라이언트 컴퓨터에 파일을 저장할 수 있음
        const reader = new FileReader();

        // 매개변수에 작성된 파일을 읽어서
        // 파일을 나타내는 URL 형태로 변경
        // -> FileReader.result 필드에 저장되어 있음
        reader.readAsDataURL(uploadFile);

        // 파일을 다 읽었을 때
        reader.onload = e => {
            // console.log(reader.result); // 읽은 파일의 URL

            // img태그의 src 속성의 속성 값으로 
            // 읽은 파일의 URL을 대입

            profileImg.setAttribute("src", reader.result);

            statusCheck = 1; // 새 이미지 선택한 경우

            // 파일이 추가된 input을 backup 해두기
            backupInput = imageInput.cloneNode(true);
        }
    };

    /* 이미지 선택 버튼을 클릭하여 선택된 파일이 변했을 때 함수 수행 */

    // change 이벤트 : input의 이전 값과 현재 값이 다를 때 발생
    imageInput.addEventListener("change", changeImageFn)


    // ---------------- x 버튼 클릭 시 기본 이미지로 변경 --------------
    // 1) 미리보기 -> 기본이미지 변경
    // 2) input태그에 value 값을 빈칸으로 변경(파일 없음)

    deleteImage.addEventListener("click", ()=>{

        profileImg.setAttribute("src", defaultImage);
        imageInput.value = "";

        backupInput.value = "";

        statusCheck = 0; // 있었는데 없어짐
    });


    //----------------- 프로필 이미지 변경 form 태그 제출 시 동작 -----------------

    const profileFrm = document.getElementById("profileFrm");

    profileFrm.addEventListener("submit", e => {
        let flag = true;

        // 1) 로그인한 회원의 프로필이 있음 -> 없음
        if(loginMemberProfileImg != null && statusCheck == 0) flag = false;
        
        // 2) 로그인한 회원의 프로필이 없음 -> 있음
        if(loginMemberProfileImg == null && statusCheck == 1) flag = false;
        
        // 3) 로그인한 회원의 프로필이 있음 -> 변경 

        if(flag){ // flag가 true인 경우 수행
            e.preventDefault(); // 기본 이벤트 제거, form태그 제출 이벤트 막기(제거)
            alert("이미지 변경 후 클릭해주세요");
        }
    });
}
