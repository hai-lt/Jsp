<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/helpers/IncludeBootstrap.jsp" />
<title>Register User</title>
</head>
<body>
	<div class="container col">
		<form class="col-sm-offset-4 col-sm-4" action="/register"
			method="post">

			<div class="form-group">
				<h3 class="center">Register</h3>
			</div>

			<div class="form-group">
				<label for="email">Email address:</label> <input type="email"
					class="form-control" id="email" name="email">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" name="password">
			</div>
			<div class="form-group">
				<label for="pwd_conf">Password Confirmation:</label> <input
					type="password" class="form-control" id="pwd_conf"
					name="password_confirmation">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>

</body>
</html>
