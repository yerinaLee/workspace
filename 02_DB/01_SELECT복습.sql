-- EMPLOYEE 테이블에서 
-- 성이 '전' 씨인 사원의 사번, 이름 조회
SELECT EMP_NAME 
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

-- EMPLOYEE 테이블에서 
-- 이름이 '수'로 끝나는 사원의 사번, 이름 조회
SELECT EMP_ID , EMP_NAME 
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%수';


-- EMPLOYEE 테이블에서 
-- 전화번호가 '010'으로 시작하는 사원의 이름, 전화전호
SELECT EMP_NAME , PHONE 
FROM EMPLOYEE
WHERE PHONE LIKE '010%';


-- EMPLOYEE 테이블에서
-- EMAIL의 아이디 중 '_' 앞쪽 글자의 수가 3글자인 사원의
-- 사번, 이름, EMAIL 조회
SELECT EMP_ID , EMP_NAME , EMAIL 
FROM EMPLOYEE
WHERE EMAIL LIKE '___#_%' ESCAPE '#';


-- 날짜(DATE) 비교하기
-- EMPLOYEE 테이블에서 입사일이
-- '1990/01/01' ~ '2000/12/31'  사이인 사원의
-- 사번, 이름, 입사일 조회
SELECT EMP_ID , EMP_NAME , HIRE_DATE 
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '19900101' AND '20001231';


/*2번 컬럼 내림차순으로 조회*/
-- EMPLOYEE 테이블에서 급여가 300만 이상, 600만 미만인 사원의
-- 사번, 이름, 급여를 이름 내림차순으로 조회
SELECT EMP_ID , EMP_NAME , SALARY 
FROM EMPLOYEE
WHERE SALARY BETWEEN 3000000 AND 5999999
ORDER BY EMP_NAME  DESC;


/* 정렬시 컬럼값이 NULL인 행의 정렬 방법 지정*/
-- 모든 사원의 이름, 전화번호 조회
SELECT EMP_NAME , PHONE 
FROM EMPLOYEE
ORDER BY PHONE DESC NULLS LAST;


-- 이름, 부서코드, 급여를
-- 부서코드 오름차순, 급여 내림차순으로 조회

SELECT EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE
ORDER BY DEPT_CODE , SALARY DESC;









































































































