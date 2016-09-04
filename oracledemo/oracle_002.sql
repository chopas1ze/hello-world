--------------------------------------------
서브쿼리
외부 쿼리 (주쿼리)
 :일반 쿼리를 의미합니다.
스칼라 서브쿼리
 :SELECT 절에 쿼리가 사용되는 경우로, 함수처럼 레코드당 정확히 하나의 값만을 반환하는 서브쿼리입니다.
인라인 뷰
 :FROM 절에 사용되는 쿼리로, 원하는 데이터를 조회하여 가상의 집합을 만들어 조인을 수행하거나 가상의 집합을 다시 조회할 때 사용합니다.
서브 쿼리
 :HERE,HAVING 절에 사용되는 쿼리입니다.
//////////////
서브쿼리는 하나의 select문장의 절 안에 포함된 또 하나의 select문장이다.
서브쿼리를 포함하고 있는 쿼리문을 메인쿼리, 포함된 또 하나의 쿼리를 서브쿼리라 한다.
서브쿼리는 비교연산자의 오른쪽에 기술해야 하고 반드시 괄호 안에 넣어야한다.
서브쿼리는 메인쿼리가 실행되기 이전에 한번만 실행이 된다.
서브쿼리는 단일행 서브쿼리와 다중행 서브쿼리로 나눈다.
단일행 서브쿼리는 오직 하나의 로우(행)로 반환되는 서브쿼리의 결과는 메인쿼리로
   보내는데 메인 쿼리의 where 절에서는 단일행 비교연산자인 =, >,>=, <, <=, <>를
   사용해야 한다.
다중행 서브쿼리는 다중행연산자(in, any(some), all, exists)와 함께 사용해야한다.
   in : 메인쿼리의 비교조건('='연산자로 비교할 경우)이 서브쿼리의 결과 중에서
         하나라도 일치하면 참이다.
   any,some : 메인 쿼리의 비교 조건이 서브 쿼리의 검색 결과와 하나 이상이 일치하면
          참이다.
   all : 메인 쿼리의 비교 조건이 서브 쿼리의 검색 결과와 모든 값이 일치하면 참이다.
   exists : 메인 쿼리의 비교 조건이 서브 쿼리의 결과 중에서 만족하는 값이 하나라도
          존재하면 참이다.
//////////
서브 쿼리 사용:SELECT, FROM, WHERE, HAVING, INSERT문의 VALUES, UPDATE문의 SET, CREATE문
/////////
서브쿼리와 조인 비교
		서브쿼리						
결과 집합	외부쿼리(메인쿼리) 레벨로 결과 집합이 생성		
컬럼 사용	외부쿼리의 컬럼을 사용할 수 있지만 서브쿼리의 컬럼을 외부에서 사용할 수 없다.

                조인
