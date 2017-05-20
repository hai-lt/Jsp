<%@page import="models.bean.Vacxin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vacxin</title>
<jsp:include page="/helpers/IncludeBootstrap.jsp" />
</head>
<body>
	<%
	  Vacxin vacxin = (Vacxin) request.getAttribute("vacxin");
	%>
	<jsp:include page="/views/header.jsp" />

	<form class="container col-sm-4 col-sm-offset-4" action="vacxins"
		method="post">
		<input type="hidden" name="id" value="<%=vacxin.getId()%>" />
		<div class="form-group">
			<h2>Update Vacxin</h2>
		</div>
		<div class="form-group">
			<label for="name">Name:</label> <input type="text"
				class="form-control" id="email" name="name"
				value="<%=vacxin.getName()%>" required>
		</div>
		<div class="form-group">
			<label for="price">Giá:</label> <input type="text"
				class="form-control" id="price" name="price"
				value="<%=vacxin.getPrice()%>" required>
		</div>
		<div class="form-group">
			<label for="counts">Số lần tiêm:</label> <input type="text"
				class="form-control" id="counts" name="injecting_counts"
				value="<%=vacxin.getInjecting_counts()%>" required>
		</div>
		<div class="form-group">
			<label for="supplier">Nhà cung cấp:</label> <input type="text"
				class="form-control" id="supplier" name="supplier"
				value="<%=vacxin.getSupplier()%>" required>
		</div>
		<div class="form-group">
			<label for="description">Mô tả:</label> <input type="text"
				class="form-control" id="description" name="description"
				value="<%=vacxin.getDescription()%>" required>
		</div>
		<button type="submit" class="btn btn-default">Update</button>
	</form>
</body>
</html>
