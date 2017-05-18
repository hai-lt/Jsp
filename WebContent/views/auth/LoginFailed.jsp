<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Failed</title>
<jsp:include page="/helpers/IncludeBootstrap.jsp" />
</head>
<body>
	<div class="panel panel-danger col-sm-6 col-sm-offset-3">
		<div class="panel-heading">Invalid username and password</div>
		<div class="panel-body">
			<a href="views/Login.jsp">Try again</a>
		</div>
		<div class="panel-body">
			<a href="views/auth/register.jsp">Register</a>
		</div>
	</div>
</body>
</html>