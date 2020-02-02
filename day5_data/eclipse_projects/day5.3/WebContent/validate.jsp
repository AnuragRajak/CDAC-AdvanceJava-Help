<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="cust" class="beans.CustomerBean" scope="session" />
<jsp:setProperty property="*" name="cust" />
<body>
	<h4>Auth status : ${sessionScope.cust.validateCustomer()}</h4>
</body>
</html>