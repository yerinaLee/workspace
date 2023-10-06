<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 가입</title>
  <link rel="stylesheet" href="/resources/css/main.css">
  <link rel="stylesheet" href="/resources/css/signup.css">
</head>
<body>
  
  <main>  
    <h1>회원 가입</h1>

    <form class="signup-container" action="/signup" method="POST" name="signupForm">
      <div class="signup-row">
        <div class="input-container">
          <label>아이디</label>
          <input type="text" name="id" id="id">
        </div>
        <p class="message">영어 대/소문자, 숫자 포함 6~16글자</p>
      </div>

      <div class="signup-row">
        <div class="input-container">
          <label>비밀번호</label>
          <input type="password" name="pw" id="pw">
        </div>
        <p class="message">영어 대/소문자, 숫자 포함 6~16글자</p>
      </div>

      <div class="signup-row">
        <div class="input-container">
          <label>비밀번호 확인</label>
          <input type="password" id="pw-check">
        </div>
        <p class="message">비밀번호를 입력해주세요</p>
      </div>

      <div class="signup-row">
        <div class="input-container">
          <label>이름</label>
          <input type="text" name="name" id="name">
        </div>
        <p class="message">한글 2~8글자</p>
      </div>

      <div class="signup-row">
        <div class="input-container">
          <label>성별</label>
          남 <input type="radio" name="gender" value="M"> / 
          여 <input type="radio" name="gender" value="F">
        </div>
      </div>

      <div class="signup-row">
        <button>회원 가입</button>
      </div>

    </form>

  </main>

  <script src="/resources/js/signup.js"></script>
</body>
</html>