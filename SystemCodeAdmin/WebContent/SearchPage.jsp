<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ExceptionPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="main.css"  type="text/css" rel="stylesheet" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<title>Search Page</title>
</head>
<body>
<!-- div id="banner"-->
<!-- object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0" width="976" height="90">
<param name="movie" value="banner.swf" />
<param name="quality" value="best" />
<param name="menu" value="true" />
<param name="allowScriptAccess" value="sameDomain" />
<embed src="images/banner.swf" quality="best" menu="true" width="976" height="90" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" allowScriptAccess="sameDomain" />
</object-->

<!-- /div-->

<div id="header">
<ul>
<li id="selected" ><a href="#">Search</a></li>
<li ><a href="index.jsp">Create New</a></li>

</ul>

</div>


<div id="content">
<!-- search fields -->
<form action="SearchServlet" method="get">
<table width="100%" >
<tr>
<td width="280px"><span>Search Type:</span> <span><%@ include file="CodeType.jsp" %></span></td>
<td width="250px"><span>Search Airline Code:</span><span> <%@ include file="AirlineCode.jsp" %></span></td>
<td width="310px"><span>Search Key:</span><span> <input type="text" name="searchText" /></span></td>
<td><input type="reset" value="Clear"/></td>
<td><input type="submit" value="Search"/></td></tr>
</table>

</form>
<hr />

<c:choose>
<c:when test="${returnDataList == null}">
	No records matched your selection.
</c:when>
<c:otherwise>
<p>
${fn:length(returnDataList)} records matched for search result of ${requestType==null?"":requestType} ${airlineCode==null?"":" and "} ${airlineCode==null?"":airlineCode}.</p><br/>
<table class="result">

<tr>
<c:forEach var="listHeader" items="${returnHeaderList}">
<th><c:out value="${listHeader}"/></th>
</c:forEach>
</tr>
<c:forEach var="listData" items="${returnDataList}" varStatus="loopStatus">
<tr class="${loopStatus.index % 2 == 0 ? 'oddRow' : 'evenRow'}">
<c:forEach var="dataMap" items="${listData}">
<td><c:out value="${dataMap}"/></td>
</c:forEach>
</tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose>
</div>

</body>
</html>