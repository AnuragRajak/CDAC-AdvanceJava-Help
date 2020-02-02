<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		<table>

			<tr>
				<td>Contents</td>
				<td><input name="contents" type="file" multiple="multiple"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Upload Contents" /></td>
			</tr>
		</table>
	</form>
</body>
</html>