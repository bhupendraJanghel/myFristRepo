<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form:form action="processForm" method="post" modelAttribute="login">

		User Name : <form:input type="text" path="userName"/><form:errors path="userName" cssClass="error"/><br/>
		<br /> Password : <form:input type="password"  path="password"/><form:errors path="password" cssClass="error" /><br />
		<br /> <input type="submit" value="Login"/> <input type="reset"
			value="Reset">

	</form:form>
</body>
</html>