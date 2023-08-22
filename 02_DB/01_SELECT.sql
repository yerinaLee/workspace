/* SELECT (조회) 
 * 
 * - 지정된 테이블에서 원하는 데이터를 조회하는 SQL
 * 
 * - 데이터를 조회하면 작성된 구문에 맞는 행, 열이 조회됨
 * 	  -> 조회된 결과 행의 집합 == RESULT SET(결과 집합)
 * 
 * - RESULT SET은 0행 이상이 포함될 수 있다
 * 	  -> 조회 조건에 맞는 행이 없을 수 있기 때문에 0행도 포함됨. 
 * 
 * */

-- SQL 한 줄 실행 : ctrl + Enter
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

SELECT EMP_NAME
FROM EMPLOYEE;

-- EMPLOYEE 테이블 모든 행, 모든 컬럼 조회
-- * : 모든, ALL, 전부
SELECT * FROM EMPLOYEEL;

-- EMPLOYEE 테이블에서 이름, 전화번호만 조회
SELECT EMP_NAME, PHONE FROM EMPLOYEE;

-- DEPARTMENT 테이블의 모든 행, 열 조회
SELECT * FROM DEPARTMENT;

-- DEPARTMENT 테이블에서 부서명만 조회
SELECT DEPT_TITLE FROM DEPARTMENT;


/* [SELECT 작성법]
 * ( | : 또는)
 * 
 * SELECT 컬럼명 | *
 * FROM 테이블명 
 * WHERE 조건식; -- 조건에 맞는 행만 조회
 * 
 */

-----------------------------------------------------

-- <컬럼 값 산술 연산>

-- 컬럼 값 : 행과 열이 교차하되는 테이블의 한 칸에 작성된 값

-- SELECT문 작성 시
-- 컬럼명에 산술 연산을 작성하면
-- 조회 결과(RESULT SET)에 연산 결과가 반영된다

-- EMPLOYEE 테이블에서
-- 모든 사원의 이름, 급여, 급여 + 100만 조회
SELECT EMP_NAME, SALARY, SALARY + 1000000
FROM EMPLOYEE;
--> 조회 시 꼭 테이블에 있는 컬럼명만 그대로 작성할 필요 없다

-- EMPLOYEE 테이블에서
-- 모든 사원의 사번, 이름, 연봉 조회
-- (연봉 == 급여 * 12)

SELECT EMP_ID, EMP_NAME, SALARY*12
FROM EMPLOYEE;

-----------------------------------------------------

-- ***** 오늘 날짜 조회 ***** (중요!!)

-- DB는 시간을 나타내고, 연산하기 위한 다양한 기능을 제공

-- SYSDATE : 시스템 상의 현재 시간

-- DUAL(DUmmy tAbLe)  테이블 :
-- 	가짜 테이블(단순 데이터 조회 시 사용하는 임시테이블)
SELECT SYSDATE FROM DUAL;


-- * 날짜 연산하기 (+/-)*
--> 일 단위로 +,- 연산 가능
SELECT SYSDATE -1, SYSDATE, SYSDATE +1
FROM DUAL;

-- 현재 시간, 한 시간 후, 1분 후, 30초 후 조회
SELECT SYSDATE,
	   SYSDATE + (1/24),
	   SYSDATE + (1/24/60),
	   SYSDATE + (1/24/60/60 * 30)
FROM DUAL;


-- EMPLOYEE테이블
-- 이름, 입사일, 오늘까지 근무한 일 수(년단위) 조회

-- FLOOR(실수) : 내림 처리
SELECT EMP_NAME , HIRE_DATE , FLOOR( (SYSDATE - HIRE_DATE) / 365 )

FROM EMPLOYEE;

-----------------------------------------------------

-- <컬럼 별칭 지정>

-- 별칭 지정 방법
-- 1) 컬럼명 AS 별칭 : 문자O, 띄어쓰기 X, 특수문자 X
-- 2) 컬럼명 AS "별칭" : 문자O, 띄어쓰기 O, 특수문자 O

-- 3) 컬럼명 별칭 : 문자O, 띄어쓰기 X, 특수문자 X
-- 4) 컬럼명 "별칭" : 문자O, 띄어쓰기 O, 특수문자 O

