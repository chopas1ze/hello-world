  #도시별 부서명, 사원이름, 사원연봉을 출력
 select l.city, d.department_name, e.first_name, e.salary
 from locations l, departments d, employees e
 where l.location_id=d.location_id
 and d.department_id=e.department_id
 order by l.city
 