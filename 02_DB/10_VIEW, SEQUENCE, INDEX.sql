/* VIEW
 * 
 * 	- 논리적 가상 테이블
 * 	-> 테이블 모양을 하고는 있지만, 실제로 값을 저장하고 있진 않음.
 * 
 *  - SELECT문의 실행 결과(RESULT SET)를 저장하는 객체
 * 
 * 
 * ** VIEW 사용 목적 **
 *  1) 복잡한 SELECT문을 쉽게 재사용하기 위해.
 *  2) 테이블의 진짜 모습을 감출 수 있어 보안상 유리.
 * 
 * ** VIEW 사용 시 주의 사항 **
 * 	1) 가상의 테이블(실체 X)이기 때문에 ALTER 구문 사용 불가.
 * 	2) VIEW를 이용한 DML(INSERT,UPDATE,DELETE)이 가능한 경우도 있지만
 *     제약이 많이 따르기 때문에 조회(SELECT) 용도로 대부분 사용.
 * 
 * 
 *  ** VIEW 작성법 **
 *  CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름 [컬럼 별칭]
 *  AS 서브쿼리(SELECT문)
 *  [WITH CHECK OPTION]
 *  [WITH READ OLNY];
 * 
 * 
 *  1) OR REPLACE 옵션 : 
 * 		기존에 동일한 이름의 VIEW가 존재하면 이를 변경
 * 		없으면 새로 생성 (덮어씌우기?)
 *  
 *  2) FORCE | NOFORCE 옵션 : //사용빈도 안높아요 
 *    FORCE (강제!!): 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰 생성
 *    NOFORCE(기본값): 서브쿼리에 사용된 테이블이 존재해야만 뷰 생성
 *    
 *  3) 컬럼 별칭 옵션 : 조회되는 VIEW의 컬럼명을 지정
 * 
 *  4) WITH CHECK OPTION 옵션 : 
 * 		옵션을 지정한 컬럼의 값을 수정 불가능하게 함.
 * 
 *  5) WITH READ OLNY 옵션 : ★★★★★★
 * 		뷰에 대해 SELECT만 가능하도록 지정.
 * 		DML 실행 못하게할수있음
 * */


/* VIEW를 생성하기 위해서는 권한이 필요하다 !!!!*/
-- (관리자 계정 접속)
GRANT CREATE VIEW TO 계정명;


-- 모든 사원의 사번, 이름, 부서명, 직급명을 사번 오름 차순으로 조회
SELECT EMP_ID 사번, EMP_NAME 이름 , NVL(DEPT_TITLE, '없음') 부서명, JOB_NAME 직급명
FROM EMPLOYEE
NATURAL JOIN JOB
LEFT JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)
ORDER BY EMP_ID;


-- 위 SELECT 문을 VIEW로 생성해서 저장해두기

CREATE VIEW V_EMP
AS SELECT EMP_ID 사번, EMP_NAME 이름 , NVL(DEPT_TITLE, '없음') 부서명, JOB_NAME 직급명
	FROM EMPLOYEE
	NATURAL JOIN JOB
	LEFT JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)
	ORDER BY EMP_ID;

-- 생성한 뷰 V_EMP를 이용해서 SELECT
SELECT * FROM V_EMP;


-- V_EMP에서 대리 직급 사원을 이름 오름차순으로 조회
SELECT * FROM V_EMP
WHERE 직급명 = '대리'
ORDER BY 2;

-------------------------------------

/* OR REPLACE 옵션 사용하기 */
-- ORA-00955: 기존의 객체가 이름을 사용하고 있습니다.
--> 옵션 추가 후 다시 실행
CREATE OR REPLACE VIEW V_EMP
AS SELECT EMP_ID 사번, EMP_NAME 이름 , NVL(DEPT_TITLE, '없음') 부서명, JOB_NAME 직급명,
	NVL(LOCAL_NAME, '없음') 지역명
	FROM EMPLOYEE
	NATURAL JOIN JOB
	LEFT JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)
	LEFT JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
	ORDER BY EMP_ID;

-- 지역명에 ASIA가 포함되는 직원 사번 내림차순조회
SELECT *
FROM V_EMP
WHERE 지역명 LIKE 'ASIA%'
ORDER BY 사번 DESC;


-------------------------------------
/* WITH READ OLNY 옵션 사용하기 */

-- DEPARTMENT 테이블 복사한 테이블 DEPT_COPY2 생성

CREATE TABLE DEPT_COPY2
AS SELECT * FROM DEPARTMENT;


SELECT * FROM DEPT_COPY2;
-- DEPT_TITLE만 NULL 허용

