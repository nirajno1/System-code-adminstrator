<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="ExceptionPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="main.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/utils.js"></script>
<script type="text/javascript" src="js/TransactionIdUtil.js"></script>

<title>Input page</title>
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
<form class="form_custom" action="InputServlet" method="post" onsubmit="return isValidSubmit()">
<input type="hidden" name="requestType" value="${requestType}"/> 
<table class="table_center">
	<c:forEach var="contorlDTO" items="${datalist}">
		<tr>
			<td align="right"><c:out
				value="${contorlDTO.controlDisplayName}: " /></td>


			<c:choose>

				<c:when test="${contorlDTO.controlType=='text'}">
					<c:choose>
						<c:when test="${contorlDTO.controlName=='airlineCode'}">
							<td><%@ include file="AirlineCode.jsp"%></td>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${contorlDTO.sysGeneratedCol}">
									<td align="left"><input class="input_disabled" type="${contorlDTO.controlType}"
										name="${contorlDTO.controlName}"
										id="${contorlDTO.controlName}"
										size="${contorlDTO.controlSize}" readonly="true"></input></td>
								</c:when>
								<c:otherwise>
									<td align="left"><input type="${contorlDTO.controlType}"
										name="${contorlDTO.controlName}"
										id="${contorlDTO.controlName}"
										size="${contorlDTO.controlSize}" ></input></td>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="${contorlDTO.controlType=='textarea'}">
					<td align="left"><textarea name="${contorlDTO.controlName}"
						rows="4" cols="${contorlDTO.controlSize}"></textarea></td>
				</c:when>
			</c:choose>


		</tr>
	</c:forEach>
	<tr align="right">
		<td><input type="reset" value="Clear"></input></td>
		
		<td>
		<c:choose>
		<c:when test="${requestType=='Transaction Id'}">
		
		<input name='transacId' type="button" value="${requestType}" onclick="getTransactionId()"></input>
		<input type="submit" value="Submit0"></input>
		</c:when>
		<c:otherwise>
		<input type="submit" value="Submit2"></input>
		</c:otherwise>
		</c:choose>
		</td>
	</tr>
	<tr>
		<td><a href="index.jsp"><img src="images/back.gif" alt="back"
			class="back_img" /></a></td>
		<td>&nbsp;</td>
	</tr>
</table>
</form>
</div>
</body>
</html>