<%@page import="java.util.ArrayList"%>
<%@page import="models.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Users Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/helpers/IncludeBootstrap.jsp" />
</head>
<body>
	<%
	  User user = (User) request.getAttribute("user");
	  if (user != null) {
	%>

	<jsp:include page="/views/header.jsp" />

	<div class="container col-sm-offset-1 col-sm-10">
		<h2>User management</h2>

		<form class="navbar-form navbar-left" role="search" action="index"
			method="post">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search"
					name="name">
			</div>
			<button type="submit" class="btn btn-default">Search</button>
		</form>
		<jsp:include page="/views/vacxins/index.jsp" />
	</div>
	<%
	  }
	%>
</body>
</html>