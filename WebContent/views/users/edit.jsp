<%@page import="models.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit User</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/helpers/IncludeBootstrap.jsp" />
</head>
<body>
	<%
	  User user = (User) request.getAttribute("user");
	  User userUpdated = (User) request.getAttribute("user_updated");
	  if (user != null && userUpdated != null) {
	%>
	<jsp:include page="/views/header.jsp" />

	<form class="container col-sm-4 col-sm-offset-4" action="users"
		method="post">
		<input type="hidden" name="id" value="<%=userUpdated.getId()%>" />
		<div class="form-group">
			<h2>Update user info</h2>
		</div>
		<div class="form-group">
			<label for="username">Last name:</label> <input type="text"
				class="form-control" id="email" name="username"
				value="<%=userUpdated.getUsername()%>" required>
		</div>
		<div class="form-group">
			<label for="pwd">Role:</label> <input type="text"
				class="form-control" id="pwd" name="password"
				value="<%=userUpdated.getPassword()%>" required>
		</div>
		<button type="submit" class="btn btn-default">Update</button>
	</form>
	<%
	  }
	%>
</body>
</html>
