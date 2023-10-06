<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 목록</title>
</head>
<body>

  <table border="1">
    <thead>
      <tr>
        <th>회원번호</th>   
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>성별</th>
        <th>가입일</th>
      </tr>
    </thead>

    <tbody>
      <c:forEach items="${memberList}" var="mem">
        <tr>
          <td>${mem.memberNo}</td>
          <td>${mem.memberId}</td>
          <td>${mem.memberPw}</td>
          <td>${mem.memberName}</td>
          <td>${mem.gender}</td>
          <td>${mem.enrollDate}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  
</body>
</html>