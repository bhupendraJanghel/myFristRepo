<%@page import="com.example.spring.Student"%>
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
	Hello, ${student.first_name } ${student.last_name };
	<BR> Country : ${student.country }
	<%-- <br /> Languages known :
	<%
		Student s = (Student) request.getAttribute("student");
		String[] arr = s.getLanguage();
		for (String s1 : arr) {
			out.println(s1+",");
		}
	%> --%>
	<br /> Favorite Language:${student.favoriteLanguage }

	<br /> Operating System:
	<%
		Student s = (Student) request.getAttribute("student");
		String[] arr = s.getOperatingSystem();
		for (String s1 : arr) {
			out.println(s1 + ",");
		}
	%>
	<br/>
	
	 <a href="../student/showForm"> Back to form..</a><br/>
	 <a href="../home">Back to Home</a>
</body>
</html>