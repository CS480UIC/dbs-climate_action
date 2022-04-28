<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete AQI</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Delete AQI</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/AqiServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
	AQI ID   :<input type="text" name="aqi_id" value="${aqi.aqi_id }" disabled/>
	<br/>
	Measuring Year：<input type="number" name="measuring_year" value="${aqi.measuring_year }" disabled/>
	<br/>
	Value	：<input type="text" name="aqi_metric" value="${aqi.aqi_metric }" disabled/>
	<br/>
	Reporting City	：<input type="text" name="reporting_city" value="${aqi.reporting_city }" disabled/>
	<br/>
	Reporting Date	：<input type="date" name="reporting_date" value="${aqi.reporting_date }" disabled/>
	<br/>
	<input type="submit" value="Delete AQI"/>
</form>

</body>
</html>
