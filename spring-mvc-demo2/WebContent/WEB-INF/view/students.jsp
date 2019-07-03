<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>List Of Students</h2>

	<table class="table table-bordered ">
		<tr>
		<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Country</th>
			<th>Favorite Language</th>
			<th>Operating System</th>
			<th colspan=2>Operation</th>
		</tr>
		<tr>
			<c:forEach var="std" items="${list }">
				<td>${std.id}</td>
				<td>${std.first_name}</td>
				<td>${std.last_name}</td>
				<td>${std.country}</td>
				<td>${std.favoriteLanguage}</td>
				<td>${std.os}</td>
				<td><a href="/spring-mvc-demo2/database/update/${std.id }">Edit</a></td>
				<td><a href="/spring-mvc-demo2/database/delete/${std.id }">Delete</a></td>
		</tr>
		</c:forEach>

	</table>
	
	<a href="../student/showForm"> Back to form..</a><br/>
	 <a href="../home">Back to Home</a>
</body>
</html>