-- ""의 의미
-- 1) 대/소문자 구분
-- 2) 특수문자, 띄어쓰기도 인식! (문자열 그대로 인식)


-- EMPLOYEE 테이블에서
-- 사번, 사원이름, 급여, 사원연봉 조회
-- (컬럼명은 별칭으로 위에 작성된 이름과 동일하게 조회)


SELECT EMP_ID AS 사번,  -- 공식문서나 시험에서 사용됨
		EMP_NAME AS "사원 이름",
		SALARY 급여 ,
		SALARY * 12 "사원 연봉"  -- 보통 많이 사용하는 방법
FROM EMPLOYEE;

-----------------------------------------------------

-- 리터럴 : 표현되는 값 자체
--> 자료형 별로 표기법이 존재

-- 1) 숫자 표기법 : 1, 3.14, -10 ('', "" 없이 숫자 그대로 작성)
-- 2) 문자열, 날짜 표기법 : '가나다', '2023-08-21'
		--> 양쪽에 '' (홑따옴표) 작성!

-- 연결 연산자 || : 문자열 이어 쓰기

SELECT EMP_NAME, SALARY + 1000000 || '원'
FROM EMPLOYEE;


-----------------------------------------------------

-- DISTINCT (별개의, 따로따로)
--> 조회 시 지정된 컬럼에 중복되는 값을 한 번만 표시할 때 사용
--> 중복 제거

SELECT DISTINCT DEPT_CODE FROM EMPLOYEE;


-----------------------------------------------------

-- CTRL + SHIFT + 방향키 위아래 : 라인 이동

/*******************/
/***** WHERE절 *****/ --중요!!!
/*******************/

-- 테이블에서 조건을 충족하는 행을 조회할 때 사용
-- WHERE절에는 조건식(true/false)만 작성 (조건식 안에는 비교연산자 사용)

-- 비교 연산자 : >, <, >=, <=, =(같다), !=, <>(같지 않다)
-- 논리 연산자 : AND, OR, NOT // 글자가 연산자가 된다

-- EMPLOYEE 테이블에서 급여가 300만원 초과인 사원의
-- 사번, 이름, 급여, 부서코드 조회

/*3*/ SELECT EMP_ID , EMP_NAME , SALARY , DEPT_CODE 
/*1*/ FROM EMPLOYEE
/*2*/ WHERE SALARY > 3000000; -- 기준 외의 데이터는 삭제함

-- 1) 테이블 선정
-- 2) 테이블 한 행씩 접근하면서 조건식이 TRUE이면 결과에 포함
--	  FALSE면 미포함
-- 3) 추려진 결과 행 중 알맞은 컬럼만 선택 -> 최종 RESULT SET 생성


-- EMPLOYEE 테이블에서 
-- 연봉이 5천만원 이하인 사원의
-- 사번, 이름, 연봉 조회
/*3*/ SELECT EMP_ID , EMP_NAME , SALARY * 12 연봉
/*1*/ FROM EMPLOYEE
/*2*/ WHERE (SALARY * 12) <= 50000000;



-- EMPLOYEE 테이블에서 
-- 부서코드가 'D9'이 아닌 사원의
-- 사번, 이름, 부서코드, 전화번호 조회
SELECT EMP_ID "사번" , EMP_NAME 이름, DEPT_CODE "부서코드" , PHONE AS 전화번호
FROM EMPLOYEE
WHERE DEPT_CODE != 'D9';


-- EMPLOYEE 테이블에서 
-- 급여가 300만원 이상이면서
-- 부서코드가 D6인 사원의 이름, 부서코드, 급여 조회
SELECT EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE
WHERE SALARY >= 3000000 AND DEPT_CODE = 'D6';


-- EMPLOYEE 테이블에서 
-- 급여가 300만원 이상, 500만 이하인 사원의
-- 사번, 이름, 입사일, 급여 조회

SELECT EMP_ID "사번" , EMP_NAME "이름" , HIRE_DATE "입사일" , SALARY "급여"
FROM EMPLOYEE
WHERE SALARY >= 3000000 AND SALARY <= 5000000;


