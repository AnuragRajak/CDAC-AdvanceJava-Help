<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>From 2nd page</h5>
<h5>${pageContext.session.id}</h5>
	<%--send attribute values to clnt  --%>
	<h5>Page Scoped attr ${pageScope.attr1}</h5>
	<h5>Request Scoped attr ${requestScope.attr2}</h5>
	<h5>Session Scoped attr ${sessionScope.attr3}</h5>
	<h5>Application(ctx) Scoped attr ${attr4}</h5>

</body>
</html>