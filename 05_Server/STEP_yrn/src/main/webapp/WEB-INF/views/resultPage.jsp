<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>결과 페이지</title>
</head>
<body>
  <h1>${param.name} 님의 구매 목록</h1>
  <h3>
  검은펜 ${param.blackPen}개 : ${blackPenTotal}
  <br>
  빨간 펜 ${param.redPen}개 : ${redPenTotal}
  <br>
  파란 펜 ${param.bluePen}개 : ${bluePenTotal}
  <br>
  화이트 ${param.white}개 : ${whiteTotal}

  <hr>

  총합 ${total}원을 결제하셨습니다.
  </h3>
</body>

</html>