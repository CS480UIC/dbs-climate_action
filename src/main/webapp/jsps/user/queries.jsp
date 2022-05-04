<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>List of the queries</h1>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/findState'/>" target="body">List the states with area more than 100,000</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/findEmission'/>" target="body">List the years with their average CO2 emission</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/findAqi'/>" target="body">Please list all the cities with aqi more than 50</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/findDisaster'/>" target="body">Please list all the disaster name with their total damage cost</a>&nbsp;&nbsp;
    <br/>
    
  </body>
</html>
