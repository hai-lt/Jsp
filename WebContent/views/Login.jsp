<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	<jsp:include page="/helpers/IncludeBootstrap.jsp" />
</head>
<body>
	<% if (session.getAttribute("success_message") != null) { %>
		<% session.removeAttribute("success_message"); %>
		<script type="text/javascript">
			alert("Register successfully")
		</script>
	<% }%>
	<form action="/JSP/login" method="post">
		<div>
			<label>Username</label> <input type="text" name="username">
		</div>
		<div>
			<label>Password</label> <input type="password" name="password">
		</div>
			<% if (request.getAttribute("warning") != null) {%>
				<label><%= request.getAttribute("warning") %></label>
				<% request.removeAttribute("warning"); %>
			<% } %>
		</div>
		<input type="submit" value="Login">
	</form>
</body>
</html>