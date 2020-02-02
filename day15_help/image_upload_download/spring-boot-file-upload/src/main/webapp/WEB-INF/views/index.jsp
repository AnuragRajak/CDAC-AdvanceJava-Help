<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>
		Hello from spring boot MVC ....@<%=new Date()%></h4>
	<h5>
		<a href="upload">Upload Files</a>
	</h5>
	<h5>
		<a href="download">Download Files</a>
	</h5>
	<h5>
		<a href="show_image/mars.gif">View Image</a>
	</h5>
</body>
</html>