select last_name,salary from employees where salary>(select salary from employees where last_name='abel');

select last_name,salary,job_id from employees where job_id>(select job_id from employees where employee_id=141) and salary>(select salary from employees where employee_id='143');

select last_name, job_id,salary from employees where salary=(select min(salary) from employees);

select department_id, min(salary) from employees group by department_id having min(salary)>(select min(salary) from employees where department_id=50);

select employee_id, last_name,job_id,salary from employees where salary< any (select salary from employees where job_id='IT_PROG') and job_id <> 'IT_PROG';
select employee_id, last_name,job_id,salary from employees where salary< all (select salary from employees where job_id='IT_PROG') and job_id <> 'IT_PROG';


select last_name,hire_date from employees where department_id=(select department_id from employees where last_name='Zlotkey') and last_name<> 'Zlotkey';

select employee_id, last_name,salary from employees where salary>(select avg(Salary) from employees) order by salary ;

select employee_id,last_name,department_id from employees where department_id=any(select department_id from employees where last_name like '%u%');

select last_name,department_id,job_id from employees where department_id= any(select department_id from departments where location_id=1700);

select last_name ,salary from employees where manager_id=any(select manager_id from employees where last_name='king');

select department_id,last_name from employees where department_id=(select department_id from departments where department_name='executive');

select employee_id,last_name,salary from employees where salary>(select avg(salary) from employees) and department_id=any(select department_id from employees where last_name like '%u%');