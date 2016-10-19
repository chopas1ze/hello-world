create table memtab(
num number;
id varchar2(10),
pass varchar2(20),
name varchar2(50)
);


create sequence memtab_num_seq
start with 1
increment by 1
nocache
nocycle;


insert into memtab
	values(memtab_num_seq.nextval,'kim','1234','홍길동')


commit

insert into mem values(mem_num_seq.nextval,'홍길동',30,'서울')
insert into mem values(mem_num_seq.nextval,'kong',25,'경기')
insert into mem values(mem_num_seq.nextval,'이영희',20,'부산')
insert into mem values(mem_num_seq.nextval,'고사영',30,'대전')

select * from mem

select count(*) from memtab where id='kim' and pass='1234'



DELETE FROM mem
