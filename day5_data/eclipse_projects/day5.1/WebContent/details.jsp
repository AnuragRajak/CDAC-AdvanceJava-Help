<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><h5>JSession ID : <%= session.getId() %></h5>
	<h4>Login Successful....</h4>
	<h4>
		User Details :
		<%=session.getAttribute("user_dtls")%></h4>
	<h5>
		<a href="logout.jsp">Log Me Out</a>
	</h5>
</body>
</html>