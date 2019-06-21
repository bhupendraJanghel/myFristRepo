create view view_employees as select last_name ,first_name, hire_date from employees; 
show tables;
desc view_employees;

select * from view_employees;


create view view_office_employees as select o.city,e.employee_id from locations o , employees e where o.location_id=e.lo;


create view view_manager_employees2 as select e.first_name,e.last_name,d.manager_id,d.last_name as manager from employees e join employees d where e.employee_id=d.manager_id;

select * from view_manager_employees2;

drop table view;

create view view_course_1 as select course_code,course_name,course_duration  from course_info where  course_code>167;

select * from view_course_1;

create view view_library as select b.BOOK_CODE,b.BOOK_TITLE,m.MEMBER_ID,m.MEMBER_NAME,m.MEMBERSHIP_STATUS from lms_book_details b inner join lms_members m;

select * from view_library;

drop view view_course_1;

