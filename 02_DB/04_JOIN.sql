
/* 
[JOIN 용어 정리]
  오라클       	  	                                SQL : 1999표준(ANSI) 
----------------------------------------------------------------------------------------------------------------
등가 조인		                            내부 조인(INNER JOIN), JOIN USING / ON
                                            + 자연 조인(NATURAL JOIN, 등가 조인 방법 중 하나)
----------------------------------------------------------------------------------------------------------------
포괄 조인 		                        왼쪽 외부 조인(LEFT OUTER), 오른쪽 외부 조인(RIGHT OUTER)
                                            + 전체 외부 조인(FULL OUTER, 오라클 구문으로는 사용 못함)
----------------------------------------------------------------------------------------------------------------
자체 조인, 비등가 조인   	                    	JOIN ON
----------------------------------------------------------------------------------------------------------------
카테시안(카티션) 곱		               			교차 조인(CROSS JOIN)
CARTESIAN PRODUCT

- 미국 국립 표준 협회(American National Standards Institute, ANSI) 미국의 산업 표준을 제정하는 민간단체.
- 국제표준화기구 ISO에 가입되어 있음.
*/
-----------------------------------------------------------------------------------------------------------------------------------------------------

-- JOIN
-- 하나 이상의 테이블에서 데이터를 조회하기 위해 사용.
-- 수행 결과는 하나의 Result Set으로 나옴.

/* 
- 관계형 데이터베이스에서 SQL을 이용해 테이블간 '관계'를 맺는 방법.

- 관계형 데이터베이스는 최소한의 데이터를 테이블에 담고 있어
  원하는 정보를 테이블에서 조회하려면 한 개 이상의 테이블에서 
  데이터를 읽어와야 되는 경우가 많다.
  이 때, 테이블간 관계를 맺기 위한 연결고리 역할이 필요한데,
  두 테이블에서 같은 데이터를 저장하는 컬럼이 연결고리가됨.   
*/

--------------------------------------------------------------------------------------------------------------------------------------------------

-- 기존에 서로 다른 테이블의 데이터를 조회 할 경우 아래와 같이 따로 조회함.

-- 직원번호, 직원명, 부서코드, 부서명을 조회 하고자 할 때
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE;
-- 직원번호, 직원면, 부서코드는 EMPLOYEE테이블에 조회가능

-- 부서명은은 DEPARTMENT테이블에서 조회 가능
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;


SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_ID , DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);


-- 1. 내부 조인(INNER JOIN) ( == 등가 조인(EQUAL JOIN))
--> 연결되는 컬럼의 값이 일치하는 행들만 조인됨.  
-- (== 일치하는 값이 없는 행은 조인에서 제외됨. )

-- 작성 방법 크게 ANSI구문과 오라클 구문 으로 나뉘고 
-- ANSI에서  USING과 ON을 쓰는 방법으로 나뉜다.

-- *ANSI 표준 구문
-- ANSI는 미국 국립 표준 협회를 뜻함, 미국의 산업표준을 제정하는 민간단체로 
-- 국제표준화기구 ISO에 가입되어있다.
-- ANSI에서 제정된 표준을 ANSI라고 하고 
-- 여기서 제정한 표준 중 가장 유명한 것이 ASCII코드이다.

-- *오라클 전용 구문
-- FROM절에 쉼표(,) 로 구분하여 합치게 될 테이블명을 기술하고
-- WHERE절에 합치기에 사용할 컬럼명을 명시한다



-- 1) 연결에 사용할 두 컬럼명이 다른 경우

-- EMPLOYEE 테이블, DEPARTMENT 테이블을 참조하여
-- 사번, 이름, 부서코드, 부서명 조회

-- EMPLOYEE 테이블에 DEPT_CODE컬럼과 DEPARTMENT 테이블에 DEPT_ID 컬럼은 
-- 서로 같은 부서 코드를 나타낸다.
--> 이를 통해 두 테이블이 관계가 있음을 알고 조인을 통해 데이터 추출이 가능.


-- 1) ANSI 방식!!
-- 연결에 사용할 컬럼명이 다른 경우 ON()을 사용
SELECT EMP_ID , EMP_NAME, DEPT_CODE, DEPT_ID , DEPT_TITLE  
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);
-- EMPLOYEE에 DEPT_CODE와 DEPARTMENT의 DEPT_ID 는 의미가 같은 컬럼(값도 같음)이기에
-- 두 컬럼을 이용해서 EMPLOYEE, DEPARTMENT 테이블을 하나로 합침
-- 하동운, 이오리는 DEPT_CODE가 NULL이기에
-- DEPT_ID 중 일치하는 값이 없어서 합친(JOIN) 결과에 포함 X

