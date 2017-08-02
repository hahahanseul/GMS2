--*********************************
--2017/08/02
--[1] MAJOR_TAB
--[2] SUBJECT_TAB
--[3] MEMBER_TAB
--[4] PROF_TAB
--[5] STUDENT_TAB
--[6] GRADE_TAB
--[7] BOARD_TAB
--*********************************
SELECT * FROM tab;
DROP SEQUENCE article_seq;
CREATE SEQUENCE seq
START WITH 2000
INCREMENT BY 1
NOCACHE
NOCYCLE;

--*********************************
--[1] MAJOR_TAB
--2017/08/02
--전공관리 테이블
--major_id, title
--*********************************
--DDL
	CREATE TABLE MAJOR(
	major_id VARCHAR2(10),
	title VARCHAR2(10),
	PRIMARY KEY(major_id)
);
--DML

--*********************************
--[2] SUBJECT_TAB
--2017/08/02
--과목관리 테이블
--subj_id,title, major_id
--*********************************
CREATE TABLE Subject(
	subj_id VARCHAR2(10),
	title VARCHAR2(10),
	major_id VARCHAR2(10),
	PRIMARY KEY (subj_id),
	FOREIGN KEY (major_id) REFERENCES Major(major_id)
		ON DELETE CASCADE
);
--DML
INSERT INTO Subject(subj_id,title,major_id)
VALUES('','','');


--*********************************
--[3] MEMBER_TAB
--2017/08/02
--회원관리 테이블
--member_id,name,pw,ssn,regdate,
--phone,email,major_id,profile
--*********************************
--DDL
CREATE TABLE Member(
	member_id VARCHAR2(10), 
	name VARCHAR2(20),
	pw VARCHAR2(10), 
	ssn VARCHAR2(15),
	regdate DATE,
	phone VARCHAR2(20),
	email VARCHAR2(20),
	profile VARCAHR2(20),
	PRIMARY KEY(member_id),
	FOREIGN KEY (major_id) REFERENCES Major(major_id)
		ON DELETE CASCADE
);
DROP TABLE Member;
--DML
INSERT INTO Member(member_id,name,pw,ssn,regdate,phone,email,major_id,profile)
VALUES('ko','고승경','1','700215-1821305',SYSDATE,'010-1234-5678','ko@test.com','economics','ko.jpg');
SELECT * FROM Member;
SELECT * FROM Member WHERE id = 'hong';
SELECT * FROM prof p, member m
where p.member_id=m.member_id;

SELECT COUNT(*) AS count FROM Member;
UPDATE Member SET pw = '2' WHERE member_id = 'hong';
DELETE FROM Member WHERE member_id='hansuru';


--*********************************
--[4] PROF_TAB
--2017/08/02
--교수관리 테이블
--member_id,salary
--*********************************
CREATE TABLE Prof(
	member_id VARCHAR2(10),
	salary VARCHAR2(10),
	PRIMARY KEY(member_id),
	FOREIGN KEY(member_id) REFERENCES Member(member_id)
		ON DELETE CASCADE
);

--DML

INSERT INTO PROF(MEMBER_ID,SALARY)
VALUES('gogh','1000');

--*********************************
--[5] STUDENT_TAB
--2017/08/02
--학생관리 테이블
--member_id,stu_no
--*********************************
--DDL
CREATE TABLE Student(
	member_id VARCHAR2(10),
	stu_no VARCHAR2(8),
	PRIMARY KEY(member_id),
	FOREIGN KEY(member_id) REFERENCES Member(member_id)
		ON DELETE CASCADE
);
DROP TABLE Student;
--DML
INSERT INTO STUDENT(MEMBER_ID,STU_NO)
VALUES('hahahah','20167014');
SELECT * FROM Student;

--*********************************
--[6] GRADE_TAB
--2017/08/02
--성적관리 테이블
--grade_seq, score, exam_date, subj_id, member_id
--*********************************
--DDL
CREATE TABLE Grade(
	grade_seq NUMBER,
	score VARCHAR2(3),
	exam_date VARCHAR2(12),
	subj_id VARCHAR2(10),
	member_id VARCHAR2(10),
	PRIMARY KEY(grade_seq),
	FOREIGN KEY (member_id) REFERENCES Member(member_id)
		ON DELETE CASCADE,
	FOREIGN KEY(subj_id) REFERENCES Subject(subj_id)
	 	ON DELETE CASCADE
);
DROP TABLE Grade;
ALTER TABLE GRADE
RENAME COLUMN id TO member_id; 
--DML
SELECT * FROM Grade;
--member_id를 입력하면 평균점수를 반환하는 sql
SELECT avg(SCORE)
FROM(SELECT DISTINCT
m.member_id id,m.name name,mj.title as major,g.SCORE,sj.title AS subject, g.exam_date
FROM member m, student s, grade g, subject sj, major mj
WHERE
    m.member_id=s.member_id
    and m.member_id = g.member_id
    and sj.MAJOR_ID = mj.MAJOR_ID
    and sj.subj_id = g.subj_id) t
    WHERE t.id='hong';

SELECT avg(SCORE)
FROM(SELECT
		m.member_id id,m.name name,g.SCORE score, g.exam_date exam_date
	FROM grade g
		inner join Subject s on g.subj_id=s.subj_id
		inner join Member m on m.member_id=g.member_id
	) t
WHERE t.id='hong';
    
INSERT INTO Grade(grade_seq,score,exam_date,subj_id,member_id)
VALUES (seq.nextval,'90','2017-03','java','hong');

--*********************************
--[7] BOARD_TAB
--2017/08/02
--게시물관리 테이블
--article_seq, id, title, content, hitcount, regdate
--*********************************
-DDL
CREATE TABLE Board(
	article_seq NUMBER,
	id VARCHAR2(10),
	title VARCHAR2(20),
	content VARCHAR2(100),
	hitcount NUMBER,
	regdate	DATE,
	PRIMARY KEY(article_seq),
	FOREIGN KEY(id) REFERENCES Member(id)
		ON DELETE CASCADE
);

-DML

INSERT INTO Board(article_seq, member_id, title, content, hitcount, regdate)
VALUES (seq.nextval, 'hong', '홍길동 안녕', '고동을 청춘의 무엇을 창공에 그들은 그리하였는가?', 0,SYSDATE);

SELECT * FROM Board;
DELETE FROM Board WHERE seq='1011';

SELECT DISTINCT member_id 
FROM Board WHERE member_id LIKE '%h%';

SELECT SUM(article_seq)
FROM Board;