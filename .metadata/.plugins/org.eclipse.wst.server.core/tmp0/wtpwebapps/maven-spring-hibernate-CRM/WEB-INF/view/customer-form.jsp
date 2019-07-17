<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
</head>
<body>

	<form:form action="processForm" method="post"
		modelAttribute="customerModel">
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input type="text" path="firstName" /></td>
				<td><form:errors path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input type="text"  path="lastName" /></td>
				<td><form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input type="text"  path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit  "></td>
			</tr>
		</table>
	</form:form>

</body>
</html>