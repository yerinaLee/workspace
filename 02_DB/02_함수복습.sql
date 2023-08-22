-- EMPLOYEE테이블에서
-- 사원명, 이메일, 이메일 길이 조회
-- 단, 이메일 길이가 12 이하인 행만 조회
-- 이메일 길이 오름차순 조회
SELECT EMP_NAME , EMAIL , LENGTH(EMAIL) "길이"
FROM EMPLOYEE
WHERE LENGTH(EMAIL) <= 12
ORDER BY EMAIL ;


-- 문자열에서 맨 앞에있는 'B'의 위치를 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA', 'B', 5, 2)
FROM DUAL;

-- SUBSTR(문자열 | 컬럼명, 시작위치(숫자로)[, 길이])
-- 문자열을 시작 위치부터 지정된 길이 만큼 잘라내서 반환
-- 길이 미작성 시 시작 위치 부터 끝까지 잘라내서 반환
SELECT SUBSTR('AABAACAABBAA', 3, 1)
FROM DUAL;


-- EMPLOYEE 테이블에서 
-- 사원명, 이메일 아이디 (@ 앞에까지 문자열)을
-- 이메일 아이디 오름차순으로 조회
SELECT EMP_NAME , SUBSTR(EMAIL , 1, INSTR(EMAIL , '@') -1) "아이디"
FROM EMPLOYEE
ORDER BY EMAIL ;


SELECT '###나나나###나나나####',
	TRIM(LEADING '#' FROM '###나나나###나나나####'),
	TRIM(TRAILING '#' FROM '###나나나###나나나####'),
	TRIM(BOTH '#' FROM '###나나나###나나나####')
FROM DUAL;



SELECT REPLACE (NATIONAL_NAME, '국', '국') 
FROM NATIONAL;


SELECT MOD (105, 100)
FROM DUAL;

SELECT 1.1, CEIL(1.1), FLOOR(1.1)
FROM DUAL;

SELECT 123.456,
	ROUND (123.456),
	ROUND (123.456, 1), -- 123.5
	ROUND (123.456, 2), --123.46
	ROUND (123.456, -2) -- 100
FROM DUAL;



SELECT -123.5,
	TRUNC(-123.5), -- -123
	FLOOR(-123.5), -- -124
	TRUNC(2.5), FLOOR(2.5) --2
FROM DUAL; 


SELECT SYSDATE , SYSTIMESTAMP 
FROM DUAL;

SELECT MONTHS_BETWEEN(SYSDATE, '19921222')
FROM DUAL;

-- EMPLOYEE 테이블에서
-- 모든 사원의 사번, 이름, 입사일, N년차
SELECT EMP_ID , EMP_NAME , HIRE_DATE , CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12) "N년차"
FROM EMPLOYEE;


SELECT LAST_DAY(ADD) 
FROM DUAL;

-- EMPLOYEE 테이블에서
-- 사번, 이름, 전화번호 조회
-- 전화 번호가 없으면 '없음'
-- 전화 번호가 있으면 '010********'
SELECT EMP_ID, EMP_NAME ,
	NVL2(PHONE, (SUBSTR(PHONE, 1, 3) || '********'),'없음')
FROM EMPLOYEE;


SELECT EMP_ID , EMP_NAME ,
	NVL2(PHONE,
	RPAD(SUBSTR(PHONE, 1, 3), LENGTH(PHONE), '*') 
	, '없음')
FROM EMPLOYEE;







































































































