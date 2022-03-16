<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Entity1 Create</title>
    
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
  <h1>Create a new entry for Natural Disaster</h1>
<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
	Disaster ID    :<input type="number" name="n_id" value="${form.n_id }"/>
	<span style="color: red; font-weight: 900">${errors.n_id }</span>
	<br/>
	Disaster Name：<input type="text" name="disaster_name" value="${form.disaster_name }"/>
	<span style="color: red; font-weight: 900">${errors.disaster_name }</span>
	<br/>
	Year of Occurence	：<input type="number" name="occurence_year" value="${form.occurence_year }"/>
	<span style="color: red; font-weight: 900">${errors.occurence_year }</span>
	<br/>
	Damage Costs	：<input type="number" name="damage_cost" value="${form.damage_cost }"/>
	<span style="color: red; font-weight: 900">${errors.damage_cost }</span>
	<br/>
	<input type="submit" value="Create Natural Disaster"/>
</form>
  </body>
</html>
