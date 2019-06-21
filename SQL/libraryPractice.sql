SELECT MEMBER_ID,MEMBER_NAME,CITY,MEMBERSHIP_STATUS FROM lms_members WHERE MEMBERSHIP_STATUS='permanent';

SELECT b1.book_code,b2.publication,b2.price,b3.supplier_name FROM(SELECT b1.book_code FROM LMS_BOOK_ISSUE b1 GROUP BY book_code HAVING COUNT(b1.BOOK_CODE) > 1) b1 JOIN LMS_BOOK_DETAILS b2 ON b1.book_code = b2.book_code JOIN LMS_SUPPLIERS_DETAILS b3 ON b2.supplier_id = b3.supplier_id;



SELECT  lms_members.MEMBER_ID,MEMBER_NAME FROM lms_members JOIN lms_book_issue ON lms_members.MEMBER_ID=lms_book_issue.MEMBER_ID WHERE lms_book_issue.BOOK_CODE='BL000002';

SELECT BOOK_CODE,BOOK_TITLE, AUTHOR FROM lms_book_details WHERE AUTHOR LIKE 'P%';

SELECT COUNT(*) AS 'no of books' FROM lms_book_details WHERE CATEGORY='JAVA';

SELECT CATEGORY,COUNT(*) AS 'no of books' FROM lms_book_details GROUP BY CATEGORY;


SELECT PUBLICATION,COUNT(*) AS 'no of books' FROM lms_book_details WHERE PUBLICATION='prentice Hall';

SELECT b.BOOK_CODE,b.BOOK_TITLE FROM lms_book_details b JOIN lms_book_issue bi ON b.BOOK_CODE=bi.BOOK_CODE WHERE bi.DATE_ISSUE='2012-4-1';

SELECT MEMBER_ID,MEMBER_NAME,DATE_REGISTER,DATE_EXPIRE FROM lms_members WHERE DATE_FORMAT(date_expire,'%Y-%m')< '2013-4';

SELECT MEMBER_ID,MEMBER_NAME,DATE_REGISTER,MEMBERSHIP_STATUS FROM lms_members WHERE DATE_FORMAT(date_register,'%Y-%m')<'2012-03'  AND MEMBERSHIP_STATUS='temporary';

SELECT MEMBER_ID,MEMBER_NAME AS Name,CITY FROM lms_members WHERE city='chennai' OR city='delhi';

SELECT DISTINCT CONCAT(book_title,' is written by ',author) FROM lms_book_details;

SELECT * FROM lms_suppliers_details;
DESC lms_suppliers_details;
SELECT AVG(price) FROM lms_book_details WHERE CATEGORY='java';

SELECT SUPPLIER_ID,SUPPLIER_NAME,EMAIL FROM lms_suppliers_details WHERE EMAIL like '%gmail.com';

SELECT SUPPLIER_ID,SUPPLIER_NAME,COALESCE(address,contact,email) AS 'contact_Details' FROM lms_suppliers_details;

SELECT SUPPLIER_ID,SUPPLIER_NAME,CONTACT, IF(ADDRESS IS NOT NULL,'yes','no') AS 'phone available' FROM lms_suppliers_details;


SELECT m.MEMBER_ID, m.MEMBER_NAME, m.CITY, SUM(f.FINE_AMOUNT) AS FINE FROM LMS_MEMBERS m INNER JOIN LMS_BOOK_ISSUE i ON m.MEMBER_ID = i.MEMBER_ID INNER JOIN LMS_FINE_DETAILS f ON i.FINE_RANGE = f.FINE_RANGE GROUP BY m.MEMBER_ID, m.MEMBER_NAME, m.CITY;


/*-------------------Average Question-----*/

SELECT m.MEMBER_ID,m.MEMBER_NAME,b.BOOK_CODE,bd.BOOK_TITLE FROM lms_members m JOIN lms_book_issue b ON m.MEMBER_ID=b.MEMBER_ID JOIN lms_book_details bd ON b.BOOK_CODE=bd.BOOK_CODE;

select count(b.BOOK_CODE) as no_of_books_available from lms_book_details b left join lms_book_issue i on b.BOOK_CODE=i.BOOK_CODE where i.BOOK_CODE is null;

select m.MEMBER_ID,m.MEMBER_NAME,f.FINE_AMOUNT,f.FINE_RANGE  from lms_members m join lms_book_issue b on m.MEMBER_ID=b.MEMBER_ID join lms_fine_details f on b.fine_range=f.FINE_RANGE where f.FINE_AMOUNT<100;

select BOOK_CODE,BOOK_TITLE,PUBLICATION,BOOK_EDITION,PRICE,year(PUBLISH_DATE) as 'year' from lms_book_details order by PUBLISH_DATE,PUBLICATION,BOOK_EDITION;

select BOOK_CODE,BOOK_TITLE,RACK_NUM from lms_book_details where RACK_NUM='A1' order by BOOK_TITLE;

select m.MEMBER_ID,m.MEMBER_NAME,f.FINE_AMOUNT from lms_members m join lms_book_issue b on m.MEMBER_ID=b.MEMBER_ID join lms_fine_details f on b.FINE_RANGE=f.FINE_RANGE ;


