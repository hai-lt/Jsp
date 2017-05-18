<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register User</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/helpers/IncludeBootstrap.jsp" />
</head>
<body>
	<div class="container col">
		<form class="col-sm-offset-4 col-sm-4" action="/JSP/register"
			method="post">

			<div class="form-group">
				<h3 class="center">Register</h3>
			</div>

			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" id="username" name="username" required>
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" name="password" required>
			</div>
			<div class="form-group">
				<label for="pwd_conf">Password Confirmation:</label> <input
					type="password" class="form-control" id="pwd_conf"
					name="password_confirmation" required>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>

</body>
</html>
