<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
    <section>
        <!-- 클릭 시 메인 페이지로 이동하는 로고 -->
        <a href="/">
            <img src="/resources/images/logo.jpg" alt="로고" id="homeLogo">
        </a>
    </section>


    <section>
        <!-- 검색어 입력할 수 있는 요소 배치 -->
        <article class="search-area">

            <form action="#" method="GET">

                <fieldset> <!-- form태그 내 영역 구분 -->

                    <!--  autocomplete="off" : 브라우저 제공 자동완성 off -->
                    <input type="search" name="query" id="query"
                    placeholder="검색어를 입력해주세요."
                    autocomplete="off" value="">

                    <%-- 제목 검색 --%>
                    <input type="hidden" name="key" value="t">

                    <!-- 검색 버튼 -->
                    <button id="searchBtn" class="fa-solid fa-magnifying-glass"></button>

                </fieldset>
            </form>

            <ul id="searchResult" class="close"></ul>
        </article>

    </section>


    <section></section>


    <!-- 우측 상단 드롭다운 메뉴 추가 예정-->
    <div class="header-top-menu">

    </div>


</header>

<nav>
    <ul>
        <li><a href="#">공지사항</a></li>
        <li><a href="#">자유 게시판</a></li>
        <li><a href="#">질문 게시판</a></li>
        <li><a href="#">FAQ</a></li>
        <li><a href="#">1:1문의</a></li> 
    </ul>
</nav>