<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

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
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
        <section class="myPage-content">

            <%-- sideMenu.jsp  include --%>
			<jsp:include page="/WEB-INF/views/myPage/sideMenu.jsp"/>

            <section class="myPage-main">

                <h1 class="myPage-title">프로필</h1>
                <span class="myPage-subject">프로필 이미지를 변경할 수 있습니다.</span>

                <form action="profile" method="POST" name="myPageFrm" id="profileFrm" enctype="multipart/form-data" >     
                    <div class="profile-image-area">

                        <img src="/resources/images/user.png" id="profileImage">

                    </div>
                    <span id="deleteImage">x</span>

                    <div class="profile-btn-area">
                        <label for="imageInput">이미지 선택</label>
                        <input type="file" name="profileImage" id="imageInput" accept="image/*">
                        <button>변경하기</button>
                    </div>
                    
                    <div class="myPage-row">
                        <label>이메일</label>
                        <%-- session scope에 loginMember에서 필요한 회원 데이터 얻어와 출력 --%>
                        <span>${sessionScope.loginMember.memberEmail}</span>
                    </div>
                    
                    <div class="myPage-row">
                        <label>가입일</label>
                        <span>${sessionScope.loginMember.enrollDate}</span>
                    </div>
                    
                </form>
                

            </section>

        </section>

    </main>

    <%-- footer.jsp  include --%>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="/resources/js/myPage/myPage.js"></script>
</body>
</html>