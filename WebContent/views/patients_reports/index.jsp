<%@page import="models.bean.PatientsReport"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Mã Khách Hàng</th>
				<th>Tên Khách Hàng</th>
				<th>Giá</th>
			</tr>
		</thead>
		<tbody>
			<%
			  ArrayList<PatientsReport> patientsReports = (ArrayList<PatientsReport>) request.getAttribute("patients_reports");
			  for (int index = 0; index < patientsReports.size(); index++) {
			    PatientsReport patientsReport = patientsReports.get(index);
			%>
			<tr>
				<td><%=patientsReport.getCutomerId()%></td>
				<td><%=patientsReport.getCutomerName()%></td>
				<td><%=patientsReport.getPrice()%></td>
			</tr>
			<%
			  }
			%>

		</tbody>
	</table>
	<%
	  if (patientsReports.isEmpty()) {
	%>
	<h3><small>Hiện chưa có bệnh nhân nào tới khám</small></h3>
	<%
	  }
	%>
</div>