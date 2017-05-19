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
			  ArrayList<PatientsExport> patientHistories = (ArrayList<PatientsExport>) request.getAttribute("patients_history");
			  for (int index = 0; index < patientHistories.size(); index++) {
			    PatientsExport patientHistory = patientHistories.get(index);
			%>
			<tr>
				<th><%=patientHistory.getPatientId()%></th>
				<th><%=patientHistory.getPatientName()%></th>
				<th><%=patientHistory.getVacxinName()%></th>
				<th><%=patientHistory.getVacxinId()%></th>
				<th><%=patientHistory.getVacxinName()%></th>
				<th><%=patientHistory.getInjectionCounts()%></th>
				<th></th>
			</tr>
			<%
			  }
			%>
		</tbody>
	</table>
</div>