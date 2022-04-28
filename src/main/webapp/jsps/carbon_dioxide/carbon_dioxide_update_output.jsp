<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Carbon_dioxide</title>
    
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
  <h1>Update Carbon_dioxide</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	State ID    :<input type="text" name="co_id" value="${carbon_dioxide.co_id }" disabled/>
	<br/>
	Year of Emission：<input type="number" name="emission_year" value="${carbon_dioxide.emission_year }" disabled/>
	<br/>
	Value	：<input type="number" step=any name="co_metric" value="${carbon_dioxide.co_metric }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Carbon_DioxideServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="co_id" value="${carbon_dioxide.co_id }"/>
				<input type="hidden" name="emission_year" value="${carbon_dioxide.emission_year }"/>
	Value	：<input type="number" step=any name="co_metric" value="${form.co_metric }"/>
	<span style="color: red; font-weight: 900">${errors.co_metric }</span>
	<br/>
	<input type="submit" value="Update Carbon-dioxide"/>
</form>

</body>
</html>