-- 2) 오라클 방식!! (JOIN이라는 단어를 작성하지 않음)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_ID, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID; 



-- DEPARTMENT 테이블, LOCATION 테이블을 참조하여
-- 부서명, 지역명 조회

-- ANSI 방식
SELECT DEPT_TITLE, LOCAL_NAME
FROM DEPARTMENT
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);

-- 오라클 방식
SELECT DEPT_TITLE, LOCAL_NAME
FROM DEPARTMENT , LOCATION
WHERE LOCATION_ID = LOCAL_CODE;


-- 부서명이 '해외영업2부'인 사원의
-- 사번, 이름, 부서명을 사번 오름차순으로 조회
-- ANSI방식
/* 3 */SELECT EMP_ID, EMP_NAME, DEPT_TITLE
/*1-1*/FROM EMPLOYEE
/*1-2*/JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
/* 2 */WHERE DEPT_TITLE = '해외영업2부'
/* 4 */ORDER BY EMP_ID ;

-- 오라클 방식
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
AND DEPT_TITLE = '해외영업2부' -- 오라클 방식 조인 시 추가 조건은 AND 사용
ORDER BY EMP_ID ;


-- 2) 연결에 사용할 두 컬럼명이 같은 경우
-- EMPLOYEE 테이블, JOB테이블을 참조하여
-- 사번, 이름, 직급코드, 직급명 조회

-- ANSI
-- 연결에 사용할 컬럼명이 같은 경우 USING(컬럼명)을 사용함
SELECT EMP_ID, EMP_NAME, JOB_CODE , JOB_NAME 
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE);


-- 오라클 -> 별칭 사용 (어떤 테이블의 컬럼명인지 알아야하기에!!)
-- 테이블 별로 별칭을 등록할 수 있음.
SELECT EMP_ID, EMP_NAME, JOB.JOB_CODE , JOB_NAME 
FROM EMPLOYEE , JOB
WHERE EMPLOYEE.JOB_CODE = JOB.JOB_CODE ;

SELECT EMP_ID, EMP_NAME, E.JOB_CODE , JOB_NAME 
FROM EMPLOYEE E , JOB J -- 테이블명 별칭 순서로 작성
WHERE E.JOB_CODE = J.JOB_CODE ;



---------------------------------------------------------------------------------------------------------------


-- 2. 외부 조인(OUTER JOIN)

-- 두 테이블의 지정하는 컬럼값이 일치하지 않는 행도 조인에 포함을 시킴
-->  *반드시 OUTER JOIN임을 명시해야 한다.

-- OUTER JOIN과 비교할 INNER JOIN 쿼리문
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
/*INNER*/ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);


-- 1) LEFT [OUTER] JOIN  : 합치기에 사용한 두 테이블 중 왼편에 기술된 테이블의 
-- 컬럼 수를 기준으로 JOIN
-- ANSI 표준
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

--> LEFT JOIN : JOIN 구문을 기준으로,
			-- 왼쪽에 작성된 테이블의 모든 행이 JOIN결과에 포함되게 하는 JOIN

-- 오라클 구문
SELECT EMP_NAME , DEPT_TITLE
FROM EMPLOYEE , DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+);
-- 		NULL    = (D1 ~ D9)(+) // NULL이 없어도 추가해라!라는 뜻
-- DEPT_CODE의 값(NULL)이
-- DEPT_ID의 값(D1 ~ D9)과 일치하지 않아도 추가해라~~~~~~~~


-- 2) RIGHT [OUTER] JOIN : 합치기에 사용한 두 테이블 중 
-- 오른편에 기술된 테이블의  컬럼 수를 기준으로 JOIN
-- ANSI 표준
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE RIGHT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

--> RIGHT JOIN : JOIN 구문을 기준으로,
			-- 오른쪽에 작성된 테이블의 모든 행이 JOIN결과에 포함되게 하는 JOIN

-- 오라클 구문
SELECT EMP_NAME , DEPT_TITLE
FROM EMPLOYEE , DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;


-- 3) FULL [OUTER] JOIN   : 합치기에 사용한 두 테이블이 가진 모든 행을 결과에 포함
-- ** 오라클 구문은 FULL OUTER JOIN을 사용 못함

