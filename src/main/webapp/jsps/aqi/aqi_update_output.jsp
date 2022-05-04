<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update AQI</title>
    
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
  <h1>Update AQI</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	AQI ID    :<input type="text" name="aqi_id" value="${aqi.aqi_id }" disabled/>
	<br/>
	
	Measuring Year：<input type="number" name="measuring_year" value="${aqi.measuring_year }" disabled />
	<br/>
	Value	：<input type="number" name="aqi_metric" value="${aqi.aqi_metric }" disabled/>
	<br/>
	Reporting City	：<input type="text" name="reporting_city" value="${aqi.reporting_city }" disabled/>
	<br/>
	Reporting Date	：<input type="date" name="reporting_date" value="${aqi.reporting_date }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/AqiServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="aqi_id" value="${aqi.aqi_id }"/>
				<input type="hidden" name="measuring_year" value="${aqi.measuring_year }"/>
	AQI Metric：<input type="number" name="aqi_metric" value="${form.aqi_metric }"/>
	<span style="color: red; font-weight: 900">${errors.aqi_metric }</span>
	<br/>
	Reporting City	：<input type="text" name="reporting_city" value="${form.reporting_city }"/>
	<span style="color: red; font-weight: 900">${errors.reporting_city }</span>
	<br/>
	Reporting Date	：<input type="date" name="reporting_date" value="${form.reporting_date }"/>
	<span style="color: red; font-weight: 900">${errors.reporting_date }</span>
	<br/>
	<input type="submit" value="Update Aqi"/>
</form>

</body>
</html>
