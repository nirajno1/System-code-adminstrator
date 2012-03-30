<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ExceptionPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="main.css" type="text/css" rel="stylesheet" />
<title>Confirmation page</title>
</head>
<body>
<div id="header">
<ul>
	<li><a href="SearchPage.jsp">Search</a></li>
	<li id="selected"><a href="#">Create
	${requestType==null?"new":requestType}</a></li>

</ul>

</div>
<div id="content">
<form class="form_custom" action="SaveServlet" method="post" >
<table class="table_center_cfrm">
<tr><th>Name</th><th>Value</th></tr>

<c:forEach var="contorlDTO" items="${datalist}" varStatus="loopStatus">
<tr class="${loopStatus.index % 2 == 0 ? 'oddRow' : 'evenRow'}">
<td align="right"><c:out value="${contorlDTO.controlDisplayName}: "></c:out></td>
<td align="left"><c:out value="${contorlDTO.value}"></c:out></td>
</tr>
</c:forEach>
<tr>
		<td><a href="#" onclick="javascript:parent.history.back()"><img src="images/back.gif" alt="Back" class="back_img" /></a></td>
		<td><input type="submit" value="Save"></input></td>
	</tr>
</table>
</form>


</div>
</body>
</html>