<%@page import="java.util.ArrayList"%>
<%@page import="models.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/helpers/IncludeBootstrap.jsp" />
<title>Users Management</title>
</head>
<body>
	<%
	  User user = (User) request.getAttribute("user");
	  if (user != null) {
	%>

	<jsp:include page="/views/header.jsp" />

	<div class="container col-sm-offset-2 col-sm-8">
		<h2>User management</h2>

		<form class="navbar-form navbar-left" role="search" action="index"
			method="post">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search"
					name="username">
			</div>
			<button type="submit" class="btn btn-default">Search</button>
		</form>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th></th>
				</tr>
			</thead>
			<%
			  ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
			%>
			<tbody>
				<%
				  for (int i = 0; i < users.size(); i++) {
				%>
				<tr>
					<td><%=users.get(i).getUsername()%></td>
					<td><%=users.get(i).getPassword()%></td>
					<td>

						<form class="form-inline">
							<div class="form-group">
								<a href="users?id=<%=users.get(i).getId()%>&action=delete">Delete</a>
							</div>
							<div class="form-group">
								<a href="users?id=<%=users.get(i).getId()%>">Update</a>
							</div>
						</form>
					</td>
				</tr>
				<%
				  }
				%>
			</tbody>
		</table>
		<%
		  if (request.getAttribute("searched") != null && users.isEmpty()) {
		%>
		<h5>No Result is matched!</h5>
		<%
		  }
		%>
	</div>
	<%
	  }
	%>
</body>
</html>