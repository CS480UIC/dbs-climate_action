<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update State</title>
    
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
  <h1>Update State</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	State code    :<input type="text" name="code" value="${state.code }" disabled />
	<br/>
	State name：<input type="text" name="name" value="${state.name }" disabled/>
	<br/>
	State area	：<input type="number" name="area" value="${state.area }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/StateServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="code" value="${state.code }"/>
	State Name：<input type="text" name="name" value="${form.name }"/>
	<span style="color: red; font-weight: 900">${errors.name }</span>
	<br/>
	State Area	：<input type="number" name="area" value="${form.area }"/>
	<span style="color: red; font-weight: 900">${errors.area }</span>
	<br/>
	<input type="submit" value="Update Entity1"/>
</form>

</body>
</html>
