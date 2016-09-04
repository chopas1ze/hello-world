select * from departments;

	department_id
	department_name
	manager_id
	location_id
	
select * from mem
	
 create table mem(
 num number,
 name varchar2(20),
 age  number(3),
 loc varchar2(10));
  
 create sequence mem_num_seq
 start with 1
 increment by 1
 nocache
 nocycle;

 insert into mem values(mem_num_seq.nextval, '홍길동',30,'서울');
 select * from mem order by num;
 commit
 
 
 select * from departments;
 select * from mem ORDER by num;
 delete from mem WHERE num>=4;
 
 SELECT e.employee_id, e.first_name, e.salary, d.department_id, d.department_name,l.location_id,l.city
 FROM employees e, departments d, locations l
 WHERE e.department_id=d.department_id AND d.location_id=l.location_id
 
 