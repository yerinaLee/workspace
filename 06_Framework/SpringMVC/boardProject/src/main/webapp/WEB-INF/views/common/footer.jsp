<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<footer>
    <p>Copyright &copy; KH Information Educational Institute A-Class</p>

    <article>
        <a href="#">프로젝트 소개</a>    
        <span>|</span>
        <a href="#">이용약관</a>    
        <span>|</span>
        <a href="#">개인정보처리방침</a>    
        <span>|</span>
        <a href="#">고객센터</a>    
    </article>
</footer>

<%-- EL, JSTL은 JSP 파일에서만 작성 가능!! --%>
<%-- .css, .js, .html에서 EL/JSTL 사용 불가능! --%>

<%-- message가 있을 경우(request scope에 세팅된 상태) --%>
<c:if test="${not empty message}">
    <script>
        alert("${message}");
        // -> EL 구문 출력 시 ""/'' 없는 문자열로 출력되기 때문에
        //    필요시 JS에서 따옴표를 붙여야 한다!
    </script>
</c:if>