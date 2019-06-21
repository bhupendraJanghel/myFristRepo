  /* pair subqueries*/
SELECT employee_id,manager_id,department_id FROM employees WHERE (manager_id,department_id) IN (SELECT manager_id,department_id FROM employees WHERE employee_id IN (199,174)) AND employee_id NOT IN(199,174);

/* non pair subqueries*/     /*both are having same result*/
SELECT employee_id,manager_id,department_id FROM employees WHERE manager_id IN(SELECT manager_id FROM employees WHERE employee_id IN(174,199)) AND department_id IN(SELECT department_id FROM employees WHERE employee_id IN(174,199)) AND employee_id NOT IN(174,199);

/*scalar subqueries   and also an example of case expresssion*/

SELECT employee_id,last_name,(CASE WHEN department_id=(SELECT department_id FROM departments WHERE location_id=1800) THEN 'CANADA' ELSE 'USA' END) AS location FROM  employees;  

select employee_id,last_name from employees e order by (select department_name from departments d where e.department_id=d.department_id);

/*corelated subqueries*/
/*find all employees who earn more than the average dalary in their department*/

select last_name,salary,department_id from employees outr where salary>(select avg(salary) from employees where department_id=outr.department_id);


select e.employee_id,last_name,e.job_id  from employees e where 2<=(select count(*) from job_history where employee_id=e.employee_id);


/*Exist and not exist operator*/
/*find employee who have atleast one person reporting on them*/

select employee_id,last_name,job_id,department_id from employees outr where exists(select last_name from employees where manager_id=outr.employee_id);
select employee_id,last_name,job_id from departments  outr where not exists(select last_name from employees where manager_id=outr.employee_id);
select department_id,department_name from departments d where not exists(select last_name from employees where department_id=d.department_id);



delete from employees  where employee_id=(select employee_id from job_history where employee_id=employees.employee_id);



delete from product where productcode=(se);


/* With clausec -- it is not work with mysql*/

/*write a query to display the department*/

with dept_cost as (select d.department_name , sum(e.salary) as dept_total from employees e join department d on e.department_id=d.department_id group by d.department_name), avg_cost as(select sun(dept_total)/count(*) as dept_avg from dept_costs) select * from dept_costs where dept_total > (select dept_avg from avg_cost) order by department_name;



/* practice question*/

select last_name,department_id,salary from employees where (department_id,salary) in (select department_id,salary from employees where commission_pct is not null);


select e.last_name,d.department_name,e.salary from employees e,departments d where e.department_id=d.department_id and (salary,ifnull(commission_pct,0)) in 
(select salary, ifnull(commission_pct,0) from employees e,departments d where e.department_id=d.department_id and location_id=1700);


SELECT last_name, hire_date, salary	FROM employees	WHERE (salary, IFNULL(commission_pct,0)) IN		(SELECT salary, IFNULL(commission_pct,0)
		FROM employees
		WHERE last_name = 'Kochhar')
	AND last_name != 'Kochhar';
    
select last_name,job_id,salary from employees where salary>all(select salary from employees where job_id='SA_MAN') order by salary desc;

select employee_id,last_name,department_id from employees where department_id in (select department_id from departments where 
location_id in(select location_id from locations where city like 'T%'));



select last_name ,salary,department_id,avg(salary) from employees where salary >(select avg(salary)  from employees group by department_id) order by avg(salary);


	SELECT e.last_name ename, e.salary salary,
		e.department_id deptno, AVG(a.salary) dept_avg
	FROM employees e, employees a
	WHERE e.department_id = a.department_id
	AND e.salary > (SELECT AVG(salary)
			FROM employees
			WHERE department_id = e.department_id )
	GROUP BY e.last_name, e.salary, e.department_id
	ORDER BY AVG(a.salary);

SELECT outr.last_name
	FROM employees outr
	WHERE outr.employee_id
	NOT IN (SELECT iner.manager_id
		FROM employees iner);

	SELECT last_name
	FROM employees outr
	WHERE outr.salary < (SELECT AVG(iner.salary)
			      FROM employees iner
			      WHERE iner.department_id
				= outr.department_id);
                
                
                
	SELECT last_name
	FROM employees outr
	WHERE EXISTS (SELECT last_name
			FROM employees innr
			WHERE innr.department_id =
				outr.department_id
			AND innr.hire_date > outr.hire_date
			AND innr.salary > outr.salary);
            
SELECT employee_id, last_name,
		(SELECT department_name
		FROM departments d
		WHERE e.department_id =
			d.department_id ) department
		FROM employees e
		ORDER BY department;