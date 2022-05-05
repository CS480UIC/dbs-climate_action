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
		<th>Area</th>
		<th>Year</th>
		<th>CO2 Emission</th>
	</tr>
<c:forEach items="${AllList}" var="all">
	<tr>
		<td>${all.code}</td>
		<td>${all.name}</td>
		<td>${all.area}</td>
		<td>${all.emission_year}</td>
		<td>${all.co_metric}</td>		
	</tr>
</c:forEach>
</table>
</body>
</html>
