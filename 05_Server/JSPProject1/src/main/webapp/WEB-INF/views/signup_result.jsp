<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSP 주석 (개발자도구 페이지에 보여지지 않음)--%>
<!-- HTML 주석 -->

<% // scriptlet(스크립틀릿) : 
  // JSP에서 자바 코드를 작성할 수 있는 영역

  String id = request.getParameter("inputId");
  String pw = request.getParameter("inputPw"); 
  String pwCheck = request.getParameter("inputPwCheck"); 
  String name = request.getParameter("inputName"); 
  int age = Integer.parseInt( request.getParameter("inputAge") );

%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 가입 결과</title>
</head>
<body>
  <%-- 
    <%= %> (JSP) 표현식(expression) :
      Java의 값, 변수 값을 HTML 형식으로 표현하여
      화면에 출력하는 구문
   --%>

  <%-- <h1><%= id%></h1> --%>

  <% if( !pw.equals(pwCheck) ){ %>   <%-- 비밀번호 불일치 --%>
    <h1>비밀번호가 일치하지 않습니다</h1>
  <% } else if( age < 14 ){ %>   <%-- 14세 미만 --%>
    <h1>14세 이상만 가입 가능합니다</h1>
  <% } else { %>
    <h1>가입 성공</h1>
    <ul>
      <li>아이디 : <%= id%></li>
      <li>비밀번호 : <%= pw%></li>
      <li>이름 : <%= name%></li>
      <li>나이 : <%= age%>세</li>
    </ul>
    <hr>

    <h3>EL(Expression Language) 버전 출력</h3>
    <ul>
      <li>아이디 : ${param.inputId}</li>
      <li>비밀번호 : ${param.inputPw}</li>
      <li>이름 : ${param.inputName}</li>
      <li>나이 : ${param.inputAge}</li>
    </ul>

  <% } %>


  
</body>
</html>