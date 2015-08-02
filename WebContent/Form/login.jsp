<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring Tiles Contact Form</title>
</head>
<body>
	<h2>Login</h2>
	<form:form method="post" action="doLogin.html">
		<table>
			<tr>
				<td><form:label path="email">Email Name</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="login" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
