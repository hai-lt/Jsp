<%@page import="models.bean.Vacxin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Tên</th>
				<th>Mô tả</th>
				<th>Giá</th>
				<th>Số lần tiêm</th>
				<th>Nhà cung cấp</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
			  ArrayList<Vacxin> vacxins = (ArrayList<Vacxin>) request.getAttribute("vacxins");
			  for (int index = 0; index < vacxins.size(); index++) {
			    Vacxin vacxin = vacxins.get(index);
			%>
			<tr>
				<td><%=vacxin.getId()%></td>
				<td><%=vacxin.getName()%></td>
				<td><%=vacxin.getDescription()%></td>
				<td><%=vacxin.getPrice()%></td>
				<td><%=vacxin.getInjecting_counts()%></td>
				<td><%=vacxin.getSupplier()%></td>
				<td>
					<form class="form-inline">
						<div class="form-group">
							<a href="users?id=<%=vacxins.get(index).getId()%>&action=delete">Delete</a>
						</div>
						<div class="form-group">
							<a href="users?id=<%=vacxins.get(index).getId()%>">Update</a>
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
	  if (vacxins.isEmpty()) {
	%>
	<h3><small>Hiện chưa có vacxin nào được nhập</small></h3>
	<%
	  }
	%>
</div>