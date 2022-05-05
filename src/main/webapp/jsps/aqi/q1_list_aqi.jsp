<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Combined Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Code</th>
		<th>Name</th>
		<th>Aqi</th>
		<th> Reporting City</th>
		<th>Measuring Year</th>
	</tr>
<c:forEach items="${AqiList}" var="aqi">
	<tr>
		<td>${aqi.code}</td>
		<td>${aqi.name}</td>
		<td>${aqi.aqi_metric}</td>
		<td>${aqi.reporting_city}</td>
		<td>${aqi.measuring_year}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
