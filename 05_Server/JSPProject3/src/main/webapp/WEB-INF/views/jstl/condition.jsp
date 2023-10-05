<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- core태그 : 자주 사용하는 자바 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- fmt(format)태그 : 형식, 형변환 관련 코드 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JSTL 조건문</title>
</head>
<body>
  <h1>1. 단일 조건문 (c:if 태그) </h1>  
  
  <pre>
   - 조건식이 true이면 수행 + 화면에 출력

   - 별도의 else 구문이 없음

   - 속성은 test만 존재

   ** test 속성 값 작성 시 주의 사항 **

   1) 속성 값은 무조건 EL 구문으로 작성해야된다!!
      test="\${key == 123}"

   2) 속성 값은 무조건 true/false가 최종 결과로 나와야한다

   3) 속성 값을 작성하는 "" 제일 앞/뒤에는 띄어쓰기가 있으면 안된다!!
      오류 예시 :
        test = "  ${key == 123}" // 앞에 공백
        test = "${key == 123}  " // 뒤에 공백
  </pre>

  <hr>

  <h3>c:if 테스트용 변수 선언</h3>
  <c:set var="menu" scope="page" value="순대국밥"/>
  <c:set var="price" scope="page" value="19500"/>
  <c:set var="money" scope="page" value="10000"/>

  <ul>
    <li>menu : ${menu}</li>
    <li>price : ${price}</li>
    <li>money : ${money}</li>
  </ul>

  <c:if test="${ price == 9000}" >
    <h5>9000원 입니다</h5>    
  </c:if>

  <c:if test="${ price != 9000}" >
    <h5>9000원이 아닙니다</h5>    
  </c:if>

  <hr>

  <%-- fmt:parseNumber 태그

    - 값을 숫자로 변환한 후 새로운 변수를 생성해서 대입
      (변수 생성은 선택 가능)

    - 속성
      1) value : 숫자로 바꾸려는 값 (필수)

      2) pattern : value의 패턴을 인식하여 변환할 수 있게 함
        ex) value="1,000,000" pattern="0,000,000"
            -> 1000000

      3) var : 변수명
      4) scope : 범위 지정

      5) integerOnly : 
        true : 정수 부분만 변환
        false : 정수가 아닌 부분(소수)도 변환 (기본값)
  --%>


  <%-- 숫자로 변환해서 변수로 저장 --%>
  <fmt:parseNumber var="parseMoney" value="${money}"/>
  <fmt:parseNumber var="parsePrice" value="${price}"/>

  <c:if test="${ parseMoney >= parsePrice }" >
    ${menu}을 먹을 수 있습니다.
  </c:if>

  <c:if test="${ parseMoney < parsePrice }" >
    ${menu}을 먹을 수 없습니다ㅠ
  </c:if>


  <hr>
  <h1>2. 연속된 조건문 (c:choose / c:when / c:otherwise) </h1>
  <%-- if ~ else if ~ else if ~ else --%>

  <pre>
    - c:choose 태그 :  c:when / c:otherwise를 감싸는 태그
                    (이 안에 if ~ else if ~ else 구문을 쓰겠다)

      *** c:choose 태그 작성 주의 사항 ***
      choose 태그 내부에는
      c:when, c:otherwise, JSP 주석, 공백 이외에는
      아무것도 작성되면 안된다!!


    - c:when(언제) 태그 : if, else if를 나타내는 태그
                         속성은 test 밖에 없음 (c:if 참고)


    - c:otherwise(그렇지 않으면) 태그 : else 역할의 태그로 아무런 속성이 없음!!
  </pre>


  <hr>

  <h4>테스트 방법</h4>
  <pre>
    주소창에 값을 직접 입력한 후
    \${param.key} 를 이용해 값 얻어오기

    ex) http://localhost/jstl/condition?val=77

    쿼리스트링(?val=77) 부분을 변경하면서 테스트
  </pre>

  <%-- 파라미터에 val이 존재 한다면! --%>
  <c:if test="${not empty param.val}" >
    <fmt:parseNumber var="parseVal" value="${param.val}"/>
    <c:choose>
       <c:when test="${ parseVal > 100 }">
          ${parseVal}은 100보다 큽니다.
       </c:when>

       <c:when test="${ parseVal > 50 }" >
          ${parseVal}은 50 초과 100 이하 입니다.
       </c:when>
    
       <c:otherwise>
          ${parseVal}은 50 이하 입니다.
       </c:otherwise>
    </c:choose>
  </c:if>
  

</body>
</html>