--id,name,pw,ssn,regdate; 

INSERT INTO Member(id,name,pw,ssn,regdate)
VALUES('song2','송무명','1','170215-4821305',SYSDATE)

SELECT * FROM Member;
SELECT * FROM Member WHERE id = 'hong';
SELECT * FROM Member WHERE name = '홍길동';
SELECT COUNT(*) AS count FROM Member;
UPDATE Member SET pw = '2' WHERE id = 'hong';
DELETE FROM Member WHERE id='hansuru';
-- id, title, content;
-- article_seq, hitcount;
-- regdate;
INSERT INTO Board(article_seq, id, title, content, hitcount, regdate)
VALUES (article_seq.nextval, 'hong', '홍길동 안녕', '고동을 청춘의 무엇을 창공에 그들은 그리하였는가?', 0,SYSDATE);

INSERT INTO Board(article_seq, id, title, content, hitcount, regdate)
VALUES (article_seq.nextval, 'hanseul', '여기 좀 봐봐', '같은 위하여, 이것은 인간의 싶이 역사를 없는 산야에 것이다.', 0,SYSDATE);

INSERT INTO Board(article_seq, id, title, content, hitcount, regdate)
VALUES (article_seq.nextval, 'hanseul', '그러하냐', '생의 트고, 위하여 만천하의 우리 아름다우냐?', 0,SYSDATE);

INSERT INTO Board(article_seq, id, title, content, hitcount, regdate)
VALUES (article_seq.nextval, 'hanseul', '밥', '불어 밥을 끓는 이 산야에 것이다. ', 0,SYSDATE);

INSERT INTO Board(article_seq, id, title, content, hitcount, regdate)
VALUES (article_seq.nextval, 'lee', '안녕하세요', '품고 거선의 충분히 얼마나 인간의 못할 얼음에 것이다. ', 0,SYSDATE);

INSERT INTO Board(article_seq, id, title, content, hitcount, regdate)
VALUES (article_seq.nextval, 'lee', '안녕히가세요', '이는 없으면 못할 석가는 눈에 옷을 사막이다.  ', 0,SYSDATE);

INSERT INTO Board(article_seq, id, title, content, hitcount, regdate)
VALUES (article_seq.nextval, 'park', '쓸쓸해요', '쓸쓸한 위하여 놀이 얼마나 광야에서 인생을 튼튼하며, 위하여서.', 0,SYSDATE);

INSERT INTO Board(article_seq, id, title, content, hitcount, regdate)
VALUES (article_seq.nextval, 'park', '청춘이 뭔가요', '그들의 인생에 꽃이 실로 청춘의 못할 공자는 것이다.', 0,SYSDATE);

INSERT INTO Board(article_seq, id, title, content, hitcount, regdate)
VALUES (article_seq.nextval, 'kim', '청춘예찬', '무엇을 생명을 얼마나 품으며, 청춘의 교향악이다.', 0,SYSDATE);

INSERT INTO Board(article_seq, id, title, content, hitcount, regdate)
VALUES (article_seq.nextval, 'li', '웅대', '아름답고 사람은 웅대한 어디 쓸쓸하랴?', 0,SYSDATE);

INSERT INTO Board(article_seq, id, title, content, hitcount, regdate)
VALUES (article_seq.nextval, 'hanseul', '바람이분다능', '구하지 그들은 위하여서, 희망의 봄바람이다.', 0,SYSDATE);

INSERT INTO Board(article_seq, id, title, content, hitcount, regdate) VALUES (article_seq.nextval,?,?,?,0,SYSDATE)

SELECT * FROM Board;

DELETE FROM Board WHERE article_seq='1011'