결과 집합	조인되는 테이블간의 곱 레벨이 집합이 생성
컬럼 사용	조인되는 테이블의 컬럼을 모두 사용할 수 있다.
//////
**결과 집합이 하나의 테이블 레벨이고 다른 테이블을 체크`의 용도로 사용한다면 조인이 아닌 서브쿼리를 사용해야 합니다.
--------------------------------------------------------------  
 
--Lex가 근무하는 부서명을 출력하시오.
SELECT department_id
FROM employees
WHERE first_name='Lex'

SELECT department_name
FROM departments
WHERE department_id=90

SELECT department_name
FROM employees e, departments d
WHERE e.department_id=d.department_id and e.first_name='Lex';

SELECT department_name
FROM departments
WHERE department_id=(SELECT department_id FROM employees WHERE first_name='Lex');

--Lex와 같은 부서에 근무하는 사원의 이름과 부서번호를 출력하시오.
SELECT first_name, department_id 
FROM employees
WHERE department_id=(SELECT department_id FROM employees WHERE first_name='Lex');


--'Lex'와 동일한 직업(job_id)을 가진 사원의 이름(first_name),
-- 직업(job_title), 입사일(hire_date)을 출력하시오.
SELECT e.first_name as "사원의 이름", j.job_title as "직업", e.hire_date as "입사일"
FROM employees e, jobs j
WHERE e.job_id=j.job_id and e.job_id=(SELECT job_id FROM employees WHERE first_name='Lex');

--IT에 근무하는 사원의 이름, 부서번호를 출력하시오.
SELECT first_name , department_id
FROM employees
WHERE department_id=(SELECT department_id FROM departments WHERE department_name='IT');
			
--Bruce보다 연봉을  많이 받은 사원이름(first_name), 부서명을 출력하시오.
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id=d.department_id and e.salary>(SELECT salary FROM employees WHERE first_name='Bruce')
					
--Steven과 같은 부서에서 근무하는 사원의 이름, 급여, 입사일을 출력하시오.(in)
SELECT first_name, salary, hire_date, department_id
FROM employees
WHERE department_id in(SELECT department_id FROM employees WHERE first_name='Steven');

--부서별로 가장 급여를 많이 받는 사원의 이름, 급여, 부서번호를 출력하시오.(in)
SELECT first_name, salary,department_id
FROM employees
--department_id가 null일때는 비교시 걸러서 비교된다.
WHERE department_id,salary in(SELECT department_id, max(salary) FROM employees GROUP BY department_id)
ORDER BY department_id;


--부서번호 30소속된 사원들중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를
--받는 사원의 이름, 급여, 입사일을 출력하시오.(all)
--(서브쿼리에서 max()함수를 사용하지 않는다.)
SELECT first_name,salary,hire_date
FROM employees
WHERE salary > all(SELECT salary FROM employees WHERE department_id=30);

--부서번호가 30번인 사원들이 받는 최저급여보다 높은 급여를 받는 사원의 이름, 
--급여, 입사일을 출력하시오.(min()함수를 사용하지 않는다)(any)
SELECT first_name,salary,hire_date
FROM employees
WHERE salary > any (SELECT salary FROM employees WHERE department_id=30);

--20번 부서에 속한 사원이 있으면 사원들의 사원명, 입사일, 급여,
--부서번호를 출력하시오.(exists)
SELECT first_name, hire_date, salary
FROM employees
WHERE exists (SELECT department_id FROM employees WHERE department_id=20);


------------------------------------------------------
Top-N 서브쿼리
   상위의 값을 추출할때 사용된다.
   <, <=연산자를 사용할수 있다. 단 비교되는 값이 1일때는 =도 가능하다.
   order by절을 사용할 수 있다.
------------------------------------------------------
--급여가 가장높은 상위 3명을 검색하시오.
--rownum(행번호를 받지못하면 사용할수없다)

SELECT b.*
FROM (SELECT rownum as rm, a.first_name, a.salary FROM(SELECT first_name, salary FROM employees ORDER BY salary desc) a)b
WHERE b.rm<=3;
--rownum은 예약어라 b.rownum을 사용할수 없다.

SELECT rownum,a.first_name, a.salary
FROM(SELECT first_name, salary FROM employees ORDER BY salary desc) a
WHERE rownum <= 3;
   
컬럼이나 행의 갯수에 따라서
1. 단일 행 서브쿼리
2. 다중 행 서브쿼리
3. 단일 컬럼 서브쿼리
4. 다중 컬럼 서브쿼리

--부서명에 IT가 포함이된 사람이 속한 사원명, 부서번호, 부서명을 출력하시오(in)
SELECT e.first_name,e.department_id,d.department_name
FROM employees e, departments d
WHERE e.department_id=d.department_id AND d.department_name in(SELECT department_name
																FROM departments
																WHERE department_name like '%IT%');
																
															
--Toronto 사원들보다 많은 연봉을 받는 first_name, city, salary을 출력하시오
--(any연산자) 단 부서가 있는 사원의 정보만 출력한다.
--Toronto은 제외한다.
SELECT e.first_name, l.city, e.salary
FROM employees e, locations l, departments d
WHERE e.department_id=d.department_id and d.location_id=l.location_id and e.salary > any(select salary from employees
where department_id=(select department_id from departments where location_id=(SELECT location_id
FROM locations
WHERE city='Toronto'))) and l.city!='Toronto' and e.department_id is not null;


--연봉이 상위 5~10사이의 사원명, 입사일, 연봉을 출력하시오.(Top-N)
SELECT b.first_name,b.hire_date,b.salary
FROM (
SELECT rownum as rm , a.first_name, a.hire_date, a.salary
FROM(SELECT first_name, hire_date, salary
FROM employees
ORDER BY salary desc) a)b
WHERE b.rm>=5 and b.rm<=10;


[문제]연봉이 2500이하인 사원의 사원번호, 사원명, 연봉을 검색하시오.
SELECT employee_id, first_name, salary
FROM employees
WHERE salary<=2500;


[문제]사원테이블에서 'Lex'인 사원의 사원번호, 사원명, 연봉을 검색하시오
SELECT employee_id, first_name, salary
FROM employees
WHERE first_name='Lex';

[문제]사원번호가 132 이거나 140 이거나 148인 사원의 사원번호, 연봉을 검색하시오.
SELECT employee_id, salary
FROM employees
WHERE employee_id in(132,140,148);

[문제]연봉이 20000이상인 사원들의 사원명(first_name),입사년도,연봉를 출력하시오.
SELECT first_name as "사원명", to_char(hire_date,'yyyy') as "년도", salary as "연봉"
FROM employees
WHERE salary>=20000;

[문제]각 사원들의 사원명(first_name),사원명 길이를 출력하시오.
SELECT first_name, length(first_name)
FROM employees

[문제]"Steven님은 2003년 06월 17일 입사한 사원입니다" 처럼 각 사원을 출력하시오.
SELECT first_name || '님은 '|| to_char(hire_date,'yyyy')||'년 '||to_char(hire_date,'mon')||to_char(hire_date,'dd')||'일 입사한 사원입니다' as "사원정보"
FROM employees

[문제] 모든사원에게는 상관(Manager)이 있다. 하지만 employees테이블에 유일하게 상관이
   없는 로우가 있는데 그 사원(CEO)의 MGR컬럼값이 NULL이다. 상관이 없는 사원한
   출력하되 MGR컬럼값 NULL 대신 CEO로 출력하시오.

SELECT manager_id, nvl(to_char(manager_id),'CEO') as "MGR"
FROM employees

[문제] 가장최근에 입사한 사원의 입사일과 가장오래된 사원의 입사일을 구하시오.
SELECT MAX(HIRE_DATE), MIN(HIRE_DATE)
FROM employees

[문제] 부서별로 커미션을 받는 사원의 수를 구하시오.
SELECT COUNT(commission_pct),department_id
FROM employees
GROUP BY department_id 
ORDER BY department_id
 
[문제] 부서별 최대급여가 10000이상이 부서만 출력하시오.
SELECT department_id, MAX(salary)
FROM employees
WHERE salary>=10000
GROUP BY department_id
ORDER BY department_id

[문제] employees 테이블에서 직종이 'IT_PROG'인 사원들의 급여평균을 구하는 SELECT문장을 기술하시오
SELECT avg(salary)
FROM employees
WHERE job_id = 'IT_PROG'

[문제] employees 테이블에서 직종이 'FI_ACCOUNT' 또는 'AC_ACCOUNT' 인 사원들 중 최대연봉을  구하는    SELECT문장을 기술하시오   	
SELECT MAX(salary*12)
FROM employees
WHERE job_id='FI_ACCOUNT' or job_id='AC_ACCOUNT'

[문제] employees 테이블에서 50부서의 최소급여를 출력하는 SELECT문장을 기술하시오
SELECT MIN(salary)
FROM employees
WHERE department_id=50;

[문제] employees 테이블에서 아래의결과처럼 입사인원을 출력하는 SELECT문장을 기술하시오
SELECT sum(decode(to_char(hire_date,'yyyy'),'1997',1,0)) as "1997",
	   sum(decode(to_char(hire_date,'yyyy'),'1998',1,0)) as "1998",
	   sum(decode(to_char(hire_date,'yyyy'),'1999',1,0)) as "1999",
	   sum(decode(to_char(hire_date,'yyyy'),'2000',1,0)) as "2000"
FROM employees;

[문제] employees 테이블에서 각 부서별 인원이 1	0명 이상인 부서의 부서코드,인원수,급여의 합을 구하는  SELECT문장을 작성하여라
SELECT department_id, count(*), sum(salary)
FROM employees
GROUP BY department_id
HAVING count(department_id)>=10;


문제개요 : EMPLOYEES 테이블에서 입사한 달(hire_date) 별로 인원수를 조회하시오
SELECT to_char(hire_date,'mm')||'월' as "월" , count(*) as "직원수"
FROM employees
GROUP BY to_char(hire_date,'mm')
ORDER BY to_char(hire_date,'mm');


문제 개요 : 각 부서에서 근무하는 직원수를 조회하는 SQL 명령어를 작성하시오. 단, 직원수가 5명 이하인 부서 정보만 출력되어야 하며 부서정보가 없는 직원이 있다면 부서명에 “<미배치인원>” 이라는 문자가 출력되도록 하시오. 
그리고 출력결과는 직원수가 많은 부서먼저 출력되어야 합니다.
SELECT nvl(d.department_name,'<미배치 인원>') as "부서명", count(*) as "직원수"
FROM departments d, employees e
WHERE d.department_id(+) = e.department_id
GROUP BY department_name
HAVING count(department_name)<=5
ORDER BY count(*) desc	

<< 문제 개요 >>
각 부서 이름 별로 2003년 이전에 입사한 직원들의 인원수를 조회하시오.
SELECT d.department_name as "부서명", to_char(e.hire_date,'YYYY') as "입사일" , count(*) as "인원수"
FROM departments d, employees e
WHERE d.department_id = e.department_id
GROUP BY d.department_name, to_char(e.hire_date,'YYYY')
HAVING to_char(e.hire_date,'YYYY')<=2003

문제 개요 : 직책(job_title)이 'manager' 인 사람의 이름(first_name), 직책(job_title), 부서명(department_name)을 조회하시오.
SELECT e.first_name, j.job_title, d.department_name
FROM jobs j, employees e, departments d
WHERE d.department_id=e.department_id and e.job_id=j.job_id and j.job_title like '%Manager%'

문제 개요 : 'Executive' 부서에 속에 있는 직원들의 관리자 이름을 조회하시오. 단, 관리자가 없는 직원이 있다면 그 직원 정보도 출력결과에 포함시켜야 합니다.
SELECT d.department_id as "부서", e.first_name as "직원명" , f.first_name as "관리자명"
FROM employees e, departments d,employees f
WHERE e.department_id=d.department_id and f.employee_id(+)=e.manager_id and d.department_name='Executive';

문제개요 :department_id가 60인 부서의도시명을 알아내는 SELECT문장을 기술하시오
SELECT city 
FROM locations
WHERE location_id=(select location_id from departments where department_id=60);

문제개요 :사번이 107인 사람과 부서가같고,167번의 연봉보다 많은 사람들의 사번,이름,성,연봉를 출력하시오
SELECT employee_id,last_name,first_name,salary
FROM employees
WHERE salary>(SELECT salary
FROM employees
WHERE employee_id=167) and department_id=(SELECT department_id
FROM employees
WHERE employee_id=107)


문제개요 : 급여평균보다 연봉을 적게받는사람들중 커미션을 받는 사람들의 사번,이름,성,급여,커미션 퍼센트를 출력하시오
SELECT employee_id,last_name,first_name,salary,commission_pct
FROM employees
WHERE commission_pct is not null and  salary < (select avg(salary) from employees)

문제개요 : 각 부서의 최소연봉가 20번 부서의 최소연봉보다 많은 부서의 번호와 그부서의최소연봉를 출력하시오
SELECT department_id, min(salary)
FROM employees
GROUP BY department_id
HAVING min(salary) > (SELECT min(salary) FROM employees WHERE department_id=20)
ORDER BY department_id





