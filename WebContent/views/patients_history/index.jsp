<%@page import="models.bean.PatientsExport"%>
<%@page import="models.bean.PatientHistory"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Mã Khách Hàng</th>
				<th>Tên Khách Hàng</th>
				<th>Tên Bệnh</th>
				<th>Mã Vacxin</th>
				<th>Tên Vacxin</th>
				<th>Tổng số mũi cần tiêm</th>
			</tr>
		</thead>
		<tbody>
			<%
			  ArrayList<PatientsExport> patientHistories = (ArrayList<PatientsExport>) request
			      .getAttribute("patients_histories");
			  for (int index = 0; index < patientHistories.size(); index++) {
			    PatientsExport patientHistory = patientHistories.get(index);
			%>
			<tr>
				<td><%=patientHistory.getPatientId()%></td>
				<td><%=patientHistory.getPatientName()%></td>
				<td><%=patientHistory.getVacxinName()%></td>
				<td><%=patientHistory.getVacxinId()%></td>
				<td><%=patientHistory.getVacxinName()%></td>
				<td><%=patientHistory.getInjectionCounts()%></td>
			</tr>
			<%
			  }
			%>
		</tbody>
	</table>
	<%
	  if (patientHistories.isEmpty()) {
	%>
	<h3>
		<small>Hiện chưa có members nào được nhập</small>
	</h3>
	<%
	  }
	%>
</div>
