<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Carbon-dioxide</title>
    
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
  <h1>Read Carbon-dioxide</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Carbon_DioxideServletRead'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
	State ID    :<input type="text" name="co_id" value="${form.co_id}"/>
	<span style="color: red; font-weight: 900">${errors.co_id }</span>
	<br/>
	Year    :<input type="number" name="emission_year" value="${form.emission_year}"/>
	<span style="color: red; font-weight: 900">${errors.emission_year }</span>
	<br/>

	<input type="submit" value="Read Carbon-dioxide"/>
</form>
  </body>
</html>
