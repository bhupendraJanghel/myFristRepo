<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Customer</title>
</head>
<body>

	<h2>List of customer</h2>
	<table border=1>

		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</tr>
		
		<c:forEach  var="cst" items="${customer}">
		<tr><td>${cst.id}</td>
		<td>${ cst.firstName}</td>
		<td>${ cst.lastName}</td>
		<td>${ cst.email}</td>
		</c:forEach>
		</tr>
	</table>

</body>
</html>