-- ANSI 표준
SELECT EMP_NAME , DEPT_TITLE
FROM EMPLOYEE
--JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID); -- INNER JOIN (21행)
--LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID); -- LEFT JOIN (23행, 하동운, 이오리)
--RIGHT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID); -- RIGHT JOIN (24행, 마케팅부, 국내영업부, 해영3)
FULL JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID); -- FULL JOIN (26행)


-- 오라클 방식 사용 불가
SELECT EMP_NAME , DEPT_TITLE
FROM EMPLOYEE , DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID(+);
-- ORA-01468: outer-join된 테이블은 1개만 지정할 수 있습니다



---------------------------------------------------------------------------------------------------------------

-- 3. 교차 조인(CROSS JOIN == CARTESIAN PRODUCT)
--  조인되는 테이블의 각 행들이 모두 매핑된 데이터가 검색되는 방법(곱집합 == 모든 경우의 수)
--	(주로 자연조인 실패 결과물로 확인 가능 == 자연 조인 잘못했구나..)

SELECT EMP_NAME , DEPT_CODE , DEPT_ID , DEPT_TITLE
FROM EMPLOYEE
CROSS JOIN DEPARTMENT; -- 모든 경우의 수가 행으로 나오기때문에 기준이 필요 없음


---------------------------------------------------------------------------------------------------------------

-- 4. 비등가 조인(NON EQUAL JOIN) // 어려워서 잘 안써요.. ^^;

-- '='(등호)를 사용하지 않는 조인문
--  지정한 컬럼 값이 일치하는 경우가 아닌, 값의 범위에 포함되는 행들을 연결하는 방식

SELECT EMP_NAME , SALARY , E.SAL_LEVEL, S.SAL_LEVEL
FROM EMPLOYEE E
JOIN SAL_GRADE S ON ( SALARY BETWEEN MIN_SAL AND MAX_SAL );
-- 사원의 급여가
-- SAL_LEVEL에 작성된 최소(MIN_SAN) ~ 최대(MAX_SAN)
-- 범위의 급여가 맞을 때만 조인


---------------------------------------------------------------------------------------------------------------

-- 5. 자체 조인(SELF JOIN) // 많이써요!!!

-- 같은 테이블을 조인.
-- 자기 자신과 조인을 맺음

-- 사번, 이름, 사수번호, 사수 이름 조회
-- EMP_ID, EMP_NAME, MANAGER_ID, EMP_NAME

-- TIP. 하나의 테이블만 생각하지 말고 똑같은 테이블이 2개있다고 생각하기!

-- ANSI 표준

SELECT EMP.EMP_ID, EMP.EMP_NAME, EMP.MANAGER_ID, MGR.EMP_NAME
FROM EMPLOYEE EMP
LEFT JOIN EMPLOYEE MGR ON (EMP.MANAGER_ID = MGR.EMP_ID);
--> EMP테이블에서 찾으려는 사수의 이름이
-- MGR 테이블에 있다

-- 오라클 구문
SELECT EMP.EMP_ID, EMP.EMP_NAME, EMP.MANAGER_ID, MGR.EMP_NAME
FROM EMPLOYEE EMP , EMPLOYEE MGR
WHERE EMP.MANAGER_ID = MGR.EMP_ID(+);

---------------------------------------------------------------------------------------------------------------

-- 6. 자연 조인(NATURAL JOIN) // 많이써요!!
-- 동일한 타입과 이름을 가진 컬럼이 있는 테이블 간의 조인을 간단히 표현하는 방법
-- 반드시 두 테이블 간의 동일한 컬럼명, 타입을 가진 컬럼이 필요
--> 없을 경우 교차조인이 됨.

SELECT EMP_NAME, JOB_NAME 
FROM EMPLOYEE
--JOIN JOB USING(JOB_CODE);
NATURAL JOIN JOB;


-- NATURAL JOIN이 성립되지 않을 때
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
NATURAL JOIN DEPARTMENT ;
--> CROSS JOIN 결과가 나타남


---------------------------------------------------------------------------------------------------------------

-- 7. 다중 조인
-- N개의 테이블을 조회할 때 사용  (순서 중요! / 연결고리 생각잘하기!)

-- EMPLOYEE, DEPARTMENT, LOCATION  3개 테이블 조인

-- ANSI 표준
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);


-- 오라클 전용
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID AND LOCATION_ID = LOCAL_CODE;


-- 조인 순서를 지키지 않은 경우(에러발생)



--[다중 조인 연습 문제]

-- 직급이 대리이면서 아시아 지역에 근무하는 직원 조회
-- 사번, 이름, 직급명, 부서명, 근무지역명, 급여를 조회하세요

