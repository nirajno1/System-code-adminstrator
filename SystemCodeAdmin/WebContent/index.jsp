<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ExceptionPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="main.css" type="text/css" rel="stylesheet" />
<title>System Code Administration Home</title>
</head>
<body>

<div id="header">
<ul>
<li  ><a href="SearchPage.jsp">Search</a></li>
	<li id="selected"><a href="#">Create ${requestType==null?"new":requestType}</a></li>

</ul>

</div>

<div id="content">
<div id="form">
<form class="form_custom" action="IndexSevlet" method="post">
Please select your required :
<%@ include file="CodeType.jsp" %>



<input type="image" src="images/next.gif" class="next_img"/>
</form>
</div>
</div>
</body>
</html>