<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 프로젝트</title>
  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>

  <main>
    <h1>회원 프로그램</h1>

    <%-- 로그인이 되어있지 않다면
      == session에 "loginMember가 없다면(==null이면)"
    --%>
    <c:if test="${ empty sessionScope.loginMember}">
      <form class="login-container" action="/login" method="POST" name="login-form">
        <div class="login-row">
          <label>ID</label>
          <input type="text" id="input-id" name="id" placeholder="아이디 입력">
        </div>
  
        <div class="login-row">
          <label>PW</label>
          <input type="password" id="input-pw" name="pw" placeholder="비밀번호 입력">
        </div>
  
        <div class="login-row">
          <button>로그인</button>
        </div>
  
        <div class="login-row">
          <a href="/signup">회원 가입</a> 
        </div>

          <%-- session에 message가 존재한다면 --%>
          <c:if test="${not empty sessionScope.message}" >
            <h2>${sessionScope.message}</h2>
          </c:if>

      </form>
    </c:if>
    
    <%-- 로그인이 되어있다면
      == session에 "loginMember"가 있다면(== null 아님)
    --%>
    <c:if test="${ not empty sessionScope.loginMember}" >

      <div class="login-row">
        <h3>${loginMember.memberId} 님 환영합니다</h3>
      </div>

      <div class="login-row">
        <button id="logout-btn">로그아웃</button>
      </div>

      <div class="login-row">
        <button id="member-list-btn">회원 목록 조회</button>
      </div>

    </c:if>
    
    
  </main>
 
  <script src="/resources/js/main.js"></script>
</body>
</html>