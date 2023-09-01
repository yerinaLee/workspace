-- 시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE; -- 회원번호
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE; -- 게시글번호
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE; --댓글번호


-- MEMBER 테이블에 INSERT 하기
INSERT INTO MEMBER
VALUES (SEQ_MEMBER_NO.NEXTVAL,
	'mem01@naver.com',
	'1234',
	'1번회원',
	'0103825',
	'서울시 중구 어쩌구',
	DEFAULT, DEFAULT);
	
COMMIT;


SELECT * FROM MEMBER;


--		// 이메일, 비밀번호가 일치하는 회원의
--		// 닉네임, 전화번호, 주소를 수정
--		// (아이디 중복 없다고 가정)

UPDATE MEMBER
SET MEMBER_NICKNAME = '변경된 닉네임' ,
MEMBER_TEL = '010101010',
MEMBER_ADDRESS = '부산 해운대구'
WHERE MEMBER_EMAIL = 'mem01@naver.com'
AND MEMBER_PW = '1234'
;

ROLLBACK;
		


DELETE FROM MEMBER
WHERE MEMBER_EMAIL = 'mem01@naver.com'
AND MEMBER_PW = '1234';



UPDATE MEMBER
SET MEMBER_PW = '4321'
WHERE MEMBER_EMAIL = 'mem01@naver.com'
AND MEMBER_PW = '1234';




















