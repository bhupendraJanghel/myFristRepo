<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>

<h3>update for ${customer.id}</h3>

<form:form action="updateForm" method="post" modelAttribute="updateCustomer"/>

 First name: <form:input type="text" path="firstName" value="b"/><br>
 
 Last name: <form:input type="text" path="lastName" /><br>
 Email : <form:input type="text" path="email" value="${}"/><br> 
</form>

</body>
</html>