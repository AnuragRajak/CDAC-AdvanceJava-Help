<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>From 1st page</h5>
	<%
//	out.flush();
		//save attributes under various scopes
		pageContext.setAttribute("attr1", 1234);
		request.setAttribute("attr2", 1235);
		session.setAttribute("attr3", 1236);
		application.setAttribute("attr4", 1237);
		/* //forward 
		RequestDispatcher rd=request.getRequestDispatcher("next.jsp");
		rd.forward(request, response); */
		//clnt pull
		response.sendRedirect("next.jsp");
	%>
</body>
</html>