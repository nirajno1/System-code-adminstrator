<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="main.css" type="text/css" rel="stylesheet" />
<title>Error Page</title>
</head>
<body>
<div id="header">
<ul>
	<li><a href="SearchPage.jsp">Search</a></li>
	<li><a href="#">GET Code</a></li>
	<li><a href="index.jsp">Create New</a></li>
	<li id="selected"><a href="#">Error</a></li>
</ul>
</div>
<div id="content">
<p class="exception">
<c:out value="${pageContext.exception}"></c:out>
</p>
</div>
</body>
</html>