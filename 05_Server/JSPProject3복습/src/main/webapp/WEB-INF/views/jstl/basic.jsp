<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JSTL 기초</title>
</head>
<body>

  <%
    pageContext.setAttribute("num1", 10);
  %>

  <c:set var="num2" scope="page" value="20"/>

  <h4>num1 : ${num1}</h4>
  <h4>num2 : ${num2}</h4>
  
</body>
</html>