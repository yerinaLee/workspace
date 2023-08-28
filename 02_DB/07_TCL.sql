-- TCL(Transaction Control Language) : 트랜잭션 제어 언어
-- (Transaction : 업무, 처리)

/* TRANSACTION이란?
 - 데이터베이스의 논리적 연산 단위
 
 - 데이터 변경 사항을 묶어 하나의 트랜잭션에 담아 처리함.

 - 트랜잭션(주머니!)의 대상이 되는 데이터 변경 사항 : INSERT, UPDATE, DELETE (DML)
 - DML을 묶어서 한번에 저장할까? 취소할까? ^^
 
 EX) INSERT 수행 --------------------------------> DB 반영(X)
   
     INSERT 수행 --> 트랜잭션에 추가 --> COMMIT --> DB 반영(O)
     
     INSERT 10번 수행 --> 1개 트랜잭션에 10개 추가 --> ROLLBACK --> DB 반영 안됨


    1) COMMIT : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 DB에 반영
    
    2) ROLLBACK : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 삭제하고
                 마지막 COMMIT 상태로 돌아감. (마지막 저장시점으로 남아있다는 뜻)
                
    3) SAVEPOINT : 메모리 버퍼(트랜잭션)에 저장 지점을 정의하여
                   ROLLBACK 수행 시 전체 작업을 삭제하는 것이 아닌
                   저장 지점까지만 일부 ROLLBACK // 점을 찍어놓듯이
    
    [SAVEPOINT 사용법]
    
    SAVEPOINT 포인트명1;
    ...
    SAVEPOINT 포인트명2;
    ...
    ROLLBACK TO 포인트명1; -- 포인트1 지점 까지 데이터 변경사항 삭제

*/


SELECT * FROM DEPARTMENT2;

-- 'D0' 있을 경우 삭제
DELETE FROM DEPARTMENT2
WHERE DEPT_ID = 'D0';
COMMIT;

-- DEPARTMENT2 테이블을 복사한 DEPARTMENT3 생성
CREATE TABLE DEPARTMENT3
AS SELECT * FROM DEPARTMENT2;

-- DEPARTMENT3 확인
SELECT * FROM DEPARTMENT3;

-- 'D0', '경리부', 'L2' 삽입
INSERT INTO DEPARTMENT3
VALUES ('D0', '경리부', 'L2');
SELECT * FROM DEPARTMENT3;

-- DEPT_ID가 D9인 부서의 이름과 지역코드를
-- '전략기획팀', 'L3'로 수정
UPDATE DEPARTMENT3
SET DEPT_TITLE = '전략기획팀', LOCATION_ID='L3'
WHERE DEPT_ID = 'D9';

COMMIT; -- 현재 트랜잭션에 저장된 DML(INSERT, UPDATE)를 실제 DB에 반영

ROLLBACK; --한번 COMMIT된 내용은 ROLLBACK으로는 취소 불가

SELECT * FROM DEPARTMENT3;


----------------------------------------------------------------------------


SELECT * FROM DEPARTMENT3;

-- DEPT_ID가 'D0'인 행을 삭제
DELETE FROM DEPARTMENT3 WHERE DEPT_ID='D0';

-- DEPT_ID가 'D9'인 행을 삭제
DELETE FROM DEPARTMENT3 WHERE DEPT_ID='D9';

-- DEPT_ID가 'D8'인 행을 삭제
DELETE FROM DEPARTMENT3 WHERE DEPT_ID='D8';

ROLLBACK; -- 트랜잭션에 임시 저장된 내용을 모두 삭제
SELECT * FROM DEPARTMENT3;



-------------------------------------------------

-- SAVEPOINT 확인

-- DEPT_ID가 'D0'인 행을 삭제
DELETE FROM DEPARTMENT3 WHERE DEPT_ID='D0';
SAVEPOINT SP1;

-- DEPT_ID가 'D9'인 행을 삭제
DELETE FROM DEPARTMENT3 WHERE DEPT_ID='D9';
SAVEPOINT SP2;

-- DEPT_ID가 'D8'인 행을 삭제
DELETE FROM DEPARTMENT3 WHERE DEPT_ID='D8';
SAVEPOINT SP3;

SELECT * FROM DEPARTMENT3;


-- SP3까지만 롤백
ROLLBACK TO SP3;

-- SP2까지만 롤백
ROLLBACK TO SP2;

-- SP1까지만 롤백
ROLLBACK TO SP1;

-- 'D0' 삭제 구문도 취소 -> 그냥 ROLLBACK
ROLLBACK;

