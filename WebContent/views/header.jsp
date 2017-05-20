<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">FAMILY HOSPITAL</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="<%=request.getContextPath()%>/index">Danh
					sách Vacxin</a></li>
			<li><a href="<%=request.getContextPath()%>/patients_histories">Lịch
					sử bệnh nhân</a></li>
			<li><a href="<%=request.getContextPath()%>/patients_reports">Thống
					kê</a></li>
		</ul>
	</div>
</nav>
