<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Page</title>

    <%-- common.jsp  include --%>
    <jsp:include page="/WEB-INF/views/common/common.jsp" />

    <link rel="stylesheet" href="/resources/css/myPage/myPage-style.css">
</head>
<body>
    <main>
        <%-- header.jsp  include --%>
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <section class="myPage-content">

            <%-- sideMenu.jsp  include --%>
            <jsp:include page="/WEB-INF/views/myPage/sideMenu.jsp" />

            <section class="myPage-main">

                <h1 class="myPage-title">내 정보</h1>
                <span class="myPage-subject">원하는 회원 정보를 수정할 수 있습니다.</span>
            
                <%-- 상대 경로  : 현재 경로(주소)를 기준으로 대상 경로를 작성--%>
                <%-- 
                    현재 페이지 : http://localhost/myPage/info  (GET)
                    대상 페이지 : http://localhost/myPage/info  (POST)
                    -> 같은 상위 주소(myPage) 하위 같은 레벨(/ 개수) 이므로 대상 페이지 요청 주소 마지막 부분만 작성 
                 --%>
                <form action="info" method="POST" name="myPageFrm" id="updateInfo">

                    <%-- 로그인된 회원 정보는 sessionScope.loginMember에 존재하고 있음 --%>
                    <div class="myPage-row">
                        <label>닉네임</label>
                        <input type="text" name="memberNickname" maxlength="10" 
                            value="${loginMember.memberNickname}" id="memberNickname">             
                    </div>

                    <div class="myPage-row">
                        <label>전화번호</label>
                        <input type="text" name="memberTel"  maxlength="11" 
                            value="${loginMember.memberTel}" id="memberTel">
                    </div>

                    <div class="myPage-row info-title">
                        <span>주소</span>
                    </div>


                    <%-- 
                    ${fn:split(loginMember.memberAddress, '^^^')[0] }
                    ${fn:split(loginMember.memberAddress, '^^^')[1] }
                    ${fn:split(loginMember.memberAddress, '^^^')[2] } 
                    --%>

                    <%-- 
                        ${fn:split(문자열, 구분자)} 
                        문자열을 구분자로 나누어 배열 형태로 반환
                    --%>

                    <%-- c:set == 변수 생성(속성 추가) --%>
                    <c:set var="addr" value="${fn:split(loginMember.memberAddress, '^^^')}"/>

                    <div class="myPage-row info-address">
                        <input type="text" name="memberAddress" placeholder="우편번호" value="${addr[0]}" id="postcode">
                        <button type="button" onclick="sample6_execDaumPostcode()">검색</button>
                    </div>

                    <div class="myPage-row info-address">
                        <input type="text" name="memberAddress"  placeholder="도로명/지번 주소"  value="${addr[1]}" id="address">                
                    </div>

                    <div class="myPage-row info-address">
                        <input type="text" name="memberAddress"  placeholder="상세 주소"  value="${addr[2]}" id="detailAddress">                
                    </div>

                    <button class="myPage-submit">수정하기</button>
                </form>

            </section>

        </section>

    </main>

    <%-- footer.jsp  include --%>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <!-- 다음 주소 API -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="/resources/js/myPage/myPage.js"></script>
</body>
</html>