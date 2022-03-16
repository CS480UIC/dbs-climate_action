<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Natural Disaster</title>
    
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
  <h1>Delete Natural Disaster</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Entity1ServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="username" value="${entity1.username }"/>
	Disaster ID   :<input type="number" name="n_id" value="${entity1.username }" disabled/>
	<br/>
	
	Disaster Name：<input type="text" name="disaster_name" value="${entity1.password }" disabled/>
	<br/>
	Year of Occurence	：<input type="number" name="occurence_year" value="${entity1.email }" disabled/>
	<br/>
	Damage Costs	：<input type="number" name="damage_cost" value="${entity1.email }" disabled/>
	<br/>
	<input type="submit" value="Delete Natural Disaster"/>
</form>

</body>
</html>
