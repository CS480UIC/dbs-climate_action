<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> AQI Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>ID</th>
		<th>Reporting City</th>
	</tr>
<c:forEach items="${CityList}" var="city">
	<tr>
		<td>${city.id}</td>
		<td>${city.reporting}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