-- 컬럼명 BETWEEN a AND b = a 이상 b 이하이면 TRUE
SELECT EMP_ID "사번" , EMP_NAME "이름" , HIRE_DATE "입사일" , SALARY "급여"
FROM EMPLOYEE
WHERE SALARY BETWEEN 3000000 AND 5000000;


-- EMPLOYEE 테이블에서 
-- 급여가 300만원 미만, 500만 초과인 사원의
-- 사번, 이름, 입사일, 급여 조회
SELECT EMP_ID "사번" , EMP_NAME "이름" , HIRE_DATE "입사일" , SALARY "급여"
FROM EMPLOYEE
WHERE SALARY < 3000000 OR SALARY > 5000000;


-- 컬럼명 NOT BETWEEN a AND b = a 이상 b 이하이면 FALSE 
--> a 미만, b 초과이면 TRUE
SELECT EMP_ID "사번" , EMP_NAME "이름" , HIRE_DATE "입사일" , SALARY "급여"
FROM EMPLOYEE
WHERE SALARY NOT BETWEEN 3000000 AND 5000000 ;


-- EMPLOYEE 테이블에서 
-- 부서코드가 'D5', 'D6', 'D9'인 사원의
-- 이름, 부서코드, 급여 조회
SELECT EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR DEPT_CODE = 'D6' OR DEPT_CODE = 'D9';

-- 컬럼명 NOT IN (값 1, 값2, 값3, ...)
--  : 컬럼의 값이 () 내부의 값과 하나라도 일치하면 FALSE
SELECT EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE
WHERE DEPT_CODE NOT IN ('D5', 'D6', 'D9');


--> 11행이 조회되어야 하는데 9행만 조회됨!
-- 왜? DEPT_CODE가 NULL인 행이 2행이 있어서 그렇숨 ㅠ

-- !!!! NULL은 비교, 논리 연산시 연산의 대상이 되지 않음!!!!! 중요!!!!!

-----------------------------------------------------

-- NULL 처리 연산

-- IS NULL		: 컬럼 값이 NULL이면 TRUE
-- IS NOT NULL	: 컬럼 값이 NULL이 아니면 TRUE

-- EMPLOYEE 테이블에서 DEPT_CODE가 NULL인 사원의 이름, 부서코드 조회
SELECT EMP_NAME , DEPT_CODE 
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL;

-- EMPLOYEE 테이블에서 BONUS 컬럼의 값이 NULL이 아닌 사원의
-- 이름, 보너스 조회하기
SELECT EMP_NAME , BONUS 
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;


-----------------------------------------------------

/* LIKE
 * 
 * - 비교하려는 값이 특정한 패턴을 만족 시키면(TRUE) 조회하는 연산자
 * 
 * [작성법]
 * WHERE 컬럼명 LIKE '패턴'
 * 
 * - LIKE 패턴( == 와일드 카드  ) 
 * 
 * '%' (포함)
 * - '%A' : 문자열이 앞은 어떤 문자든 포함되고 마지막은 A
 *          -> A로 끝나는 문자열
 * - 'A%' : A로 시작하는 문자열
 * - '%A%' : A가 포함된 문자열
 *  
 * 
 * '_' (글자 수, 한 칸!)
 * - 'A_' : A 뒤에 아무거나 한 글자만 있는 문자열
 *          (AB ,A1, AQ, A가)
 * 
 * - '___A' : A 앞에 아무거나 3글자만 있는 문자열
 */


-- EMPLOYEE 테이블에서 
-- 성이 '전' 씨인 사원의 사번, 이름 조회
SELECT EMP_ID , EMP_NAME 
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';


-- EMPLOYEE 테이블에서 
-- 이름이 '수'로 끝나는 사원의 사번, 이름 조회
SELECT EMP_ID , EMP_NAME 
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%수';


-- EMPLOYEE 테이블에서 
-- 이름이 '하'가 포함된 사원의 사번, 이름 조회
SELECT EMP_ID , EMP_NAME 
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';


-- EMPLOYEE 테이블에서 
-- 이름이 '전' 시작 '돈'으로 끝나는 사원의 사번, 이름 조회 // 잘 쓰진 않아용
SELECT EMP_ID , EMP_NAME 
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%돈';