-- ANSI
SELECT EMP_ID , EMP_NAME , JOB_NAME , DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리' AND LOCAL_NAME LIKE 'ASIA%';


-- 오라클 전용
SELECT EMP_ID , EMP_NAME , J.JOB_NAME , DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE E, DEPARTMENT, LOCATION, JOB J
WHERE DEPT_CODE = DEPT_ID AND LOCATION_ID = LOCAL_CODE
AND E.JOB_CODE = J.JOB_CODE AND JOB_NAME = '대리' AND LOCAL_NAME LIKE 'ASIA%';




---------------------------------------------------------------------------------------------------------------


-- [연습문제]

-- 1. 주민번호가 70년대 생이면서 성별이 여자이고, 성이 '전'씨인 직원들의 
-- 사원명, 주민번호, 부서명, 직급명을 조회하시오.
SELECT EMP_NAME , EMP_NO , DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE EMP_NO LIKE '7%' AND SUBSTR(EMP_NO, 8, 1) = '2' AND EMP_NAME LIKE '전%'; 


      
-- 2. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명, 직급명을 조회하시오.
SELECT EMP_ID , EMP_NAME , JOB_NAME
FROM EMPLOYEE
--JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
NATURAL JOIN JOB
--JOIN JOB USING (JOB_CODE)
WHERE EMP_NAME LIKE '%형%';


-- 3. 해외영업 1부, 2부에 근무하는 사원의 
-- 사원명, 직급명, 부서코드, 부서명을 사번 오름차순으로 조회하시오.
SELECT EMP_NAME, JOB_NAME, DEPT_CODE , DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE DEPT_TITLE  IN ('해외영업1부', '해외영업2부')
ORDER BY EMP_ID;


--4. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
SELECT EMP_NAME , BONUS, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE BONUS IS NOT NULL;


--5. 부서가 있는 사원의 사원명, 직급명, 부서명, 지역명 조회
SELECT EMP_NAME, JOB_NAME, DEPT_TITLE,LOCAL_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
/*INNER*/ JOIN  DEPARTMENT ON (DEPT_CODE = DEPT_ID) 
 JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);
--WHERE DEPT_CODE IS NOT NULL; // 이너조인시 알아서 NULL은 사라지기때문에 필요 X


-- OUTER JOIN. NULL 포함!
SELECT EMP_NAME, JOB_NAME, NVL(DEPT_TITLE, '없음'), NVL(LOCAL_NAME, '없음')
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
LEFT JOIN  DEPARTMENT ON (DEPT_CODE = DEPT_ID) -- NULL을 없애고싶지 않을땐 LEFT!
LEFT JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);


-- 6. 급여등급별 최소급여(MIN_SAL)를 초과해서 받는 직원들의
--사원명, 직급명, 급여, 연봉(보너스포함)을 조회하시오.
--연봉에 보너스포인트를 적용하시오.
SELECT EMP_NAME, JOB_NAME, SALARY,
--	NVL((SALARY * 12)* (BONUS+1), (SALARY * 12)) "연봉(보너스포함)"
	SALARY * (1 + NVL(BONUS,0)) * 12 "연봉"
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
JOIN SAL_GRADE USING (SAL_LEVEL)
WHERE SALARY > MIN_SAL
ORDER BY EMP_ID;


-- 7.한국(KO)과 일본(JP)에 근무하는 직원들의 
-- 사원명, 부서명, 지역명, 국가명을 조회하시오.
SELECT EMP_NAME 사원명, DEPT_TITLE 부서명, LOCAL_NAME 지역명, NATIONAL_NAME 국가명
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_CODE IN ('KO', 'JP');


-- 8. 같은 부서에 근무하는 직원들의 사원명, 부서코드, 동료이름을 조회하시오.
-- SELF JOIN 사용
SELECT E.EMP_NAME , E.DEPT_CODE , E2.EMP_NAME "동료이름"
FROM EMPLOYEE E
RIGHT JOIN EMPLOYEE E2 ON (E.DEPT_CODE = E2.DEPT_CODE)
--WHERE E.DEPT_CODE IS NOT NULL AND E.EMP_NAME != E2.EMP_NAME 
WHERE E.EMP_ID != E2.EMP_ID
ORDER BY EMP_NAME; 



-- 9. 보너스포인트가 없는 직원들 중에서 직급코드가 J4와 J7인 직원들의 사원명, 직급명, 급여를 조회하시오.
-- 단, JOIN, IN 사용할 것
SELECT EMP_NAME , JOB_NAME, SALARY 
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE BONUS IS NULL
AND JOB_CODE IN ('J4', 'J7');






