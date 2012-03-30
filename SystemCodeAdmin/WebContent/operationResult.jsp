<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ExceptionPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="main.css" type="text/css" rel="stylesheet" />
<title>Operation Result</title>
</head>
<body>
<div id="header">
<ul>
	<li><a href="SearchPage.jsp">Search</a></li>
	<li><a href="#">GET Code</a></li>
	<li id="selected"><a href="#">Create New</a></li>
</ul>
</div>
<div id="content">
<c:choose>
<c:when test="${success=='Y'}">
Operation successfully completed.
</c:when>
<c:otherwise>
Operation failed due to some unknown reason, Please try again.
</c:otherwise>
</c:choose>

</div>

</body>
</html>
