
/* foreign key constraint */
create table offices(officecode varchar(10) primary key,city varchar(50),phone varchar(20),address varchar(40),state varchar(50),country varchar(30),postalcode varchar(30));

create table Employees(eId integer primary key,lastname varchar(50), firstname varchar(50),officecode varchar(10), foreign key(officecode) references offices(officecode) );

desc offices; 	
desc employees;

drop table product;

create table product(prductcode integer primary key,productname varchar(40) not null,productdesc varchar(120) unique);

desc product;


/* check constraint is not supported in mySQL*/

create table Employ(id integer  primary key,lastname varchar(101),extension varchar(28), contraint extension_ck check(extension like 'x%');




/*   */

create table Course_info(course_code varchar(10) primary key,course_name varchar(20) not null,course_description varchar(25),course_start_date Date, course_duration int,no_of_participants int,course_type char(3) );
desc Course_info;


create table student_info(student_id varchar(10) primary key,first_name varchar(20),last_name varchar(23),address varchar(150) );

create table student_courses(student_id varchar(10) ,course_code  varchar(20), foreign key(student_id) references student_info(student_id),foreign key(course_code) references course_info(course_info));

/* here i am using both table level contraint and column evel contraint*/

create table student_courses(student_id varchar(10) ,course_code  varchar(20),foreign key(student_id) references student_info(student_id),
constraint fk_course_code foreign key(course_code) references course_info(course_code));

insert into course_info values('167','FSD','full stack developer','2019-02-06',2,20,'reg');

insert into course_info values('168','SAP','SAp ABAP','2019-02-10',1,10,'reg');

insert into student_info values('3','arindam','banerjee','kolkata');
desc student_courses;

insert into student_courses values('1','167');
select * from course_info;

alter table course_info add column discount int;

alter table course_info drop column discount;
select s.student_id,s.first_name,s.last_name,sc.course_code from student_info s join student_courses sc on s.student_id=sc.student_id  where course_code='167';

drop table course_info;

create table course_info_one(course_code int,course  varchar(30),course_description varchar(45),course_start_date date);

alter table course_info_one modify column course_code varchar(30);

alter table course_info_two modify course_description varchar(225);

alter table course_info_one add column course_duration int, add column number_of_participa int, ADD column course_type character(3);

alter table course_info_one rename course_info_two;

alter table course_info_two change course_code course_Id varchar(30);


desc course_info_one;

rename table course_info_two to course_info_one;
truncate table course_info_one;

drop table course_info_one;

insert into course_info_one values(343,'java programming','basics of java','2019-12-12');

insert into course_info_one values(106,'oracle','oracle SQL','2019-1-5');

select * from course_info_one;
alter table course_info_one modify course_code int primary key;

update course_info_one set course='MYSQL' ,course_description='basic SQL' where course_code=106;

create table supplier(supplier_id numeric primary key ,supplier_name varchar(50) not null,address varchar(50),city varchar(50),state varchar(25),zip_code varchar(10));

CREATE TABLE CUSTOMER(customer_id numeric(10), customer_name varchar(50),address varchar(50),city varchar(50),state varchar(50),zip_code varchar(50),constraint pk_customer_id primary key(customer_id));	

desc customer;





------------------- TRANSACTION CONTROL LANGUAGE --------------------


SELECT * FROM COURSE_INFO_ONE;
insert into course_info_one values(106,'oracle','oracle SQL','2019-1-5');

START TRANSACTION;
DELETE FROM COURSE_INFO_ONE WHERE COURSE_CODE=343;

savepoint sp1;
DELETE FROM COURSE_INFO_ONE WHERE COURSE_CODE=106;
rollback to sp1;
rollback;


SELECT * FROM COURSE_INFO_ONE;

DELETE FROM COURSE_INFO_ONE WHERE COURSE_CODE=106;

COMMIT;



 /* -- ----------------------------------Data control language------------------------------------------------- --*/
 
create user bhuppi identified by 'pass@123';

grant create on *.* to 'bhuppi';    
grant insert on *.* to 'bhuppi';    
grant update on *.* to 'bhuppi';    

grant select on *.* to 'bhuppi';    

grant all on *.* to 'bhuppi';


Revoke Create on *.* from 'bhuppi';     /* take away the permission*/
 