
-- 한 줄 주석 crtl + /
/* 범위 주석 ctrl + shift + / */

-- SQL 한줄 실행 : ctrl + enter

-- 오라클 쌍따옴표의 의미 : 대문자/소문자를 구분하는 문자열

-- 예전 버전(11g 이전 버전) 오라클 구문 사용하기
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER a230724_yrn IDENTIFIED BY "921222";

GRANT CONNECT, RESOURCE, CREATE VIEW TO a230724_yrn;

ALTER USER a230724_yrn DEFAULT TABLESPACE "A230724"
QUOTA 20M ON "A230724";
