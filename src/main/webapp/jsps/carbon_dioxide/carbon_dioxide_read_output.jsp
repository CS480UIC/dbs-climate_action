<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Carbon-dioxide Output</title>
    
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
  <h1>Read Carbon-dioxide Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	State ID    :<input type="text" name="co_id" value="${carbon_dioxide.co_id }" disabled/>
	<br/>
	Year of Emission：<input type="number" name="emission_year" value="${carbon_dioxide.emission_year }" disabled/>
	<br/>
	Value	：<input type="number" step=any name="co_metric" value="${carbon_dioxide.co_metric }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