---------------------------

-- EMPLOYEE 테이블에서 
-- 전화번호가 '010'으로 시작하는 사원의 이름, 전화전호

--1) '%' 버전
SELECT EMP_NAME , PHONE 
FROM EMPLOYEE
WHERE PHONE LIKE '010%';\


--2) '_' 버전
SELECT EMP_NAME , PHONE 
FROM EMPLOYEE
WHERE PHONE LIKE '010________';
-- 좀더 깐깐하게 조건검색을 하는 와일드카드지만, %보다 덜 쓰이긴함


-- EMPLOYEE 테이블에서
-- EMAIL의 아이디 (@의 앞글자)의 글자수가 5글자인 사원의
-- 이름, EMAIL 조회
SELECT EMP_NAME , EMAIL 
FROM EMPLOYEE
WHERE EMAIL LIKE '_____@%';


-- EMPLOYEE 테이블에서
-- EMAIL의 아이디 중 '_' 앞쪽 글자의 수가 3글자인 사원의
-- 사번, 이름, EMAIL 조회

SELECT EMP_ID , EMP_NAME , EMAIL 
FROM EMPLOYEE
WHERE EMAIL LIKE '____%'; -- 이메일 4글자 이상 조회

--> 문제점 : 와일드카드 표기법 '_'와
--		    기준으로 삼을 문자열 '_'가 둘 다 와일드카드로 해석되어
--			조건식의 의미가 의도와 다르게 작성됨.

--> 해결방법 : LIKE의 ESCAPE 옵션을 사용
--> ESCAPE 옵션 : 와일드 카드의 의미를 벗어나 단순 문자열로 인식
-->  	적용 범위 : 특수문자 뒤 한 글자
SELECT EMP_ID , EMP_NAME , EMAIL 
FROM EMPLOYEE
WHERE EMAIL LIKE '___#_%' ESCAPE '#';


---------------------------------------------------------------

-- 날짜(DATE) 비교하기
-- EMPLOYEE 테이블에서 입사일이
-- '1990/01/01' ~ '2000/12/31'  사이인 사원의
-- 사번, 이름, 입사일 조회
SELECT  EMP_ID, EMP_NAME , HIRE_DATE  
FROM EMPLOYEE
WHERE HIRE_DATE >= TO_DATE('1990/01/01')
AND   HIRE_DATE <= '2000/12/31';


SELECT EMP_ID , EMP_NAME, HIRE_DATE 
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '19900101' AND '20001231';
--WHERE HIRE_DATE BETWEEN '1990-01-01' AND '2000-12-31';


-- '1990/01/01'은 사실상 문자열 형식이지만
-- 날짜 형식의 문자열이기 때문에
-- HIRE_DATE(DATE 타입) 비교시 자동으로 형변환(Parsing)
-- TO_DATE라는 함수가 자동으로 실행되는 것

--CASTING : 값의 범위만 달라지는것
--PARSING : 종류가 아예 달라지는것. 문자가 숫자가 되고...

--> 사용자(개발자)가 직접 SQL에 날짜를 입력할 땐
--	날짜 형식의 문자열을 작성한다! (2023/08/22, 2023-08-22, 20230822)

--> 날짜(DATE) 타입은 직접 비교가 가능하다!


---------------------------------------------------------------

/* ORDER BY 절
 * 
 * - SELECT문의 조회 결과(RESULT SET)를 정렬할 때 사용하는 구문
 * 
 * - *** SELECT구문에서 제일 마지막에 해석된다! ***
 * 
 * [작성법]
 * 3: SELECT 컬럼명 AS 별칭, 컬럼명, 컬럼명, ...
 * 1: FROM 테이블명
 * 2: WHERE 조건식
 * 4: ORDER BY 컬럼명 | 별칭 | 컬럼 순서 [오름/내림 차순] 
 *            [NULLS FIRST | LAST]
 * */


-- EMPLOYEE 테이블에서 급여 오름차순으로 이름, 급여 조회
-- 오름차순 : 갈수록 커진다. 제일 적게받은 사람 첫번째줄
SELECT EMP_NAME , SALARY 
FROM EMPLOYEE
ORDER BY SALARY ASC; --ASC(ascending) : 오름차순