-- DEPT_COPY2 테이블을 이용해서 VIEW 생성
CREATE VIEW V_DCOPY2
AS SELECT DEPT_ID, LOCATION_ID FROM DEPT_COPY2 ;

SELECT * FROM V_DCOPY2;


-- VIEW를 이용해서 INSERT 
INSERT INTO V_DCOPY2 VALUES('D0', 'L2');

-- INSERT 확인
SELECT * FROM V_DCOPY2;

-- VIEW 생성에 사용한 원본 테이블(DEPT_COPY2) 확인
SELECT * FROM DEPT_COPY2 dc ;
-- D0/NULL/L2
--> VIEW에 삽입을 시도했는데 원본 테이블에 삽입됨
--> VIEW는 개별적인 저장 공간이 있는 테이블이 아니라
-- 원본 테이블의 필요한 컬럼, 행을 모아서 보여주는 가상의 테이블
--> NULL 삽입 == 무결성 약화(위배)시키는 원인


ROLLBACK;

-- WITH READ ONLY 옵션을 추가 후 다시 INSERT

CREATE OR REPLACE VIEW V_DCOPY2
AS SELECT DEPT_ID, LOCATION_ID FROM DEPT_COPY2
WITH READ ONLY;

INSERT INTO V_DCOPY2 VALUES('D0', 'L2');
-- ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.



----------------------------------------------------------------

/* SEQUENCE(순서, 연속)
 * - 순차적으로 일정한 간격의 숫자(번호)를 발생시키는 객체
 *   (번호 생성기)
 * 
 * *** SEQUENCE 왜 사용할까?? ***
 * PRIMARY KEY(기본키) : 테이블 내 각 행을 구별하는 식별자 역할
 * 						 NOT NULL + UNIQUE의 의미를 가짐
 * 
 * PK가 지정된 컬럼에 삽입될 값을 생성할 때 SEQUENCE를 이용하면 좋다!
 * 
 *   [작성법]
  CREATE SEQUENCE 시퀀스이름
  [STRAT WITH 숫자] -- 처음 발생시킬 시작값 지정, 생략하면 자동 1이 기본
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승 -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트
	-- 시퀀스의 캐시 메모리는 할당된 크기만큼 미리 다음 값들을 생성해 저장해둠
	-- --> 시퀀스 호출 시 미리 저장되어진 값들을 가져와 반환하므로 
	--     매번 시퀀스를 생성해서 반환하는 것보다 DB속도가 향상됨.
 * 
 * 
 * ** 사용법 **
 * 
 * 1) 시퀀스명.NEXTVAL : 다음 시퀀스 번호를 얻어옴.
 * 						 (INCREMENT BY 만큼 증가된 수)
 * 						 단, 생성 후 처음 호출된 시퀀스인 경우
 * 						 START WITH에 작성된 값이 반환됨.
 * 
 * 2) 시퀀스명.CURRVAL : 현재 시퀀스 번호를 얻어옴.
 * 						 단, 시퀀스가 생성 되자마자 호출할 경우 오류 발생.
 * 						== 마지막으로 호출한 NEXTVAL 값을 반환
 * */


-- TEST용 테이블 생성
CREATE TABLE TB_TEST(
	TEST_NO NUMBER PRIMARY KEY,
	TEST_NAME VARCHAR2(30) NOT NULL
);


-- 시퀀스 생성
CREATE SEQUENCE SEQ_TEST_NO
START WITH 100  -- 시작 번호 100
INCREMENT BY 5 	-- NEXTVAL마다 5씩 증가
MAXVALUE 150 	-- 증가 가능한 최대값 150
NOMINVALUE 	    -- 최소값 없음
NOCYCLE		    -- 최대값까지 증가 후 반복 X
--CACHE 100		-- 미리 발생시킬 숫자를 만들어 둠 (기본 20바이트)
NOCACHE 		-- 미리 발생시킬 숫자를 만들지 않음
;


-- 현재 시퀀스 값 확인
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; --100


SELECT SEQ_TEST_NO.CURRVAL FROM DUAL; -- 100
-- ORA-08002: 시퀀스 SEQ_TEST_NO.CURRVAL은 이 세션에서는 정의 되어 있지 않습니다
-- 먼저 NEXTVAL 수행 후 CURRVAL 수행!

-- 다시 NEXTVAL 호출
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 105
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 110
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 115
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 120

