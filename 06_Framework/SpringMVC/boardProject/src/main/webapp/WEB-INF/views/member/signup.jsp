<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>

    <jsp:include page="/WEB-INF/views/common/common.jsp" />
    <link rel="stylesheet" href="/resources/css/member/signup-style.css">
</head>
<body>
    <main>
        <%-- header.jsp include --%>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <section class="signUp-content">

            <form action="/member/signup" method="POST" name="signUpFrm" id="signUpFrm">

                <!-- 이메일 입력 -->
                <label for="memberEmail">
                    <span class="required">*</span> 아이디(이메일)
                </label>

                <div class="signUp-input-area">
                    <input type="text" name="memberEmail" id="memberEmail" 
                    placeholder="아이디(이메일)" maxlength="30" autocomplete="off">
                    
                    <button id="sendAuthKeyBtn" type="button">인증번호 받기</button>
                </div>
                <span class="signUp-message" id="emailMessage">메일을 받을 수 있는 이메일을 입력해주세요.</span>



                <!-- 인증번호 입력 -->
                <label for="emailCheck">
                    <span class="required">*</span> 인증번호
                </label>

                <div class="signUp-input-area">
                    <input type="text" name="authKey" id="authKey" s placeholder="인증번호 입력" maxlength="6" autocomplete="off" >
                    
                    <button id="checkAuthKeyBtn" type="button">인증하기</button>
                </div>
                <span class="signUp-message" id="authKeyMessage"></span>
                                <!-- 인증번호가 일치하지 않습니다 -->
                

                <!-- 비밀번호/비밀번호 확인 입력 -->
                <label for="memberPw">
                    <span class="required">*</span> 비밀번호
                </label>

                <div class="signUp-input-area">
                    <input type="password" name="memberPw" id="memberPw" 
                    placeholder="비밀번호" maxlength="20" >
                </div>
                <div class="signUp-input-area">
                    <input type="password" name="memberPwConfirm" id="memberPwConfirm" 
                    placeholder="비밀번호 확인" maxlength="20" >
                </div>

                <span class="signUp-message" id="pwMessage">영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이로 입력해주세요.</span>


                <!-- 닉네임 입력 -->
                <label for="memberNickname">
                    <span class="required">*</span> 닉네임
                </label>

                <div class="signUp-input-area">
                    <input type="text" name="memberNickname" id="memberNickname" placeholder="닉네임" maxlength="10" >
                </div>

                <span class="signUp-message" id="nickMessage">한글,영어,숫자로만 2~10글자</span>


                <!-- 전화번호 입력 -->
                <label for="memberTel">
                    <span class="required">*</span> 전화번호
                </label>

                <div class="signUp-input-area">
                    <input type="text" name="memberTel" id="memberTel" placeholder="(- 없이 숫자만 입력)" maxlength="11">
                </div>

                <span class="signUp-message" id="telMessage">전화번호를 입력해주세요.(- 제외)</span>



                <!-- 주소 입력 -->
                <label for="memberAddress">주소</label>

                <div class="signUp-input-area">
                    <input type="text" name="memberAddress" placeholder="우편번호" maxlength="6" id="sample6_postcode">
                    
                    <button type="button" onclick="sample6_execDaumPostcode()">검색</button>
                </div>

                <div class="signUp-input-area">
                    <input type="text" name="memberAddress" placeholder="도로명/지번 주소" id="sample6_address">
                </div>

                <div class="signUp-input-area">
                    <input type="text" name="memberAddress" placeholder="상세 주소" id="sample6_detailAddress">
                </div>


                <button id="signUpBtn">가입하기</button>
            </form>
        </section>

    </main>

    <%-- footer.jsp include --%>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <!-- 다음 주소 API -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

    <script src="/resources/js/member/signup.js"></script>
</body>
</html>