<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>EL</title>
</head>
<body>
  <h1>EL(Expression Language)</h1>
  <pre>
    - JSP에서 표현식을 간단하고 효율적으로 작성할 수 있도록
      고안된 언어 (JSP 기본 내장)

    - Java 값을 HTML 형식으로 표시(출력) 언어

    - 기본 작성 형식 : \${ key }
  </pre>

  <hr>

  <h3>EL 특징 1 : get이라는 단어를 사용하지 않음 </h3>
  <pre>
    - 출력용도의 언어이기 때문에 set이라는 개념이 존재하지 않음
      -> 반대되는 get만 남는데 생략하여 사용
  </pre>

  <ul>
    <li>JSP 표현식 : <%= request.getParameter("test") %></li> <%-- 파라미터 중 key 값이 test인걸 얻어와라 --%>
    <li>EL : ${param.test} </li>
  </ul>

  <hr>


  <h3>EL 특징 2 : null, NullPointerException은 빈칸으로 처리</h3>

  빈칸 맞음?? ${param.test==""}


  <hr>

  <h2>EL 테스트 (POST 방식)</h2>
  <form action="/el" method="POST">
    날짜 : <input type="date" name="inputDate">

    <button>제출</button>
  </form>

</body>
</html>