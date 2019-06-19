select employee_id,e.last_name, d.location_id,department_id from employees e JOIN departments d using(department_id);

select e.employee_id,e.last_name, d.location_id,d.department_id from employees e JOIN departments d on e.department_id=d.department_id;

select e.last_name emp,m.last_name mgr from employees e join employees m on (e.manager_id=m.employee_id);        /* self join*/

select employee_id, city, department_name from employees e join departments d on d.department_id=e.department_id join locations l on d.location_id=l.location_id;

select * from locations;
select * from countries;
select * from employees;
select * from departments;

select l.location_id,l.street_address,l.city,l.state_province,c.country_name from locations l natural join countries c;

select e.last_name,d.department_id,d.department_name from employees e join departments d on e.department_id=d.department_id ;

select e.last_name,e.job_id,d.department_id,department_name from employees e join departments d on e.department_id=d.department_id join locations l on d.location_id=l.location_id where l.city='toronto';

select e.last_name 'name',e.employee_id 'EMP#' ,m.manager_id,m.last_name from employees e join employees m on e.employee_id=m.manager_id;