-- TB_TEST에 INSERT시 시퀀스 사용하기
INSERT INTO TB_TEST VALUES(SEQ_TEST_NO.NEXTVAL, '홍길동');
INSERT INTO TB_TEST VALUES(SEQ_TEST_NO.NEXTVAL, '박철수');
INSERT INTO TB_TEST VALUES(SEQ_TEST_NO.NEXTVAL, '김미영');

SELECT * FROM TB_TEST;

-- TB_TEST 테이블 UPDATE

-- TB_TEST 테이블에서 TEST_NO가 가장 작은 컬럼값을
-- 다음 시퀀스 번호로 수정
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL
WHERE TEST_NO = (SELECT MIN(TEST_NO) FROM TB_TEST);
--> 125 -> 140

-- 테이블링 서비스같은거 할 때 자신의 차례를 다시 맨뒤로 옮길때 사용

-- 위 UPDATE 구문 수행
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL
WHERE TEST_NO = (SELECT MIN(TEST_NO) FROM TB_TEST);
-- 130-> 145

UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL
WHERE TEST_NO = (SELECT MIN(TEST_NO) FROM TB_TEST);
-- 135-> 150
-- 140-> 155
-- ORA-08004: 시퀀스 SEQ_TEST_NO.NEXTVAL exceeds MAXVALUE은 사례로 될 수 없습니다
--> MAXVALUE 초과




--------------------------------

-- SEQUENCE 변경(ALTER)

/* 기본적으로 CREATE 작성법과 같으나 START WITH는 제외
 * 
 [작성법]
  ALTER SEQUENCE 시퀀스이름
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승 -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트
*/	

-- SEQ_TEST_NO의 최대값을 200으로 수정
ALTER SEQUENCE SEQ_TEST_NO
MAXVALUE 200;


SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL;





-----------------------------------------------------

-- VIEW, SEQUENCE 삭제

DROP VIEW V_DCOPY2;
DROP SEQUENCE SEQ_TEST_NO;
-- 시퀀스 START WITH를 다시 지정하고 싶으면
-- 지우고 다시 생성해야함

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY  > 3000000;


------------------------------------------------------------------------

/* INDEX(색인)
 * - SQL 구문 중 SELECT 처리 속도를 향상 시키기 위해 
 *   컬럼에 대하여 생성하는 객체
 * 
 * - 인덱스 내부 구조는 B* 트리 형식으로 되어있음.
 * 
 * 
 * ** INDEX의 장점 **
 * - 이진 트리 형식으로 구성되어 자동 정렬 및 검색 속도 증가.
 * 
 * - 조회 시 테이블의 전체 내용을 확인하며 조회하는 것이 아닌
 *   인덱스가 지정된 컬럼만을 이용해서 조회하기 때문에
 *   시스템의 부하가 낮아짐.
 * 
 * ** 인덱스의 단점 **
 * - 데이터 변경(INSERT,UPDATE,DELETE) 작업 시 
 * 	 이진 트리 구조에 변형이 일어남
 *    -> DML 작업이 빈번한 경우 시스템 부하가 늘어 성능이 저하됨.
 * 
 * - 인덱스도 하나의 객체이다 보니 별도 저장공간이 필요(메모리 소비)
 * 
 * - 인덱스 생성 시간이 필요함.
 * 
 * 
 * 
 *  [작성법]
 *  CREATE [UNIQUE] INDEX 인덱스명
 *  ON 테이블명 (컬럼명[, 컬럼명 | 함수명]);
 * 
 *  DROP INDEX 인덱스명;
 * 
 * -- 인덱스를 임의로 만드는 경우는 거의 없음
 *  ** 인덱스가 자동 생성되는 경우 **
 *  -> PK 또는 UNIQUE 제약조건이 설정된 컬럼에 대해 
 *    UNIQUE INDEX가 자동 생성된다. 
 * */


-- 인덱스를 사용하는 방법(인덱스를 이용해서 빨리 검색하는 방법)
--> 인덱스가 설정된 컬럼을 WHERE 조건절에 명시하면됨

SELECT * FROM EMPLOYEE
WHERE EMP_NAME != '0'; -- 3ms 걸림

-- EMP_ID (PK) -> 자동으로 인덱스 생성됨
SELECT * FROM EMPLOYEE
WHERE EMP_ID != '0'; -- 3ms 걸림


-- [a230724_test 계정 접속]
SELECT COUNT(*) FROM TB_INDEX_TEST;

-- 인덱스 사용 X
SELECT * FROM TB_INDEX_TEST
WHERE TEST_ID = 'TEST500000'; -- 20ms

-- 인덱스 사용 O
SELECT * FROM TB_INDEX_TEST
WHERE TEST_NO = 500000; -- 1ms

