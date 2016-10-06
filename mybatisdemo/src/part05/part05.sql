 select e.employee_id, e.first_name, d.department_name, l.street_address 
 from employees e, departments d, locations l
 where e.department_id=d.department_id
 and d.location_id=l.location_id
 
 
 
