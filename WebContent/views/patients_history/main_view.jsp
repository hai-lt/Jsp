<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Lịch Sử Khám bệnh</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/helpers/IncludeBootstrap.jsp" />
</head>
<body>
	<jsp:include page="/views/header.jsp" />

	<div class="container col-sm-offset-1 col-sm-10">
		<h2>Lịch sử khám bệnh</h2>

		<jsp:include page="/views/patients_history/index.jsp" />
	</div>
</body>
</html>