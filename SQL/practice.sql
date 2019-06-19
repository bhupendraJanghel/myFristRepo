SELECT last_name, salary from employees where salary>=12000;

select last_name, department_id from employees where employee_id=176;

select last_name,salary from employees where salary  not between 5000 and 12000;

select last_name, job_id,hire_date from employees where last_name='matos' or last_name='taylor' order by hire_date;

select last_name,department_id from employees where department_id=20 or department_id=50 order by last_name;

select last_name as Employee,salary as 'Monthly salary' from employees where (salary between 5000 and 12000) and department_id in(20,50);

select last_name, date_format(hire_date,'%d-%M-%Y') as Date  from employees where extract(year from hire_date) in (1994);

select last_name,job_id from employees where manager_id is null;

select last_name,salary,commission_pct from employees where commission_pct is not null order by salary,commission_pct;

select last_name,salary from employees where salary>12000;

select employee_id, last_name,salary, department_id from employees where manager_id=103 order by last_name;

select last_name from employees where last_name like '__a%';

select last_name from employees where last_name like '%a%e%' ;

select last_name,salary,job_id from employees where job_id in('sa_rep','st_clerk') and salary not in(2500,3500,7000);

select last_name as Employee,salary as 'Monthly Salary',commission_pct as 'Commission PCT'  from employees where commission_pct=.2;

select upper(last_name), salary from employees;

select employee_id,concat(first_name,' ',last_name) as Name,job_id,length(last_name), instr(last_name,'a') as 'contains "a"? ' from employees where substr(job_id,4)='REP';

select concat(upper(substr(first_name,1)),(substr(first_name,length(first_name)))) from employees;

select round(45.923,2), round(45.923,0),round(45.923,-1) from dual;

select last_name,salary,MOD(salary,5000) from employees where job_id='SA_REP';

select last_name,salary, ifnull(commission_pct,0)  from employees;              

select last_name, salary, ifnull(commission_pct,0), (salary*12)+(salary*12*ifnull(commission_pct,0)) as AN_SAl from employees;

select  lpad(last_name,10,'*'),rpad(last_name,10,'*') from employees;

select date_format(curdate(),'%d-%M-%Y') as Date;

select employee_id,last_name,salary,round((salary+salary*(15.5/100)),0) as 'new salary',round(salary*(15.5/100)) as increased from employees;

select concat(upper(substr(last_name,1,1)),substr(last_name,2)) as Name, length(last_name) as Length from employees where last_name like 'A%' or last_name like 'M%' or last_name like 'J%' ;

select last_name,timestampdiff(MONTH,hire_date,curDate()) as worked from employees order by worked;

select concat(last_name,' earns ',salary,' monthly but wants ',salary*3) as 'dream Salary' from employees;

select last_name,hire_date,salary,concat('Monday',date_add(month,6,hire_date)) as Review from employees;


select avg(salary),max(salary),min(salary),sum(salary),count(salary) from employees where job_id like '%rep%';

select min(hire_date),max(hire_date) from employes;

select count(*) from employees where department_id=80;

select count(commission_pct) from employees where department_id=80;

select count(distinct department_id) from employees;

select avg(commission_pct) from employees;

select department_id,avg(salary) from employees group by department_id;

select department_id, job_id,sum(salary) from employees group by department_id,job_id;

select department_id,max(salary) from employees group by department_id having max(salary)>10000;

select last_name,salary from employees order by salary desc limit 3; 

select job_id,sum(salary) as payroll from employees where job_id not like '%REP%' group by job_id having sum(salary) >13000 order by sum(salary);

select job_id, min(salary),max(salary),sum(salary),avg(salary),count(salary) from employees group by job_id;

select job_id,count(*) from employees group by job_id ;

select count(distinct(manager_id)) from employees ;

select max(salary)-min(salary) as Difference from employees;

select manager_id, min(salary) from employees where manager_id is not null group by manager_id having min(salary)>6000;

select manager_id , salary from employees where manager_id=108;

select employee_id,count(timestamp(year,1995)) from employees order by employee_id;

select timestamp(year,1995) from employees;
