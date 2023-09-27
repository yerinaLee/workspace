<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL 라이브러리 중 사용하고자 하는 태그 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
 <%@ %> : 지시자 태그(페이지 정의)

 taglib : 태그 라이브러리 추가(JSTL, 커스텀태그)

 prefix(접두사) : 태그 앞에 작성되는 단어

 uri(Uniform Resource Identifier, 통합 자원 식별자) : 
  -> 자원(코드, 이미지, 페이지 등..)을 구분하는 문자열
  -> ID 같은 것
  (JSTL 라이브러리에서 원하는 코드 찾기)
--%>


<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>피자 주문 결과</title>
</head>
<body>

  <h1>EL(Expression Language) : 표현 언어</h1>
  <pre>
    JSP의 기본 표현식을 <%-- <%= %> --%>
    보다 효율적이고 간단히 작성할 수 있도록 고안된 언어
    (JSP 기본 내장)

    화면에 출력하고자 하는 Java 코드(값, 변수명 등)를
    \${ KEY } 형식으로 작성하면
    KEY에 해당하는 Value가 화면에 표시됨
  </pre>
  
  <hr>
  <h3>\${param.name속성값} : 파라미터 출력하기</h3>
  <ul>
    <li>${param.pizza}</li>
    <li>${param.size}</li>
    <li>${param.amount}</li>
  </ul>

  <hr>
  <h3>\${속성key} : 속성의 value 출력하기</h3>
  pizzaName : ${pizzaName} <br>
  price : ${price}

  (참고) price : <%= (int)( request.getAttribute("price")) %>

  <hr>

  <h1>JSTL(JSP Standard Tag Library)</h1>
  <pre>
    JSP에서 자주 사용되거나, 공통적으로 사용되는
    Java 코드(if, for, 변수 선언, 형변환 등)를

    JSP에서 작성하기 편하게 태그 형식으로 만들어
    표준으로 제공하는 라이브러리
    (만들어진 태그 == 커스텀 태그)
  </pre>

  <hr>
  <h3>c:if 태그</h3>
  <pre>
    - Java의 if문을 대체하는 태그
    - else문 없음

    [속성]
    test 속성 : 조건을 작성하는 속성

    ** 주의사항 **
    1) test 속성의 값은 무조건 EL 형식으로 작성!
    2) 조건의 결과는 무조건 true / false
    3) test 속성값을 작성할 때 "" 내부에 작성
        "  1+1" 처럼 "" 내부 시작과 끝 부분에 공백이 있으면 안된다!(오류~)
  </pre>

  <c:if test="${1 == 2}">
    1 == 1은 같은 값
  </c:if>

  <hr>
  <hr>
  <hr>

  <h1>주문 결과</h1>
  <ul>
    <li>선택한 피자 : ${pizzaName} </li>
    <li>사이즈 : 
    <c:if test="${param.size == 'L'}">
      큰 사이즈 L
    </c:if>
    <c:if test="${param.size == 'R'}">
      보통 사이즈 R
    </c:if>
    </li>
    <li>수량 : ${param.amount} </li>
    <li>합계 : ${price} </li>
  </ul>

</body>
</html>