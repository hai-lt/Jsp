<%@page import="java.util.ArrayList"%>
<%@page import="models.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Danh Sách Vacxin</title>
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
		<h2>Danh sách vacxin</h2>

		<div class="row">
			<jsp:include page="/views/vacxins/search.jsp" />
			<jsp:include page="/views/vacxins/index.jsp" />
		</div>

	</div>
	<%
	  }
	%>
</body>
</html>