-- EMPLOYEE 테이블에서 급여 내림차순으로 이름, 급여 조회
-- 내림차순 : 갈수록 작아진다. 제일 많이받은 사람 첫번째줄
SELECT EMP_NAME , SALARY 
FROM EMPLOYEE
ORDER BY SALARY DESC; --DESC(descending ) : 내림차순


-- EMPLOYEE 테이블에서 부서 코드가 'D5', 'D6', 'D9'인 사원의
-- 사번, 이름, 부서코드를 부서코드 오름차순으로 조회
SELECT EMP_ID , EMP_NAME , DEPT_CODE 
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5', 'D6', 'D9')
ORDER BY DEPT_CODE /*ASC*/; -- ASC가 기본값(생략 가능. 생략하는 경우가 훨 많음)


/*2번 컬럼 내림차순으로 조회*/
-- EMPLOYEE 테이블에서 급여가 300만 이상, 600만 미만인 사원의
-- 사번, 이름, 급여를 이름 내림차순으로 조회
SELECT EMP_ID , EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000 AND SALARY < 6000000
ORDER BY 2 DESC; -- 2번 컬럼 내림차순으로 조회


/*ORDER BY절에는 계산식, 함수식 작성도 가능!*/
-- EMPLOYEE 테이블에서 
-- 이름, 연봉을 연봉 내림차순으로 조회
SELECT EMP_NAME , SALARY * 12 "연봉"
FROM EMPLOYEE
ORDER BY SALARY * 12 DESC; -- ORDER BY절에는 계산식, 함수식 작성도 가능!


/*ORDER BY절에는 별칭 작성도 가능! (해석 순서 중요!!)*/
-- 연봉이 3500만 이상인 사원의 
-- 사번, 이름, 연봉을 연봉 오름차순으로 조회 (모든 컬럼에 별칭 작성)
/*3*/ SELECT EMP_ID "사번" , EMP_NAME 이름 , SALARY *12 AS 연봉
/*1*/ FROM EMPLOYEE
/*2*/ WHERE SALARY * 12 >= 35000000
/*4*/ ORDER BY 연봉;
-- SELECT 절 해석 후 ORDER BY절이 해석되기때문에
-- SELECT 절에서 해석된 별칭을 다음 순서인 ORDER BY절에서 사용이 가능하다


/* 정렬시 컬럼값이 NULL인 행의 정렬 방법 지정*/
-- 모든 사원의 이름, 전화번호 조회
SELECT EMP_NAME , PHONE 
FROM EMPLOYEE
-- ORDER BY PHONE /*NULLS LAST*/; --오름차순 --> NULL은 마지막에 배치(NULLS LAST 기본값)
-- ORDER BY PHONE NULLS FIRST ;   -- 오름차순 -> NULL이 처음부분에 배치

ORDER BY PHONE DESC NULLS FIRST; --내림차순 -> NULL은 처음에 배치(NULLS FIRST 기본값)
ORDER BY PHONE DESC NULLS LAST;  --내림차순 -> NULL을 마지막에 배치


/* 정렬 중첩 */
-- 큰 분류를 먼저 정렬하고
-- 작은 분류를 큰 분류가 흐트러지지 않는 선에서 정렬(그룹이 지어지는 개념)
-- ORDER BY 큰분류, 작은분류

-- 이름, 부서코드, 급여를
-- 부서코드 오름차순, 급여 내림차순으로 조회
SELECT EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE
ORDER BY DEPT_CODE, SALARY DESC;


-- 이름, 부서코드, 직급코드
-- 부서코드 내림차순, 직급코드 오름차순, 이름 오름차순
SELECT EMP_NAME , DEPT_CODE , JOB_CODE 
FROM EMPLOYEE
ORDER BY DEPT_CODE DESC, JOB_CODE , EMP_NAME ;


/* SELECT절에 작성되지 않은 컬럼으로도 정렬 기준 작성 가능 */
-- 이름, 급여를 사번 내림차순으로 조회
SELECT /*EMP_ID, */ EMP_NAME , SALARY 
FROM EMPLOYEE
ORDER BY EMP_ID DESC;









