<%@page import="com.app.core.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!// JSP decl block
	//declare private member
	HashMap<String, User> users;

	public void jspInit() {
		System.out.println("in jspInit ");
		users = new HashMap<>();
		users.put("abc@gmail", new User("abc", "abc@gmail", "1234"));
		users.put("abc2@gmail", new User("abc2", "abc2@gmail", "2234"));

	}%>
<body>
<h5>JSession ID : <%= session.getId() %></h5>
	<%
		//authenticate 
		String email = request.getParameter("em");
		String pwd = request.getParameter("pass");
		User u = users.get(email);
		if (u != null) {
			if (u.getPassword().equals(pwd)) {
				//login success
				session.setAttribute("user_dtls", u);
				//redirect
				response.sendRedirect("details.jsp");
			} else {
				//invalid pwd
	%>
	<h4>
		Invalid Password , Pls <a href="login.jsp">Retry</a>
	</h4>
	<%
		}
		} else { //new user
	%>
	<h4>
		Invalid Email : New User , Pls <a href="register.jsp">Sign Up</a>
	</h4>
	<%
		}
	%>
</body>
<%!public void jspDestroy() {
		users = null;
		System.out.println("in jspDestroy ");
	}%>
</html>