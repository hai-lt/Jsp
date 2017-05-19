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
	<%
	  if (session.getAttribute("success_message") != null) {
	%>
	<%
	  session.removeAttribute("success_message");
	%>
	<script type="text/javascript">
		alert("Register successfully")
	</script>
	<%
	  }
	%>

	<div class="container col">
		<form class="col-sm-offset-4 col-sm-4" action="/JSP/login"
			method="post">

			<div class="form-group">
				<h3 class="center">Login</h3>
			</div>

			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" id="username" name="username" required>
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" name="password" required>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>
